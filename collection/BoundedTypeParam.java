interface Test{
	public void showYourName();
}

class UpperClass{
	public void showYourUpper(){
		System.out.println("Upper class");
	}
}

class Aa extends UpperClass implements Test{
	public void showYourName(){
		System.out.println("Aa class");
	}
}

class Bb extends UpperClass implements Test{
	public void showYourName(){
		System.out.println("Bb class");
	}
}

class BoundedTypeParam{
	public static <T extends Test> void showInstanceUpper(T param){
	// <T extends Test> : �Ű������� �ڷ����� Test�� ��ӹ޴� ��ü
	// ���׸��� �ڷ��� ���ѿ��� Ŭ������ �������̽��� �������� �ʰ� �� �� extends�� ���
		param.showYourName();
	}
	public static <T extends UpperClass> void showInstanceName(T param){
	// <T extends UpperClass> : �Ű������� �ڷ����� UpperClass�� ��ӹ޴� �ڷ���
		param.showYourUpper();
	}
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();

		showInstanceUpper(a);		showInstanceName(a);
		showInstanceUpper(b);		showInstanceName(b);
	}
}
