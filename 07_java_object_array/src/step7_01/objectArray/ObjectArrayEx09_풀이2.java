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

class ControllerCC {
	
	StudentCC[] list = null; 
	int stdCnt = 0;
	
	void addStudentCC(StudentCC st) {
		
		
	}
	
	StudentCC removeStudentCC(int index) {
		
		
	}
	
	int checkId(StudentCC st) {
		
		
		
	}
	
	void printStudentCC() {
		
	}
	
	String outData() { 
		
	}
	
	void sortData() {
		
		
	}
	
	void loadStudentCC (StudentCC[] temp, int count) {
		
		
	}
}


public class ObjectArrayEx09_풀이2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ControllerCC_ controller = new ControllerCC();
		
		String fileName = "student_db.txt";
		
		while (true) {
			
			System.out.println("1.가입 \n2.탈퇴 \n3.정렬 \n4.출력 \n5.저장 \n6.로드 \n7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				StudentCC temp = new StudentCC(); 
				System.out.println("[]");
				
				
			}
			else if (sel == 2) {
				
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
