package intro;

public class Person {
String name;
int age;
double height;
double weight;

static int count = 0;

public Person (String name, int age, double height, double weight){
	this.name = name;
	this.age = age;
	this.height = height;
	this.weight = weight;
	count++;
}

double bmi() {
	return this.weight / (this.height * this.height);
}

void print() {
	System.out.println("名前は" + this.name + "です");
	System.out.println("年齢は" + this.age + "です");
	System.out.println("bmiは" + this.bmi() + "です");
	System.out.println("---------------------------------");
}

static void printCount() {
	System.out.println("合計" + count + "人です");
}
}
