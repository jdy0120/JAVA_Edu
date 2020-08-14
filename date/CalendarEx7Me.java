import java.util.*;
import java.time.*;


class CalendarEx7Me {
	public static void main(String[] args) {
		LocalDate cdate = LocalDate.now();	// ������
		int year = cdate.getYear();
		int month = cdate.getMonthValue() ;

		if (args.length == 2) {
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
			return; // �Է¹��� ������ ������ ��
		}

		int startWeekDay = 0, endDay = 0;

		LocalDate sdate = LocalDate.now();	// ������
		sdate.of(year, month -1, 1);

		LocalDate edate = LocalDate.now();	// ������
		edate.of(year, month, 1); // �������� ������ 1��
		edate.minusDays(1); // ������ 1�Ͽ��� �Ϸ縦 �� ��¥(���ۿ��� ����)

		startWeekDay = sdate.getDayOfWeek().getValue(); 
		endDay = sdate.lengthOfMonth(); // ����

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