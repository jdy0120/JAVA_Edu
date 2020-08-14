import java.util.*;
import java.time.*;


class CalendarEx7Me {
	public static void main(String[] args) {
		LocalDate cdate = LocalDate.now();	// 시작일
		int year = cdate.getYear();
		int month = cdate.getMonthValue() ;

		if (args.length == 2) {
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
			return; // 입력받지 않으면 현재의 월
		}

		int startWeekDay = 0, endDay = 0;

		LocalDate sdate = LocalDate.now();	// 시작일
		sdate.of(year, month -1, 1);

		LocalDate edate = LocalDate.now();	// 종료일
		edate.of(year, month, 1); // 시작일의 다음달 1일
		edate.minusDays(1); // 다음달 1일에서 하루를 뺀 날짜(시작월의 말일)

		startWeekDay = sdate.getDayOfWeek().getValue(); 
		endDay = sdate.lengthOfMonth(); // 말일

		System.out.println("      " + year + "년 " + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");

		for (int i = 1 ; i < startWeekDay ; i++ ) {
			System.out.print("   ");
		}  // 1일의 시작 위치를 잡기 위한 for문

		for (int i = 1, n = startWeekDay ; i <= endDay ; i++, n++) {
			System.out.print((i < 10) ? "  " + i : " " + i);

			if (n % 7 == 0) System.out.println();
		}
	}
}