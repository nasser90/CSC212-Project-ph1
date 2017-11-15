
public class TimeS implements Time{
	private int hh;
	private int mm;
	private int ss;
	private int ms;
	
	public TimeS(){
		
	}
	
	public TimeS(int hh, int mm, int ss, int ms) {
		super();
		this.hh = hh;
		this.mm = mm;
		this.ss = ss;
		this.ms = ms;
	}

	public int getHH() {
		return hh;
	}
	
	public int getMM() {
		return mm;
	}
	
	public int getSS() {
		return ss;
	}
	
	public int getMS() {
		return ms;
	}

	
	public void setHH(int hh) {
		this.hh = hh;
	}

	
	public void setMM(int mm) {
			this.mm = mm;
	}

	
	public void setSS(int ss) {
			this.ss = ss;
	}

	/////
	public void setMS(int ms) {
		this.ms = ms;
	}

}
