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
	
	void addStudentEx(StudentEx st) {
		
		if (stdCnt == 0) {				//처음 
			list = new StudentEx[1];
		}
		else if (stdCnt > 0) {			//1명 이상 
			StudentEx[] temp = list;	//배열에 인덱스 길이 추가하기 	
			list = new StudentEx[stdCnt + 1];
			for (int i = 0; i < stdCnt; i++) {
				list[i] = temp[i];
			}
			temp = null;			
		}
		list[stdCnt] = st;				
		stdCnt++;
		
	}
	
	
	StudentEx removeStudentEx (int index) {
		
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
	
	
	int checkId(StudentEx st) {
		
		int check = -1;
		for (int i = 0; i < stdCnt; i++) {
			if (list[i].id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
		
	}
	
	
	void printStudentEx() {
		
		for (int i = 0; i < stdCnt ;i++) {
			list[i].printData();
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
			if (stdCnt - 1 != i) {
				data += "\n";
			}
		}
		return data;
		
	}
	
	
	void sortData() {
		
		for (int i = 0; i < stdCnt; i++) {
			for (int j = i; j < stdCnt ; j++) {
				if (list[i].id.compareTo(list[j].id) > 0) {
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
