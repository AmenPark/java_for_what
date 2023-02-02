package com.PAM.lastJaVa;

import java.util.ArrayList;
import java.util.Scanner;

public class RSP_View {
	private Scanner _in;

	public RSP_View() {
		_in = new Scanner(System.in);
	}

	public void showmenual() {
		System.out.println("=========================================");
		System.out.println("=======이 게임을 진행하기 위한 메뉴얼입니다.========");
		System.out.println("=========================================");
		System.out.println("|가위바위보 배팅게임입니다.");
		System.out.println("|최대배팅은 본인의 현재 점수만큼이며, 최소값은 라운드입니다.");
		System.out.println("|초기 점수는 50점에서 시작합니다.");
		System.out.println("|승리하면 배팅한 만큼 점수가 증가하며, 패배하면 그만큼 감소합니다.");
		System.out.println("|하드모드는 제작하지 않았습니다.");
		System.out.println("|사람별 점수 기록을 보고싶다면 ranking을 입력하세요.");
		System.out.println("|중복 점수 기록을 보고싶다면 score을 입력하세요.");
		System.out.println("|게임은 start를 입력하여 시작합니다.");
		System.out.println("|게임 시작시 1- 가위, 2- 바위, 3- 보 를 입력하여 가위바위보를 실행합니다.");
		System.out.println("|배팅은 bat을 입력 후 숫자를 입력하여 배팅 가능합니다.");
		System.out.println("|언제든지 도움말, f1을 입력하면 이 문장들을 다시 볼 수 있습니다.");
		System.out.println("|게임중 1,2,3, help(또는 f1), bat, exit 외의 명령어는 무시됩니다.");
		System.out.println("|게임을 중단하고 스코어를 기록하고 싶다면 exit를 입력하세요.");
		System.out.println("=========================================");
	}

	public void showGameInfo(RSPGameData data) {
		System.out.println("=========================================");
		System.out.println("|지금은 " + data.getRound() + "라운드 입니다.");
		System.out.println("|현재 점수는 " + data.getScore() + "점 입니다.");
		System.out.println("|현재 배팅은 " + data.getBat() + "점 입니다. 바꾸려면 bat을 입력하세요.");
		System.out.println("|가위-1, 바위-2, 보-3, 배팅을 바꾸려면 bat, 끝내려면 exit을 입력하세요.");
		System.out.println("=========================================");
	}

	public void showErrorInfo() {
		System.out.println("=========================================");
		System.out.println("|잘못된 입력을 하셨습니다.");
		System.out.println("|help 또는 f1을 입력하시면 도움말이 나옵니다.");
		System.out.println("=========================================");
	}

	public String getCommand() {
		System.out.print("명령어를 입력해주세요 :");
		return getInput();
	}

	public String getBats(RSPGameData data) {
		System.out.print(
				"배팅 점수를 입력하세요. 보유 점수(" + data.getScore() + ") 이상이나 현재 라운드(" + data.getRound() + ") 이하는 불가능합니다. - ");
		return getInput();
	}

	public String getGameInput(RSPGameData data) {
		System.out.print("가위(1), 바위(2), 보!(3) -");
		return getInput();
	}

	private void printRecordInfo(ScoreData data) {
		System.out.println("|" + data.getUsername() + "님이 \t" + data.getScore() + "점\t\t|");
	}

	public void printRecordInfo(ArrayList<ScoreData> datalist) {
		System.out.println("======================================");
		System.out.println("|===============순위==================|");
		for (ScoreData scoreData : datalist) {
			printRecordInfo(scoreData);
		}
		System.out.println("======================================");
	}

	public void printResultInfo(String result, RSPGameData data) {
		System.out.println("당신의 선택: ----" + RSPGameData.CHOICE2STRING[data.getUser_choice()]);
		System.out.println("컴퓨터의 선택: ---" + RSPGameData.CHOICE2STRING[data.getCom_choice()]);
		System.out.println("게임 결과: " + result);
	}
	
	public void showGameOver(RSPGameData data) {
		System.out.println("======================================");
		System.out.println("|==============GAME OVER=============|");
		System.out.println("|당신의 이름 :"+data.getUser().getName());
		System.out.println("|게임 플레이 턴 수 :"+data.getRound());
		System.out.println("|당신의 스코어 :"+data.getScore());
		System.out.println("======================================");
	}

	private String getInput() {
		return _in.nextLine();
	}

	public void destroy() {
		_in.close();
	}
}
