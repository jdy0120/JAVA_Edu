import java.util.*;



class CalendarEx2Teacher {

	static final String[] WEEK_DAY = {"", "��","��", "ȭ", "��", "��", "��", "��"};

	public static void main(String[] args) {
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		date1.set(2019, 2, 15);
		System.out.println("date1 : " + dateToString(date1));
		System.out.println("date2 : " + dateToString(date2));

		long d1 = date1.getTimeInMillis();	// date1�� �и��ʷ� ȯ��
		long d2 = date2.getTimeInMillis();	// date2�� �и��ʷ� ȯ��
		// date1�� date2 ������ ����ð��� '��(day)'������ ���
		long diff = d1 - d2;

		System.out.println(diff / (1000 * 60 * 60 * 24 ));
		System.out.println(date2);
	}
	public static String dateToString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� " + (date.get(Calendar.MONTH) + 1) + 
			"�� " + date.get(Calendar.DATE) + "�� " + 
			WEEK_DAY[date.get(Calendar.DAY_OF_WEEK)] + "����";
	}
}