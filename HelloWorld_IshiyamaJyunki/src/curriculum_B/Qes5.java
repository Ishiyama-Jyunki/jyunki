package curriculum_B;


public class Qes5 {

	/*
	* 引数なし、戻り値なしで"Hello,World"を表示
	*/
	public static void helloWorld() {
		System.out.println("Hello,World!");
	}

	/*
	 * 引数：整数(int num)、戻り値：整数(引数の二倍の値）
	 * 戻り値をもとに、"10を2倍すると20です"と表示
	 */

	public static int doubleValue(int num) {
		return num * 2;
	}

	/*
	 * 引数:整数(int num)、戻り値:true(偶数なら)、false(奇数なら)
	 * これらを利用して"10は偶数です。7は奇数です。"と表示
	 * メソッドはisEven
	 */

	public static boolean isEven(int num) {
		return num % 2 == 0;
	}

	/*
	 * 次の2つのクラスを作成し、MainクラスからGreetingクラスを
	 * 呼び出すようにしてください。
	 * Greeting.java(別のクラス) sayHello()メソッドを持ち、”こんにちは！”を表示
	 * Main.java GreetingクラスをインポートしてsayHello()を表示
	 */
	public void sayHello() {
		System.out.println("こんにちは！");
	}

	/*
	 次の2つのクラスを作成し、下記コンソールが出力されるように作成してください
	 * ※thisとsetterとフィールドを使用してください
	 * 動物名：ライオン
	 * 体長：2.1m
	 * 速度：80km/h
	 * Animal.java(別のクラス) 動物名、体長、速度の変数を持ち各変数のgetterとsetterを作成
	 * Main.java 変数の中身を設定し、出力の処理を行う
	 */

	public static class Animal {
		private String name;
		private double length;
		private int speed;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;

		}

		public void setLength(double length) {
			this.length = length;
		}

		public double getLength() {
			return this.length;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public int getSpeed() {
			return this.speed;
		}
	}

	//まとめて実行

	public static void main(String[] args) {
		//問1
		helloWorld();

		//問2
		int original = 10;
		int result = doubleValue(original);

		System.out.println(original + "を2倍にすると" + result + "です");

		//問3
		int num1 = 7;
		int num2 = 10;

		if (isEven(num2)) {
			System.out.println(num2 + "は偶数です。");
		} else {
			System.out.println(num2 + "は奇数です。");
		}

		if (isEven(num1)) {
			System.out.println(num1 + "は偶数です。");
		} else {
			System.out.println(num1 + "は奇数です。");

		}

		//問4
		Greeting greeting = new Greeting();
		greeting.sayHello();

		//問5
		Animal lion = new Animal();

		lion.setName("ライオン");
		lion.setLength(2.1);
		lion.setSpeed(80);

		System.out.println("動物名:" + lion.getName());
		System.out.println("体長:" + lion.getLength() + "m");
		System.out.println("速度:" + lion.getSpeed() + "km/h");
	}

}
