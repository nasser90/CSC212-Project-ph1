import java.io.BufferedReader;
import java.io.FileReader;

public class MainTest {

	public static void main(String[] args) {
		Subtitle i = new SubtitleT();
		
		//i.setText(i.getText().replaceAll("World", "YOU"));
		
		Time t1 = new TimeS();
		Time t2 = new TimeS();
		

		
		
		
		try{
			FileReader fr = new FileReader("src/winnie-the-pooh-2011.srt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			int ii=1;
			int isTime = 1;
			String txt = null;
			line = br.readLine();
			while(ii != 30){
				
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
					
					i.setStartTime(t1);
					i.setEndTime(t2);
					
					System.out.println(i.getStartTime().getHH());
					System.out.println(i.getStartTime().getMM());
					System.out.println(i.getStartTime().getSS());
					System.out.println(i.getStartTime().getMS());
					
					System.out.println(i.getEndTime().getHH());
					System.out.println(i.getEndTime().getMM());
					System.out.println(i.getEndTime().getSS());
					System.out.println(i.getEndTime().getMS());
					
					isTime = 0;
					
				}else{
					
					if(txt == null)
						txt = line;
					else
						txt += " "+line;
					
				}
				
				if(line.equals("")){
					
					i.setText(txt);
					System.out.println(i.getText());
					txt = null;
					line = br.readLine();
					isTime = 1;
				}

				line = br.readLine();
				ii++;
			}
			
		}catch(Exception e){
			System.out.println("null");
		}
		
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

	}

}
