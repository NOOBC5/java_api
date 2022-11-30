import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;

public class ExFile{
	
	public static void main(String[] args){

		// LocalDateTime으로 current 생성
		LocalDateTime current = LocalDateTime.now();

		// 년 월 일을 따로 분류시켜주는 자바에서 기본으로 주는 ISO_DATE Formatter사용
		DateTimeFormatter todayFormatter = DateTimeFormatter.ISO_DATE;
		// 시 분 초를 나타내는 Formatter 생성
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		//년 월을 나타내는 Formatter 생성
		DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
	
		// LocalDateTime으로 만든 current에서 년 월 일만 따로 분리해주는 코드
		String today = current.format(todayFormatter);
		// LocalDateTime으로 만든 current에서 시 분 초만 따로 분리해주는 코드
		String time = current.format(timeFormatter);
		//LocalDateTime으로 만든 current에서 년 월만 따로 분리해주는 코드
		String Month = current.format(monthFormatter);

		String path = "C:\\Users\\khjkh\\Documents\\cnai\\study\\"+Month;
		String createLogCreateFolderPath = "C:\\Users\\khjkh\\Documents\\cnai\\study\\"+Month+"\\"+today+".log";

		//File위치를 받아와 Folder변수에 넣기
		File Folder = new File(path);

		PrintWriter pw = null;
		try{
			//폴더가 없을 경우
			if(!Folder.exists()){
				try{
					//폴더 생성 코드
					Folder.mkdir();

					pw = new PrintWriter(new FileWriter(createLogCreateFolderPath));
					pw.println("Hello World!");
			
					pw.append("+ ");

					pw.println( time +"때 생성된"+today+".log 파일입니다!");

					pw.flush();
				}
				catch(Exception e){
					e.getStackTrace();
				}
				}else{
			pw = new PrintWriter(new FileWriter(createLogCreateFolderPath));
			pw.println("Hello World!");
			
			pw.append("+ ");

			pw.println( time +"때 생성된"+today+".log 파일입니다!");

			pw.flush();
		}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		pw.close();
	
	}
}