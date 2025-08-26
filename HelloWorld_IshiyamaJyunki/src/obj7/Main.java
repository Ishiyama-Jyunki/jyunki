package obj7;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Employee> members = List.of(
				new neoFullTimeEmployee("佐藤", 9),
				new neoContractEmployee("鈴木", 7),
				new neoFullTimeEmployee("田中", 8)
			);
		SalaryService service = new SalaryService(new ConsoleReporter());
		service.reportAll(members);
	}
}
