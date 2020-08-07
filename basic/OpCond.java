class OpCond{
	public static void main(String[] args) 
	{
		int n1 = 100, n2 = 50;
		int big, diff;
		if (n1 > n2){
			big = n1;
		} else{
			big = n2;
		}
		System.out.println("big : " + big);
		big = (n1 > n2) ? n1 : n2;
		diff = (n1 > n2) ? n1-n2 : n2-n1;
		System.out.println("big : " + big);
		System.out.println("diff : " + diff);
	}
}
