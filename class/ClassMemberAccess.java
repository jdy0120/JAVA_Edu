class Access{
	static int num = 0; // Ŭ���� ����
	Access(){ incrCnt(); }
	public void incrCnt(){ num++; }
}

class ClassMemberAccess{
	public static void main(String[] args) {
		Access.num++;	// �ν��Ͻ��� ������ ������� Ŭ��������� ���ٰ���
		Access ac = new Access();
		ac.num++;		// Ŭ��������� �ν��Ͻ��� ���ؼ� ������ ���� ����
		Access.num++;	// Ŭ��������� Ŭ������ ���ؼ� ������ ���� ����
		System.out.println("num : " + Access.num); // 3
	}
}
