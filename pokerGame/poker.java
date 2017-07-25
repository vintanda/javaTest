package pokerGame;

public class poker implements Comparable<poker> {
	
	private String design;
	private String number;
	
	public poker() {}
	public poker(String design, String number) {
		this.design = design;
		this.number = number;
	}
	
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public int compareTo(poker o) {
		// TODO Auto-generated method stub
		int res = this.getNumber().compareTo(o.getNumber());
		if(res > 0) {
			return 1;
		}else if(res < 0) {
			return -1;
		}else {
			int weight1 = 0;
			int weight2 = 0;
			
			if(this.getDesign().equals("ºÚÌÒ")) {
				weight1 = 4;
			}else if(this.getDesign().equals("ºìÌÒ")) {
				weight1 = 3;
			}else if(this.getDesign().equals("Ã·»¨")) {
				weight1 = 2;
			}else {
				weight1 = 1;
			}
			
			if(o.getDesign().equals("ºÚÌÒ")) {
				weight1 = 4;
			}else if(o.getDesign().equals("ºìÌÒ")) {
				weight1 = 3;
			}else if(o.getDesign().equals("Ã·»¨")) {
				weight1 = 2;
			}else {
				weight1 = 1;
			}
			
			if(weight1 > weight2) {
				return 1;
			}else {
				return -1;
			}
		}
		
	}
	
}
