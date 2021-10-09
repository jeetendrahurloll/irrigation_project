package dataFilters;

/*
 * removes the HEAD and TAIL message prefix and postfix,and checks that they are from the same message
 */
public class headTailRemover {
	/* get head position */
	public int getNextHeadPosition(String S) {
		int i = 0;
		i=S.indexOf("HEAD", i);
		return i;

	}

	/* get tail position */
	public int getNextTailPoistion(String S) {
		int i = 0;
		i=S.indexOf("TAIL", i);
		return i;
		
	}
	
	public String arduinoData(String S) {
		String data=S.substring(getNextHeadPosition(S)+7 , getNextTailPoistion(S));
		System.out.println(">>"+data);
		return data;
	}




}
