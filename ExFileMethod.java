import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;
import java.util.Scanner;

public class ExFileMethod{
	
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
	String month = current.format(monthFormatter);
	
	//폴더 생성할때나 수정할때 이름을 정해주기 위한 scanner
	Scanner scanner = new Scanner(System.in);

	//폴더의 이름을 정해주지 않았을때 기본으로 들어갈 폴더 위치
	String defaultFolderPath = "C:\\Users\\khjkh\\Documents\\"+month;	
	String defaultFilePath = "C:\\Users\\khjkh\\Documents\\"+month+"\\"+today+".log";
	
	//File위치를 받아와 defaultFolder변수에 넣기
	File defaultFolder = new File(defaultFolderPath);

	PrintWriter pw = null;
	
	try{
		System.out.println("선택지를 고르시오.");
		System.out.println("폴더 생성: C	폴더 수정:R	폴더 삭제:D");
		String userChoice = scanner.nextLine();

		if(userChoice.equals("c") || userChoice.equals("C")){
			System.out.println("폴더의 이름을 적으세요");
			String userCreateFolderName = scanner.nextLine();
			
			//유저가 폴더 이름을 정해주었을때 기본으로 들어갈 폴더 위치
			String userCreateFolderPath = "C:\\Users\\khjkh\\Documents\\"+userCreateFolderName;
			String userCreateFilePath = "C:\\Users\\khjkh\\Documents\\"+userCreateFolderName+"\\"+today+".log";

			File userCreateFolder = new File(userCreateFolderPath);

				//폴더가 없을 경우
				if(!userCreateFolder.exists()){
					userCreateFolder.mkdir();
						
					pw = new PrintWriter(new FileWriter(userCreateFilePath));
					System.out.println("파일이 생성되었습니다.");

					pw.println("Hello World!");
			
					pw.append("+ ");

					pw.println(time +"때 생성된"+today+".log 파일입니다!");

					pw.flush();
				}else{
					System.out.println("폴더가 이미 있습니다.");
				}
						
		}else if(userChoice.equals("r") || userChoice.equals("R")){
			System.out.println("수정할 폴더의 이름을 적으세요");
			String beforeUserRenameFolderName = scanner.nextLine();

			System.out.println("폴더의 수정될 이름을 적으세요");
			String afterUserRenameFolderName = scanner.nextLine();
			
			String beforeUserRenameFolderPath = "C:\\Users\\khjkh\\Documents\\"+beforeUserRenameFolderName;
			String afterUserRenameFolderPath = "C:\\Users\\khjkh\\Documents\\"+afterUserRenameFolderName;

			File beforeUserRenameFolder = new File(beforeUserRenameFolderPath);
			File afterUserRenameFolder = new File(afterUserRenameFolderPath);

				if(beforeUserRenameFolder.exists()){
					boolean RenameFolder = beforeUserRenameFolder.renameTo(afterUserRenameFolder);

					System.out.println("폴더 이름이 수정 되었습니다.");
				}else {
					System.out.println("없는 폴더입니다.");
				}
		}else if(userChoice.equals("d") || userChoice.equals("D")){
			System.out.println("삭제할 폴더의 이름을 적으세요.");
			String userDeleteFolderName = scanner.nextLine();
			
			String userDeleteFolderPath = "C:\\Users\\khjkh\\Documents\\"+userDeleteFolderName;

			File userDeleteFolder = new File(userDeleteFolderPath);
			
			if(userDeleteFolder.exists()){
				while(userDeleteFolder.exists()){
					File[] userDeleteFolderList = userDeleteFolder.listFiles();
			
					for (int i = 0; i < userDeleteFolderList.length; i++) {
						userDeleteFolderList[i].delete(); 
					}
					if(userDeleteFolderList.length == 0 && userDeleteFolder.isDirectory()){
						userDeleteFolder.delete();
					}
				}
			}else {
				System.out.println("폴더가 없습니다.");
			}
		}else {
			System.out.println("다른 선택지를 선택하셨습니다.");
		}
			
	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
