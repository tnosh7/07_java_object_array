package step7_01.objectArray;
import java.util.Scanner;

class Subj{
	
	String name;
	int score;

}


class Stud{
	
	Subj[] subjects;
	String name;

}


public class ObjectArrayEx08_연습2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		Stud[] sList = new Stud[3];
		int sCnt = 0;
		
		while (true) {
			for (int i = 0; i < sList.length; i++) {
				sList[i] = new Stud();
				if (sList[i].subjects != null) {
					for (int j = 0; j < sList[i].subjects.length; j++) {
						System.out.println((i+1) + ". name : " + sList[i].subjects[j].name + "\t score : " + sList[i].subjects[j].score);
					}
				}
				System.out.println();
			}
			System.out.println("[1.이름 추가하기]\t[2.과목 추가하기]\t[3.성적 추가하기]\t[4.종료하기]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				if (sCnt == sList.length) {
					System.out.println("더이상 입력할 수 없습니다.");
				}
				Stud temp = new Stud();
				System.out.print("이름 입력 : ");
				temp.name = scan.next();
				
				sList[sCnt].name = temp.name;
				sCnt++;
			}
			else if (sel == 2) {
				for (int i = 0; i < sCnt; i++) {
					System.out.println((i+1) + sList[i].name);
				}
				System.out.print("이름을 선택해주세요 :");
				int idx = scan.nextInt()-1 ;
				
				System.out.println("과목을 입력해주세요 : ");
				String sub = scan.next();
				
				if (sList[idx].subjects == null) {
					sList[idx].subjects = new Subj[1];
					sList[idx].subjects[0] = new Subj();
					sList[idx].subjects[0].name = sub;
					
				}
				else {
					int leng = sList[idx].subjects.length;
					Subj[]temp = sList[idx].subjects;
					sList[idx].subjects = new Subj[leng+1];
					
					
				}
				
			}
			else if (sel == 3) {}
			else if (sel == 4) {
				System.out.println("프로그램 종료");
				break;
			}
			
		
		
		}
		
		
		

	}

}
