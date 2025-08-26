package curriculum_C;

import java.util.Random;
import java.util.Scanner;

public class Qes6 {

	public static void main(String[] args) {
		Player player = new Player();
		CPU cpu = new CPU();

		boolean win = false;

		while (!win) {
			int pHand = player.chooseHand();
			int cHand = cpu.chooseHand();

			if (pHand == cHand) {
				System.out.println("あいこです。もう一度！");
			} else if ((pHand == 0 && cHand == 1) ||
					(pHand == 1 && cHand == 2) ||
					(pHand == 2 && cHand == 0)) {
				System.out.println("あなたの勝ちです。");
				win = true;
			} else {
				System.out.println("あなたの負けです。勝つまでやりましょう！");
			}
		}
		System.out.println("ゲームは終了しました。");
	}
}

class Player {
	private Scanner scanner = new Scanner(System.in);
	private String[] hands = { "グー", "チョキ", "パー" };

	public int chooseHand() {
		System.out.print("グー(0),チョキ(1),パー(2) 選んで入力:");
		int choice = scanner.nextInt();
		if (choice < 0 || choice > 2) {
			System.out.println("0～2を入力してください");
			return chooseHand();
		}
		System.out.println("あなたの手:" + hands[choice]);
		return choice;
	}

	public String getHandName(int hand) {
		return hands[hand];
	}
}

class CPU {
	private Random random = new Random();
	private String[] hands = { "グー", "チョキ", "パー" };

	public int chooseHand() {
		int choice = random.nextInt(3);
		System.out.println("CPUの手:" + hands[choice]);
		return choice;
	}

	public String getHandName(int hand) {
		return hands[hand];
	}
}
