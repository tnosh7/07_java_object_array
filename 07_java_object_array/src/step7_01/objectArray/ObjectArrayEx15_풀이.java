package step7_01.objectArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class StuDTO { 
	
	String id;
	String pw; 
	
	void printData() { 
		System.out.println("이름 : " + id + "\t비밀번호 :" + pw);
	}
}

class StuController { 
	
	ArrayList<StuDTO> stuList = new ArrayList<StuDTO>();
	
	int checkStu (StuDTO stuDTO) { 
		int check = -1 ;
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).id.equals(stuDTO)) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	void addStu (StuDTO stuDTO) {
		stuList.add(stuDTO);
	}
	StuDTO removeStu (int index) {
		StuDTO delObj = stuList.get(index);
		stuList.remove(index);
		return delObj;
	}
	
	void printStu() {
		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).printData();
		}
	}
	void sortData() {
		
		for (int i = 0; i < stuList.size(); i++) {
			for (int j = i; j < stuList.size(); j++) {
				if (stuList.get(i).id.compareTo(stuList.get(j).id) > 0) {
					String tmp = stuList.get(i).id;
					stuList.get(i).id = stuList.get(j).id;
					stuList.get(j).id = tmp;
					
					String tmp2 = stuList.get(i).pw;
					stuList.get(i).pw = stuList.get(j).pw;
					stuList.get(j).pw = tmp2;
				}
			}
		}
	}
	String outData() { 
		String data = "";
		int count = stuList.size();
		if (count == 0) {
			return data;
		}
		data += count;
		data += "\n";
		for (int i = 0; i < count; i++) {
			data+= stuList.get(i).id;
			data+= ",";
			data+= stuList.get(i).pw;
			if (count -1 != i) {
				data+="\n";
			}
		}
		return data;
	}
	void loadStu(ArrayList<StuDTO>stuList) {
		this.stuList = stuList;
	}
	
	int getSize() { 
		int size = stuList.size();
		return size;
	}
}

public class ObjectArrayEx15_풀이 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StuController contrl = new StuController();
	
		String fileName = "student_arrayList";
		
		while (true) {
			
			System.out.print("1.가입\n2.탈퇴\n3.정렬\n4.출력\n5.저장\n6.로드\n7.종료");
			int sel =scan.nextInt();
			
			if (sel == 1) {
				
				StuDTO temp = new StuDTO();
				
				System.out.print("[가입] ID 입력 : ");
				temp.id = scan.next();
				
				int check = contrl.checkStu(temp);
				
				if (check == -1) {
					System.out.print("[가입] PW 입력 : ");
					temp.pw = scan.next();
					
					contrl.addStu(temp);
					System.out.println(temp.id + "님 가입추카");
				}
				else System.out.println("중복아이디");
			}
			else if (sel == 2) {
				contrl.printStu();
				StuDTO temp = new StuDTO();
				
				System.out.println("탈퇴 아이디 입력 :");
				temp.id = scan.next();
				
				int check = contrl.checkStu(temp);
				
				if (check == -1) {
					System.out.println("가입후 이용");
				}
				else {
					System.out.println(contrl.removeStu(check).id + "님 탈퇴되었씁니다.");
				}
			}
			else if (sel == 3) {
				contrl.sortData();
				contrl.printStu();
			}
			else if (sel == 4) {
				contrl.printStu();
			}
			else if (sel == 5) {
				FileWriter fw = null;
				
				if (contrl.getSize() ==0 ) {
					continue;
				}
				try {
					fw= new FileWriter(fileName);
					String data = contrl.outData();
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
						ArrayList<StuDTO> studList = new ArrayList<StuDTO>();
						
						String line = br.readLine();
						int cnt= Integer.parseInt(line);
						
						for (int i = 0; i < cnt; i++) {
							StuDTO temp = new StuDTO();
							line = br.readLine();
							String[]value = line.split(",");
							temp.id = value[0];
							temp.pw = value[1];
							studList.add(temp);
						}
						contrl.loadStu(studList);
						contrl.printStu();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}
						try {fr.close();} catch (IOException e) {e.printStackTrace();
}
					}
				}
			}
			else if(sel == 7) {
				System.out.println("종료");
				break;
			}
		}
				
	scan.close();
	}

}
