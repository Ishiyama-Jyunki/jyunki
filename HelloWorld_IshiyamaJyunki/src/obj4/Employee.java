package obj4;

abstract class Enployee {
	protected String employeeId;
	protected String name;

	public Enployee(String employeeId, String name) {
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

class FullTimeEmployee extends Enployee {

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

class PartTimeEmployee extends Enployee{

	private static final int HOURLY_RATE = 1000;

	public PartTimeEmployee(String employeeId, String name) {
		super(employeeId, name);

	}

	@Override

	public int calculateDailyWage(int hoursWorked) {
		return hoursWorked * HOURLY_RATE;

	}
}