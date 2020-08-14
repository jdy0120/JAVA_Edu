import java.util.*;


class CalendarEx5Me {
	public static void main(String[] args) {
		Calendar cdate = Calendar.getInstance();	// 시작일
		int year = cdate.get(Calendar.YEAR);
		int month = cdate.get(Calendar.MONTH) + 1;

		if (args.length == 2) {
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
			return; // 입력받지 않으면 현재의 월
		}

		int startWeekDay = 0, endDay = 0;

		Calendar sdate = Calendar.getInstance();	// 시작일
		sdate.set(year, month -1, 1);

		Calendar edate = Calendar.getInstance();	// 종료일
		edate.set(year, month, 1); // 시작일의 다음달 1일
		edate.add(Calendar.DATE, -1); // 다음달 1일에서 하루를 뺀 날짜(시작월의 말일)

		startWeekDay = sdate.get(Calendar.DAY_OF_WEEK); 
		endDay = edate.get(Calendar.DATE); // 말일

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