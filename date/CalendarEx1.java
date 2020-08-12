import java.util.*;

class CalendarEx1{
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		// static�޼ҵ��� getInstance()�� ���� ��¥ �� �ð� �ν��Ͻ� ����
		// Calendar �ν��Ͻ��� �����Ǹ� �⺻������ ���� ��¥ �� ���� �ð��� ������

		System.out.println("�� ���� �⵵ : " + today.get(Calendar.YEAR));
		System.out.println("��(0~11) : " + today.get(Calendar.MONTH));
		// ���� 0�� 1���̰�, 11�� 12���̴�.
		System.out.println("�� ���� �� ° �� : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("�� ���� �� ° �� : " + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("���� ����" + today.get(Calendar.DATE));
		System.out.println("���� ����" + today.get(Calendar.DAY_OF_MONTH));
		// DATE�� DAY_OF_MONTH�� ������ ���� ����
		System.out.println("���� ����" + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("����(1-7), 1:�Ͽ���" + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("���� �� ° ���� : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));

		System.out.println("����(0) ����(1) : " + today.get(Calendar.AM_PM));
		System.out.println("�ð�(0~11) : " + today.get(Calendar.HOUR));
		System.out.println("�ð�(0~23) : " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("��(0~59) : " + today.get(Calendar.MINUTE));
		System.out.println("�и���(0~999) : " + today.get(Calendar.MILLISECOND));
		System.out.println("���� : " + today.getActualMaximum(Calendar.DATE));
	}
}
