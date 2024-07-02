package test2;

public class StringTest {

	public static void main(String[] args) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data[] = new double[5];
		double sum = 0;
		
		String[] st = str.split(",");
		
		
//		int count = 0;
//		for(int i = 0 ; i < st.length ; i ++) {
//			data[i] = Double.parseDouble(st[i]);
//			sum += data[i];
//			count++;
//		}
		int index = 0;
		for(String s : st) {
			data[index] = Double.parseDouble(s);
			sum += data[index++]; // 증감식 넣어줘야 마지막 인덱스까지 가능
		}
		
		double average = sum / index ;
		
		System.out.printf("합계 : %.3f\n", sum);
		System.out.println("평균 : " + average );
	}

}
