import java.util.*;

interface Week {
	int MON = 1, TUE = 2, WED = 3,  THU = 4, FRI = 5, SAT = 6, SUN = 7;
	// �������̽����� ������ �����̹Ƿ� �ڵ����� public static final�� �����
}

class InterfaceUse {
	public static void main(String[] args) {
		System.out.println("������ ������ �����ϼ���.");
		System.out.println("1. ��, 2. ȭ, 3. ��, 4. ��, 5. ��, 6. ��, 7. ��");
		System.out.print("���� ��ȣ �Է� : ");

		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();

		switch (sel) {
			case Week.MON:
				System.out.println("������  �Դϴ�.");		break;
			case Week.TUE:
				System.out.println("ȭ����  �Դϴ�.");		break;
			case Week.WED:
				System.out.println("������  �Դϴ�.");		break;
			case Week.THU:
				System.out.println("�����  �Դϴ�.");		break;
			case Week.FRI:
				System.out.println("�ݿ���  �Դϴ�.");		break;
			case Week.SAT:
				System.out.println("�����  �Դϴ�.");		break;
			case Week.SUN:
				System.out.println("�Ͽ���  �Դϴ�.");		break;
		}
	}
}
