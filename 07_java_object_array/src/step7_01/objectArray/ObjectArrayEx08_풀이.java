package step7_01.objectArray;
import java.util.Scanner;

class Subject8_풀이{
	
	String name;
	int score;

}


class Student8_풀이{
	
	Subject8_풀이[] subjects;
	String name;

}


public class ObjectArrayEx08_풀이 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student8_풀이[] studentList = new Student8_풀이[3];
		int studentCnt = 0;	// 학생 수
		
		while (true) {
			
			for (int i = 0; i < studentCnt; i++) {
				System.out.println("[" + (i+1) + "]" + studentList[i].name + "학생>>>>>>") ;
				if (studentList[i].subjects != null) {
					for (int j = 0; j < studentList[i].subjects.length; j++) {
						System.out.println("[" + (i+1) + "]" + studentList[i].subjects[j].name + "과목>>>>>" + studentList[i].subjects[j].score + "점");
					}
				}
			}
			System.out.println("[1]학생추가하기");
			System.out.println("[2]과목추가하기");
			System.out.println("[3]성적추가하기");
			System.out.println("[4]종료하기");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				System.out.print("이름 입력 : ");
				String name = scan.next();
				
				studentList[studentCnt] = new Student8_풀이();
				studentList[studentCnt].name = name;
				studentCnt++;
				
			}
			else if (sel == 2) {
				
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				System.out.print("학생 선택 : ");
				int idx =scan.nextInt() -1;
				
				System.out.print("과목 이름 : ");
				String subject = scan.next();
				
				if (studentList[idx].subjects == null) {
					studentList[idx].subjects = new Subject8_풀이[1];
					studentList[idx].subjects[0] = new Subject8_풀이(); 
					studentList[idx].subjects[0].name = subject;
				}
				else {
					//배열 길이  추가하기 
					int size = studentList[idx].subjects.length;
					
					Subject8_풀이[]tmp = studentList[idx].subjects;
					studentList[sel].subjects = new Subject8_풀이[size+1];
					for (int i = 0; i < size; i++) {
						studentList[sel].subjects[i] = tmp[i];
					}
					studentList[sel].subjects[size] = new Subject8_풀이();
					studentList[sel].subjects[size].name = subject;
					tmp = null;
				}
			}
			else if (sel == 3) {
				
				for (int i = 0; i < studentCnt; i++) {
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				System.out.println("학생 선택 : ");
				int select = scan.nextInt()-1;
				
				if (studentList[select].subjects != null) {
					for (int i = 0; i < studentList[select].subjects.length; i++) {
						System.out.println("[" + (i+1) + "]" + studentList[select].subjects[i].name);
					}
					System.out.print("과목 선택 : ");
					int num =scan.nextInt()-1;
					
					System.out.println("성적 입력 : ");
					int score = scan.nextInt();
					
					studentList[select].subjects[num].score = score;
				}
			}
			else if (sel == 4) {
				System.out.println("종료");
				break;
			}
		}
		scan.close();
	}
}
