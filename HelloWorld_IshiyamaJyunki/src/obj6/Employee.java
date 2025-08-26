package obj6;


interface Billable{
	int costForDay(int hoursWorked);
}

abstract class NewEmployee implements Billable{
	protected final String id;
	protected final String name;
	
	public NewEmployee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("%s{id= '%s, name='%s'}",
				this.getClass().getSimpleName(), id, name);
	}
}

class newFulltimeEmployee extends NewEmployee{
	public newFulltimeEmployee(String id, String name) {
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

class newContractEmployee extends NewEmployee{
	public newContractEmployee(String id, String name) {
		super(id, name);
		
	}
	
	@Override
	public int costForDay(int hoursWorked) {
		final int hourly = 1000;
		return hoursWorked * hourly;
	}
}



