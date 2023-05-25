package step7_01.objectArray;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

class StudentCC{
	
	String id;
	String pw;
	
	void printData() { 
		System.out.println("이름 : " + id + "비밀번호 : " + pw);
	}
}

class ControllerC {
	
	StudentCC[] list = null; 
	int stdCnt = 0;
	
	void addStudentCC(StudentCC st) {
		
		if (stdCnt == 0) {
			list = new StudentCC[1];
			list[0] = st;
		}
		else if (stdCnt > 0) {
			int length  = list.length;
			StudentCC[] temp = list;
			list = new StudentCC[length+1];
			for (int i = 0; i < length; i++) {
				list[i] = temp[i];
			}
			temp = null;
			list[length] = st;
		}
		stdCnt++;
	}
	
	StudentCC removeStudentCC(int index) {
		//배열 삭제 
		StudentCC delobj = list[index];
		if (stdCnt == 1) {
			list = null;
		}
		else if (stdCnt > 1) {
			StudentCC[]temp = list;
			list = new StudentCC[stdCnt-1];
			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			}
			for (int i = index; i < stdCnt-1 ; i++) {
				list[i] = temp[i +1];
			}
			temp = null; 
		}
		stdCnt--;
		return delobj;
	}
	
	int checkId(StudentCC st) {
		
		int check = -1;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == st) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	void printStudentCC() {
		
		for (int i = 0; i < stdCnt; i++) {
			System.out.println("[" + (i+1) + "]" + list[i].id);
		}
	}
	
	String outData() { 
		
		String data = "";
		if (stdCnt == 0) {
			return data;
		}
		data += stdCnt;
		data += "\n";
		for (int i = 0; i < stdCnt; i++) {
			data += list[i].id;
			data += ","; 
			data += list[i].pw;
			if (stdCnt-1 != i) {
				data += "\n";
			}
		}
		
		return data;
	}
	
	void sortData() {
		
		for (int i = 0; i < stdCnt; i++) {
			for (int j = i; j < stdCnt; j++) {
				if (list[i].id.compareTo(list[j].id) > 0) {
					StudentCC temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	void loadStudentCC (StudentCC[] temp, int count) {
		
		
	}
}


public class ObjectArrayEx09_풀이 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ControllerC controller = new ControllerC();
		
		String fileName = "student_db.txt";
		
		while (true) {
			
			System.out.println("1.가입 \n2.탈퇴 \n3.정렬 \n4.출력 \n5.저장 \n6.로드 \n7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				StudentCC temp = new StudentCC(); 
				System.out.print("[가입] id를 입력하세요 :");
				temp.id = scan.next();
				int check = controller.checkId(temp);
				if (check == -1) {
					System.out.print("[가입] pw를 입력하세요 : ");
					temp.pw = scan.next();
					controller.addStudentCC(temp);
					System.out.println(temp.id + "님 환영합니다.");
				
				}
				else {
					System.out.println("중복아이디입니다.");
				}
			}
			else if (sel == 2) {//탈퇴
				controller.printStudentCC();
				
				StudentCC temp = new StudentCC();
				System.out.print("[탈퇴] Id를 입력하세요 : ");
				temp.id = scan.next();
				int check = controller.checkId(temp);
				
				if (check == -1) {
					System.out.println("없는 아이디입니다.");
				}
				else {///삭제
					
					StudentCC del = controller.removeStudentCC(check);
					System.out.println(del.id + "님 탈퇴되었숩");
				}
			}
			else if (sel == 3) {
				controller.sortData();
				controller.printStudentCC();
			}
			else if (sel == 4) {
				controller.printStudentCC();
			}
			else if (sel == 5) {
				if (controller.stdCnt == 0) continue;
				FileWriter fw = null; 
				try { 
					fw = new FileWriter(fileName);
					String data = controller.outData();
					
				} catch (Exception e ) {
					e.printStackTrace();
				} finally {try {fw.close();} catch (IOException e) {e.printStackTrace();}
				}
			}
			else if (sel == 6) {
				
			}
			else if (sel == 7) {
				
			}
			
		}
		
	}
}
