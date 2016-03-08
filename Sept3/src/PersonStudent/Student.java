package PersonStudent;

public class Student extends Person{
	int[] grades;


	Student(int newID, String newFirstName, String newLastName) {
		super(newID, newFirstName, newLastName);
		grades = new int[10];
	}

	Student() {
		super();
		grades = new int[10];
	}

	public void setGrade(int i, int newGrade) {
		if (i>= 1 && i <= 10 && newGrade>=0 && newGrade<=100)
			grades[i-1] = newGrade;
	}

	public double getAverage() {
		int sum = 0;
		for ( int i=0; i < grades.length; i++)
			sum += grades[i];
		double avg = sum/grades.length;
		return avg;
	}

	public String getFullName () {
		return "Student's name:" + super.getFullName();
	}


	public static void main(String[] args) {
		Person Tom = new Person(12345, "Tom", "Sawyer"); 
		System.out.println(Tom.getFullName());

		Student HuckFinn = new Student(67890, "Huck", "Finn");
		System.out.println(HuckFinn.getFullName());

		Person p = HuckFinn;
		System.out.println(p.getFullName());

		Student p2 = (Student) p;
		System.out.println(p2.getFullName());

		//	Student s = Tom; WRONG!!!
	}

}


