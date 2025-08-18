package curriculum_B;

/*
 *⑥インターフェイスと抽象クラス 						
以下の要件を満たすように、インターフェイスと抽象クラスを活用して社員管理システムを作ってみましょう。						
						
要件						
1️⃣ インターフェイス Billable を作成						
	メソッド: int costForDay(int hoursWorked);					
2️⃣ 抽象クラス Employee						
	implements Billable					
	フィールド: id, name					
	コンストラクタで初期化					
	costForDay は抽象メソッドとして実装しない（つまりサブクラスでオーバーライドする）					
3️⃣ サブクラスを2つ作成						
	FullTimeEmployee					
	ContractEmployee					
	それぞれの costForDay を以下の通りにする					
		FullTimeEmployee: 1時間1250円、8時間超過は1.25倍				
		ContractEmployee: 1時間1000円				
4️⃣ メインクラス Main						
	List<Billable> に社員を複数追加し、for-each ループで costForDay を呼び出して日給を出力する。					
	社員の型を問わず、Billable 型だけで動作させること。					

 */

import java.util.ArrayList;
import java.util.List;

interface Billable{
	int costForDay(int hoursWorked);
}

abstract class newEmployee5 implements Billable{
	protected final String id;
	protected final String name;
	
	public newEmployee5(String id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("%s{id= '%s, name='%s'}",
				this.getClass().getSimpleName(), id, name);
	}
}

class newFulltimeEmployee2 extends newEmployee5{
	public newFulltimeEmployee2(String id, String name) {
		super(id, name);
	}
	
	@Override
	public int costForDay(int hoursWorked) {
		final int hourly = 1250;
		int nomal = Math.min(hoursWorked, 8);
		int overtime = Math.max(0, hoursWorked - 8);
		long base = (long) nomal * hourly;
		long ot = Math.round(overtime * hourly * 1.25);
		return (int) (base + ot);
	}
}

class newContractEmployee2 extends newEmployee5{
	public newContractEmployee2(String id, String name) {
		super(id, name);
		
	}
	
	@Override
	public int costForDay(int hoursWorked) {
		final int hourly = 1000;
		return hoursWorked * hourly;
	}
}

public class Main_F {
	public static void main(String[] args) {
		List<Billable> members = new ArrayList<>();
		members.add(new newFulltimeEmployee2("F001","佐藤"));
		members.add(new newContractEmployee2("T001","田中"));
		members.add(new newFulltimeEmployee2("F002","鈴木"));
		members.add(new newContractEmployee2("T002","山田"));
		
		int[] hoursList = {6, 8, 9, 10};
		int x = 0;
		for (Billable b : members) {
			int hours = hoursList[x++];
			int pay = b.costForDay(hours);
			System.out.printf("%s / %d時間: 日給 %,d 円%n", b, hours, pay);
		}
	}

}
