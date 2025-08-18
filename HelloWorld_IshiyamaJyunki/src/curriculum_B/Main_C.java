package curriculum_B;

/*
 *③カプセル化 						
次の条件に沿って Java プログラムを作成し、出力してください。						
条件						
１	Employee クラスを作成し、以下のプライベートフィールドを定義する。					
		employeeId（文字列型）				
		name（文字列型）				
２	これらのフィールドにアクセスするために、以下のメソッドを用意する。					
		public void setEmployeeId(String id)				
		public String getEmployeeId()				
		public void setName(String name)				
		public String getName()				
３	Main クラスで Employee オブジェクトを生成し、set メソッドで「E002」「田中花子」を設定後、get メソッドで出力する。					
						
出力						
	社員ID: E002, 名前: 田中花子					

 */

public class Main_C {
	public static void main(String[] args) {
		Employee3 emp2 = new Employee3();
		
		emp2.setEmployeeId ("E002");
		emp2.setName ("田中花子");
		
		System.out.println("社員ID:" + emp2.getEmployeeId() + "名前;" + emp2.getName());
	}

}

class Employee3{
	
	private String employeeId;
	private String name;
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
		
	}
		
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String getEmployeeId() {
		return this.employeeId;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
	
}
