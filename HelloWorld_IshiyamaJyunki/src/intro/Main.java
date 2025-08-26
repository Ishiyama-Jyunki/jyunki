package intro;

public class Main {
	public static void main(String[] args) {
		Person person1 = new Person("山田太郎", 20, 1.7, 60.0);
		Person person2 = new Person("鈴木花子", 25, 1.6, 50.0);

		person1.print();
		person2.print();

		Person.printCount();
	}
}
