import java.time.*;
import java.time.temporal.*;


class TimeEx1 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		// ���� ��¥�� �̿��Ͽ� LocalDate ��ü ����
		LocalDate bdate = LocalDate.of(1999, 12, 31);
		// Ư�� ��¥(1999�� 12�� 31��)�� �̿��Ͽ� LocalDate ��ü ����

		System.out.println("today : " + today); // today : 2020-08-13
		System.out.println("bdate : " + bdate); // bdate : 1999-12-31

		System.out.println(bdate.withYear(2000)); // 2000-12-31
		// bdate.withYear(2000) : bdate�� ��¥���� �⵵�� 2000������ ����

		System.out.println(bdate.plusDays(1)); // 2000-01-01
		// bdate.plusDays(1) : bdate�� ��¥�� 1���� ���϶�� �ǹ�

		System.out.println(bdate.plus(1, ChronoUnit.DAYS)); // 2000-01-01
		// bdate.plus(1, ChronoUnit.DAYS) : bdate�� ��¥�� ��(day)�� �ش��ϴ� ����
		// 1�� ���϶�� �ǹ�

		// with()�� plus() ��� ��¥�� �����Ű���� ������ �ƴ� ���ο� ��ü�� ������

		System.out.println(bdate.minusMonths(1));	// 1999-11-30
		// bdate.minusMonths(1)

		System.out.println(bdate.minusWeeks(1));	// 1999-12-24

		System.out.println(bdate.minus(10, ChronoUnit, DAYS));	// 1999-12-21
	}
}
