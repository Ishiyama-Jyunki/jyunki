package curriculumA;

public class Qes1 {

	private static final String String = null;

	public static void main(String[] args) {

		//各型の変数を宣言し、初期値を設定してください。
		byte byteNum = 0;
		short shortNum = 0;
		int intNum = 0;
		long longNum = 0L;
		float floatNum = 0.0f;
		double doubleNum = 0.0d;
		char letter = '\u0000';
		String letters = null;
		boolean isBoolean = false;

		//1で宣言した各型の変数に指定された値を代入してください。
		byteNum = 10;
		shortNum = 100;
		intNum = 1000;
		longNum = 10000;
		floatNum = 9.5f;
		doubleNum = 10.5;
		letter = 'a';
		letters = "ハロー";
		isBoolean = true;

		//値を代入した変数を用いて出力してください。
		System.out.println(byteNum + shortNum + intNum + longNum);
		System.out.println(byteNum * 2);
		System.out.println(letter + letters + isBoolean);
		System.out.println(byteNum * 3 + shortNum + intNum + longNum);
		System.out.println(byteNum * shortNum * intNum * longNum);
		System.out.println(doubleNum / shortNum);
		System.out.println(byteNum - shortNum);

		/*nameというString型の変数を宣言し
		その変数に"山田太郎"という値を代入してください。
		name変数を使用してコンソールにこんにちは、山田太郎さん！と表示してください。*/
		String name = null;
		name = "山田太郎";
		System.out.println("こんにちは、" + name + "さん！");

		/*ageというint型の変数を宣言し、
		 その変数に25を代入してください。
		 age変数を使用してコンソールに年齢:25歳を代入してください*/
		int age = 0;
		age = 25;
		System.out.println("年齢:" + age + "歳");

		/*num1というint型の変数を宣言し、10を代入
		  num2というint型の変数を宣言し、5を代入
		  num1とnum2を足した結果をsumという変数に代入し、コンソールに表示してください。*/
		int num1 = 10;
		int num2 = 5;
		int sum = num1 + num2;
		System.out.println(sum);

		/*scoreというint型の変数を宣言し、80を代入
		 scoreに20を加えて、更新する
		 最終スコア:100をscoreを使用してコンソールに表示してください*/
		int score = 80;
		System.out.println(score); //出力:80
		score = score + 20; //scoreに20を足して更新
		System.out.println(score); //出力:最終スコア:100

		/*priceというdouble型の変数を宣言し、99.99を代入
		 priceをint型に変換し、整数価格:99とコンソールに表示してください*/
		double price = 99.99;
		int intprice = (int) price;
		System.out.println("整数価格:" + intprice);

		/*String型の変数numStrを宣言し、"123"を代入
		 numStrをint型に変換し、
		 変換後の値:の後ろにnumStr+10した結果をコンソールに表示してください
		 */
		String numStr = "123";
		int num = Integer.parseInt(numStr);
		int result = num + 10;
		System.out.println("変換後の値:" + result);

		/*int型の変数numに50を代入
		 * numをString型に変換し、得点:50の形で表示
		 */
		int num3 = 50;
		String numStr1 = java.lang.String.valueOf(num3);
		System.out.println("得点:" + numStr1 + "点");

		/*次の条件を満たすプログラムを条件演算子を使用して作成してください。
		 * int型の変数aに10を代入
		 * int型の変数bに20を代入
		 * aが少ないかどうかをboolean変数reaultに代入
		 * resultの値を表示
		 */
		int a = 10;
		int b = 20;
		boolean result1 = a < b;
		System.out.println("result:" + result1);

		/*条件演算子（三項演算子）を使用してください。
		 * int型の変数xに15を代入
		 * xが10以上なら"OK"、そうでなければ"NG"を表示	   
		 */
		int x = 15;
		String result2 = (x >= 10) ? "OK" : "NG";
		System.out.println(result2);

		/*String text = 私はJavaが好きです。Javaは楽しい！という
		 * 文章の中にある[Java]を[Python]に置き換えて表示してください
		 * 
		 */
		String text = "私はJavaが好きです。Javaは楽しい!";
		String replacedText = text.replace("Java", "Python");
		System.out.println(replacedText);

	}
}
