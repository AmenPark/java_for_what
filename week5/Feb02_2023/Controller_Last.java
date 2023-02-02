package com.PAM.lastJaVa;

// 가위바위보 게임.
// 매 게임 정보를 기록.
// IP주소와 이름으로 사용자를 특정.
// 언제 게임을 했는지, 몇연승을 했는지도 기록.
// 플레이를 하면 기록됨.
// 플레이어의 승리 경향성을 분석.
// 게임시 플레이어가 가장 자주내지 않는 것에게 지는것을 내기.

public class Controller_Last {
	public static void main(String[] args) {
		DB_RSP_DAO dao = DB_RSP_DAO.getInstance();
		RSP_View view = new RSP_View();

		view.showmenual();
		String input;

		RSP_Model model = new RSP_Model();
		User you = model.getUser();
		dao.setUserNo(you);

		RSPGameData gamedata = null;
		int yourchoice=0;
		while (true) {
			input = view.getCommand().toLowerCase().trim();
			if (input.equals("exit")) {
				break;
			} else if (input.equals("help") | input.equals("f1")) {
				view.showmenual();
			} else if (input.equals("ranking")) {
				view.printRecordInfo(dao.getLeaderBoardDataGroupByName());
			} else if (input.equals("score")) {
				view.printRecordInfo(dao.getLeaderBoardData());
			} else if (input.equals("start")) {
				gamedata = model.startGame(you);
				model.ComRandomChoice(gamedata);
				dao.insertGame(gamedata);
				while (true) {
					view.showGameInfo(gamedata);
					input = view.getCommand().toLowerCase().trim();
					if(input.equals("exit")) {
						break;
					} else if((yourchoice=model.isValidDigit(input))>0) {
						gamedata.setUser_choice(yourchoice);
						view.printResultInfo(model.tryRSP(gamedata), gamedata);
						dao.uploadRSP(gamedata);
						model.ComRandomChoice(gamedata);
						gamedata.addRound();
					} else if(input.equals("help")|input.equals("f1")) {
						view.showGameInfo(gamedata);
					} else if(input.equals("bat")) {
						model.setBats(view.getBats(gamedata), gamedata);
					} else {
						view.showErrorInfo();
					}
					if(gamedata.getScore() < gamedata.getRound()) {
						break;
					}
				}
				view.showGameOver(gamedata);
			} else {
				view.showErrorInfo();
			}

		}

		view.destroy();
	}
}
