class SwitchEx2{
	public static void main(String[] args) {
		// ����(score)�� �̿��Ͽ� ������ ���
		int score = 88;
		if (score >= 90)
		{
			System.out.println("A");
		} else if (score >= 80)
		{
			System.out.println("B");
		} else if (score >= 70)
		{
			System.out.println("C");
		} else if (score >= 60)
		{
			System.out.println("D");
		} else{
			System.out.println("F");
		}


		switch (score/10)
		{
		case 10: case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
		}
		// num�� ���� 10������ ���� '0�̻� 10�̸�', '10�̻� 20�̸�',
		// '20�̻� 30�̸�', '30�̻�' ���� ���
		int num = 10;
		switch ((num-1)/10)
		{
		case 0:
			System.out.println("1�̻� 10����");
			break;
		case 1: 
			System.out.println("11�̻� 20����");
			break;
		case 2:
			System.out.println("21�̻� 30����");
			break;
		default:
			System.out.println("31�̻�");
		}
	}
}