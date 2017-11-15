
public class SubtitleT implements Subtitle {
	private Time startTime;
	private Time endTime;
	private String text;
	
	public SubtitleT(){
		
	}
	
	public SubtitleT(Time startTime, Time endTime, String text) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.text = text;
	}


	public Time getStartTime() {
		return startTime;
	}


	public Time getEndTime() {
		return endTime;
	}


	public String getText() {
		return text;
	}


	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}


	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	
}
