package obj7;



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

abstract class Employee{
	private final String name;
	private final int hoursWorked;
	private final PayPolicy policy;
	
	protected Employee(String name, int hoursWorked, PayPolicy policy) {
		this.name = name;
		this.hoursWorked = hoursWorked;
		this.policy = policy;
	}
	public String getName() {return name;}
	public int getHoursWorked() {return hoursWorked;}
	public int salary() {return policy.calculate(hoursWorked);}
}

class neoFullTimeEmployee extends Employee {
	public neoFullTimeEmployee(String name, int hours) {
		super(name, hours, new FullTimePayPolicy());
	}
}

class neoContractEmployee extends Employee{
	public neoContractEmployee(String name, int hours) {
		super(name, hours, new ContractPayPolicy());
	}
}

class SalaryService{
	private final Reporter reporter;
	public SalaryService(Reporter reporter) {this.reporter = reporter;}
	
	public void report(Employee e) {
		reporter.print(e.getName() + "の給料は" + e.salary() + "円");
	}
	
	public void reportAll(Iterable<? extends Employee> employees) {
		for (Employee e : employees) report(e);
	}
}