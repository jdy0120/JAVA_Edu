abstract class PersonalNumberStorage {
	public abstract void addPersonalInfo(String name, String perNum);
	public abstract String searchName(String perNum);
}

class PersonalNumInfo {	// ��������� Ŭ����
	String name, number;
	PersonalNumInfo(String name, String number) {
		this.name = name;
		this.number = number;
	}
	String getName() { return name; }
	String getNumber() { return number; }
}

class PersonalNumberStorageImpl extends PersonalNumberStorage {
// abstractŬ������ PersonalNumberStorage�� ��ӹ޾����Ƿ� 
// PersonalNumberStorageŬ������ �ִ� abstract�޼ҵ带 �ݵ�� �����ؾ� ��
	PersonalNumInfo[] perArr;
	// PersonalNumInfo�� �迭 perArr�� ����
	// (������ ����ִ� �ν��Ͻ��� �����ϱ� ���� �迭)
	int numOfPerInfo;
	// perArr�迭�� �ε��� ��ȣ �� ����� ������ ������ �����ϱ� ���� ����

	public PersonalNumberStorageImpl(int sz) {
		perArr = new PersonalNumInfo[sz];
		// �޾ƿ� int�� sz�� �̿��Ͽ� perArr�迭�� ����
		numOfPerInfo = 0;
		// perArr�迭�� ������ �������� �ε�����ȣ �ʱ�ȭ
	}
	public void addPersonalInfo(String name, String perNum) {
		perArr[numOfPerInfo] = new PersonalNumInfo(name, perNum);
		// �޾ƿ� �Ű������� ���� �̿��Ͽ� PersonalNumInfo�� �ν��Ͻ��� ������ ��
		// perArr�迭�� ����
		numOfPerInfo++;
		// ������ ����� PersonalNumInfo�� �ν��Ͻ��� ��ġ �ε��� ����
	}
	public String searchName(String perNum) {
		for (int i = 0 ; i < numOfPerInfo ; i++) {
			if (perNum.equals(perArr[i].getNumber())) {
			// �޾ƿ� perNum�� perArr�迭�� ����ִ� �ν��Ͻ��� number���� ������ 
			// ���Ͽ� ���ϴ� �̸��� ����
				return perArr[i].getName();
			}
		}
		return null;
		// ����Ÿ���� ��ü�̸� ��𼭵� ����� �� ����
	}
}

class AbstractEx {
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(10);
		storage.addPersonalInfo("ȫ�浿", "950000-1234567");
		storage.addPersonalInfo("����ġ", "970000-1234567");
		// storage�ν��Ͻ��� ����Ŭ������ PersonalNumberStorage�� �ڷ����̳� 
		// �������̵��� �޼ҵ��̹Ƿ� ����Ŭ������ PersonalNumberStorageImpl�� 
		// addPersonalInfo()�޼ҵ尡 �����

		String sch1 = storage.searchName("950000-1234567");
		String sch2 = storage.searchName("970000-1234567");
		String sch3 = storage.searchName("990000-1234567");

		// sch1 ~ 3���� �˻��� �Ǿ����� ������ȭ�� �̸���, 
		// �˻������ ������ ������ȣ�� '�˻������ �����ϴ�'��� ���
		if (sch1 == null)
			System.out.println("950000-1234567 : �˻������ �����ϴ�.");
		else
			System.out.println("950000-1234567 : " + sch1);

		if (sch2 == null)
			System.out.println("950000-1234567 : �˻������ �����ϴ�.");
		else
			System.out.println("950000-1234567 : " + sch2);

		if (sch3 == null)
			System.out.println("950000-1234567 : �˻������ �����ϴ�.");
		else
			System.out.println("950000-1234567 : " + sch3);
	}
}
