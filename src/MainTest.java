import java.io.BufferedReader;
import java.io.FileReader;

public class MainTest {

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
	
	public static void main(String[] args) {
		//Subtitle i = new SubtitleT();
		
		//i.setText(i.getText().replaceAll("World", "YOU"));
		
//		Time t1 = new TimeS();
//		Time t2 = new TimeS();
//
//		try{
//			FileReader fr = new FileReader("src/winnie-the-pooh-2011.srt");
//			BufferedReader br = new BufferedReader(fr);
//			String line = br.readLine();
//			int ii=1;
//			int isTime = 1;
//			String txt = null;
//			line = br.readLine();
//			while(line != null){
//				
//				if(isTime == 1){
//					//System.out.println(line);
//					t1.setHH(Integer.parseInt(line.substring(0, 2)));
//					t1.setMM(Integer.parseInt(line.substring(3, 5)));
//					t1.setSS(Integer.parseInt(line.substring(6, 8)));
//					t1.setMS(Integer.parseInt(line.substring(9, 12)));
//					
//					t2.setHH(Integer.parseInt(line.substring(17, 19)));
//					t2.setMM(Integer.parseInt(line.substring(20, 22)));
//					t2.setSS(Integer.parseInt(line.substring(23, 25)));
//					t2.setMS(Integer.parseInt(line.substring(26, 29)));
//					
//					i.setStartTime(t1);
//					i.setEndTime(t2);
//					
//					System.out.println(i.getStartTime().getHH());
//					System.out.println(i.getStartTime().getMM());
//					System.out.println(i.getStartTime().getSS());
//					System.out.println(i.getStartTime().getMS());
//					
//					System.out.println(i.getEndTime().getHH());
//					System.out.println(i.getEndTime().getMM());
//					System.out.println(i.getEndTime().getSS());
//					System.out.println(i.getEndTime().getMS());
//					
//					isTime = 0;
//					
//				}else{
//					
//					if(txt == null)
//						txt = line;
//					else
//						txt += " "+line;
//					
//				}
//				
//				if(line.equals("")){
//					
//					i.setText(txt);
//					System.out.println(i.getText());
//					txt = null;
//					line = br.readLine();
//					isTime = 1;
//				}
//
//				line = br.readLine();
//				ii++;
//			}
//			
//		}catch(Exception e){
//			System.out.println("null");
//		}
		
//		System.out.println(t1.getHH());
//		System.out.println(t1.getMM());
//		System.out.println(t1.getSS());
//		System.out.println(t1.getMS());
//		
//		System.out.println(t2.getHH());
//		System.out.println(t2.getMM());
//		System.out.println(t2.getSS());
//		System.out.println(t2.getMS());
		
		//System.out.println(i.getText().contains("Hello World"));
		
		//System.out.println(i.getText());
		
		SubtitleSeqT x;
		
		x = new SubtitleSeqT();
		x.addSubtitle(new SubtitleT(new TimeS(0,0,13,1), new TimeS(0,0,22,1), "YOU!!"));
		
		x.addSubtitle(new SubtitleT(new TimeS(0,0,25,1), new TimeS(0,0,28,1), "Ok Ok OK"));
		
		x.addSubtitle(new SubtitleT(new TimeS(0,0,29,1), new TimeS(0,0,30,1), "Ok1 Ok1 OK1"));
		
		x.addSubtitle(new SubtitleT(new TimeS(0,0,0,0), new TimeS(0,0,10,1), "Hello World"));

		x.addSubtitle(new SubtitleT(new TimeS(0,0,31,1), new TimeS(0,0,34,1), "YOU!! 2"));
		
		x.addSubtitle(new SubtitleT(new TimeS(0,0,40,1), new TimeS(0,0,47,1), "Ok Ok OK 2"));
		
		x.addSubtitle(new SubtitleT(new TimeS(0,0,35,1), new TimeS(0,0,37,1), "Ok1 Ok1 OK1 2"));
		
		x.addSubtitle(new SubtitleT(new TimeS(0,0,11,0), new TimeS(0,0,12,1), "Hello World 2"));
		
//		x.printAll();
		
//		x = (SubtitleSeqT) SubtitleSeqFactory.loadSubtitleSeq("src/winnie-the-pooh-2011.srt");
//		
//		x.printAll();
		
		
		List<Subtitle> l;
		
		//l = x.getSubtitles(new TimeS(0,0,0,0), new TimeS(0,0,30,0));
		
		//l = x.getSubtitles("World");
		
		//printList(l);
		x.printAll();
		System.out.println("-----------------------------");
		x.shift(-10001);
		x.printAll();
		
	}

}
