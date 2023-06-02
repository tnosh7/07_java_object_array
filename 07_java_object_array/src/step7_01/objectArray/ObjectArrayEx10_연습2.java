package step7_01.objectArray;

import java.util.ArrayList;

public class ObjectArrayEx10_연습2 {

	public static void main(String[] args) {

		//ArrayList~~~
		ArrayList<Integer> test1 = new ArrayList<Integer>();
		ArrayList<Double> test2 = new ArrayList<Double>();
		ArrayList<String> test3 = new ArrayList<String>();
		ArrayList<Character> test4 = new ArrayList<Character>();
		ArrayList<Boolean> test5 = new ArrayList<Boolean>();
		
		
		
		test1.add(10);
		test1.add(20);
		test1.add(30);
		test1.add(40);
		test1.add(150);
		for (int i = 0; i < test1.size(); i++) {
			System.out.println("test1 : " + test1);
		}
		int tmp = test1.get(1);
		System.out.println(tmp);
		test1.remove(4);
		test1.set(2, -1);
		System.out.println(test1);
		
		
		test2.add(1.0);
		test2.add(2.0);
		test2.add(3.0);
		test2.add(4.0);
		for (Double b : test2) {
			System.out.print(b + " / ");
		}
		test2.clear();
		System.out.println();		
		test3.add("바나나");
		test3.add("키위");
		test3.add("딸기");
		test3.add("복숭아");
		test3.add("토마토");
		System.out.println(test3);
		test3.set(4,"망고");
		
		for (String S : test3) {
			if(S.equals("바나나")) {
				S = "수박";
			}
			System.out.print(S + " ");
		}
		
		test4.add('=');
		test4.add('o');
		test4.add('=');
		System.out.print(test4);
		System.out.println();
		System.out.println("test1길이: "+test1.size() + " test2길이: " +test2.size()+ " test3길이: " +test3.size()+ " test4길이: "+test4.size() );
		
		test4.remove(0);
		System.out.println(test4.size());
		test4.set(0, 'W');					//set은 기존의 인덱스 길이만큼만 넣을 수 있음 
		test4.set(1, 'A');
		System.out.println(test4);
		
		test5.add(true);
		test5.add(true);
		test5.add(true);
		test5.add(true);
		test5.add(true);
		test5.add(true);
		
		test5.set(3, false);
		System.out.println(test5);
		test5.remove(1);
	}


}
