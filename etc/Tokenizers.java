import java.util.*;

class Tokenizers {
	public static void main(String[] args) {
		String strData = "11:22:33:44:55";
		StringTokenizer st = new StringTokenizer(strData, ":");
		

		while (st.hasMoreTokens()){
		// st에 토큰이 더 있으면
			System.out.print(st.nextToken() + " ");
		}
		// StringTokenizer는 한 번 루프를 돌리면 다음에는 돌 수 없음 다시 사용하려면 새로 만들어야 함
		System.out.println();

		String[] arr = strData.split(":");
		// 동일한 결과를 String클래스의 split()메소드로 표현
		for (int i = 0; i < arr.length ; i++ ){
			System.out.print(arr[i] + " ");
		}

		// 동일한 결과를 String클래스의 split()메소드로 표현
	}
}
