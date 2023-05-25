package step7_01.objectArray;

import java.util.ArrayList;

class Tvv {
	
	String name;
	String brand;
	int price;

	void setData(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
}


public class ObjectArrayEx13_풀이 {

	public static void main(String[] args) {
		
		// ArrayList 사용
		ArrayList<Tvv> list = new ArrayList<Tvv>();
		Tvv temp = new Tvv();
				
		temp.setData("TV", "삼성", 1000);
		list.add(temp);
		
		temp = new Tvv();
		temp.setData("시그니처TV", "엘지", 2000);
		list.add(temp);
		
		temp = new Tvv();
		temp.setData("스마트TV", "애플", 3000);
		list.add(temp);
		
		temp = new Tvv();
		temp.setData("4KTV", "샤오미", 500);
		list.add(temp);
		
		for (Tvv tv : list) {
			System.out.println("제품명 :" + tv.name + "\t제조사 :" + tv.brand +"\t가격 : " + tv.price );
		}
		System.out.println("------------------");
		
		list.remove(0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("name : " + list.get(i).name);
			System.out.println("brand : " + list.get(i).brand);
			System.out.println("price : " + list.get(i).price);
			System.out.println();
		}
		System.out.println("===================");
		for (Tvv tv : list) {
			System.out.println("name : " + tv.name);
			System.out.println("brand : " + tv.brand);
			System.out.println("price : " + tv.price);
			System.out.println();
		}
		
	}

}
