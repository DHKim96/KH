package test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodsTest {

	public static void main(String[] args) {
		System.out.println("다음 항목의 값을 입력하시오.");
	

		Goods goods = new Goods();
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("상품명 : ");
			String name = br.readLine();
			goods.setName(name);
			
			System.out.print("가격 : ");
			Integer price = Integer.parseInt(br.readLine());
			goods.setPrice(price);
			
			System.out.print("수량 : ");
			Integer quantity = Integer.parseInt(br.readLine());
			goods.setQuantity(quantity);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		System.out.println("입력된 결과는 다음과 같습니다.");
		System.out.println(goods);
		int totalPrice = goods.getPrice() * goods.getQuantity();
		System.out.println("총 구매 가격 : " + totalPrice + " 원");
		
	}

}
