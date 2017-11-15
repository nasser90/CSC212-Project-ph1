
public class SubtitleSeqT implements SubtitleSeq {
	
	List<Subtitle> Subtitles;
	
	public SubtitleSeqT(){
		Subtitles = new LinkedList<Subtitle>();
	}
	

	public SubtitleSeqT(List<Subtitle> subtitles) {
	
		Subtitles = subtitles;
	}
	
	public void addSubtitle(Subtitle st) {
		if(!Subtitles.full())
			Subtitles.insert(st);
	}

	public List<Subtitle> getSubtitles() {
		List<Subtitle> l1 = new LinkedList<>();
		List<Subtitle> l2 = new LinkedList<>();
		
		if(!Subtitles.empty()){
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
				
				if(convertToMS(small.getStartTime()) > convertToMS(l1.retrieve().getStartTime())){

					small = l1.retrieve();
					s = c;
				}
				
				l1.findFirst();
				for(int i=0; i<= s; i++){
					if(!l1.empty() && small.equals(l1.retrieve()))
						l1.remove();
					else
						l1.findNext();
				}

				if(!l2.full())
					l2.insert(small);
			}
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
						r.insert(sl.retrieve());
				
				sl.findNext();
			}
			// Begin for the last element
			
			if(!r.full())
				if(convertToMS(startTime) <= convertToMS(sl.retrieve().getStartTime())
				&& convertToMS(endTime) >= convertToMS(sl.retrieve().getEndTime()))
					r.insert(sl.retrieve());
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
		
		if(!Subtitles.empty())
			Subtitles.findFirst();
		
		while(!Subtitles.last()){
			int start = convertToMS(Subtitles.retrieve().getStartTime()) + offset;
			int end = convertToMS(Subtitles.retrieve().getEndTime()) + offset;
			
			if(start < 0)
				start = 0;
			
			if(end < 0)
				end = 0;
			
			Time startTime = convertToTime(start);
		//	System.out.println(startTime.getHH()+":"+startTime.getMM()+":"+startTime.getSS()+","+startTime.getMS());
			Time endTime = convertToTime(end);
		//	System.out.println(endTime.getHH()+":"+endTime.getMM()+":"+endTime.getSS()+","+endTime.getMS());
			
			
			if(end != 0){	
				Subtitles.retrieve().setStartTime(startTime);
				Subtitles.retrieve().setEndTime(endTime);
				
				Subtitles.findNext();
			}else{
				Subtitles.remove();
			}
			
		}
		// Begin for the last element

		int start = convertToMS(Subtitles.retrieve().getStartTime()) + offset;
		int end = convertToMS(Subtitles.retrieve().getEndTime()) + offset;
		
		if(start < 0)
			start = 0;
		
		if(end < 0)
			end = 0;
		
		Time startTime = convertToTime(start);
		//System.out.println(startTime.getHH()+":"+startTime.getMM()+":"+startTime.getSS()+","+startTime.getMS());
		Time endTime = convertToTime(end);
		//System.out.println(endTime.getHH()+":"+endTime.getMM()+":"+endTime.getSS()+","+endTime.getMS());
		
