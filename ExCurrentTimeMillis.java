import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.util.Scanner;

public class ExCurrentTimeMillis{
	
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

		//걸릴 시간을 입력 받을수 있게 만드는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("파일이 생성되기까지 걸릴 시간을 입력하세요.");

		//정수형 자료가 들어갈 수있게 해주기
		int secondInsert = sc.nextInt();

		//File위치를 받아와 Folder변수에 넣기
		File Folder = new File(path);

		PrintWriter pw = null;
		try{
			int secondInsertTime = (secondInsert  * 1000);
			//폴더가 없을 경우
			if(!Folder.exists()){
				try{
					//실행 시간 구하는 시작 시간
					long start = System.currentTimeMillis();
					//잠시 일시정지 시켜주는 코드
					Thread.sleep(secondInsertTime);

					//폴더 생성
					Folder.mkdir();

					pw = new PrintWriter(new FileWriter(createLogCreateFolderPath));
					System.out.println("파일이 생성되었습니다!");

					//실행 시간 구하는 끝나는 시간
					long end = System.currentTimeMillis();
					//실행 시간이 얼마나 걸렸는지 알려주기 위한 코드
					long plusCreateFolderSecond = (end - start)/1000;
					
					pw.println("Hello World!");
			
					pw.append("+ ");

					pw.println( time +"때 생성된"+today+".log 파일이 생성되기까지 걸린 시간은 "+plusCreateFolderSecond+"초 입니다.");

					pw.flush();
				}
				catch(Exception e){
					e.getStackTrace();
				}
				}else{
			//실행 시간 구하는 시작 시간
			long start = System.currentTimeMillis();
			try{
			//잠시 일시정지 시켜주는 코드
			Thread.sleep(secondInsertTime);
			}catch(Exception e){
			}

			pw = new PrintWriter(new FileWriter(createLogCreateFolderPath));
			System.out.println("파일이 생성되었습니다!");

			//실행 시간 구하는 끝나는 시간
			long end = System.currentTimeMillis();
			//실행 시간이 얼마나 걸렸는지 알려주기 위한 코드
			long plusCreateFolderSecond = (end - start)/1000;

			pw.println("Hello World!");
			
			pw.append("+ ");

			pw.println( time +"때 생성된"+today+".log 파일이 생성되기까지 걸린 시간은 "+plusCreateFolderSecond+"초 입니다.");

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