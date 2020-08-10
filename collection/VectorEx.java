import java.util.*;

class  VectorEx{
	public static void main(String[] args) {
		Vector v = new Vector(5);
		v.add("1");	v.add("2"); v.add("3");
		print(v);
		/*
		[1, 2, 3]
		Size : 3
		Capacity : 5
		*/

		v.trimToSize(); // 용량을 크기에 맞춰 줄임
		System.out.println("=== After trimToSize() ===");
		print(v);
		/*
		[1, 2, 3]
		Size : 3
		Capacity : 3
		*/

		v.ensureCapacity(6);
		System.out.println("=== After trimToSize() ===");
		print(v);
		/*
		[1, 2, 3]
		Size : 3
		Capacity : 6
		*/

		v.setSize(7);
		System.out.println("=== After trimToSize() ===");
		print(v);

		/*
		[1, 2, 3, null, null, null, null] // 객체의 기본값은null이기 때문에 null로 채워준다.
		Size : 7
		Capacity : 12
		*/
		v.clear();
		System.out.println("=== After trimToSize() ===");
		print(v);

		/*
		[]
		Size : 0
		Capacity : 12
		*/

	}
	public static void print(Vector v){
		System.out.println(v);
		System.out.println("Size : " + v.size());
		System.out.println("Capacity : " + v.capacity());
	}
}
