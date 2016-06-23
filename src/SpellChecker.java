import java.util.HashSet;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class SpellChecker {
	static Scanner in = new Scanner(System.in);
	static HashSet<String> dictSet = new HashSet<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileReader fr = new FileReader("/usr/share/dict/words");

			BufferedReader br = new BufferedReader(fr);
			String line;
			Scanner addd =new Scanner(br);
			
			while (addd.hasNext()) {
				//System.out.println("Line is: " + line);
				String[] words = addd.nextLine().split(" ");

				for (int i = 0; i < words.length; i++) {

					dictSet.add(words[i]);
				}


			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		boolean cont=true;

		while (cont){
			System.out.println("Enter phrase to check spelling");
			String phrase = in.nextLine();
			if(phrase.equals("q")!=true){
				String [] checkedWords = phrase.split(" ");
				for (int i = 0; i < checkedWords.length; i++){
					if(dictSet.contains(checkedWords[i])){
						System.out.println(checkedWords[i]+" is spelled correctly");
					}
					else if(dictSet.contains(checkedWords[i])!=true){
						System.out.println(checkedWords[i]+" is not spelled correctly");
					}

				}
			}
			else if(phrase.equals("q")){
				cont=false;
			}

		}
	}
}
