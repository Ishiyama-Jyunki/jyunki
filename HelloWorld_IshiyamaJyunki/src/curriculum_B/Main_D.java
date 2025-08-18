package curriculum_B;

/*
 * 継承 						
次の条件に沿って Java プログラムを作成し、出力してください。						
条件						
A：以下のクラスを作成する。						
１	抽象クラス Employee					
		フィールド: employeeId（文字列）、name（文字列）				
		コンストラクタ: Employee(String id, String name)				
		メソッド:				
			public String getEmployeeId()			
			public String getName()			
			public abstract int calculateDailyWage(int hoursWorked)			
２	サブクラス FullTimeEmployee					
		定数: private static final int HOURLY_RATE = 1200				
		calculateDailyWage の実装（残業 8h 超過分は 25% 割増）				
３	サブクラス PartTimeEmployee					
		定数: private static final int HOURLY_RATE = 1000				
		calculateDailyWage の実装（割増なし）				
						
B：Main クラスで以下を実装する。						
	FullTimeEmployee と PartTimeEmployee のオブジェクトを作成し、9h 勤務時の給与を出力する。					
						
出力						
	正社員の給与: 11250 円					
	パート社員の給与: 9000 円					

 */

public class Main_D {
	public static void main(String[] args) {
		FullTimeEmployee2 fulltime = new FullTimeEmployee2("E001", "山田太郎");
		PartTimeEmployee parttime = new PartTimeEmployee("E002", "佐藤花子");

		int fullTimeWage = fulltime.calculateDailyWage(9);
		int partTimeWage = parttime.calculateDailyWage(9);

		System.out.println("正社員の給与" + fullTimeWage + "円");
		System.out.println("パート社員の給与" + partTimeWage + "円");
	}

}

abstract class Enployee4 {
	protected String employeeId;
	protected String name;

	public Enployee4(String employeeId, String name) {
		this.employeeId = employeeId;
		this.name = name;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public String getName() {
		return this.name;
	}

	public abstract int calculateDailyWage(int hoursWorked);

}

class FullTimeEmployee extends Enployee4 {

	private static final int HOURLY_RATE = 1200;

	public FullTimeEmployee(String employeeId, String name) {
		super(employeeId, name);

	}

	@Override

	public int calculateDailyWage(int hoursWorked) {
		if (hoursWorked <= 8) {
			return hoursWorked * HOURLY_RATE;
		} else {
			int normalpay = 8 * HOURLY_RATE;
			int overtimehours = hoursWorked - 8;
			int overtimepay = (int) (overtimehours * HOURLY_RATE * 1.25);
			return normalpay + overtimepay;
		}
	}
}

class PartTimeEmployee extends Enployee4 {

	private static final int HOURLY_RATE = 1000;

	public PartTimeEmployee(String employeeId, String name) {
		super(employeeId, name);

	}

	@Override

	public int calculateDailyWage(int hoursWorked) {
		return hoursWorked * HOURLY_RATE;

	}
}
