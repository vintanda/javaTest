/**
 * @author me
 * @time 2017/07/24
 */
/*
 * �˿���С��Ϸ
 * ����һ���˿���
 * ������ң������ID�����֣�ID����Ϊ���֣�������������ʾ������������
 * ��������������������
 * ��������Ҹ��������ƽ��бȽϣ����ʤ��
 * �ȽϹ����������ȣ�������ͬʱ���ա��ں�÷�����Ĺ�����бȽ�
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
		
		//��ȡ�˿���
		List<poker> pokers = playgame.getPokers();
		
		//����˿���
		for(poker poker:pokers) {
			System.out.println(poker.getDesign() + poker.getNumber());
		}
		
		//����������ң���������ҵ�pokers��ArrayList�����ϴ������ǰ���������
		Scanner scanner = new Scanner(System.in);
		int id;
		String name;
		System.out.println("�������һ����ҵ�ID(����)");
		while(true) {
			try {
				id = scanner.nextInt();
			}catch(InputMismatchException ce) {
				System.out.println("ID����Ϊ���֣����������룡");
				scanner.close();
				scanner = new Scanner(System.in);
				continue;
			}
			System.out.println("�������һ����ҵ�������");
			name = scanner.next();
			break;
		}
		player p1 = new player(id, name);
		
		System.out.println("������ڶ�����ҵ�ID(����)");
		while(true) {
			try {
				id = scanner.nextInt();
			}catch(InputMismatchException ce) {
				System.out.println("ID����Ϊ���֣����������룡");
				scanner.close();
				scanner = new Scanner(System.in);
				continue;
			}
			System.out.println("������ڶ�����ҵ�������");
			name = scanner.next();
			break;
		}
		player p2 = new player(id, name);
		
		//��������Ϣ
		System.out.println("��һ����ҵ���ϢΪ��" + p1.getID() + p1.getName());
		System.out.println("�ڶ�����ҵ���ϢΪ��" + p2.getID() + p2.getName());
		
		//�ر�������
		scanner.close();
		
		//����
//		Iterator<poker> it = pokers.iterator();
//		p1.setP1(it.next());
//		p2.setP1(it.next());
//		p1.setP2(it.next());
//		p2.setP2(it.next());
		
		
		//����
		List<poker> tempList = new ArrayList<>();
		poker tempPoker = pokers.get((int)(Math.random() * 52));
		
		//����һ���˷���һ����
		p1.setP1(tempPoker);
		tempList.add(tempPoker);
		
		//���ڶ����˷���һ����
		do {
			tempPoker = pokers.get((int)(Math.random() * 52));
		}while(tempList.contains(tempPoker));
		p2.setP1(tempPoker);
		
		//����һ���˷��ڶ�����
		do {
			tempPoker = pokers.get((int)(Math.random() * 52));
		}while(tempList.contains(tempPoker));
		p1.setP2(tempPoker);
		
		//���ڶ����˷��ڶ�����
		do {
			tempPoker = pokers.get((int)(Math.random() * 52));
		}while(tempList.contains(tempPoker));
		p2.setP2(tempPoker);
		
		
		//�����ҷ�������
		System.out.println("��һλ��ҵ���Ϊ��" 
		+ p1.getP1().getDesign() + p1.getP1().getNumber()+ "��"
				+ p1.getP2().getDesign() + p1.getP2().getNumber());
		System.out.println("�ڶ�λ��ҵ���Ϊ��" + 
				p2.getP1().getDesign() + p2.getP1().getNumber()+ "��"
				+ p2.getP2().getDesign() + p2.getP2().getNumber());

		//�Ƚ��ƵĴ�С 
		//���Ƽ��뵽ArrayList�������Ƚ�
		List<poker> list1 = new ArrayList<poker>();
		list1.add(p1.getP1());
		list1.add(p1.getP2());
		
		List<poker> list2 = new ArrayList<poker>();
		list2.add(p2.getP1());
		list2.add(p2.getP2());
		
		//ѡȡ�Լ����нϴ��
		Collections.sort(list1);
		Collections.sort(list2);
		
		//�����֤���
		System.out.println(list1.get(1).getDesign() + list1.get(1).getNumber());
		System.out.println(list2.get(1).getDesign() + list2.get(1).getNumber());
		
		//������ұȴ�С
		if(list1.get(1).compareTo(list2.get(1)) > 0) {
			System.out.println("���" + p1.getID() + ":" + p1.getName() + "��ʤ��");
		}else {
			System.out.println("���" + p2.getID() + ":" + p2.getName() + "��ʤ��");
		}
	}

}
