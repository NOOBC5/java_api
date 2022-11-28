import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class ExLocalDate{
	
	public static void main(String[] args){

		LocalDate today = LocalDate.now();
		
		String path = "C:\\Users\\khjkh\\Documents\\cnai\\study\\"+today+".log";

		
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileWriter(path));
			pw.println("Hello World");
			
			pw.append('+');

			pw.append(" Wow!!");

			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		pw.close();
	
	}
}