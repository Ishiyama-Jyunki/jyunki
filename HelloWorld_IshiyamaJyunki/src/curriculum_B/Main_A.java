package curriculum_B;

/*①基本概念
 * 次の条件に沿って Java プログラムを作成し、出力してください。						
条件						
１	クラス名は Employee とする。					
２	Employee クラスには以下のメンバを持たせる。					
・	name（文字列型）フィールド				
・	work() メソッド：[name]は働いています。 と出力する。				
３	Main クラスに main() メソッドを作り、以下の操作を行う。					
・	Employee クラスのインスタンス（オブジェクト）を生成する。				
・	name に「山田太郎」を設定する。				
・	work() を呼び出して出力を確認する。				

出力						
山田太郎は働いています。					
 */

public class Main_A {
	public static void main(String[] args) {

		EmployeeBase employee = new EmployeeBase();

		employee.name = "山田太郎";

		employee.work();
	}
}

class Employee {
	String name;

	void work() {
		System.out.println(name + "は働いています");
	}

}
