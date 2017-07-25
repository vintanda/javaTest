package pokerGame;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

public class playGame {

	private List<poker> pokers = new ArrayList<>();
//	private List<player> players = new ArrayList<>();
	
	public List<poker> getPokers() {
		String design = "";
		String number = "";
		
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 13;j++) {
				
				//选择花色
				if(i == 0) {
					design = "黑桃";
				}else if(i == 1) {
					design = "红桃";
				}else if(i == 2) {
					design = "梅花";
				}else {
					design = "方片";
				}
				
				//选择数字
				if(j == 0) {
					number = "A";
				}else if(j > 0 && j < 10) {
					number = (j+1) + "";
				}else if(j == 10) {
					number = "J";
				}else if(j == 11) {
					number = "Q";
				}else {
					number = "K";
				}
				
				//生成一张牌
				pokers.add(new poker(design, number));
			}
		}
		return pokers;
	}

	public void setPokers(List<poker> pokers) {
		this.pokers = pokers;
	}

//	public List<player> getPlayers() {
//		return players;
//	}
//
//	public void setPlayers(List<player> players) {
//		this.players = players;
//	}

}
