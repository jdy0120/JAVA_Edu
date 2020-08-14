import java.time.*;
import java.time.temporal.*;


class TimeEx1 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		// 현재 날짜를 이용하여 LocalDate 객체 생성
		LocalDate bdate = LocalDate.of(1999, 12, 31);
		// 특정 날짜(1999년 12월 31일)를 이용하여 LocalDate 객체 생성

		System.out.println("today : " + today); // today : 2020-08-13
		System.out.println("bdate : " + bdate); // bdate : 1999-12-31

		System.out.println(bdate.withYear(2000)); // 2000-12-31
		// bdate.withYear(2000) : bdate의 날짜에서 년도를 2000년으로 변경

		System.out.println(bdate.plusDays(1)); // 2000-01-01
		// bdate.plusDays(1) : bdate의 날짜에 1일을 더하라는 의미

		System.out.println(bdate.plus(1, ChronoUnit.DAYS)); // 2000-01-01
		// bdate.plus(1, ChronoUnit.DAYS) : bdate의 날짜에 일(day)에 해당하는 값에
		// 1을 더하라는 의미

		// with()와 plus() 모두 날짜를 변경시키지만 원본이 아닌 새로운 객체에 적용함

		System.out.println(bdate.minusMonths(1));	// 1999-11-30
		// bdate.minusMonths(1)

		System.out.println(bdate.minusWeeks(1));	// 1999-12-24

		System.out.println(bdate.minus(10, ChronoUnit, DAYS));	// 1999-12-21
	}
}
