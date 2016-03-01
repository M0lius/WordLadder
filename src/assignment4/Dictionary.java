package assignment4;

public class Dictionary {

	public Dictionary() {
		// TODO Auto-generated constructor stub
	}
	
	public void Init(filename) {
		
		Dictionary dictionary = new Arraylist[String];
		
		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);
			
			i = 0;
			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				if (s.charAt(0) != '*'){
					for (j = 0; j < 5; j++) {
						Arraylist[i] += s.charAt(j);
					}
					i++;
				}
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
		String word = new string();
	}

}
