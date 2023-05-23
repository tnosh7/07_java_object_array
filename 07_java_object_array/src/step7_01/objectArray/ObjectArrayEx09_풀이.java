package step7_01.objectArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class StudentEx_풀이{
	
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
		
	}
	
}



class Controller_풀이 {					//여기에 학생리스트
	
	StudentEx[] list = null;			//add될 배열 
	int stdCnt = 0;
	

public class ObjectArrayEx09_풀이 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Controller_풀이 controller = new Controller_풀이();
		
		String fileName = "student_db.txt";
		
		while (true) {
			
			System.out.println("1.가입 \n2.탈퇴 \n3.정렬 \n4.출력 \n5.저장 \n6.로드 \n7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				
				
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
