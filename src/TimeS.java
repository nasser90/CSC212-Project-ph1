
public class TimeS implements Time{
	private int hh;
	private int mm;
	private int ss;
	private int ms;
	
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
		if(mm>=0 && mm<60)
			this.mm = mm;
	}

	
	public void setSS(int ss) {
		if(ss>0 && ss<60)
			this.ss = ss;
	}

	/////
	public void setMS(int ms) {
		this.ms = ms;
	}

}
