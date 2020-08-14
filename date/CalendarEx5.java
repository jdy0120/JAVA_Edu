import java.util.*;


class CalendarEx5 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("�޷��� ������ java CalendarEx5 2020 11");
			return;
		}

		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		// ���ڿ��� �޾� �� �⵵�� ���� ������ ��ȯ

		int startWeekDay = 0, endDay = 0;
		// startWeekDay : ������(1��)�� ���Ϲ�ȣ�� ������ ����, endDay : ����

		Calendar sdate = Calendar.getInstance();	// ������
		sdate.set(year, month -1, 1);
		// �Է¹��� �⵵�� ���� �̿��Ͽ� �������� ����(���� -1�� �ؾ� ��)

		Calendar edate = Calendar.getInstance();	// ������
		edate.set(year, month, 1); // �������� ������ 1��
		edate.add(Calendar.DATE, -1); // ������ 1�Ͽ��� �Ϸ縦 �� ��¥(���ۿ��� ����)

		startWeekDay = sdate.get(Calendar.DAY_OF_WEEK); 
		// �������� ���Ϲ�ȣ���� 1���� ���� ��ġ
		endDay = edate.get(Calendar.DATE); // ����

		System.out.println("      " + args[0] + "�� " + args[1] + "��");
		System.out.println(" SU MO TU WE TH FR SA");

		for (int i = 1 ; i < startWeekDay ; i++ ) {
			System.out.print("   ");
		}  // 1���� ���� ��ġ�� ��� ���� for��

		for (int i = 1, n = startWeekDay ; i <= endDay ; i++, n++) {
		// i : ��¥�� ��(day) �κ��� ����� ����
		// n : ���Ϲ�ȣ ������� �������� ������ ���� �ٷ� ������ ���� �뵵
			System.out.print((i < 10) ? "  " + i : " " + i);
			// ��(day)�� 10�̸��� ������ ��� �ڸ��� �� ĭ �� ���

			if (n % 7 == 0) System.out.println();
			// �������� �������Ƿ� ���� �ٷ� ����
		}
	}
}