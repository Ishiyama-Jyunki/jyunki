package curriculum_B;

/*
 *②クラスとオブジェクト 						
次の条件に沿って Java プログラムを作成し、出力してください。						
条件						
１	クラス名は Employee とする。					
２	Employee クラスに以下のメンバを持たせる。					
		employeeId（文字列型）フィールド				
		name（文字列型）フィールド				
		showInfo() メソッド：社員ID: [employeeId], 名前: [name] と出力する。				
３	Main クラスに main() メソッドを作り、以下の操作を行う。					
		Employee クラスのインスタンスを生成する。				
		employeeId に「E001」、name に「佐藤太郎」を設定する。				
		showInfo() を呼び出して、出力を確認する。				
						
出力						
	社員ID: E001, 名前: 佐藤太郎					

 */


public class Main_B {
	public static void main(String[] args) {
		Employee2 emp = new Employee2();
		
		emp.employeeId = "E001";
		emp.name = "佐藤太郎";
		
		emp.showInfo();
	}

}

class Employee2 {
	String employeeId;
	String name;
	
	void showInfo() {
		System.out.println("社員ID:" + employeeId + "名前;" + name);
	}
}
