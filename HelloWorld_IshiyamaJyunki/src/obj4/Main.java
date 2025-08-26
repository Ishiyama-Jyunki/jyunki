package obj4;


public class Main {
	public static void main(String[] args) {
		FullTimeEmployee fulltime = new FullTimeEmployee("E001", "山田太郎");
		PartTimeEmployee parttime = new PartTimeEmployee("E002", "佐藤花子");

		int fullTimeWage = fulltime.calculateDailyWage(9);
		int partTimeWage = parttime.calculateDailyWage(9);

		System.out.println("正社員の給与" + fullTimeWage + "円");
		System.out.println("パート社員の給与" + partTimeWage + "円");
	}
}
