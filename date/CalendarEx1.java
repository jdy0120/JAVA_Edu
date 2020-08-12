import java.util.*;

class CalendarEx1{
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		// static메소드인 getInstance()를 통해 날짜 및 시간 인스턴스 생성
		// Calendar 인스턴스는 생성되면 기본적으로 오늘 날짜 및 현재 시간이 지정됨

		System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
		System.out.println("월(0~11) : " + today.get(Calendar.MONTH));
		// 월은 0이 1월이고, 11이 12월이다.
		System.out.println("이 해의 몇 째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주 : " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("달의 몇일" + today.get(Calendar.DATE));
		System.out.println("달의 몇일" + today.get(Calendar.DAY_OF_MONTH));
		// DATE와 DAY_OF_MONTH는 동일한 값을 리턴
		System.out.println("해의 몇일" + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1-7), 1:일요일" + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("달의 몇 째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));

		System.out.println("오전(0) 오후(1) : " + today.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("시간(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : " + today.get(Calendar.MINUTE));
		System.out.println("밀리초(0~999) : " + today.get(Calendar.MILLISECOND));
		System.out.println("말일 : " + today.getActualMaximum(Calendar.DATE));
	}
}
