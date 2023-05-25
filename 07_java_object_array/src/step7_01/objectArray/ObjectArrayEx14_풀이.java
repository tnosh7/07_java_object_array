package step7_01.objectArray;

import java.util.ArrayList;
import java.util.Arrays;

// MeArrayList 만들기
class MeArrayList {

	int[] arr;
	int elementCnt;

	void print() {
		
		System.out.println(Arrays.toString(arr));
		
	}

	
	void add(int value) {
		
		if (elementCnt == 0) {
			arr = new int[elementCnt+1];
		}
		else if (elementCnt > 0) {
			int[]tmp = arr;
			arr= new int[elementCnt+1];
			for (int i = 0; i < elementCnt; i++) {
				arr[i] = tmp[i];
			}
			tmp = null;
		}
		arr[elementCnt] = value;
		elementCnt++;
	}

	
	void add(int index, int value) {			//추가하기
		
		if (elementCnt ==0) {
			arr = new int[elementCnt +1]; 
		}
		else if (elementCnt > 0) {
			int[]tmp = arr;
			arr= new int[elementCnt+1];
			
			int j =0 ;
			for (int i = 0; i < elementCnt+1; i++) {
				if (i != index) {
					arr[i] = tmp[j++];
				}
			}
			tmp = null;
		}
		arr[index] = value;
		elementCnt++;
	}
	void remove(int index) {
		
		if (elementCnt == 1) {
			arr = null;
		}
		else if (elementCnt > 1 ) {
			int[]tmp = arr;
			arr = new int[elementCnt -1];
			int j = 0;
			for (int i = 0; i < elementCnt-1; i++) {
				if (i != index) {
					arr[j++] = tmp[i];
				}
			}
			tmp = null;
		}
	elementCnt--;
	}

	
	int size() {
		return elementCnt;
	}

	
	int get(int index) {
		return arr[index];
	}

	
	void set(int index, int value) {
		arr[index] = value;
	}

	
	void clear() {
		arr = null;
		elementCnt = 0;
	}

}


public class ObjectArrayEx14_풀이 {

	public static void main(String[] args) {

		// [ ArrayList 사용 ] 
		ArrayList<Integer> list = new ArrayList<Integer>();

		// 추가하기
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		
		// 삽입하기
		list.add(0, 9);
		// 출력하기
		System.out.println(list);

		// (index로)삭제하기
		list.remove(3);
		System.out.println(list);

		// 길이 구하기
		int elementCnt = list.size();
		System.out.println("elementCnt = " + elementCnt);

		// (index로)값 꺼내오기
		System.out.print("[");
		for (int i = 0; i < elementCnt; i++) {
			System.out.print(list.get(i));
			if (i != elementCnt - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");

		// 특정 위치의 값 수정하기
		list.set(3, 5);
		System.out.println(list);

		// 모든 데이터를 제거하기
		list.clear();
		System.out.println(list.size());

		
		
		
		System.out.println("\n========================================\n");
		
		
		
		
		// [ 직접 구현한 ArrayList ] 
		MeArrayList meList = new MeArrayList();
		// 추가하기
		meList.add(10);
		meList.add(20);
		meList.add(30);
		meList.add(40);
		meList.add(50);
		meList.print();
		
		// 삽입하기
		meList.add(0, 9);
		meList.print();
		// 출력하기
		meList.print();

		// (index로)삭제하기
		meList.remove(3);
		meList.print();
		// 길이 구하기
		int elementCount = meList.size();
		System.out.println("elementCount = " + elementCount);

		System.out.print("[");
		// (index로)값 꺼내오기
		for (int i = 0; i < elementCount; i++) {
			System.out.print(meList.get(i));
			if (i != elementCount-1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		System.out.println();
		// 특정 위치의 값 수정하기
		meList.set(3, 5);
		meList.print();
		
		// 모든 데이터를 제거하기
		meList.clear();
		System.out.println(meList.size());
	}

}
