package step7_01.objectArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

class StudentEx_풀이{
	
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
		
	}
	
}



class Controller_풀이 {					//여기에 학생리스트
	
	Student[] list = null;			//add될 배열 
	int stdCnt = 0;
	
	void addStudent (Student st) {
		
		if (stdCnt == 0) {
			list = new Student[1];
		}
		else if (stdCnt>0) { 
			Student[] tmp = list;
			list = new Student[stdCnt + 1];
			for (int i = 0; i < tmp.length; i++) {
				list[i] = tmp[i];
			}
			tmp = null;
		}
		list[stdCnt] = st;
		stdCnt++;
 	}
	Student removeStudent (int index) {
		Student deleteodj = list[index];
		
		if (stdCnt ==1) {
			list = null;
		}
		else {
			Student[] tmp = list;
			list = new Student[stdCnt-1];
			for (int i = 0; i < index; i++) {
				list[i] = tmp[i];
			}
			for (int i = index; i < stdCnt-1; i++) {
				list[i] = tmp[i+1];
			}
		tmp = null;
		}
		stdCnt--;
		return deleteodj;
	}
	int checkId(StudentEx_풀이 tmp) {
		int check = -1;
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(tmp)) {
				check = i;
			}
		}
	}	
	void printStudentEx() {
		
	}
	String outData() {
		
	}
	void sortData() {
		
	}
	void loadStudentEx (StudentEx_풀이[] temp , int count) {
		
		
	}
	
	
public class ObjectArrayEx09_풀이 {

	public void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Controller_풀이 controller = new Controller_풀이();
		
		String fileName = "student_db.txt";
		
		while (true) {
			
			System.out.println("1.가입 \n2.탈퇴 \n3.정렬 \n4.출력 \n5.저장 \n6.로드 \n7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				Student tmp = new Student();
				System.out.print("[가입] id 를 입력하세요 >>");
				tmp.id = scan.next();
				int check = controller.checkId(tmp);
				if (check ==-1) {
					System.out.print("[가입] pw 를 입력하세요 >>");
					tmp.pw = scan.next();
					controller.addStudent(tmp);
					System.out.println(tmp.id + "님 가입을 축하드립니다.");
				}
				else {
					System.out.println("중복아이디");
				}
			}
			else if (sel == 2) {
				controller.printStudentEx();
				Student tmp = new Student();
				System.out.println("탈퇴 아이디 입력 : ");
				tmp.id = scan.next();
				int check = controller.checkId(tmp);
				
				if (check==-1) {
					System.out.println("없느 아이디");
				}
				else {
					Student del_st = controller.removeStudent(check);
					System.out.println(del_st.id + "님 탈퇴되었습니다.");
				}
			}
			else if (sel == 3) {
				
			}
			else if (sel == 4) {
				
			}
			else if (sel == 5) {
				
			}
			else if (sel == 6) {
				
			}
			else if (sel == 7) {
				
			}
			
			

		
		}
	}
}
}

