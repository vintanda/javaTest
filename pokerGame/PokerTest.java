/**
 * @author me
 * @time 2017/07/24
 */
/*
 * 扑克牌小游戏
 * 定义一套扑克牌
 * 两个玩家，玩家有ID和名字：ID必须为数字，不是数字则提示错误并重新输入
 * 各给两个玩家随机两张牌
 * 用两个玩家各自最大的牌进行比较，大的胜出
 * 比较规则：数字优先，数字相同时按照“黑红梅方”的规则进行比较
 */
package pokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
//import java.util.Iterator;
import java.util.List;
//import java.util.Random;
import java.util.Scanner;
//import java.util.Set;

public class PokerTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playGame playgame = new playGame();
		
		//获取扑克牌
		List<poker> pokers = playgame.getPokers();
		
		//输出扑克牌
		for(poker poker:pokers) {
			System.out.println(poker.getDesign() + poker.getNumber());
		}
		
		//定义两个玩家，给两个玩家的pokers的ArrayList中添加洗过的最前面的四张牌
		Scanner scanner = new Scanner(System.in);
		int id;
		String name;
		System.out.println("请输入第一个玩家的ID(数字)");
		while(true) {
			try {
				id = scanner.nextInt();
			}catch(InputMismatchException ce) {
				System.out.println("ID必须为数字，请重新输入！");
				scanner.close();
				scanner = new Scanner(System.in);
				continue;
			}
			System.out.println("请输入第一个玩家的姓名：");
			name = scanner.next();
			break;
		}
		player p1 = new player(id, name);
		
		System.out.println("请输入第二个玩家的ID(数字)");
		while(true) {
			try {
				id = scanner.nextInt();
			}catch(InputMismatchException ce) {
				System.out.println("ID必须为数字，请重新输入！");
				scanner.close();
				scanner = new Scanner(System.in);
				continue;
			}
			System.out.println("请输入第二个玩家的姓名：");
			name = scanner.next();
			break;
		}
		player p2 = new player(id, name);
		
		//输出玩家信息
		System.out.println("第一个玩家的信息为：" + p1.getID() + p1.getName());
		System.out.println("第二个玩家的信息为：" + p2.getID() + p2.getName());
		
		//关闭输入流
		scanner.close();
		
		//发牌
//		Iterator<poker> it = pokers.iterator();
//		p1.setP1(it.next());
//		p2.setP1(it.next());
//		p1.setP2(it.next());
//		p2.setP2(it.next());
		
		
		//发牌
		List<poker> tempList = new ArrayList<>();
		poker tempPoker = pokers.get((int)(Math.random() * 52));
		
		//给第一个人发第一张牌
		p1.setP1(tempPoker);
		tempList.add(tempPoker);
		
		//给第二个人发第一张牌
		do {
			tempPoker = pokers.get((int)(Math.random() * 52));
		}while(tempList.contains(tempPoker));
		p2.setP1(tempPoker);
		
		//给第一个人发第二张牌
		do {
			tempPoker = pokers.get((int)(Math.random() * 52));
		}while(tempList.contains(tempPoker));
		p1.setP2(tempPoker);
		
		//给第二个人发第二张牌
		do {
			tempPoker = pokers.get((int)(Math.random() * 52));
		}while(tempList.contains(tempPoker));
		p2.setP2(tempPoker);
		
		
		//输出玩家发到的牌
		System.out.println("第一位玩家的牌为：" 
		+ p1.getP1().getDesign() + p1.getP1().getNumber()+ "和"
				+ p1.getP2().getDesign() + p1.getP2().getNumber());
		System.out.println("第二位玩家的牌为：" + 
				p2.getP1().getDesign() + p2.getP1().getNumber()+ "和"
				+ p2.getP2().getDesign() + p2.getP2().getNumber());

		//比较牌的大小 
		//将牌加入到ArrayList中用来比较
		List<poker> list1 = new ArrayList<poker>();
		list1.add(p1.getP1());
		list1.add(p1.getP2());
		
		List<poker> list2 = new ArrayList<poker>();
		list2.add(p2.getP1());
		list2.add(p2.getP2());
		
		//选取自己牌中较大的
		Collections.sort(list1);
		Collections.sort(list2);
		
		//输出验证结果
		System.out.println(list1.get(1).getDesign() + list1.get(1).getNumber());
		System.out.println(list2.get(1).getDesign() + list2.get(1).getNumber());
		
		//两个玩家比大小
		if(list1.get(1).compareTo(list2.get(1)) > 0) {
			System.out.println("玩家" + p1.getID() + ":" + p1.getName() + "获胜！");
		}else {
			System.out.println("玩家" + p2.getID() + ":" + p2.getName() + "获胜！");
		}
	}

}
