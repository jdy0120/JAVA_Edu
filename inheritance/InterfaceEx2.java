interface PersonalNumberStorage{
	public abstract void addPersonalInfo(String name, String perNum);
	public abstract String searchName(String perNum);
}

class PersonalNumInfo{
	String name, number;
	PersonalNumInfo(String name, String number){
		this.name = name;
		this.number = number;
	}
	String getName() { return name; }
	String getNumber() { return number; }
}

class PersonalNumberStorageImpl implements PersonalNumberStorage{
// PersonalNumberStorage�� �������̽��̹Ƿ� ����� �ƴ� �����ؾ� ��
	PersonalNumInfo[] perArr;

	int numOfPerInfo;

	public PersonalNumberStorageImpl(int sz){
		perArr = new PersonalNumInfo[sz];
		numOfPerInfo = 0;
	}
	public void addPersonalInfo(String name, String perNum){
		perArr[numOfPerInfo] = new PersonalNumInfo(name,perNum);
		numOfPerInfo++;
	}
	public String searchName(String perNum){
		String str;
		for (int i = 0; i < numOfPerInfo ; i++ ){
			if (perNum.equals(perArr[i].getNumber())){
				str = "�̸� : " + perArr[i].getName() + "/ �ֹι�ȣ : " + perArr[i].getNumber();
				return str;
			}
		}
		str = "�˻������ �����ϴ�.";
		return str;
	}
}


class InterfaceEx2{
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(10);
		storage.addPersonalInfo("ȫ�浿", "950000-1234567");
		storage.addPersonalInfo("����ġ", "970000-1234567");

		System.out.println(storage.searchName("950000-1234567"));
		System.out.println(storage.searchName("970000-1234567"));
	}
}
