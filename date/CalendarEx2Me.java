import java.util.*;


class CalendarEx2Me {
	static final String[] WEEK_DAY = {"", "일","월", "화", "수", "목", "금", "토"};

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
			day = "일";
			break ;
			case 2:
			day = "월";
			break ;
			case 3:
			day = "화";
			break ;
			case 4:
			day = "수";
			break ;
			case 5:
			day = "목";
			break ;
			case 6:
			day = "금";
			break ;
			case 7:
			day = "토";
			break ;
		}

		System.out.println(year + "년 " + month + "월 " + day + "일");

		// date1을 2019년 3월 15일로 지정하고, date1과 date2를 출력
		// 출력시 'xxxx년 xx월 xx일 x요일'로 출력



	}
}
