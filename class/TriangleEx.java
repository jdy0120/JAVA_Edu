/*
Ŭ������ : Triangle
������� : �غ��� ���̸� ������ �� �ִ� double�� ����
 - �ν��Ͻ� ������ ���ÿ� �ʱ�ȭ�� �̷������ ��
�޼ҵ� : �غ��� ������ ���� ������ �� �ִ� setter, �ﰢ���� ���̸� ���Ͽ� �����ϴ� �޼ҵ�
*/
class Triangle{
	double bottom;
	double height;
	public Triangle(double b,double h){
		bottom = b;
		height = h;
	}

	public void setBottom(double b) {bottom = b;}
	public void setHeight(double h) {height = h;}

	public double getArea(){
		return bottom * height / 2;
	}

}

class TriangleEx{
	public static void main(String[] args) {
		//�غ� 25.5, ���� : 13.5 �� �ﰢ�� �ν��Ͻ� ���� �� ���̸� ���
		Triangle tr = new Triangle(25.5,13.5);
		System.out.println("�ﰢ���� ���� : " + tr.getArea());
		//�غ��� 23.4, ���̸� 17.5�� ������ �� ���̸� ���
		tr.setBottom(23.4);
		tr.setHeight(17.5);
		System.out.println("�ﰢ���� ���� : " + tr.getArea());
	}
}
