import java.util.*;
import java.text.*;


class DateFormatEx {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4, sdf5, sdf6, sdf7, sdf8, sdf9;

		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy�� MMM dd�� E����");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		sdf5 = new SimpleDateFormat("������ �� ���� D��° ���Դϴ�.");
		sdf6 = new SimpleDateFormat("������ �� ���� d��° ���Դϴ�.");
		sdf7 = new SimpleDateFormat("������ �� ���� w��° ���Դϴ�.");
		sdf8 = new SimpleDateFormat("������ �� ���� W��° ���Դϴ�.");
		sdf9 = new SimpleDateFormat("������ �� ���� F��° E�����Դϴ�.");

		System.out.println(sdf1.format(today)); // 2020-08-13
		System.out.println(sdf2.format(today)); // '20�� 8�� 13�� �����
		System.out.println(sdf3.format(today)); // 2020-08-13 11:59:29.410
		System.out.println(sdf4.format(today)); // 2020-08-13 11:59:29 ����
		System.out.println();					
		System.out.println(sdf5.format(today)); // ������ �� ���� 226��° ���Դϴ�.
		System.out.println(sdf6.format(today)); // ������ �� ���� 13��° ���Դϴ�.
		System.out.println(sdf7.format(today)); // ������ �� ���� 33��° ���Դϴ�.
		System.out.println(sdf8.format(today)); // ������ �� ���� 3��° ���Դϴ�.
		System.out.println(sdf9.format(today)); // ������ �� ���� 2��° ���Դϴ�.

	}
}


/*
G : ����(BC, AD) / y : �⵵ / M : ��	/ w : ���� �� ° ��		/ W : ���� �� ° ��
D : ���� �� ° ��	/ d : ���� �� ° ��		/ F : ���� �� ° ����(1~5) / E : ����(��~��)
a : ����/����		/ H : ��(0~23)		/ k : �ð�(1~24) / h : ��(0~11) / m : ��(0~59)
s : ��(0~59)		/ S : �и���(0~999)	/ ' : Ư������ ǥ��
*/