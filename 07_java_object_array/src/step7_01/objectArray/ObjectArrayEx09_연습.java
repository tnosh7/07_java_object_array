package step7_01.objectArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class StudentEx{
	
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
		
	}
	
}



class Controller {
	
	StudentEx[] list = null;
	int stdCnt = 0;
	
	void addStudentEx(StudentEx st) {		//추가
		
		if (stdCnt == 0) {
			list = new StudentEx[1];		//리스트 배열이랑 id pw 연결 
		}
		else if (stdCnt > 0) {				
			StudentEx[] temp = list;
			list = new StudentEx[stdCnt + 1];
			for (int i = 0; i < stdCnt; i++) {
				list[i] = temp[i];
			}
			temp = null;
		}
		list[stdCnt] = st;
		stdCnt++;
		
	}
	
	
	StudentEx removeStudentEx (int index) {		//삭제 
		
		StudentEx deleteObj = list[index];  	
		if (stdCnt == 1) {
			list = null;					
		}
		else if (stdCnt > 1) {					
			StudentEx [] temp = list;
			list = new StudentEx[stdCnt -1];
			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			}
			for (int i = index; i < stdCnt -1; i++) {
				list[i] = temp[i + 1];
			}
			temp = null;
		}
		stdCnt--;
		
		return deleteObj;  // 굳이 return을 안해주고 데이터만 삭제해주어도 되는데
						// 타 언어의 pop()메서드와 같이 삭제하는 데이터를 return하는 방식처럼 구현해본 예시
		
	}
	
	
	int checkId(StudentEx st) {					//기존 id랑 비교 
		
		int check = -1;
		for (int i = 0; i < stdCnt; i++) {
			if (list[i].id.equals(st.id)) {
				check = i;						//인덱스 check로 
				break;
			}
		}
		return check;
		
	}
	
	
	void printStudentEx() {						//학생데이터 출력 
		
		for (int i = 0; i < stdCnt ;i++) {
			list[i].printData();
		}
		
	}	
	
	
	String outData() {							//data 변수에 저장 
		
		String data = "";
		if (stdCnt == 0) {
			return data;				
		}
		data += stdCnt;					//??????
		data += "\n";							
		for (int i = 0; i < stdCnt; i++) {
			data += list[i].id;
			data += ",";
			data += list[i].pw;
			if (stdCnt - 1 != i) {
				data += "\n";
			}
		}
		return data;
		
	}
	
	
	void sortData() {					//정렬
		
		for (int i = 0; i < stdCnt; i++) {
			for (int j = i; j < stdCnt ; j++) {
				if (list[i].id.compareTo(list[j].id) > 0) {	//같지 않으면  크면 양수였ㄷ나??  
					StudentEx temp = list[i];				
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		
	}
	
	
	void loadStudentEx (StudentEx[] temp , int count) {
		
		this.stdCnt = count;
		this.list = temp;
		
	}
	
}


public class ObjectArrayEx09_연습 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Controller controller = new Controller();
		
		String fileName = "student_db.txt";
		
		while (true) {
			//1.가입-기존아이디랑 중복 확인, add할 배열 필요. 2.탈퇴-아이디.비번 확인, 탈퇴 인덱스 길이 조정
			//3.정렬-기존에 있는 String이름 비교해서 compartTo로 정렬해줌 4.출력-가입된list출력 5.저장-FileWriter
			//6.로드-ff, fr, br이용ㅇ  
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				StudentEx temp = new StudentEx();
				System.out.println("[가입] id 를 입력하세요 >>> ");
				temp.id = scan.next();			
				int check =  controller.checkId(temp);	//기존에 있는 아이디인지 비교 
														//
				if (check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next();
					controller.addStudentEx(temp);		//id추가함
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else {
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) {
				
				controller.printStudentEx();		
				
				StudentEx temp = new StudentEx();
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();	
				int check = controller.checkId(temp);
				
				if (check == -1) {
					System.out.println("없는 아이디입니다.");
				}
				else {
					StudentEx del_st = controller.removeStudentEx(check);
					System.out.println(del_st.id + "님 탈퇴 되었습니다.");
				}
				
			}
			else if (sel == 3) {
				
				controller.sortData();
				controller.printStudentEx();
				
			}
			else if (sel == 4) {
				
				controller.printStudentEx();
				
			}
			else if (sel == 5) {
				
                if (controller.stdCnt == 0) continue;
				
                FileWriter fw = null;
                
                try {
                	
					fw = new FileWriter(fileName);
					String data = controller.outData();
					if (!data.equals("")) {//내용이 있다면 
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
						
						String line = br.readLine();
						int count = Integer.parseInt(line);
						StudentEx [] temp = new StudentEx[count];
						
						for (int i = 0; i < count; i++) {
							temp[i] = new StudentEx();
							line = br.readLine();
							String[] value = line.split(",");
							temp[i].id = value[0];
							temp[i].pw = value[1];
						}
						
						controller.loadStudentEx(temp , count);
						
					}
					
					controller.printStudentEx();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
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
