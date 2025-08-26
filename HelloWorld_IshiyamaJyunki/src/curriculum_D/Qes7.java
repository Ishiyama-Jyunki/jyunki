package curriculum_D;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * 「Player vs Daemon」バトルプログラム					
					
✅ Playerの名前を入力し、ステータス（HP, AT, SP）をランダム設定					
✅ Daemonのステータスは事前にテキストファイルから読み込み					
✅ スピード（SP）が高い方が先に攻撃、同じ場合はランダムで決定					
✅ バトルの結果をテキストファイルに出力					
✅ ターン制バトルを行い、どちらかのHPが0以下になるまで続ける					
					
Character クラス → 共通のキャラクター情報（HP, AT, SP）を管理					
loadDaemon メソッド → Daemon のステータスをテキストファイルから読み込む					
					
					
バトルの流れ					
	先攻決定（SPが高い方 / 同じならランダム）				
	交互に攻撃し、HPが0以下になったら終了				
	結果を battle_log.txt に記録				
					
					
					
Daemonのステータスファイル (daemon_status.txt) の例					
Daemon					
85					
12					
6					

 */

class Character {
	protected String name;
	protected int hp;
	protected int at;
	protected int sp;

	public Character(String name, int hp, int at, int sp) {
		this.name = name;
		this.hp = hp;
		this.at = at;
		this.sp = sp;
	}

	public boolean isDead() {
		return hp <= 0;
	}

	public int attack(Character target) {
		int damage = Math.max(1, this.at);
		target.hp = Math.max(0, target.hp - damage);
		return damage;
	}

	@Override
	public String toString() {
		return String.format("%s (HP:%d. AT:%d, SP:%d)", name, hp, at, sp);
	}
}

class DeamonLoader {
	private String filePath;

	public DeamonLoader(String filePath) {
		this.filePath = filePath;
	}

	public Character load() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			for (String raw : lines) {
				String line = raw.trim();
				if (line.isEmpty())
					continue;

				String[] parts = line.split("\\s+");
				if (parts.length < 4) {
					System.out.println("フォーマットが間違ってます。例:Deamon 85 12 6");
					return null;
				}

				String name = parts[0];
				int hp = Integer.parseInt(parts[1]);
				int at = Integer.parseInt(parts[2]);
				int sp = Integer.parseInt(parts[3]);

				return new Character(name, hp, at, sp);
			}
			System.out.println("ファイルに有効な行がありません。");
			return null;
		} catch (IOException e) {
			System.out.println("ファイル読み込みエラー:" + e.getMessage());
			return null;
		}
	}
}

public class Qes7 {
	public static void main(String[] args) {
		final String DEAMON_FILE = "src/curriculum_D/deamon_status.txt";
		Random rand = new Random();

		//デーモン
		try (Scanner sc = new Scanner(System.in)) {
			DeamonLoader loader = new DeamonLoader(DEAMON_FILE);
			Character deamon = loader.load();
			if (deamon == null) {
				System.out.println("Deamonのロードに失敗しました。終了します。");
				return;
			}

			//プレイヤー
			System.out.println("プレイヤー名を入力");
			String playerName = sc.nextLine().trim();
			if (playerName.isEmpty())
				playerName = "player";

			int pHP = rand.nextInt(26) + 75;
			int pAT = rand.nextInt(11) + 10;
			int pSP = rand.nextInt(11) + 10;
			Character player = new Character(playerName, pHP, pAT, pSP);

			System.out.println("\n===バトル開始===");
			System.out.println(player);
			System.out.println(deamon);

			Character attacker = null;
			Character defender = null;
			if (player.sp > deamon.sp) {
				attacker = player;
				defender = deamon;
				System.out.println("先攻:" + player.name);
			} else if (player.sp < deamon.sp) {
				attacker = deamon;
				defender = player;
				System.out.println("先攻:" + deamon.name);
			} else {
				if (rand.nextBoolean()) {
					attacker = player;
					defender = deamon;
					System.out.println("先攻:" + player.name + "(ランダム)");
				} else {
					attacker = deamon;
					defender = player;
					System.out.println("先攻:" + deamon.name + "(ランダム)");
				}
			}

			int turn = 1;
			while (true) {
				System.out.printf("\n-- Turn %d --\n", turn);

				int dmg = attacker.attack(defender);
				System.out.printf("%s の攻撃! %s に %d ダメージ!\n",
						attacker.name, deamon == defender ? deamon.name : player.name, dmg);
				System.out.printf("残りHP: %s=%d / %s=%d\n",
						attacker.name, attacker.hp, defender.name, defender.hp);

				if (defender.isDead()) {
					System.out.println("\n" + defender.name + "は倒れた！");
					System.out.println("勝者:" + attacker.name);
					break;
				}

				Character tmp = attacker;
				attacker = defender;
				defender = tmp;
				turn++;
			}
		}

	}

}
