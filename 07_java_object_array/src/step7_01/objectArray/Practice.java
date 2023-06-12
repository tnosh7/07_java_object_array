package step7_01.objectArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import jdk.jfr.events.FileWriteEvent;

class People{
	String id;
	String pw;
	
	void printP() {
		System.out.println("이름 :" + id + "\t비번 : " + pw);
	}
}
class Active {
	People[]accList;
	int accCnt = 0;
	
	int checkId (People index) {
		int check = -1;
		for (int i = 0; i < accCnt; i++) {
			if (accList[i].equals(index)) check = i;
		}
		return check;
	}
	
	void addAcc (String ac, String ps) {
		if (accCnt == 0) {
			accList = new People[1];
			accList[accCnt] = new People();
			accList[accCnt].id = ac;
			accList[accCnt].pw = ps;
 		}
		else if (accCnt > 0) {
			int length = accList.length;
			People[]temp = accList;
			accList = new People[accCnt+1];
			for (int i = 0; i < temp.length; i++) {
				accList[i] = temp[i];
			}
			temp = null;
			
			accList[length] = new People();
			accList[length].id = ac;
			accList[length].pw = ps;
		}
		accCnt++;
	}
	
	void delAcc (String delid, String delpw) {
		int delObj = -1;
		
		for (int i = 0; i < accCnt; i++) {
			if (delid.equals(accList[i].id) && delpw.equals(accList[i].pw)) {
				delObj = i;
			}
		}
		if (delObj == -1) {
			System.out.println("ID와 PW를 확인해주세요.");
			return;
		}
		else if (delObj != -1) {
			System.out.print("PW 입력 : ");
			
			int length = accList.length;
			People[] temp = accList;
			accList = new People[accCnt-1];
			for (int i = 0; i < delObj; i++) {
				accList[i] = temp[i];
			}
			for (int i = delObj; i < temp.length; i++) {
				accList[i] = temp[i+1];
			}
			temp = null;
			accCnt--;
		}
	}
	
	void sortAcc() { 
		
		for (int i = 0; i < accCnt; i++) {
			for (int j = 0; j < accCnt; j++) {
				if (accList[i].id.compareTo(accList[j].id) > 0) {
					People temp = accList[i];
					accList[i] = accList[j];
					accList[j] = temp;
				}
			}
		}
	}
	void printPeople () { 
		for (int i = 0; i < accCnt; i++) {
			accList[i].printP();
		}
		
	}
	
	String outData() { 
		
		String data = "";
		if (accCnt ==0) {
			return data;
		}
		
		data += accCnt;
		data += "\n";
		for (int i = 0; i < accCnt; i++) {
			data+= accList[i].id;
			data+= ",";
			data+= accList[i].pw;
			if (accCnt-1 != i) {
				data += "\n";
			}
		}
		return data;
	}
	
	
}






public class Practice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Active ac = new Active();
		String fileName = "people.txt";
		
		while (true) {
			System.out.println("1.가입\n2.탈퇴\n3.정렬\n4.출력\n5.저장\n6.로드\n7.종료 :");
			int sel = scan.nextInt();
			if (sel == 1) {
				People temp = new People();
				System.out.print("[가입]ID입력 : ");
				temp.id = scan.next();
				int check = ac.checkId(temp);
				if (check == -1) {
					System.out.print("[가입]PW입력 : ");
					temp.pw = scan.next();
					ac.addAcc(temp.id, temp.pw);
				}
			}
			else if (sel == 2) {
				System.out.print("[탈퇴]ID입력 : ");
				String delId = scan.next();
				System.out.print("[탈퇴]PW입력 : ");
				String delPw = scan.next();
				ac.delAcc(delId, delPw); 
			}
			else if (sel == 3) {
				ac.sortAcc();
				ac.printPeople();
			}
			else if (sel == 4) {
				ac.printPeople();
			}
			else if (sel == 5) {
				if (ac.accCnt == 0) continue;
				
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(fileName);
					String data = ac.outData();
					fw.write(data);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if (sel == 6) {}
			else if (sel == 7) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		
		
	}

}
