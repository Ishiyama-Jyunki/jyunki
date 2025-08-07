package curriculum_B;

import java.util.Random;

public class Qes3 {

	public static void main(String[] args) {

		/*for 文を使って 1 から 10 までの数字を 1 つずつ表示
		 * 			
		 */
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		/*for 文を使って 2 から 20 までの 偶数 を 1 つずつ表示			
		 */
		for (int i2 = 2; i2 <= 20; i2 += 2) {
			System.out.println(i2);
		}

		/*for 文を使って 10 から 1 まで カウントダウンして表示			
		 * 
		 */
		for (int i3 = 10; i3 >= 1; i3--) {
			System.out.println(i3);
		}

		/*for 文を使って 1 から 100 までの合計 を表示		
		 * 
		 */
		int sum = 0;
		for (int i3 = 1; i3 <= 100; i3++) {
			sum += i3;
		}
		System.out.println("1から100までの合計は" + sum + "です");

		/*for 文を使って 以下のような三角形を出力		
		 *		
		 **		
		 ***		
		 ****		
		 *****		
		 * 
		 */
		for (int i4 = 1; i4 <= 5; i4++) {
			// アスタリスクをi個入力
			for (int j = 1; j <= i4; j++) {
				System.out.print("*");
			}
			// 
			System.out.println();
		}

		/*while 文を使って 1 から 10 まで を 1 つずつ表示			
		 * 
		 */
		int i5 = 1;

		while (i5 <= 10) {
			System.out.println(i5);
			i5++;
		}

		/*while 文を使って 2 から 20 までの偶数 を 1 つずつ表示			
		 * 
		 */
		int i6 = 2;

		while (i6 <= 20) {
			System.out.println(i6);
			i6 += 2;
		}

		/*while 文を使って 10 から 1 まで のカウントダウンを表示			
		 * 
		 */
		int i7 = 10;

		while (i7 >= 1) {
			System.out.println(i7);
			i7--;
		}

		/*while 文を使って 1 から 100 までの合計 を表示			
		 * 
		 */
		int sum2 = 0;
		int i8 = 1;

		while (i8 <= 100) {
			sum2 += i8;
			i8++;
		}
		System.out.println(sum2);

		/*for文を使用して下記の通りに出力してください			
		 * 
		 */
		// 左の数
		for (int i9 = 1; i9 <= 9; i9++) {
			// 右の数
			for (int j2 = 1; j2 <= 9; j2++) {
				int result = i9 * j2;
				// i5 * jの形式
				System.out.printf("%02d * %02d = %02d" , j2, i9, result);
				if (j2 != 9) {
					System.out.print("||");
				}
			}

			System.out.println();
		}

		/*入力した商品の残り台数が出力されるシステムを下記の条件で作成してください									
		・拡張for文・Switch文・条件演算子を使用すること　※普通のif文は使用不可									
		・Switch文内でテレビとディスプレイは続けて書き、条件演算子で各項目を出力される値を変更してください									
		・テレビとディスプレイは同じ商品扱いとし、二つの合計値は常に11になるようにしてください。 									
		・例：テレビと受け取った場合、→「テレビの残り台数は〇台です」※〇はランダムで出た数字　ディスプレイは（11-〇）の値									
		・入力される値は右記の表のどれかが入力され、入力回数の縛りはありません									商品一覧
		・入力された値は「、」区切りで指定してください									パソコン
		・そのほかの値が入力された場合下記を出力されるようにしてください									冷蔵庫
		『受け取った値』は指定の商品ではありません								扇風機
		・残り台数は0〜11までのランダムな値が出力されるようにしてください									洗濯機
									加湿器
		入力例↓↓									テレビ
		パソコン、冷蔵庫、扇風機、洗濯機、加湿器、テレビ、ディスプレイ、その他商品									ディスプレイ
		
		出力例↓↓									
		パソコンの残り台数は8台です									
		冷蔵庫の残り台数は7台です									
		扇風機の残り台数は7台です									
		洗濯機の残り台数は10台です									
		加湿器の残り台数は3台です									
		テレビの残り台数は9台です									
		ディスプレイの残り台数は2台です									
		『 その他商品 』は指定の商品ではありません									
		 * 
		 */

		String input = "パソコン、冷蔵庫、扇風機、洗濯機、加湿器、テレビ、ディスプレイ、その他商品";

		String[] items = input.split("、");

		Random rand = new Random();

		int tvCount = rand.nextInt(12);
		int displayCount = 11 - tvCount;

		for (String item : items) {
			switch (item) {
			case "テレビ":
			case "ディスプレイ":

				String message = item.equals("テレビ")
						? "テレビの残り台数は" + tvCount + "台です"
						: "ディスプレイの残り台数は" + displayCount + "台です";
				System.out.println(message);
				break;

			case "パソコン":
			case "冷蔵庫":
			case "扇風機":
			case "洗濯機":
			case "加湿器":

				int count = rand.nextInt(12);
				System.out.println(item + "残りの台数は" + count + "台です");
				break;

			default:
				System.out.println("「" + item + "」は指定の商品ではありません");
				break;
			}
		}
	}

}
