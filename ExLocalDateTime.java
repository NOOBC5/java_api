import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ExLocalDateTime{
	
	public static void main(String[] args){

		// LocalDateTime으로 current 생성
		LocalDateTime current = LocalDateTime.now();

		// 년 월 일을 따로 분류시켜주는 자바에서 기본으로 주는 ISO_DATE Formatter사용
		DateTimeFormatter todayFormatter = DateTimeFormatter.ISO_DATE;
		// 시 분 초를 나타내는 Formatter 생성
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
	
		// LocalDateTime으로 만든 current에서 년 월 일만 따로 분리해주는 코드
		String today = current.format(todayFormatter);
		// LocalDateTime으로 만든 current에서 시 분 초만 따로 분리해주는 코드
		String time = current.format(formatter);

		String path = "C:\\Users\\khjkh\\Documents\\cnai\\study\\"+today+".log";	

		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileWriter(path));
			pw.println("Hello World!");
			
			pw.append("+ ");

			pw.println( time +"때 생성된"+today+".log 파일입니다!");

			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		pw.close();
	
	}
}
