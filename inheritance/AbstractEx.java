abstract class PersonalNumberStorage{
	public abstract void addPersonalInfo(String name, String perNum);
	public abstract String searchName(String perNum);
}

class PersonalNumInfo{ // 정보저장용 클래스
	String name, number;
	PersonalNumInfo(String name, String number){
		this.name = name;
		this.number = number;
	}
	String getName() { return name; }
	String getNumber() { return number; }
}

class PersonalNumberStorageImpl extends PersonalNumberStorage{
// abstract클래스인 PersonalNumberStorage를 상속받았으므로 
// PersonalNumberStorage클래스에 있는 abstract메소드를 반드시 구현해야 함
	PersonalNumInfo[] perArr;
	// PersonalNumInfo형 배열 perArr을 선언 (정보가 들어있는 인스턴스를 저장하기 위한 배열)
	int numOfPerInfo;
	// perArr배열의 인덱스 번호 및 저장된 데이터 개수를 저장하기 위한 변수

	public PersonalNumberStorageImpl(int sz){
		perArr = new PersonalNumInfo[sz];
		// 받아온 int값 sz를 이용하여 perArr배열을 생성
		numOfPerInfo = 0;
		// perArr배열에 저장할 데이터의 인덱스번호 초기화
	}
	public void addPersonalInfo(String name, String perNum){
		perArr[numOfPerInfo] = new PersonalNumInfo(name,perNum);
		// 받아온 매개변수의 값을 이용하여 PersonalNumInfo의 인스턴스를 생성한 후 perArr배열에 저장
		numOfPerInfo++;
		// 다음에 저장될 PersonalNumInfo의 인스턴스의 위치 인덱스 조절
	}
	public String searchName(String perNum){
		String str;
		for (int i = 0; i < numOfPerInfo ; i++ ){
			if (perNum.equals(perArr[i].getNumber())){
			// 받아온 perNum과 perArr배열에 들어있는 인스턴스의 number값을 같은지 비교하여 원하는 이름을 리턴
				str = "이름 : " + perArr[i].getName() + "/ 주민번호 : " + perArr[i].getNumber();
				return str;
			}
		}
		str = "검색결과가 없습니다.";
		return str;
		// 리턴타입이 객체이면 어디서든 사용할 수 있음
	}
}

class AbstractEx{
	public static void main(String[] args) {
		PersonalNumberStorage storage = new PersonalNumberStorageImpl(10);
		storage.addPersonalInfo("홍길동", "950000-1234567");
		storage.addPersonalInfo("전우치", "970000-1234567");
		// storage인스턴스는 상위클래스인 PersonalNumberStorage의 자료형이나 오버라이딩된 메소드이므로 하위클래스인 PersonalNumberStorageImpl의 addPersonalInfo()메소드가 실행됨

		String sch1 = storage.searchName("970000-1234567");
		String sch2 = storage.searchName("950000-1234567");
		String sch3 = storage.searchName("990000-1234567");

		System.out.println(sch1);
		System.out.println(sch2);
		System.out.println(sch3);
	}
}
