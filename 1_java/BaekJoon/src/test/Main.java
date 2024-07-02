package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		try {
			// 1. 분배합 N = 생성자 M + M의 각 자릿 수의 수
			// 2. M의 각 자릿 수의 합은
			/*
			 * 나머지 a =  M % 10; (일의 자리의 나머지)
			 * sum += a; 자릿 수를 더 함
			 * M -= a;
			 * M /= 10; 자릿 수가 줄어듦
			 * 가장 높은 자릿 수의 합 sum 까지 구할 수 있음.
			 */
			//3. i = 1부터 분배합 N까지의 for 문을 돌림
			//4. 만약 임의의 수 i + i의 자릿 수의 합 sum = N 을 만족하면 탈출
			//	 i가 1부터 증가했기에 자연스럽게 분배합을 만족하는 생성자 중 가장 작은 수가 됨
			//+ 다만 각 자릿 수에 들어갈 수 있는 최대값이 9이기에 
			// 생성자는 분배합 - 분배합의 자리의 갯수 * 9 보다 작을 수 없음.
			// 따라서 for문의 시작점을 분배합 - 분배합의 자리의 갯수 * 9 로 잡을 수 있음.
			String strNum = br.readLine(); 
			
			int N = Integer.parseInt(strNum);
			
			int result = 0;
			
	
			for(int i = N - (strNum.length() * 9) ; i <= N ; i++ ) {
				int sum = 0;
				int a = i;
				while(a >= 1) {
					int reminder = a % 10;
					sum += reminder;
					a -= reminder;
					a /= 10;
				}
				if(sum + i == N) {
					result = i;
					break;
				}
			}

			bw.write(result + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