		if(end != 0){	
			Subtitles.retrieve().setStartTime(startTime);
			Subtitles.retrieve().setEndTime(endTime);
		}else{
			Subtitles.remove();
		}
		// End of last element

	}

	
	public void cut(Time startTime, Time endTime) {
		
		if ( !Subtitles.empty() ) {
			
			Subtitles.findFirst();
			
			boolean deleted = false;
			
				while ( !Subtitles.last() ) {
					
					deleted = false;
					
					if ( convertToMS(Subtitles.retrieve().getStartTime()) >= convertToMS(startTime) )
						
						if ( convertToMS(Subtitles.retrieve().getEndTime()) <= convertToMS(endTime) )
							
							Subtitles.remove();
					
					Subtitles.findNext();
					
				}
				
				if ( convertToMS(Subtitles.retrieve().getStartTime()) >= convertToMS(startTime) )
					
					if ( convertToMS(Subtitles.retrieve().getEndTime()) <= convertToMS(endTime) )
						
						Subtitles.remove();
				
					Subtitles.findFirst();
				
				int c = convertToMS(startTime) - convertToMS(endTime) - 1;
				
				while ( !Subtitles.last() ) {
					
					if ( convertToMS(Subtitles.retrieve().getStartTime()) > convertToMS(endTime) ) {
						
						int ss = convertToMS(Subtitles.retrieve().getStartTime());
						
						int ee = convertToMS(Subtitles.retrieve().getEndTime());
						
						ss += c;
						
						ee += c;
						
						Subtitles.retrieve().setStartTime(convertToTime(ss));
						
						Subtitles.retrieve().setStartTime(convertToTime(ee));
					}
					
					if ( convertToMS(Subtitles.retrieve().getStartTime()) < 0 )
						
						Subtitles.retrieve().setStartTime(convertToTime(0));
					
					if ( convertToMS(Subtitles.retrieve().getEndTime()) <= 0) {
						
						Subtitles.remove();
						
						deleted = true;
					
					}	
					
					if ( !deleted )
					
						Subtitles.findNext();
					
				}
				
				if ( convertToMS(Subtitles.retrieve().getStartTime()) > convertToMS(endTime) ) {
					
					int ss = convertToMS(Subtitles.retrieve().getStartTime());
					
					int ee = convertToMS(Subtitles.retrieve().getEndTime());
					
					ss += c;
					
					ee += c;
					
					Subtitles.retrieve().setStartTime(convertToTime(ss));
					
					Subtitles.retrieve().setStartTime(convertToTime(ee));	
					

					if ( convertToMS(Subtitles.retrieve().getStartTime()) < 0 )
						
						Subtitles.retrieve().setStartTime(convertToTime(0));
					
					if ( convertToMS(Subtitles.retrieve().getEndTime()) <= 0) {
						
						Subtitles.remove();
						
						deleted = true;
					
					}	
					
				}
				
			}
		
	}

	
	private int convertToMS(Time t){
		
		return  (t.getHH() * 60 * 60 * 1000) +
				(t.getMM() * 60 * 1000) +
				(t.getSS() * 1000) +
				t.getMS();
	}
	
	private Time convertToTime(int ms){
		Time t = new TimeS();
		
		t.setHH((ms / (1000 * 60 * 60)));
		t.setMM((ms / (1000 * 60)) % 60);
		t.setSS((ms / 1000) % 60 );
		t.setMS(ms % 1000);
		
		return t;
	}
	
	public void printAll( ) {
		
		if (!Subtitles.empty()) {
			
			Subtitles.findFirst();
			
		
			while ( !Subtitles.last() ) {
				
				System.out.print(Subtitles.retrieve().getStartTime().getHH() + ":");
				
				System.out.print(Subtitles.retrieve().getStartTime().getMM() + ":");
				
				System.out.print(Subtitles.retrieve().getStartTime().getSS() + ",");
				
				System.out.print(Subtitles.retrieve().getStartTime().getMS()    );
				
				System.out.print("  --> ");
				
				System.out.print(Subtitles.retrieve().getEndTime().getHH() + ":");
				
				System.out.print(Subtitles.retrieve().getEndTime().getMM() + ":");
				
				System.out.print(Subtitles.retrieve().getEndTime().getSS() + ",");
				
				System.out.println(Subtitles.retrieve().getEndTime().getMS()    );
				
				
				System.out.println(Subtitles.retrieve().getText());
				System.out.println();
				
				Subtitles.findNext();
					
			}
			
			
			System.out.print(Subtitles.retrieve().getStartTime().getHH() + ":");
			
			System.out.print(Subtitles.retrieve().getStartTime().getMM() + ":");
			
			System.out.print(Subtitles.retrieve().getStartTime().getSS() + ",");
			
			System.out.print(Subtitles.retrieve().getStartTime().getMS()    );
			
			System.out.print("  --> ");
			
			System.out.print(Subtitles.retrieve().getEndTime().getHH() + ":");
			
			System.out.print(Subtitles.retrieve().getEndTime().getMM() + ":");
			
			System.out.print(Subtitles.retrieve().getEndTime().getSS() + ",");
			
			System.out.println(Subtitles.retrieve().getEndTime().getMS()    );
			
			
		
			System.out.println(Subtitles.retrieve().getText());
			System.out.println();
			
		}
	}
	
	public static void printList(List<Subtitle> Subtitles){
		if (!Subtitles.empty()) {
			
			Subtitles.findFirst();
			
		
			while ( !Subtitles.last() ) {
				
				System.out.print(Subtitles.retrieve().getStartTime().getHH() + ":");
				
				System.out.print(Subtitles.retrieve().getStartTime().getMM() + ":");
				
				System.out.print(Subtitles.retrieve().getStartTime().getSS() + ",");
				
				System.out.print(Subtitles.retrieve().getStartTime().getMS()    );
				
				System.out.print("  --> ");
				
				System.out.print(Subtitles.retrieve().getEndTime().getHH() + ":");
				
				System.out.print(Subtitles.retrieve().getEndTime().getMM() + ":");
				
				System.out.print(Subtitles.retrieve().getEndTime().getSS() + ",");
				
				System.out.println(Subtitles.retrieve().getEndTime().getMS()    );
				
				
				System.out.println(Subtitles.retrieve().getText());
				System.out.println();
				
				Subtitles.findNext();
					
			}
			
			
			System.out.print(Subtitles.retrieve().getStartTime().getHH() + ":");
			
			System.out.print(Subtitles.retrieve().getStartTime().getMM() + ":");
			
			System.out.print(Subtitles.retrieve().getStartTime().getSS() + ",");
			
			System.out.print(Subtitles.retrieve().getStartTime().getMS()    );
			
			System.out.print("  --> ");
			
			System.out.print(Subtitles.retrieve().getEndTime().getHH() + ":");
			
			System.out.print(Subtitles.retrieve().getEndTime().getMM() + ":");
			
			System.out.print(Subtitles.retrieve().getEndTime().getSS() + ",");
			
			System.out.println(Subtitles.retrieve().getEndTime().getMS()    );
			
			
		
			System.out.println(Subtitles.retrieve().getText());
			System.out.println();
			
		}
	}
	
}
