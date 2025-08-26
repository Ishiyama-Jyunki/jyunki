package obj6;

import java.util.ArrayList;
import java.util.List;



public class Main {
	public static void main(String[] args) {
		List<Billable> members = new ArrayList<>();
		members.add(new newFulltimeEmployee("F001","佐藤"));
		members.add(new newContractEmployee("T001","田中"));
		members.add(new newFulltimeEmployee("F002","鈴木"));
		members.add(new newContractEmployee("T002","山田"));
		
		int[] hoursList = {6, 8, 9, 10};
		int x = 0;
		for (Billable b : members) {
			int hours = hoursList[x++];
			int pay = b.costForDay(hours);
			System.out.printf("%s / %d時間: 日給 %,d 円%n", b, hours, pay);
		}
	}
}
