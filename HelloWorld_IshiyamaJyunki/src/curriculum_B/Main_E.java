package curriculum_B;

/*
 * ポリモーフィズム 						
すでに以下のクラスが定義されています。						
	abstract class Employee {					
	protected String id;					
	protected String name;					
	public Employee(String id, String name) {					
	this.id = id;					
	this.name = name;					
	}					
	public abstract int calculateDailyWage(int hoursWorked);					
	}					
						
	class FullTimeEmployee extends Employee {					
	public FullTimeEmployee(String id, String name) {					
	super(id, name);					
	}					
	@Override					
	public int calculateDailyWage(int hoursWorked) {					
	int hourlyRate = 1250;					
	int overtime = Math.max(0, hoursWorked - 8);					
	int regularHours = hoursWorked - overtime;					
	return (regularHours * hourlyRate) + (int)(overtime * hourlyRate * 1.25);					
	}					
	}					
						
	class ContractEmployee extends Employee {					
	public ContractEmployee(String id, String name) {					
	super(id, name);					
	}					
	@Override					
	public int calculateDailyWage(int hoursWorked) {					
	int hourlyRate = 1000;					
	return hoursWorked * hourlyRate;					
	}					
	}					
						
以下を実装してください。						
１	社員リスト（List<Employee>）に FullTimeEmployee と ContractEmployee を複数追加する。					
２	for-each ループで calculateDailyWage を呼び出し、各社員の給料を出力する。					
３	サブクラスを明示的に扱わずに、共通の Employee 型で実装する。					

 */
import java.util.ArrayList;
import java.util.List;

public class Main_E {
	public static void main(String[] args) {

		List<EmployeeBase> employees = new ArrayList<>();

		employees.add(new FullTimeEmployee2("E001", "山田太郎"));
		employees.add(new FullTimeEmployee2("E002", "佐藤花子"));
		employees.add(new ContractEmployee("F001", "砂本晴充"));
		employees.add(new ContractEmployee("F002", "川西温大"));

		for (EmployeeBase emp : employees) {

			int wage = emp.calculateDailyWage(9);
			System.out.println(emp.getName() + "の給与:" + wage + "円");
		}
	}

}

abstract class EmployeeBase {
	protected String id;
	protected String name;

	public EmployeeBase(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public abstract int calculateDailyWage(int hoursWorked);
}

class FullTimeEmployee2 extends EmployeeBase {
	public FullTimeEmployee2(String id, String name) {
		super(id, name);
	}

	@Override
	public int calculateDailyWage(int hoursWorked) {
		int hourlyRate = 1250;
		int overtime = Math.max(0, hoursWorked - 8);
		int regularHours = hoursWorked - overtime;
		return (regularHours * hourlyRate) + (int) (overtime * hourlyRate * 1.25);
	}
}

class ContractEmployee extends EmployeeBase {
	public ContractEmployee(String id, String name) {
		super(id, name);
	}

	@Override
	public int calculateDailyWage(int hoursWorked) {
		int hourlyRate = 1000;
		return hoursWorked * hourlyRate;
	}
}
