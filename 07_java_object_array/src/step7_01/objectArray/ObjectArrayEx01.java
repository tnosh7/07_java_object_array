package step7_01.objectArray;

class Product {
	
	String name;
	int price; 
	
}


public class ObjectArrayEx01 {

	public static void main(String[] args) {
		
		// int[] arr = new int[3];
		
		// 클래스배열 생성방법 > 클래스명[] 배열명 = new 클래스명[크기];
		Product[] productList = new Product[3];   // + List
		
		productList[0] = new Product();
		productList[1] = new Product();
		
		Product p = new Product();
		p.name = "장패드";
		p.price = 10000;
		
		productList[2] = p;
		
		productList[0].name = "기계식 키보드";
		productList[0].price = 45000;
		
		productList[1].name = "무소음 마우스";
		productList[1].price = 27000;
		
		for (int i = 0; i < productList.length; i++) {
			System.out.println("name : " + productList[i].name);	
			System.out.println("price : " + productList[i].price);
		}
		
		// [응용] 생각해보기 
		? temp1 = productList; 	 		 // 주소 or 데이터 
		? temp2 = productList[0]; 		// 주소 or 데이터 
		? temp3 = productList[0].name;	// 주소 or 데이터 
		? temp3 = productList[0].price;	// 주소 or 데이터 
		
		
	}

}
