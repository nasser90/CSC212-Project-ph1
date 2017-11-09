import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


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
		File f = new File(fileName);
		try{
			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
		}catch(Exception e){
			return null;
		}
		return s;
	}
}
