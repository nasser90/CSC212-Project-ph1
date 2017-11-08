
public class SubtitleT implements Subtitle {
	private Time startTime;
	private Time endTime;
	private String text;
	
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
