import java.util.*;

class  CalendarEx3{
	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600,60,1};
		final String[] TIME_NAME = {"�ð� ", "�� ","�� "};

		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();

		//time1�� 10�� 20�� 30��, time2�� 20�� 30�� 10��

		time1.set(time1.get(Calendar.YEAR),time1.get(Calendar.MONTH),time1.get(Calendar.DATE),10,20,30);
		time2.set(Calendar.HOUR_OF_DAY,20);
		time2.set(Calendar.MINUTE,30);
		time2.set(Calendar.SECOND,10);

		System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "�� " + time1.get(Calendar.MINUTE) + "�� " + time1.get(Calendar.SECOND) + "��");
		System.out.println("time2 : " + time2.get(Calendar.HOUR_OF_DAY) + "�� " + time2.get(Calendar.MINUTE) + "�� " + time2.get(Calendar.SECOND) + "��");

		long diff = Math.abs(time2.getTimeInMillis()) - Math.abs(time1.getTimeInMillis());
		System.out.println("time1�� time2�� �ð����� " + (diff/1000) + "��");
		
		diff /= 1000;
		String tmp = "";
		for (int i = 0; i < TIME_UNIT.length ; i++ ){
			tmp += diff / TIME_UNIT[i] + TIME_NAME[i];
			diff = diff % TIME_UNIT[i];
		}
		System.out.println("�ú��ʷ� ȯ���ϸ�" + tmp);
	}
}
