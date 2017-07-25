package pokerGame;

public class player {

	private int ID;
	private String name;
	private poker p1;
	private poker p2;
	
	//构造方法
	public player() {}
	public player(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	
	//getter setter方法
	public poker getP1() {
		return p1;
	}
	public void setP1(poker p1) {
		this.p1 = p1;
	}
	public poker getP2() {
		return p2;
	}
	public void setP2(poker p2) {
		this.p2 = p2;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
