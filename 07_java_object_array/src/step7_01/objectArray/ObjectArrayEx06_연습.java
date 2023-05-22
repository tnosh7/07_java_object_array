package step7_01.objectArray;

class Member{
	
	String name;
	int num;
	
}


class MemberManager{

	Member[] memberList = new Member[3];	//고정 

}


public class ObjectArrayEx06_연습 {

	public static void main(String[] args) {

		// 해석해보기
		MemberManager mg = new MemberManager();	
		Member m1 = new Member();
		//System.out.println(m1);	링크확인용
		mg.memberList[0] = m1;
		m1.name = "김철수";
		m1.num = 1001;
		
		m1 = new Member();		//초기화. 새로 클래스를 연결해서 링크가 달라진다.
		//System.out.println(m1);   링크확인용
		mg.memberList[1] = m1;
		m1.name = "이만수";
		m1.num = 1002;
		
		m1 = new Member();
		mg.memberList[2] = m1;
		m1.name = "박영희";
		m1.num = 1003;
		
		for (int i = 0; i < mg.memberList.length; i++) {
			System.out.println("num : " + mg.memberList[i].num);
			System.out.println("name : " + mg.memberList[i].name);
			System.out.println();
		}
		
		Member temp = mg.memberList[1];
		System.out.println("num : " + temp.num);
		System.out.println("name : " +temp.name);

	}

}
