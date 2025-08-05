package curriculum_B;

import java.util.Scanner;

public class Qes4 {


	public static void main(String[] args) {

		/*int型の配列を作成し、1,2,3,4,5を格納する
		 * 配列の全要素を順番に表示
		 */
		int[] numbers = {1,2,3,4,5};
		for (int i = 0; i < numbers.length; i++){
			System.out.println(numbers[i]);
		}

		/*int型の配列{10,20,30,40,50}を用意する
		 * 配列の要素を逆順に表示
		 */
		int[] numbers2 = {10,20,30,40,50};
		for (int i = numbers2.length - 1; i >= 0; i--){
			System.out.println(numbers2[i]);
		}

		/*int型の配列{3,5,7,9,11}を用意する
		 * 配列の全要素の合計を計算し、表示
		 */
		int sum = 0;
		int[] numbers3 = {3,5,7,9,11};
		for (int i = 0; i < numbers3.length; i ++ ) {
			sum += numbers3[i];}
		System.out.println(sum);


		/*int型の配列{12,7,9,21,5,18}を用意
		 * 最大値と最小値を求めて表示
		 */
		int[] numbers4 = {12,7,9,21,5,18};

		int max = numbers4[0];
		int min = numbers4[0];

		for (int num : numbers4) {
			max = (num > max) ? num : max;
			min = (num < min) ? num : min;
		}
		System.out.println("最大値:" + max);
		System.out.println("最小値:" + min);




		/*int型の配列{1,2,3,4,5}を用意
		 * 配列の全ての要素を二倍し、結果を表示
		 * 結果を処理する際の表示に拡張for文を使用
		 */
		int[] numbers5 = {1,2,3,4,5};
		for (int num : numbers5) {
			System.out.println(num * 2);
		}
		/*int型の配列{4.7.10.15.20}を用意
		 * 入力した数が配列に含まれているのかを判定して表示
		 */
		int [] numbers6 = {4,7,10,15,20};

		Scanner scanner = new Scanner (System.in);
		System.out.print("数値を入力してください");
		int input = scanner.nextInt();

		boolean found = false;
		for (int num : numbers6) {
			if (num == input) {
				found = true;
				break;
			}
		}

		if (found) {
			System.out.println(input + "は配列に含まれています");
		} else {
			System.out.println(input + "は配列に含まれていません");
		}
		scanner.close();

		/*二次元配列int[][] array=[1.2][3.4][5.6]
		 * の要素を全て表示
		 */
		int[][] array = {
				{1, 2},
				{3, 4},
				{5, 6}
		};

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
		/*二次元配列int[][] array = {{10,20,30,}{40,50,60}{70,80,90}};
		 * を用意する。配列内の合計を表示
		 */
		int[][] array2 = {
				{10, 20, 30},
				{40, 50, 60},
				{70, 80, 90}
						
				};
		
		int sum2 = 0;
		
		for (int i = 0; i < array2.length; i ++) {
			for (int j = 0; j < array2[i].length; j ++) {
				sum2 += array2[i][j];
			}
		
		}
		System.out.println("配列内の合計:" + sum2);
		
		/*二次元配列int[][] array = {{12,15,8},{6,19,25},{30,2,10}}を用意
		 * 配列内の最大値と最小値を表示
		 */
		int[][] array3 = {
				{12, 15, 8},
				{6, 19, 25},
				{30, 2, 10},
		};
		
		int max2 = array3[0][0];
	    int min2 = array3[0][0];
	    
	    for (int i = 0; i < array3.length; i ++) {
	    	for (int j = 0; j < array3[i].length; j ++) {
	    		if (array3[i][j] > max2) {
	    			max2 = array3[i][j];
	    		}
	    		if (array3[i][j] < min2) {
	    			min2 = array3[i][j];
	    		}
	    	}
	    }
	    System.out.println("最大値:" + max2);
	    System.out.println("最小値:" + min2);
	    
	    /*三次元配列int[][] array = {{{1,2},{3,4}},{{5,6},{7,8}}};を用意
	     * 配列内の全ての要素を表示
	     */
	    int[][][] array4 = {
	    		{
	    			{1, 2},
	    			{3, 4}
	    		},
	    		{
	    			{5, 6},
	    			{7, 8}
	    		}
	    };
	    
	    for (int i = 0; i < array4.length; i ++) {
	    	for (int j = 0; j < array4[i].length; j ++) {
	    		for (int k = 0; k < array4[i][j].length; k ++) {
	    			System.out.print(array4[i][j][k] + "");
	    		}
	    		System.out.println();	    		
	    	}
	    	System.out.println("---");
	    
	    		
	    }

	}
}

