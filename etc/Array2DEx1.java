class Array2DEx1{
	public static void main(String[] args) {
		int[][] arr = new int[3][4];	// 3�� 4���� 2���� �迭 arr�� ����
		for (int i = 0; i < arr.length ; i++){	// ���� ��
			for (int j = 0; j < arr[0].length ; j++){	// ���� ��
				arr[i][j] = i+j;
			}
		}
		for (int i = 0; i < arr.length ; i++){
			for (int j = 0; j < arr[0].length ; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
