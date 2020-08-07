class TestInfo{
	int ID;
	int Korean;
	int English;
	int Mathematic;
	public TestInfo(int n1,int n2,int n3,int n4){
		ID = n1;
		Korean = n2;
		English = n3;
		Mathematic = n4;
	}
	public void setID(int num) { ID = num; }
	public void setKorean(int num) { Korean = num; }
	public void setEnglish(int num) { English = num; }
	public void setMathematic(int num) { Mathematic = num; }

	public int getID(){ return ID; }
	public int getKorean(){ return Korean; }
	public int getEnglish(){ return English; }
	public int getMathematic(){ return Mathematic; }

	public double Average(){
		double avg = ((double)(getKorean()+getEnglish()+getMathematic()))/3;
		return avg;
	}

	public void showPoint(){
		System.out.println("학번 : " + ID + "\n국어 : " + Korean + "/ 영어 : " + English + "/ 수학 : " + Mathematic + "\n평균 : " + Average());
	}

}

class  TestInfoEx{
	public static void main(String[] args) {
		TestInfo student1 = new TestInfo(1517039,88,75,77);
		TestInfo student2 = new TestInfo(1517025,98,70,79);
		TestInfo student3 = new TestInfo(1517018,85,81,80);
		
		student1.showPoint();
		student2.showPoint();
		student3.showPoint();

	}
}
