package step7_01.objectArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// DTO (DataTransferObject) : 데이터 전송 모델 객체
class StudentDTO{
	
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 : " + this.id + " 비밀번호 : " + this.pw);
	}
	
}


class StudentController{
	
	ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();
	
	void addStudent(StudentDTO studentDTO) {
		studentList.add(studentDTO);
	}
	
	
	StudentDTO removeStudent(int index) {
		StudentDTO deletedObj = studentList.get(index);
		studentList.remove(index);
		return deletedObj;
	}
	
	
	int checkId(StudentDTO studentDTO) {
		int check = -1;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).id.equals(studentDTO.id)) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	
	void printStudent() {
		for (int i = 0; i < studentList.size() ;i++) {
			studentList.get(i).printData();
		}
	}	
	
	
	String outData() {
		
		String data = "";
		int lineCnt = studentList.size();
		if (lineCnt == 0){
			return data;
		}
		
		data += lineCnt;
		data += "\n";
		for (int i = 0; i < lineCnt; i++) {
			data += studentList.get(i).id;
			data += ",";
			data += studentList.get(i).pw;
			if (lineCnt - 1 != i) {
				data += "\n";
			}
		}
		return data;
		
	}
	
	
	void sortData() {
		/*
              	직접 구현해보세요.
        */
	}
	
	
	void loadStudent(ArrayList<StudentDTO> studentList ) {
		this.studentList = studentList;
	}	
	
	
	int getSize() {
		return studentList.size();
	}
	
}

public class ObjectArrayEx15_연습 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentController controller = new StudentController();
		
		String fileName = "student_arraylist_db.txt";
		
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				StudentDTO temp = new StudentDTO();
				System.out.println("[가입] id 를 입력하세요 >>> ");
				temp.id = scan.next();			
				int check =  controller.checkId(temp);
				
				if (check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next();
					controller.addStudent(temp);	
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else {
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) {
				
				controller.printStudent();
				
				StudentDTO temp = new StudentDTO();
				
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();	
				
				int check = controller.checkId(temp);
				if (check == -1) {
					System.out.println("없는 아이디입니다.");
				}
				else {
					System.out.println(controller.removeStudent(check).id + "님 탈퇴 되었습니다.");
				}
				
			}
			else if (sel == 3) {
				
				controller.sortData();
				controller.printStudent();
				
			}
			else if (sel == 4) {
				
				controller.printStudent();
				
			}
			else if (sel == 5) {

				FileWriter fw = null;
				
                if (controller.getSize() == 0) continue;
				
                try {
					
                	fw = new FileWriter(fileName);
					String data = controller.outData();
					
					if (!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
                finally {
                	try {fw.close();} catch (IOException e) {e.printStackTrace();}	
                }
			}
			else if (sel == 6) {
				
				FileReader fr = null;
				BufferedReader br = null;
				try {
					
					File file = new File(fileName);
					
					if (file.exists()) {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						ArrayList<StudentDTO> studentList = new ArrayList<StudentDTO>();
						
						String line = br.readLine();
						int lineCnt = Integer.parseInt(line);
						
						for (int i = 0; i < lineCnt; i++) {
							StudentDTO temp = new StudentDTO();
							line = br.readLine();
							String value[] = line.split(",");
							temp.id = value[0];
							temp.pw = value[1];
							studentList.add(temp);
						}
						controller.loadStudent(studentList);
						
					}
					controller.printStudent();
					
				}
				catch (Exception e) {e.printStackTrace();}
				finally {
					try {br.close();} catch (IOException e) {e.printStackTrace();}
					try {fr.close();} catch (IOException e) {e.printStackTrace();}
				}
									
			}
			else if (sel == 7) { 
				System.out.println("종료");
				break;
			}
		}
		
		scan.close();

	}

}
