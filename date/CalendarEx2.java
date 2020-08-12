import java.util.*;

class  CalendarEx2{
	static final String[] WEEK_DAY = {"","일","월","화","수","목","금","토"};
	public static void main(String[] args) {

		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		// date1을 2019년 3월 15일로 지정하고 date1과 date2를 출력
		// 출력시 xxxx년 xx월 xx일 x요일로 출력
		date1.set(2019,2,15);
		System.out.println("date1 : " + dateToString(date1));
		System.out.println("date2 : " + dateToString(date2));

		long d1 = date1.getTimeInMillis(); // date1을 밀리초로 환산
		long d2 = date2.getTimeInMillis(); // date2를 밀리초로 환산
		long diff = (d2 - d1)/1000/24/60/60; // 초단위로 환산
		//date1과 date2사이의 경과시간을 '일(day)' 단위로 출력
		System.out.println(diff + "일이 지났습니다.");
	}
	public static String dateToString(Calendar date){
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 " + WEEK_DAY[date.get(Calendar.DAY_OF_WEEK)] + "요일";
	}
}
