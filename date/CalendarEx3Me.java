import java.util.*;


class CalendarEx3Me {
	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_NAME = {"�ð� ", "�� ", "��"};

			Calendar time1 = Calendar.getInstance();
			Calendar time2 = Calendar.getInstance();

			time1.set(Calendar.HOUR_OF_DAY, 10);
			time1.set(Calendar.MINUTE, 20);
			time1.set(Calendar.SECOND, 30);	

			time2.set(Calendar.HOUR_OF_DAY, 20);
			time2.set(Calendar.MINUTE, 30);
			time2.set(Calendar.SECOND, 10);	

			int hour1 = time1.get(Calendar.HOUR_OF_DAY);
			int minute1 = time1.get(Calendar.MINUTE);
			int second1 = time1.get(Calendar.SECOND);
			
			int hour2 = time2.get(Calendar.HOUR_OF_DAY);
			int minute2 = time2.get(Calendar.MINUTE);
			int second2 = time2.get(Calendar.SECOND);

			// time1�� 10�� 20�� 30��, time2�� 20�� 30�� 10�ʷ� ����
			System.out.println(hour1 + "�� " + minute1 + "�� " + second1 + "��");
			System.out.println(hour2 + "�� " + minute2 + "�� " + second2 + "��");

			long diff = Math.abs(time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000;
			System.out.println("time1�� time2�� �ð����� " + (diff) + "��");

			String tmp = "";
			for (int i = 0 ; i < TIME_UNIT.length ; i++ ) {
				tmp += diff / TIME_UNIT[i] + TIME_NAME[i];
				diff %= TIME_UNIT[i];
			}
			System.out.println("�ú��ʷ� ȯ���ϸ� " + tmp);
	}
}
