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
				
				//ѡ��ɫ
				if(i == 0) {
					design = "����";
				}else if(i == 1) {
					design = "����";
				}else if(i == 2) {
					design = "÷��";
				}else {
					design = "��Ƭ";
				}
				
				//ѡ������
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
				
				//����һ����
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
