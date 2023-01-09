
public class Refree {
	Player p1;
	Player p2;
	boolean game;
	int win;
	int maxwin;

	public void start(Player play1, Player play2) {
		System.out.println("게임을 시작합니다.");
		p1 = play1;
		p2 = play2;
		p1.user = true;
		win = 0;
		maxwin = 0;
		game = true;
		while (game) {
			gethand(p1);
			gethand(p2);
			judge();
		}
		System.out.printf("게임 결과는 %d 연승입니다.", maxwin);
	}

	public void gethand(Player P) {
		while (true) {
			P.fire();
			if (P.ans > 0 && P.ans < 4) {
				break;
			}
		}
	}

	public void judge() {
		int r = (p1.ans - p2.ans + 3) % 3;
		switch (r) {
		case 0:
			System.out.println("비겼다!");
			maxwin = maxwin > win ? maxwin : win;
			win = 0;
			break;
		case 1:
			System.out.println("승리!");
			win++;
			break;
		case 2:
			System.out.println("패배!");
			maxwin = maxwin > win ? maxwin : win;
			win = 0;
			game = false;
			break;
		default:
			break;

		}
	}

}
