import java.util.*;

class Tokenizers {
	public static void main(String[] args) {
		String strData = "11:22:33:44:55";
		StringTokenizer st = new StringTokenizer(strData, ":");
		

		while (st.hasMoreTokens()){
		// st�� ��ū�� �� ������
			System.out.print(st.nextToken() + " ");
		}
		// StringTokenizer�� �� �� ������ ������ �������� �� �� ���� �ٽ� ����Ϸ��� ���� ������ ��
		System.out.println();

		String[] arr = strData.split(":");
		// ������ ����� StringŬ������ split()�޼ҵ�� ǥ��
		for (int i = 0; i < arr.length ; i++ ){
			System.out.print(arr[i] + " ");
		}

		// ������ ����� StringŬ������ split()�޼ҵ�� ǥ��
	}
}
