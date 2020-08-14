import java.util.*;


class CalendarEx5Me {
	public static void main(String[] args) {
		Calendar cdate = Calendar.getInstance();	// ������
		int year = cdate.get(Calendar.YEAR);
		int month = cdate.get(Calendar.MONTH) + 1;

		if (args.length == 2) {
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
			return; // �Է¹��� ������ ������ ��
		}

		int startWeekDay = 0, endDay = 0;

		Calendar sdate = Calendar.getInstance();	// ������
		sdate.set(year, month -1, 1);

		Calendar edate = Calendar.getInstance();	// ������
		edate.set(year, month, 1); // �������� ������ 1��
		edate.add(Calendar.DATE, -1); // ������ 1�Ͽ��� �Ϸ縦 �� ��¥(���ۿ��� ����)

		startWeekDay = sdate.get(Calendar.DAY_OF_WEEK); 
		endDay = edate.get(Calendar.DATE); // ����

		System.out.println("      " + year + "�� " + month + "��");
		System.out.println(" SU MO TU WE TH FR SA");

		for (int i = 1 ; i < startWeekDay ; i++ ) {
			System.out.print("   ");
		}  // 1���� ���� ��ġ�� ��� ���� for��

		for (int i = 1, n = startWeekDay ; i <= endDay ; i++, n++) {
			System.out.print((i < 10) ? "  " + i : " " + i);

			if (n % 7 == 0) System.out.println();
		}
	}
}