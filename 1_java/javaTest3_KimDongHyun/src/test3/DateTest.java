package test3;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateTest {

	public static void main(String[] args) {
		Date birthDay, today;
		birthDay = new Date(1996-1900, 5-1, 27);
		today = new Date();
		
			
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		String formatBirth = format1.format(birthDay);
		
		String formatNow = format2.format(today);
		
		System.out.println("생일 : " + formatBirth);
		
		System.out.println("현재 : " + formatNow);
		
		System.out.println("나이 : " +  ( today.getYear() - birthDay.getYear() ) + " 세");
		

	}

}
