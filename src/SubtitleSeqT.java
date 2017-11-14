
public class SubtitleSeqT implements SubtitleSeq {
	
	List<Subtitle> Subtitles;
	
	public SubtitleSeqT(){
		Subtitles = new LinkedList<Subtitle>();
	}

	public void addSubtitle(Subtitle st) {
		if(!Subtitles.full())
			Subtitles.insert(st);
	}

	public List<Subtitle> getSubtitles() {
		List<Subtitle> l1 = new LinkedList<>();
		List<Subtitle> l2 = new LinkedList<>();
		
		if(!Subtitles.empty())
			Subtitles.findFirst();
		
		// copying from the original list to l1 
		while(!Subtitles.last()){
			if(!l1.full())
				l1.insert(Subtitles.retrieve());
			Subtitles.findNext();
		}
		
		if(!l1.full())
			l1.insert(Subtitles.retrieve());
		
		// Sorting the list from the small stratTime to the biggest one
		// 
		while(!l1.empty()){
			l1.findFirst();
			
			Subtitle small = l1.retrieve();
			int s = 0;
			int c = 0;
			
			while(!l1.last()){
				if(convertToMS(small.getStartTime()) > convertToMS(l1.retrieve().getStartTime())){
					small = l1.retrieve();
					s = c;
				}
				c++;
				l1.findNext();
			}
			
			l1.findFirst();
			for(int i=0; i<= s; i++){
				if(!l1.empty() && i == s)
					l1.remove();
				l1.findNext();
			}
			
			if(!l2.full())
				l2.insert(small);
		}
		
		return l2;
	}

	// 
	public Subtitle getSubtitle(Time time) {

		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				
				if(convertToMS(time) >= convertToMS(Subtitles.retrieve().getStartTime())
						&& convertToMS(time) <= convertToMS(Subtitles.retrieve().getEndTime()))
					return Subtitles.retrieve();
				
				Subtitles.findNext();
			}
			
			// Begin for the last element
			if(convertToMS(time) >= convertToMS(Subtitles.retrieve().getStartTime())
					&& convertToMS(time) <= convertToMS(Subtitles.retrieve().getEndTime()))
				return Subtitles.retrieve();
			// End of last element
		}
		
		return null;
	}

	//////////////////
	public List<Subtitle> getSubtitles(Time startTime, Time endTime) {
		List<Subtitle> sl = getSubtitles();
		List<Subtitle> r = new LinkedList<>();

		
		if(!sl.empty()){
			sl.findFirst();
			
			while(!sl.last()){
				
				if(!r.full())
					if(convertToMS(startTime) <= convertToMS(sl.retrieve().getStartTime())
					&& convertToMS(endTime) >= convertToMS(sl.retrieve().getEndTime()))
						r.insert(Subtitles.retrieve());
				
				Subtitles.findNext();
			}
			// Begin for the last element
			
			if(!r.full())
				if(convertToMS(startTime) <= convertToMS(sl.retrieve().getStartTime())
				&& convertToMS(endTime) >= convertToMS(sl.retrieve().getEndTime()))
					r.insert(Subtitles.retrieve());
			// End of last element
		}
		
		return r;
	}

	
	public List<Subtitle> getSubtitles(String str) {
		List<Subtitle> sl = getSubtitles();
		List<Subtitle> l = new LinkedList<>();
		
		if(!sl.empty()){
			sl.findFirst();
			
			while(!sl.last()){
				if(sl.retrieve().getText().contains(str))
					if(!l.full())
						l.insert(sl.retrieve());
				sl.findNext();
			}
			
			if(sl.retrieve().getText().contains(str))
				if(!l.full())
					l.insert(sl.retrieve());
		}
		
		
		return l;
	}

	
	public void remove(String str) {
		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				if(Subtitles.retrieve().getText().contains(str)){
					if(!Subtitles.empty())
						Subtitles.remove();
				}else
					Subtitles.findNext();
			}
			
			if(Subtitles.retrieve().getText().contains(str))
				if(!Subtitles.empty())
					Subtitles.remove();
		}
		
	}

	
	public void replace(String str1, String str2) {
		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				Subtitles.retrieve().setText(Subtitles.retrieve().getText().replaceAll(str1, str2));
				Subtitles.findNext();
			}
			Subtitles.retrieve().setText(Subtitles.retrieve().getText().replaceAll(str1, str2));
		}
		
	}

	
	public void shift(int offset) {
		
		
	}

	
	public void cut(Time startTime, Time endTime) {
		
		
	}

	
	private static int convertToMS(Time t){
		
		return  (t.getHH() * 60 * 60 * 1000) +
				(t.getMM() * 60 * 1000) +
				(t.getSS() * 1000) +
				t.getMS();
	}
}
