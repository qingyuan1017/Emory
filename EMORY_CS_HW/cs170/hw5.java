public class hw5 {
	public static int Monday = 0;
	public static int Tuesday = 1;
	public static int Wednesday = 2;
	public static int Thursday = 3;
	public static int Friday = 4;

	public static void main(String[] args) {
		course c1 = new course("Introduction to Programming");
		c1.setDay(new int[] { Monday, Wednesday, Friday });
		c1.setTime(10, 11);

		course c2 = new course("Calculus");
		c2.setDay(new int[] { Monday, Tuesday });
		c2.setTime(10, 12);

		course c3 = new course("Computer Science I");
		c3.setDay(new int[] { Tuesday, Thursday, Friday });
		c3.setTime(13, 15);

		course c4 = new course("Linear Algebra");
		c4.setDay(new int[] { Friday });
		c4.setTime(12, 15);

		course c5 = new course("Physics");
		c5.setDay(new int[] { Wednesday, Thursday });
		c5.setTime(12, 15);

		student s1 = new student("Alex");
		s1.add(c1);
		s1.add(c4);
		s1.add(c2);
		s1.add(c3);
		s1.add(c5);

		student s2 = new student("Brian");
		s2.add(c2);
		s2.add(c3);
		s2.add(c4);
		s2.add(c5);
		s2.add(c1);

		student s3 = new student("Cliff");
		s3.add(c1);
		s3.add(c2);
		s3.add(c3);
		s3.add(c4);
		s3.add(c5);

		student s4 = new student("David");
		s4.add(c5);
		s4.add(c4);
		s4.add(c3);
		s4.add(c2);
		s4.add(c1);

		student s5 = new student("Efron");
		s5.add(c1);
		s5.add(c3);
		s5.add(c2);
		s5.add(c4);
		s5.add(c5);

		student s6 = new student("Frank");
		s6.add(c1);
		s6.add(c5);
		s6.add(c2);
		s6.add(c3);
		s6.add(c4);

		student s7 = new student("Grace");
		s7.add(c2);
		s7.add(c4);
		s7.add(c1);
		s7.add(c3);
		s7.add(c5);

		student s8 = new student("Halen");
		s8.add(c3);
		s8.add(c4);
		s8.add(c2);
		s8.add(c1);
		s8.add(c5);

		student s9 = new student("Ian");
		s9.add(c5);
		s9.add(c2);
		s9.add(c4);
		s9.add(c3);
		s9.add(c1);

		student s10 = new student("Jack");
		s10.add(c1);
		s10.add(c4);
		s10.add(c3);
		s10.add(c5);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
		System.out.println(s9);
		System.out.println(s10);

	}
}
