package step7_01.objectArray;

class Member_풀이{
	
	String name;
	int num;
	
}


class MemberManager_풀이{

	Member_풀이[] memberList = new Member_풀이[3];

}


public class ObjectArrayEx06_풀이 {

	public static void main(String[] args) {

		// 해석해보기
		MemberManager_풀이 mg = new MemberManager_풀이();	
		Member_풀이 m1 = new Member_풀이();
		
		mg.memberList[0] = m1;
		m1.name = "김철수";
		m1.num = 1000;
		
		m1 = new Member_풀이();
		mg.memberList[1] = m1;
		m1.name = "이만수";
		m1.num = 1001;
		
		m1 = new Member_풀이();
		mg.memberList[2] = m1;
		m1.name = "박영희";
		m1.num = 1002;
		
		for (int i = 0; i < mg.memberList.length; i++) {
			System.out.println("num : " + mg.memberList[i].num);
			System.out.println("name : " + mg.memberList[i].name);
			System.out.println();
		}
		
		Member_풀이 temp = mg.memberList[1];
		System.out.println("num : " + temp.num);
		System.out.println("name : " + temp.name);
	}

}
