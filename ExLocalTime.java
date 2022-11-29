import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExLocalTime{
	
	public static void main(String[] args){

		LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");

		String path = "C:\\Users\\khjkh\\Documents\\cnai\\study\\"+today+".log";

		String formatedTime = time.format(formatter);		

		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileWriter(path));
			pw.println("Hello World!");
			
			pw.append('+');

			pw.println( formatedTime +"때 생성된"+today+".log 파일입니다!");

			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		pw.close();
	
	}
}