package registrationsystem;

import java.time.LocalDate;
import java.time.Month;

/**
 * This main method will be used to test your Student class. Your class must
 * name it's methods such that it can work with this main method.
 * 
 */
public class StudentTest {
	public static void main(String[] args) {

		// testing a student with appropriate data

		Student st1 = new Student("Fred", "Flintstone", "16 Cobblestone Way", "Bedrock", "L0L 6T6", "COPA", 223,
				LocalDate.of(2000, Month.AUGUST, 22), LocalDate.of(1974, Month.APRIL, 12));

		System.out.printf("Student 1 is: %s, he is %d years old.%n", st1, st1.getStudentAge());
		System.out.printf("Address: %s%n", st1.getStudentAddress());

		// Have the student change their address
		st1.changeAddress("49 Granite Court", "Bedrock", "R2D 2B3");
		System.out.printf("The new address: %s%n", st1.getStudentAddress());

		// Test if the student can get suspended
		System.out.printf("The student is currently %s%n",
				st1.StudentInGoodStanding() ? "in good standing" : "suspended");
		st1.suspendStudent();
		System.out.printf("Now, the student is currently %s%n",
				st1.StudentInGoodStanding() ? "in good standing" : "suspended");
		st1.reinstateStudent();
		System.out.printf("Now, the student is currently %s%n",
				st1.StudentInGoodStanding() ? "in good standing" : "suspended");

		System.out.println("Expected Result : Please check the year entered, student cannot be over 100 years old");
		// Test adding a student that is too old to enrol in college
		try {
			Student st2 = new Student("Barney", "Rubble", "18 Cobblestone Way", "Bedrock", "L0L 6T6", "COPA", 224,
					LocalDate.of(2016, Month.FEBRUARY, 1), LocalDate.of(1872, Month.APRIL, 12));
		} catch (IllegalArgumentException ex) {

			System.out.println("Actual result" + ex.getMessage());
		}
		//
	} // end of main method
} // student of class