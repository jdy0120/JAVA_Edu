import java.util.*;


class CalendarEx2Me {
	static final String[] WEEK_DAY = {"", "��","��", "ȭ", "��", "��", "��", "��"};

	public static void main(String[] args) {
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		date1.set(Calendar.YEAR, 2019);
		date1.set(Calendar.MONTH, 3);
		date1.set(Calendar.DATE, 15);		
		
		Date nextDay = date1.getTime();
		System.out.println(nextDay);

		int year = date1.get(Calendar.YEAR);
		int month = date1.get(Calendar.MONTH);
		int day = date1.get(Calendar.DATE);
		int dayNum = date1.get(Calendar.DAY_OF_WEEK);

		System.out.println(dayNum);

		String day = "";

		switch(dayNum){
			case 1:
			day = "��";
			break ;
			case 2:
			day = "��";
			break ;
			case 3:
			day = "ȭ";
			break ;
			case 4:
			day = "��";
			break ;
			case 5:
			day = "��";
			break ;
			case 6:
			day = "��";
			break ;
			case 7:
			day = "��";
			break ;
		}

		System.out.println(year + "�� " + month + "�� " + day + "��");

		// date1�� 2019�� 3�� 15�Ϸ� �����ϰ�, date1�� date2�� ���
		// ��½� 'xxxx�� xx�� xx�� x����'�� ���



	}
}
