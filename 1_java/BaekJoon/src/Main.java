import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
<<<<<<< HEAD
		// 체스판 경우의 수 2개. 해당 체스판들을 2차원 배열로 생성.
		char[][] chessBoard1 = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};
		
		char[][] chessBoard2 = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
								{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
								{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
		
		try {
			String[] size = br.readLine().split(" ");
			//N, M 입력받음
			int N = Integer.parseInt(size[0]);
			int M = Integer.parseInt(size[1]);
			// for문을 통해 각 행의 상태를 배열에 대입하기 위해
			// char형의 이차원 배열 선언
			//  토크나이저 객체 초기화하여 한줄씩 입력받은 후 해당 객체의 내용을 이중포문 통해 char 이차원 배열에 대입
			char[][] board = new char[N][M];
			for(int i = 0 ; i < N; i++) {
				String row = br.readLine();
				for(int j = 0 ; j < M; j++) {
					board[i][j] = row.charAt(j);
				}
			}
			// 색이 다른 정사각형의 갯수를 세기 위한 int 변수 생성
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			for(int i = 0; i < N - 7;  i++) {
				for(int j = 0; j < M - 7; j++) {
					for(int k = 0; k < 8; k++) {
						for(int l = 0; l < 8; l++) {
							// 보드의 비교시작점에서 체스판1,2 비교시 칠해야하는 정사각형의 갯수 중 최솟값을 각각 count1, count2에 대입
							if(board[i+k][j+l] != chessBoard1[k][l]) {
								count1++;
							}
							if(board[i+k][j+l] != chessBoard2[k][l]) {
								count2++;
							}
						}
					}
					// 두 최솟값 중 최솟값을 count1 변수를 재활용하여 대입
					count1 = ( count1 <= count2 ) ? count1 : count2;
					// 해당 count1 변수를 이전까지의 최솟값 중 가장 최소값인 count3 변수와 비교하여 진 최종값을 count3에 저장
					// 이때 최초 실행으로 인해 비교할 count3 변수가 0이라면 바로 count1 대입
					// 허나 count3가 0일 때마다 count3에 count1을 대입해버리면 최소값으로 0이 나오는 경우를 자체 처리해버려 0 다음의 최솟값이 최종 최솟값으로 남게됨
					// 따라서 count1이 for문을 실행한 후에도 0일 경우를 예외처리해줘야함
					if(count1 == 0) {
						// 최솟값이 0이 나오면 0보다 작은 최솟값은 없으므로 더 이상 for문 돌리지 않고 바로 main문 종료하도록 구현
						bw.write(0 + "");
						return;
					} else {
						if(count3 == 0) {
							count3 = count1;
						} else {
						// 아니라면 count3 변수와 직전의 최솟값인 count1 비교하여 더 작은 값을 count3에 대입하여 저장(즉 최종 최솟값)
							count3 = ( count3 <= count1 ) ? count3 : count1; 
						}
					}
					// 비교 종료시 다음 비교를 위해 count1, count2 변수 초기화
					count1 = 0;
					count2 = 0;
				}
			}
			bw.write(count3 + "");
=======
		StringTokenizer stk;
		try {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int f = Integer.parseInt(stk.nextToken());
			
			for(int i = -999; i <= 999; i++) {
				for(int j = -999; j <= 999; j++) {
					if((a * i) + (b * j) == c) {
						if( (d * i) + (e * j) == f ) {
							bw.write(i + " " + j);
							return;
						}
					}
				}
			}
			
>>>>>>> 2d787073286f8eed369ce05dc369f0bafcb26d2e
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
