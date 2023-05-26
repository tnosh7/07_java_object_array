package step7_01.objectArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

class StuEx{
	String id;
	String pw;
	
	void printData() { 
		System.out.println("이름 : " + id + "비밀번호 : " + pw);
	}
}

class Controla {
	
	StuEx[] list = null;
	int stuCnt = 0;
	
	int checkId(StuEx st) {
		
		int check = -1; 
		for (int i = 0; i < stuCnt; i++) {
			if (list[i].equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
		
	}
	void addStuEx (StuEx st) {
		
		if (stuCnt == 0) {
			list = new StuEx[1];
		}
		else if (stuCnt > 0) {
			StuEx[] temp = list;
			list = new StuEx[stuCnt + 1];
			for (int i = 0; i < stuCnt; i++) {
				list[i] = temp[i];
			}
			temp = null;
		}
		list[stuCnt] = st;
		stuCnt++;
	}
	StuEx removeStuEx (int index) {
		StuEx delobj = list[index];
		if (stuCnt == 1) {
			list = null; 
		}
		else if (stuCnt > 1) {
			StuEx[]temp = list;
			list = new StuEx[stuCnt-1];
			
			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			}
			
			for (int i = index; i < stuCnt -1 ; i++) {
				list[i] = temp[i+1];
			}
			temp = null;
		}
		stuCnt--;
		return delobj;
	}
	void sortData() {
		for (int i = 0; i < stuCnt; i++) {
			for (int j = 0; j < stuCnt; j++) {
				if (list[i].id.compareTo(list[j].id) >0 ) {
					StuEx temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	String outData() { 
		String data = "";
		if (stuCnt == 0) {
			return data;
		}
		data += stuCnt;
		data += "\n";
		for (int i = 0; i < stuCnt; i++) {
			data += list[i].id;
			data += ",";
			data += list[i].pw;
			if (stuCnt -1 != i) 
				data+="\n"; 
		}
		return data;
	}
	
	void loadStuEx (StuEx[]temp, int count) {
		this.stuCnt = count;
		this.list = temp;
	}
	
	
	void printStuEx() { 
		for (int i = 0; i < stuCnt; i++) {
			list[i].printData();
		}
	}
}

public class ObjectArrayEx09_풀이2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Controla control = new Controla();
		
		String fileName= "student_db.txt";
		
		while (true) {
			
			System.out.println("1.가입\n2.탈퇴\n3.정렬\n4.출력\n5.저장\n6.로드\n7.종료 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				
				StuEx temp = new StuEx();
				
				System.out.print("id : ");
				temp.id = scan.next();
				
				int check = control.checkId(temp);
				if (check == -1) {
					System.out.println("pw : ");
					temp.pw = scan.next();
					
					control.addStuEx(temp);
				}
				else {
					System.out.println("중복아이디");
				}
			}
			else if (sel == 2) {
				control.printStuEx();
				StuEx temp = new StuEx();
				System.out.println("id 입력 : ");
				temp.id =scan.next();
				
				int check = control.checkId(temp);
				if (check != -1 ) {
					StuEx del_st = control.removeStuEx(check);
					System.out.println(del_st.id + "님 탈퇴를 축하합니다.");
				}
				else {
					System.out.println("없는 아이디");
				}
			}
			else if (sel == 3) {
				control.printStuEx();
				control.sortData();
			}
			else if (sel == 4) {
				control.printStuEx();
			}
			else if (sel == 5) {
				
				if (control.stuCnt == 0) continue;
				
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(fileName);
					String data = control.outData();
					if (!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {fw.close();} catch (IOException e) {e.printStackTrace();}
				}
			}
			else if (sel == 6) {
				
				FileReader fr = null;
				BufferedReader br = null;
				
				File file = new File(fileName);
				
				if (file.exists()) {
					
					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						String line = br.readLine();
						int count = Integer.parseInt(line);
						StuEx[]temp = new StuEx[count];
						
						for (int i = 0; i < count ; i++) {
							temp[i] = new StuEx();
							line = br.readLine();
							String[]value = line.split(",");
							temp[i].id = value[0];
							temp[i].pw = value[1];
						}
						control.loadStuEx(temp, count);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}
					}
					try {fr.close();} catch (IOException e) {e.printStackTrace();}
				}
			}
			else if (sel ==7) {
				System.out.println("종료");
				break;
			}
				
		}
		
		scan.close();
	}
}
