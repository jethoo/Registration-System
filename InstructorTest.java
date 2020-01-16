
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Radhika
 */
public class InstructorTest {

	public static void main(String[] args) {
		System.out.printf("~~~~~~~Test 1: create a valid Instructor and call the toString() method ~~~~~~~");
		Instructor jDub = new Instructor("Radhika", "Sharma", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6",
				LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
		System.out.printf("%nExpected output: The Instructor is: Radhik Sharma", jDub);
		System.out.printf("%nActual output:   The Instructor is: %s", jDub);

		System.out.printf("%n%n~~~~~~~Test 2: Display the Instructor's age ~~~~~~~");
		System.out.printf("%nExpected output Radhika Sharma is 53 years old");
		System.out.printf("%nActual output:   %s is %d years old.", jDub, jDub.getAgeInYears());

		System.out.printf("%n%n~~~~~~~Test 3: Display how long the Instructor has been at the college ~~~~~~~");
		System.out.printf("%nExpected output: Radhika Sharma has been at the college 5 years.");
		System.out.printf("%nActual output:   %s has been at the college %d years.", jDub, jDub.NoOfYearsAtCollege());

		System.out.printf("%n%n~~~~~~~Test 4: Display the Instructor's address )~~~~~~~");
		System.out.printf("%nExpected output: The address of Radhika Sharma is 10 Awesome Lane, Barrie, L2S 1A6");
		System.out.printf("%nActual output:   The address of %s is %s", jDub, jDub.getInstructorAddress());

		System.out.printf("%n%n~~~~~~~Test 5: Change the Instructor address and display the result ~~~~~~~");
		jDub.changeAddress("101 Spring St.", "Utopia", "L3S 2A2");
		System.out.printf("%nExpected output: The address of Radhika Sharma is 101 Spring St., Utopia, L3S 2A2");
		System.out.printf("%nActual output:   The address of %s is %s", jDub, jDub.getInstructorAddress());

		System.out.printf("%n%n~~~~~~~Test 6: Display the courses the Instructor can teach ~~~~~~~");
		System.out.printf(
				"%nExpected output: Radhika Sharma can teach the following courses: not qualified to teach courses yet.");
		System.out.printf("%nActual output:   %s can teach the following courses: %s", jDub,
				jDub.listOfSubjectsCertifiedToTeach());

		System.out.printf("%n%n~~~~~~~Test 7: Add some courses for the instructor to teach ~~~~~~~");
		jDub.addCourseToInstructorAbilities("COMP1008");
		jDub.addCourseToInstructorAbilities("COMP2003");
		System.out.printf("%nExpected output: Radhika Sharma can teach the following courses: [COMP1008, COMP2003]");
		System.out.printf("%nActual output:   %s can teach the following courses: %s", jDub,
				jDub.listOfSubjectsCertifiedToTeach());

		System.out.printf(
				"%n%n~~~~~~~Test 8: Test if the canTeach() identifies that an instructor cannot teach a course  ~~~~~~~");
		System.out.printf("%nExpected output: Radhika Sharma is certified to teach \"COMP3002\": false");
		System.out.printf("%nActual output:   %s is certified to teach \"COMP3002\": %s", jDub,
				jDub.InstructorcanTeach("COMP3002"));

		System.out.printf(
				"%n%n~~~~~~~Test 9: Test if the canTeach() identifies that an instructor can teach a course ~~~~~~~");
		System.out.printf("%nExpected output: Radhika Sharma is certified to teach \"COMP1008\": true");
		System.out.printf("%nActual output:   %s is certified to teach \"COMP1008\": %s", jDub,
				jDub.InstructorcanTeach("COMP1008"));

		System.out.printf("%n%n~~~~~~~Test 10: Test creating an Instructor that is too old ~~~~~~~");
		System.out.printf("%nExpected output: Please check the year entered, instructor cannot be over 100 years old");
		System.out.printf("%nActual output:   ");
		try {
			Instructor oldMan = new Instructor("Al", "Dente", 1000013, "16 Ancient Ave", "Innisfil", "W32S 1A6",
					LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1901, Month.DECEMBER, 21));
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("~~~~~~~Test 11: Test changing a birthday with a invalid date  ~~~~~~~");
		System.out.println("Expected output: Please check the year entered, instructor cannot be over 100 years old.");
		System.out.print("Actual output:   ");
		try {
			jDub.setBirthday(LocalDate.of(1901, Month.FEBRUARY, 21));

		} catch (IllegalArgumentException ex) {
			System.out.print(ex.getMessage());
		}

		System.out.printf("%n%n~~~~~~~Test 12: Test creating an Instructor that has an invalid hire date ~~~~~~~");
		System.out.printf(
				"%nExpected output: The hired on date for Anita Knapp is more than 80 years ago, it has been set to null.");
		System.out.printf("%nActual output:   ");
		try {
			Instructor hiredLongAgo = new Instructor("Anita", "Knapp", 1000014, "16 Ancient Ave", "Innisfil",
					"W32S 1A6", LocalDate.of(1910, Month.AUGUST, 22), LocalDate.of(1981, Month.DECEMBER, 21));

		} catch (IllegalArgumentException ex) {
			System.out.print(ex.getMessage() + "\n");
		}
		System.out.println("List of Subject" + jDub.listOfSubjectsCertifiedToTeach());
	}
}
