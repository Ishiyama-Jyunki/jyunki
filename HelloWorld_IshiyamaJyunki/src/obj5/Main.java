package obj5;

import java.util.ArrayList;
import java.util.List;



public class Main {
	public static void main(String[] args) {

		List<EmployeeBase> employees = new ArrayList<>();

		employees.add(new FullTimeEmployee("E001", "山田太郎"));
		employees.add(new FullTimeEmployee("E002", "佐藤花子"));
		employees.add(new ContractEmployee("F001", "砂本晴充"));
		employees.add(new ContractEmployee("F002", "川西温大"));

		for (EmployeeBase emp : employees) {

			int wage = emp.calculateDailyWage(9);
			System.out.println(emp.getName() + "の給与:" + wage + "円");
		}
	}
}
