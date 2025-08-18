package curriculum_B;

import java.util.List;

interface PayPolicy{
	int calculate(int hoursWorked);
}

interface Reporter{
	void print(String message);
}

class FullTimePayPolicy implements PayPolicy{
	public int calculate(int h) {
		final int hourly = 1250;
		int regular = Math.min(h, 8);
		int overtime = Math.max(0, h-8);
		long base = (long) regular * hourly;
		long ot = Math.round(overtime * hourly * 1.25);
		return (int) (base + ot);
	}
}

class ContractPayPolicy implements PayPolicy{
	public int calculate(int h) {return h * 1000;}
}

class ConsoleReporter implements Reporter{
	public void print(String message) { System.out.println(message);}
}

abstract class Employee6{
	private final String name;
	private final int hoursWorked;
	private final PayPolicy policy;
	
	protected Employee6(String name, int hoursWorked, PayPolicy policy) {
		this.name = name;
		this.hoursWorked = hoursWorked;
		this.policy = policy;
	}
	public String getName() {return name;}
	public int getHoursWorked() {return hoursWorked;}
	public int salary() {return policy.calculate(hoursWorked);}
}

class neoFullTimeEmployee extends Employee6 {
	public neoFullTimeEmployee(String name, int hours) {
		super(name, hours, new FullTimePayPolicy());
	}
}

class neoContractEmployee extends Employee6{
	public neoContractEmployee(String name, int hours) {
		super(name, hours, new ContractPayPolicy());
	}
}

class SalaryService{
	private final Reporter reporter;
	public SalaryService(Reporter reporter) {this.reporter = reporter;}
	
	public void report(Employee6 e) {
		reporter.print(e.getName() + "の給料は" + e.salary() + "円");
	}
	
	public void reportAll(Iterable<? extends Employee6> employees) {
		for (Employee6 e : employees) report(e);
	}
}
	
public class Main_G {
	public static void main(String[] args) {
		List<Employee6> members = List.of(
				new neoFullTimeEmployee("佐藤", 9),
				new neoContractEmployee("鈴木", 7),
				new neoFullTimeEmployee("田中", 8)
			);
		SalaryService service = new SalaryService(new ConsoleReporter());
		service.reportAll(members);
	}

}
