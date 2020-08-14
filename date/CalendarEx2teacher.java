import java.util.*;



class CalendarEx2Teacher {

	static final String[] WEEK_DAY = {"", "일","월", "화", "수", "목", "금", "토"};

	public static void main(String[] args) {
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		date1.set(2019, 2, 15);
		System.out.println("date1 : " + dateToString(date1));
		System.out.println("date2 : " + dateToString(date2));

		long d1 = date1.getTimeInMillis();	// date1을 밀리초로 환산
		long d2 = date2.getTimeInMillis();	// date2를 밀리초로 환산
		// date1과 date2 사이의 경과시간을 '일(day)'단위로 출력
		long diff = d1 - d2;

		System.out.println(diff / (1000 * 60 * 60 * 24 ));
		System.out.println(date2);
	}
	public static String dateToString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + 
			"월 " + date.get(Calendar.DATE) + "일 " + 
			WEEK_DAY[date.get(Calendar.DAY_OF_WEEK)] + "요일";
	}
}