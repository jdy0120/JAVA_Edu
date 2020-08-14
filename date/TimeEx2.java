import java.time.*;
import java.time.temporal.*;


class TimeEx2 {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2019, 1, 1);
		LocalDate date2 = LocalDate.of(2020, 12, 31);

		Period pe = Period.between(date1, date2);
		// betwwen() : �� ��¥ ������ ���� ���ϴ� �޼ҵ�

		System.out.println("date1 : " + date1); // date1 : 2019-01-01
		System.out.println("date2 : " + date2); // date2 : 2020-12-31
		System.out.println("pe : " + pe);

		System.out.println("YEAR : " + pe.get(ChronoUnit.YEARS));
		System.out.println("MONTH : " + pe.get(ChronoUnit.MONTHS));
		System.out.println("DAY : " + pe.get(ChronoUnit.DAYS));
		// �� ��¥ ������ ������ ����� ������ ����

		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 34, 56);

		Duration du = Duration.between(time1, time2);
		// between() : �� �ð� ������ ���� ���ϴ� �޼ҵ�

		System.out.println("time1 : " + time1); // time1 : 00:00
		System.out.println("time2 : " + time2);
		System.out.println("du : " + du);

		LocalTime tmp = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		// Duration���� �ʴ����� �������� getSeconds()�޼ҵ�� �����ϳ�
		// �ð��̳� �� ������ �������� �޼ҵ�� �����Ƿ� LocalTime��ü�� ����
		/// �ú��� ������ �����ͼ� ���
		// du.getSeconds() : du�� �ð����� �ʴ����� ȯ���Ͽ� ����
		// LocalTime.of(0,0).plusSeconds() : 0�� 0���� LocalTime��
		// du.getSeconds()�� ���� �ʴ��� �ð����� ���� ���ο� LocalTime�� ����

		System.out.println("HOUR : " + tmp.getHour());
		System.out.println("MINUTE : " + tmp.getMinute());
		System.out.println("SECOND : " + tmp.getSecond());
		System.out.println("NANO : " + tmp.getNano());
		// LocalTime�� get~ �޼ҵ���� �̿��Ͽ� �ú��� ������ ����
	}
}
