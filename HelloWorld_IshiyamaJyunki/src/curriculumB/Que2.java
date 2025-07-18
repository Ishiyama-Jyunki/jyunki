package curriculumB;

public class Que2 {
	private static final String String = null;

	public static void main(String[] args) {
	

/*int型の変数scoreに75を代入
 * ageが60以上なら"合格です！"と表示		
 */
  int score = 75;if (score >= 60);
  System.out.println("合格です！");
 
 /*int型の変数ageに25を代入
  *ageが20以上30以下なら"適正年齢です"と表示
  *それ以外なら"対象外です"と表示
  */
  int age = 25;
  if (age >= 20 && age <= 30)
  System.out.println("適正年齢です");
  else if (age < 20 || age > 30)
  System.out.println("対象外です");
  
 /*int型の変数ageに18を代入
  * ageが20以上なら"成人です"と表示
  * ageが13以上19以下なら"ティーンエイジャーです"と表示
  * ageが12以下なら"子供です"と表示
  */
  int age2 = 18;
  if (age2 >= 20)
	  System.out.println("成人です");
  else if (age2 >=13 && age2 <= 19)
	  System.out.println("ティーンエイジャーです");
  else if (age2 <= 12)
	  System.out.println("子供です");
  
  /*int型の変数x,y,zに30,15,50を代入
   * 一番大きい数値を判定して表示
   */
  int x = 30;
  int y = 15;
  int z = 50;
  int max = (x > y) ? ((x > z) ? x : z) : (( y > z ) ? y : z);
  System.out.println("最大値は" + max + "です");
  
  /*int型の変数numを用意
   * numの値が0よりも大きければ"正の数です"と表示
   * numの値が0なら"0です"と表示
   * numの値が0より小さければ"負の数です"と表示
   */
  int num = -8;
  if (num > 0)
	  System.out.println("正の数です");
  else if (num == 0)
	  System.out.println("0です");
  else
	  System.out.println("負の数です");
  
  /*int型の変数numを用意
   * numが偶数なら"偶数です"と表示
   * numが奇数なら"奇数です"と表示
   */
  int num2 = 73;
  if (num2 % 2 == 0)
	  System.out.println("偶数です");
  else 
      System.out.println("奇数です");
  
  /*int型の変数scoreに0から100の値を代入
   * 90以上なら"優"
   * 70以上なら"良"
   * 50以上なら"可"
   * 50未満なら"不可"を表示
   */
  int score2 = 33;
  String result = (score2 >= 90) ? "優":
	              (score2 >= 70) ? "良":
	              (score2 >= 50) ? "可": "不可";
  System.out.println(result);
  
  /*入力がnullまたは空文字("")のときに「入力が無効です」
   * と表示される処理を作成してください
   */
  String input = "";
  if (input == null || input.isEmpty())
	  System.out.println("「入力が無効です」");
  /*int 型の変数 day を用意（1～7 の数値を代入）		
day の値に応じて曜日を表示		
1 → "月曜日"		
2 → "火曜日"		
3 → "水曜日"		
4 → "木曜日"		
5 → "金曜日"		
6 → "土曜日"		
7 → "日曜日"		
それ以外の値なら "無効な入力です" と表示		
※Switch文を使用してください		
*/
  int day = 4;
  switch (day) {
  case 1:
   System.out.println("月曜日");
  break;
  case 2:
   System.out.println("火曜日");
  break;
  case 3:
   System.out.println("水曜日");
  break;
  case 4:
   System.out.println("木曜日");
  break;
  case 5:
   System.out.println("金曜日");
  break;
  case 6:
   System.out.println("土曜日");
  break;
  case 7:
   System.out.println("日曜日");
  break;
  default:
   System.out.println("無効な入力です");
     }
    

/*int 型の変数 month を用意（1～12 の数値を代入）			
month の値に応じて季節を表示			
12, 1, 2 → "冬"			
3, 4, 5 → "春"			
6, 7, 8 → "夏"			
9, 10, 11 → "秋"			
それ以外の値なら "無効な月です" と表示			
※Switch文を使用してください			
*/
 int month = 17;
 switch (month) {
 case 12: case 1: case 2:
	System.out.println("冬です");
	break;
 case 3: case 4: case 5:
	System.out.println("春です");
    break;
 case 6: case 7: case 8:
	System.out.println("夏です");
	break;
 case 9: case 10: case 11:
	System.out.println("秋です");
	break;
	default:
		System.out.println("無効な月です");
  }
 }
}
 
