import java.util.*;

class ExceptionUseTry{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];

		for (int i = 0; i < 3 ; i++ ){
			try{
				System.out.print("������ ���� �� �Է� : ");
				int num1 = sc.nextInt();

				System.out.print("������ �� �Է� : ");
				int num2 = sc.nextInt();

				System.out.print("������ ��� ���� �ε��� �Է� : ");
				int idx = sc.nextInt();

				arr[idx] = num1/num2;
				System.out.println("������ ��� : " + arr[idx]);
				System.out.println("����� ��ġ : " + idx);
			}catch (ArithmeticException k){
			//ArithmeticException�� �߻��� ��� ó���ϴ� ����
				System.out.println("������ ���� 0�� �� �� �����ϴ�.");
				i--;
				continue;

			}catch (ArrayIndexOutOfBoundsException e){
				System.out.println("�ε����� 0~99 ������ ���Դϴ�.");
				i--;
				continue;
			} catch (Exception e){
			// ��� ���ܿ� ���� ó��
				System.out.println("���ܹ߻�");
			}
		}
	}
}