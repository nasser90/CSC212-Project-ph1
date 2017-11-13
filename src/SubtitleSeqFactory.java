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
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			
			int isTime = 1;
			String txt = null;
			line = br.readLine();
			
			Subtitle st = new SubtitleT();
			Time t1 = new TimeS();
			Time t2 = new TimeS();
			
			while(line != null){
				
				if(isTime == 1){
					//System.out.println(line);
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
					else
						txt += " "+line;
					
				}
				
				if(line.equals("")){
					
					st.setText(txt);
					s.addSubtitle(st);
					//System.out.println(i.getText());
					txt = null;
					line = br.readLine();
					isTime = 1;
				}

				line = br.readLine();
			}
			
		}catch(Exception e){
			//e.printStackTrace();
			return null;
		}
		
		return s;
	}
}
