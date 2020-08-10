class Aa{
	public String toString() { return "class Aa"; }
}

class Bb{
	public String toString() { return "class Bb"; }
}

class InstanceTypeShower2{
	public <T,U> void showInstType(T inst1, U inst2){
		System.out.println(inst1);
		System.out.println(inst2);
	}
}

class GenericMethod2{
	public static void main(String[] args) {
		Aa a = new Aa();	Bb b = new Bb();
		InstanceTypeShower2 shower = new InstanceTypeShower2();
		shower.<Aa,Bb>showInstType(a,b);
		shower.showInstType(a,b);
		// ���׸����� ������ �ڷ����� �� �� �̻��� ��쿡�� ���׸� ��������
	}
}
