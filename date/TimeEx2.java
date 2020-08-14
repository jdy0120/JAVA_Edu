import java.time.*;
import java.time.temporal.*;


class TimeEx2 {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2019, 1, 1);
		LocalDate date2 = LocalDate.of(2020, 12, 31);

		Period pe = Period.between(date1, date2);
		// betwwen() : 두 날짜 사이의 차를 구하는 메소드

		System.out.println("date1 : " + date1); // date1 : 2019-01-01
		System.out.println("date2 : " + date2); // date2 : 2020-12-31
		System.out.println("pe : " + pe);

		System.out.println("YEAR : " + pe.get(ChronoUnit.YEARS));
		System.out.println("MONTH : " + pe.get(ChronoUnit.MONTHS));
		System.out.println("DAY : " + pe.get(ChronoUnit.DAYS));
		// 두 날짜 사이의 간격을 년월일 단위로 추출

		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 34, 56);

		Duration du = Duration.between(time1, time2);
		// between() : 두 시간 사이의 차를 구하는 메소드

		System.out.println("time1 : " + time1); // time1 : 00:00
		System.out.println("time2 : " + time2);
		System.out.println("du : " + du);

		LocalTime tmp = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		// Duration에는 초단위로 가져오는 getSeconds()메소드는 존재하나
		// 시간이나 분 단위로 가져오는 메소드는 없으므로 LocalTime객체로 만들어서
		/// 시분초 단위로 가져와서 사용
		// du.getSeconds() : du의 시간차를 초단위로 환산하여 리턴
		// LocalTime.of(0,0).plusSeconds() : 0시 0분의 LocalTime에
		// du.getSeconds()로 구한 초단위 시간차를 더해 새로운 LocalTime을 생성

		System.out.println("HOUR : " + tmp.getHour());
		System.out.println("MINUTE : " + tmp.getMinute());
		System.out.println("SECOND : " + tmp.getSecond());
		System.out.println("NANO : " + tmp.getNano());
		// LocalTime의 get~ 메소드들을 이용하여 시분초 단위로 구분
	}
}
