import java.util.*;

class RandomGenerator{
	public static void main(String[] args) {
		Random rand = new Random();

		for (int i = 0; i < 3 ; i++ ){
			System.out.println(rand.nextDouble());
			// 0�̻� 1�̸��� �Ǽ��� �������� ���
		}

		for (int i = 0; i < 5 ; i++ ){
			System.out.print(rand.nextInt(20) + " ");
			// 0�̻� 20�̸��� ������ �������� ���
		}
	}
}
