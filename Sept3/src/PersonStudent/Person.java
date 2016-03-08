package PersonStudent;

public class Person {
	int ID;
	String firstName;
	String lastName;


	Person() {
		ID = 0;
		firstName = "";
		lastName = "";
	}

	Person(int newID, String newFirstName, String newLastName) {
		ID = newID;
		firstName = newFirstName;
		lastName = newLastName;
	}


	public void setFirstName(String name) {
		firstName = name;
	}

	public void setLastName(String last) {
		lastName = last;
	}

	public String getFullName () {
		return firstName + " " + lastName;
	}


}


