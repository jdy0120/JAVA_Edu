class Array2DEx2{
	public static void main(String[] args) {
		int[][] arr = {
			{1,2},
			{3,4,5},
			{6,7,8,9}
		};
		// �ڹٿ����� 2���� �迭���� ���� �ٸ� ũ���� 1���� �迭�� ���� �� ����.
		System.out.println("�迭�� ���α��� : " + arr.length);

		for (int i = 0;i < arr.length ;i++ ){
			System.out.println(i+1 + "���� ���� : " + arr[i].length);
		}
	}
}
