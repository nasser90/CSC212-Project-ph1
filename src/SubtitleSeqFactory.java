import java.io.BufferedReader;
import java.io.FileReader;


public class SubtitleSeqFactory {

	// Return an empty subtitles sequence 
	public static SubtitleSeq getSubtitleSeq() {
		SubtitleSeq s = new SubtitleSeqT();
		return s;
	}

	// Load a subtitle sequence from an SRT file. If the file does not exist or
	// is corrupted (incorrect format), null is returned. 
	public static SubtitleSeq loadSubtitleSeq(String fileName) {
		SubtitleSeq s = new SubtitleSeqT();
		
		try{
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		String ext = "srt";
		
		// check if extension is srt
		if(!extension.equals(ext))
			return null;
			
		
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			
			int isTime = 1;
			String txt = null;
			int c = 1;
			
			Subtitle st = new SubtitleT();
			Time t1 = new TimeS();
			Time t2 = new TimeS();

			while(line != null){
				
				// order number
				
				if(isTime == 1 && Integer.parseInt(line) == c){
					line = br.readLine();
					c++;
				}else if(isTime == 1 && Integer.parseInt(line) != c){
					return null;
				}
				
				if(isTime == 1){
					//System.out.println(line);

					// check --> is not exist.
					if(!line.substring(12,17).equals(" --> "))
						return null;
					
					t1.setHH(Integer.parseInt(line.substring(0, 2)));
					t1.setMM(Integer.parseInt(line.substring(3, 5)));
					t1.setSS(Integer.parseInt(line.substring(6, 8)));
					t1.setMS(Integer.parseInt(line.substring(9, 12)));
					
					t2.setHH(Integer.parseInt(line.substring(17, 19)));
					t2.setMM(Integer.parseInt(line.substring(20, 22)));
					t2.setSS(Integer.parseInt(line.substring(23, 25)));
					t2.setMS(Integer.parseInt(line.substring(26, 29)));
					
					st.setStartTime(t1);
					st.setEndTime(t2);
					
					// check endTime is not less than startTime.
					if(SubtitleSeqT.convertToMS(t1) > SubtitleSeqT.convertToMS(t2))
						return null;
					
//					System.out.println(i.getStartTime().getHH());
//					System.out.println(i.getStartTime().getMM());
//					System.out.println(i.getStartTime().getSS());
//					System.out.println(i.getStartTime().getMS());
//					
//					System.out.println(i.getEndTime().getHH());
//					System.out.println(i.getEndTime().getMM());
//					System.out.println(i.getEndTime().getSS());
//					System.out.println(i.getEndTime().getMS());
					
					isTime = 0;
					
				}else{
					
					if(txt == null)
						txt = line;
					else if(!line.equals("")){ /// for new line
						txt += " "+line;
					}
					
				}
				
				//System.out.println(linee+" "+line.equals(""));
				
				//s.printAll();
				
				// check next line for time line is not empty.
				if(line.equals("") && txt == null && isTime == 0 )
					return null;
				
				if(line.equals("")){
					
					st.setText(txt);
					s.addSubtitle(st);
					st = new SubtitleT();
					t1 = new TimeS();
					t2 = new TimeS();
					//s.printFirst();
					//System.out.println("After adding:");
					//s.printAll();
					//System.out.println(i.getText());
					txt = null;
					isTime = 1;
					
				}
				
				line = br.readLine();
				
				if(line == null){
					st.setText(txt);
					s.addSubtitle(st);
				}
				
				
				
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		//s.printAll();
		
		return s;
	}
}
