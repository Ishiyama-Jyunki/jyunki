package obj3;

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee();
		
		emp.setEmployeeId ("E002");
		emp.setName ("田中花子");
		
		System.out.println("社員ID:" + emp.getEmployeeId() + "名前;" + emp.getName());
	}
}
