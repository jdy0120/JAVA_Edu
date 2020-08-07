import java.util.*;

class ArrayMaxMin{
	public static void main(String[] args) {
		int[] arrInt = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arrInt.length ; i++ ){
			System.out.print(i+1+"��° ���� �Է� : ");
			arrInt[i] = sc.nextInt();
		}
		System.out.println("�迭�� �ּ� �� : " + minValue(arrInt));
		System.out.println("�迭�� �ִ� �� : " + maxValue(arrInt));
	}
	public static int minValue(int[] arr){
		int num = arr[0];
		for (int i = 1; i < arr.length ;i++ ){
			if (arr[i] < num){
				num = arr[i];
			}
		}
		return num;
	}
	public static int maxValue(int[] arr){
		int num = arr[0];
		for (int i = 1; i < arr.length ;i++ ){
			if (arr[i] > num){
				num = arr[i];
			}
		}
		return num;
	}
}
