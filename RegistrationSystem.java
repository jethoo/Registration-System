
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

public class RegistrationSystem {

    public static void main(String[] args) {
        ArrayList<String> failedTest = new ArrayList<String>();

        double marks = 0;
        double totalMarks = 70;
        System.out.printf("!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");
        System.out.printf("%n!~~             Student Tests                  ~~!");
        System.out.printf("%n!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");

        
/** Test 1**/       
        System.out.printf("%n~~~~~~~Test 1: create a valid Student (1 mark)~~~~~~~");
        Student st1 = new Student("Colin", "Allcars", "16 Cobblestone Way",
                "Barrie", "L0L 6T6", "COPA", 223,
                LocalDate.of(2000, Month.AUGUST, 22),
                LocalDate.of(1974, Month.APRIL, 12));
        System.out.printf("%nExpected output: The student is: Colin Allcars, student number: 223");
        System.out.printf("%nActual output:   The student is: %s", st1);
        if (st1.toString().equalsIgnoreCase("Colin Allcars, student number: 223")) {
            marks++;
            System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        } else {
            failedTest.add("Test 1");
        }
        
        
/** Test 2**/
        System.out.printf("%n%n~~~~~~~Test 2: create a valid Student (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: Colin Allcars, student number: 223 was born on 1974-04-12 and is 45 years old");
        System.out.printf("%nActual output:   %s was born on %s and is %d years old", st1, st1.getStudentBirthday(), st1.getStudentAge());
        if (st1.getStudentBirthday().equals(LocalDate.of(1974, Month.APRIL, 12)) && st1.getStudentAge() == 45) {
            marks++;

            System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        } else {
            failedTest.add("Test 2");
        }

        
/** Test 3**/
        System.out.printf("%n%n~~~~~~~Test 3: Test the Student getAge() method with a birthday that has already happened this year: (1 mark)~~~~~~~");
        Student st2 = new Student("Gail", "Storm", "10 Tornado St", "Windsor", "H6T D3S", "COPR", 10001,
                LocalDate.of(2010, Month.JANUARY, 22), LocalDate.of(1999, Month.DECEMBER, 31));
        System.out.printf("%nExpected output: Student: Gail Storm, student number: 10001 is 19 years old");
        System.out.printf("%nActual output:   Student: %s is %d years old", st2, st2.getStudentAge());
        if (st2.getStudentAge() == 19) {
            marks++;
        } else {
            failedTest.add("Test 3");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

/**Test 4  **/                
        System.out.printf("%n%n~~~~~~~Test 4: change the students' address (1 mark)~~~~~~~");
        st1.changeAddress("49 Granite Court", "Bedrock", "R2D 2B3");
        System.out.printf("%nExpected output: Colin Allcars, student number: 223 new address is 49 Granite Court Bedrock R2D 2B3");
        System.out.printf("%nActual output:   %s new address is %s", st1, st1.getStudentAddress());
        if (st1.getStudentAddress().equals("49 Granite Court Bedrock R2D 2B3")) {
            marks++;
            System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        } else {
            failedTest.add("Test 4 ");
        }

        
/**Test 5   **/           
        System.out.printf("%n%n~~~~~~~Test 5: the Student should not be suspended (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: Colin Allcars, student number: 223 is in good standing: true");
        System.out.printf("%nActual output:   %s is in good standing: %s", st1, st1.StudentInGoodStanding());
        if (st1.StudentInGoodStanding()) {
            marks++;

            System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        } else {
            failedTest.add("Test 5");
        }
        
        
/**Test 6  **/   
        System.out.printf("%n%n~~~~~~~Test 6: suspend the Student (1 mark)~~~~~~~");
        st1.suspendStudent();
        System.out.printf("%nExpected output: Colin Allcars, student number: 223 is in good standing: false");
        System.out.printf("%nActual output:   %s is in good standing: %s", st1, st1.StudentInGoodStanding());
        if (!st1.StudentInGoodStanding()) {
            marks++;
        } else {
            failedTest.add("Test 6");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
/**Test 7  **/           
        System.out.printf("%n%n~~~~~~~Test 7: Add a student that is too old - should throw an exception (2 mark)~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: Please check the year entered, student cannot be over 100 years old");
        System.out.printf("%nActual output:   ");
        //Test adding a student that is too old to enrol in college
        try {
            Student st3 = new Student("Barney", "Rubble", "18 Cobblestone Way",
                    "Bedrock", "L0L 6T6", "COPA", 224,
                    LocalDate.of(2016, Month.FEBRUARY, 1),
                    LocalDate.of(1872, Month.APRIL, 12));
            
            failedTest.add("Test 7");
        
        } catch (IllegalArgumentException e) {
            System.out.printf("%s", e);
            marks+=2;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
/**Test  8 **/           
        System.out.printf("%n%n~~~~~~~Test 8: retrieve the year a Student enrolled in the school (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: Colin Allcars, student number: 223 enrolled in the year 2000");
        System.out.printf("%nActual output:   %s enrolled in the year %d", st1, st1.getNoOfYearEnrolled());
        if (st1.getNoOfYearEnrolled() == 2000) {
            marks++;
        } else {
            failedTest.add("Test 8");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        System.out.printf("%n%n!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");
        System.out.printf("%n!~~             Instructor Tests               ~~!");
        System.out.printf("%n!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");

        
/**Test 9  **/           
        System.out.printf("%n~~~~~~~Test 9: create a valid Instructor and call the toString() method (1 mark)~~~~~~~");
        Instructor karenV = new Instructor("Karen", "Vader", 1000012, "10 Hightop Lane", "Barrie", "L2S 1A6", LocalDate.of(2013, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
        System.out.printf("%nExpected output: The Instructor is: Karen Vader");
        System.out.printf("%nActual output:   The Instructor is: %s", karenV);
        if (karenV.toString().equalsIgnoreCase("Karen Vader")) {
            marks++;
        } else {
            failedTest.add("Test 9");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
/**Test  10 **/           
        System.out.printf("%n%n~~~~~~~Test 10: Display the Instructor's age (1 mark)~~~~~~~");
        System.out.printf("%nExpected output:Karen Vader is 57 years old.");
        System.out.printf("%nActual output: %s is %d years old.", karenV, karenV.getAgeInYears());
        if (karenV.getAgeInYears() == 57) {
            marks++;
        } else {
            failedTest.add("Test 10");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
/**Test  11 **/           
        System.out.printf("%n%n~~~~~~~Test 11: Display how long the Instructor has been at the college (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: Karen Vader has been at the college 6 years.");
        System.out.printf("%nActual output:   %s has been at the college %d years.", karenV, karenV.NoOfYearsAtCollege());
        if (karenV.NoOfYearsAtCollege() == 6) {
            marks++;
        } else {
            failedTest.add("Test 11");
        }        
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

 
        
/**Test  12 **/           
        System.out.printf("%n%n~~~~~~~Test 12: Display the Instructor's address (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: The address of Karen Vader is 10 Hightop Lane, Barrie, L2S 1A6");
        System.out.printf("%nActual output:   The address of %s is %s", karenV, karenV.getInstructorAddress());
        if (karenV.getInstructorAddress().equals("10 Hightop Lane, Barrie, L2S 1A6")) {
            marks++;
        } else {
            failedTest.add("Test 12");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);



/**Test  13  **/           
        System.out.printf("%n%n~~~~~~~Test 13: Change the Instructor address and display the result (1 mark)~~~~~~~");
        karenV.changeAddress("101 First Floor Ave.", "Utopia", "L3S 2A2");
        System.out.printf("%nExpected output: The address of Karen Vader is 101 First Floor Ave., Utopia, L3S 2A2");
        System.out.printf("%nActual output:   The address of %s is %s", karenV, karenV.getInstructorAddress());
        if (karenV.getInstructorAddress().equals("101 First Floor Ave., Utopia, L3S 2A2")) {
            marks++;
        } else {
            failedTest.add("Test 13");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
/**Test  14 **/           

        System.out.printf("%n%n~~~~~~~Test 14: Display the courses the Instructor can teach (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: Karen Vader can teach the following courses: not qualified to teach courses yet.");
        System.out.printf("%nActual output:   %s can teach the following courses: %s", karenV, karenV.listOfSubjectsCertifiedToTeach());
        if (karenV.listOfSubjectsCertifiedToTeach().equals("not qualified to teach courses yet.")) {
            marks++;
        } else {
            failedTest.add("Test 14");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        

/**Test  15 **/          
        System.out.printf("%n%n~~~~~~~Test 15: Add some courses for the instructor to teach (1 mark)~~~~~~~");
        karenV.addCourseToInstructorAbilities("COMP1008");
        karenV.addCourseToInstructorAbilities("COMP2003");
        System.out.printf("%nExpected output: Karen Vader can teach the following courses: [COMP1008, COMP2003]");
        System.out.printf("%nActual output:   %s can teach the following courses: %s", karenV, karenV.listOfSubjectsCertifiedToTeach());
        if (karenV.listOfSubjectsCertifiedToTeach().equals("[COMP1008, COMP2003]")) {
            marks++;
        } else {
            failedTest.add("Test 15");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        

/**Test  16 **/           
        System.out.printf("%n%n~~~~~~~Test 16: Test if the canTeach() identifies that an instructor cannot teach a course (1 mark) ~~~~~~~");
        System.out.printf("%nExpected output: Karen Vader is certified to teach \"COMP3002\": false");
        System.out.printf("%nActual output:   %s is certified to teach \"COMP3002\": %s", karenV, karenV.InstructorcanTeach("COMP3002"));
        if (!karenV.InstructorcanTeach("COMP3002")) {
            marks++;
        } else {
            failedTest.add("Test 16");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

 
 /**Test  17 **/          
        System.out.printf("%n%n~~~~~~~Test 17: Test if the canTeach() identifies that an instructor can teach a course (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: Karen Vader is certified to teach \"COMP1008\": true");
        System.out.printf("%nActual output:   %s is certified to teach \"COMP1008\": %s", karenV, karenV.InstructorcanTeach("COMP1008"));
        if (karenV.InstructorcanTeach("COMP1008")) {
            marks++;
        } else {
            failedTest.add("Test 17");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        

/**Test  18 **/           
        System.out.printf("%n%n~~~~~~~Test 18: Test if the same course can be added more than once to an Instructor (1 mark)~~~~~~~");
        karenV.addCourseToInstructorAbilities("COMP2003");
        System.out.printf("%nExpected output: Karen Vader can teach the following courses: [COMP1008, COMP2003]");
        System.out.printf("%nActual output:   Karen Vader can teach the following courses: %s", karenV.listOfSubjectsCertifiedToTeach());
        if (karenV.listOfSubjectsCertifiedToTeach().equals("[COMP1008, COMP2003]")) {
            marks++;
        } else {
            failedTest.add("Test 18");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
        
        
/**Test  19 **/           
        System.out.printf("%n%n~~~~~~~Test 19: Test creating an Instructor that is too old (2 marks) ~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: Please check the year entered, instructor cannot be over 100 years old");
        System.out.printf("%nActual output:   ");
        try {
            Instructor oldMan = new Instructor("Al", "Dente", 1000013, "16 Ancient Ave", "Innisfil", "W32S 1A6", 
                    LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1901, Month.DECEMBER, 21));
             
            failedTest.add("Test 19");        
        } catch (IllegalArgumentException e) {
            System.out.printf("%s", e);
            marks += 2;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
        
/**Test  20 **/   
        System.out.printf("%n%n~~~~~~~Test 20: Test creating an Instructor that has an invalid hire date (2 marks) ~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: 1910-08-22 as a hire date would mean Anita started working over 80 years ago");
        System.out.printf("%nActual output:   ");
        try {
            Instructor hiredLongAgo = new Instructor("Anita", "Knapp", 1000014, "16 Ancient Ave", "Innisfil", "W32S 1A6", 
                    LocalDate.of(1910, Month.AUGUST, 22), LocalDate.of(1981, Month.DECEMBER, 21));
             
            failedTest.add("Test 20");        
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks += 2;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        System.out.printf("%n%n!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");
        System.out.printf("%n!~~               Course Tests                 ~~!");
        System.out.printf("%n!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");

        

/**Test  21  **/   
        System.out.printf("%n%n~~~~~~~Test 21: create a valid Instructor and then create a valid Course with the Instructor (1 marks)~~~~~~~");
        Instructor frank = new Instructor("Frank", "Enstein", 1000012, "10 Awesome Lane", "Barrie", "L2S 1A6", LocalDate.of(2010, Month.AUGUST, 22), LocalDate.of(1962, Month.JUNE, 6));
        frank.addCourseToInstructorAbilities("COMP1008");
        Course comp1008 = new Course(frank, "COMP1008", "Intro to OOP", "E202", DayOfWeek.TUESDAY, LocalTime.parse("11:00"), 3);
        System.out.printf("%nExpected output: The course is: COMP1008-Intro to OOP");
        System.out.printf("%nActual output:   The course is: %s", comp1008);        //note: this will actually call the course toString() method
        if (comp1008.toString().equals("COMP1008-Intro to OOP")) {
            marks++;
        } else {
            failedTest.add("Test 21");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
/**Test  22 **/           
        System.out.printf("%n%n~~~~~~~Test 22: Test the getRoom method (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: The course COMP1008-Intro to OOP is in room: E202");
        System.out.printf("%nActual output:   The course %s is in room: %s", comp1008, comp1008.getClassRoom());
        if (comp1008.getClassRoom().equals("E202")) {
            marks++;
        } else {
            failedTest.add("Test 22");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);



/**Test  23 **/           
        System.out.printf("%n%n~~~~~~~Test 23: Test the getCourseDayAndTime() method (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: The course is hosted on: TUESDAY's, starting at 11:00");
        System.out.printf("%nActual output:   The course is hosted on: %s", comp1008.getCourseDayAndTime());
        if (comp1008.getCourseDayAndTime().equals("TUESDAY's, starting at 11:00")) {
            marks++;
        } else {
            failedTest.add("Test 23");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        

/**Test  24 **/           
        System.out.printf("%n%n~~~~~~~Test 24: Test the getInstructor method (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: The course is taught by: Frank Enstein");
        System.out.printf("%nActual output:   The course is taught by: %s", comp1008.getInstructorToTeach());
        if (comp1008.getInstructorToTeach().equals(frank)) {
            marks++;
        } else {
            failedTest.add("Test 24");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

 
        
/**Test  25 **/           
        System.out.printf("%n%n~~~~~~~Test 25: Test adding Students to the class (1 marks)~~~~~~~");
        st1.reinstateStudent();
        Student st3 = new Student("Howie", "Doohan", "12 Greeter Ln", "Thornhill", "H9T A3S", "COPR", 10002, LocalDate.of(2011, Month.AUGUST, 21), LocalDate.of(1997, Month.APRIL, 16));
        Student st4 = new Student("Jerry", "Atrick", "39 Elder Ave", "Newmarket", "A6T D3S", "COPR", 10003, LocalDate.of(2008, Month.AUGUST, 22), LocalDate.of(1943, Month.MARCH, 23));
        Student st5 = new Student("Leigh", "King", "182 Drip Drive", "Etobicoke", "Q6X D3S", "COPA", 10004, LocalDate.of(2010, Month.AUGUST, 21), LocalDate.of(2000, Month.FEBRUARY, 14));
        comp1008.addStudent(st1);
        System.out.printf("%nExpected output: The course list has this student: Colin Allcars, student number: 223");
        System.out.printf("%nActual output:   The course list has this student: %s", comp1008.displayTheClassList());
        if (comp1008.displayTheClassList().equals("Colin Allcars, student number: 223")) {
            marks++;
        } else {
            failedTest.add("Test 25");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        

/**Test  26 **/           
        System.out.printf("%n%n~~~~~~~Test 26: Test adding more than the max # of Students allowed in a Course (1 marks)~~~~~~~");
        comp1008.addStudent(st3);
        comp1008.addStudent(st4);
        System.out.printf("%nExpected output: Student was not added because the course is full");
        System.out.printf("%nActual output:   %s", comp1008.addStudent(st5));
        if (comp1008.addStudent(st5).equals("Student was not added because the course is full")) {
            marks++;
        } else {
            failedTest.add("Test 26");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        

/**Test  27  **/           
        System.out.printf("%n%n~~~~~~~Test 27: Test adding a suspended student to a Course(1 marks)~~~~~~~");
        st4.suspendStudent();
        System.out.printf("%nExpected output: The Student is not in good standing and cannot join the course.");
        System.out.printf("%nActual output:   %s", comp1008.addStudent(st4));
        if (comp1008.addStudent(st4).equals("The Student is not in good standing and cannot join the course.")) {
            marks++;
        } else {
            failedTest.add("Test 27");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        

/**Test   28 **/           
        System.out.printf("%n%n~~~~~~~Test 28: Test increasing the max size of the class to 80 (2 marks)~~~~~~~");
        System.out.printf("%nExpected output: Max class size = 40, it has been set to 40");
        System.out.printf("%nActual output:   %s", comp1008.setClassSize(80));
        if (comp1008.setClassSize(80).equals("Max class size = 40, it has been set to 40") && comp1008.getClassSize() == 40) {
            marks += 2;
        } else {
            failedTest.add("Test 28");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
        

/**Test  29 **/           
        System.out.printf("%n%n~~~~~~~Test 29: Test creating a course with an invalid early start time (1 marks)~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: Course start time must be between 08:00-18:00");
        System.out.printf("%nActual output:   ");
        frank.addCourseToInstructorAbilities("COMP2003");
        try {
            Course comp2003 = new Course(frank, "COMP2003", "Intro to DB", "E204", DayOfWeek.THURSDAY, LocalTime.parse("06:00"), 20);
            
            failedTest.add("Test 29");        
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks += 1;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        

/**Test  30  **/           
        System.out.printf("%n%n~~~~~~~Test 30: Test creating a course with an invalid late start time (1 marks)~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: Course start time must be between 08:00-18:00");
        System.out.printf("%nActual output:   ");
        frank.addCourseToInstructorAbilities("COMP2003");
        try {
            Course comp2003 = new Course(frank, "COMP2003", "Intro to DB", "E204", DayOfWeek.THURSDAY, LocalTime.parse("18:01"), 20);
          
            failedTest.add("Test 30");
        
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks++;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        

/**Test   31 **/           
        System.out.printf("%n%n~~~~~~~Test 31: Test the matureClass() method when it is an older class (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: The average age for the class is above 25: true");
        System.out.printf("%nActual output:   The average age for the class is above 25: %s", comp1008.matureClass());
        if (comp1008.matureClass()) {
            marks++;
        } else {
            failedTest.add("Test 31");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

// /**Test    32 **/      
        System.out.printf("%n%n~~~~~~~Test 32: Test the matureClass() method when it is a younger class (1 mark)~~~~~~~");
        st1.setBirthday(LocalDate.of(2000, Month.DECEMBER, 31));
        st2.setBirthday(LocalDate.of(2000, Month.FEBRUARY, 16));
        st3.setBirthday(LocalDate.of(2000, Month.MARCH, 23));
        st4.setBirthday(LocalDate.of(2000, Month.MARCH, 29));
        System.out.printf("%nExpected output: The average age for the class is above 25: false");
        System.out.printf("%nActual output:   The average age for the class is above 25: %s", comp1008.matureClass());
        if (!comp1008.matureClass()) {
            marks++;
        } else {
            failedTest.add("Test 32");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        

/**Test  33 **/           
        System.out.printf("%n%n~~~~~~~Test 33: Test to ensure invalid Instructor will not be added: (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: Professor Frank Enstein is not qualified to teach COMP9999");
        System.out.printf("%nActual output:   ");
        try {
            Course comp9999 = new Course(frank, "COMP9999", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20);
             
            failedTest.add("Test 33");
        
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks++;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        System.out.printf("%n%n!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");
        System.out.printf("%n!~~        Course With lab Tests               ~~!");
        System.out.printf("%n!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!");

        
/**Test  34  **/           
        System.out.printf("%n%n~~~~~~~Test 34: Test creating a valid lab course: (2 marks)~~~~~~~");
        Instructor labGuy = new Instructor("Dan", "Gerus", 1000013, "15 Risk Ave.", "Barrie", "L3S 1A6", LocalDate.of(2011, Month.AUGUST, 22), LocalDate.of(1982, Month.JUNE, 6));
        labGuy.addCourseToInstructorAbilities("COMP2004-LAB");
        karenV.addCourseToInstructorAbilities("COMP2004");
        CourseWithLab comp2004 = new CourseWithLab(karenV, "COMP2004", "FX GUIs", "E208", DayOfWeek.MONDAY, LocalTime.parse("08:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
        System.out.printf("%nExpected output: COMP2004-FX GUIs with lab");
        System.out.printf("%nActual output:   %s", comp2004.toString());
        if (comp2004.toString().equals("COMP2004-FX GUIs with lab")) {
            marks += 2;
        } else {
            failedTest.add("Test 34");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
        
/**Test  35  **/   
        System.out.printf("%n%n~~~~~~~Test 35: Test creating a CourseWithLab that has an unqualified Instructor: (2 marks)~~~~~~~");
        Instructor alec = new Instructor("Alec", "Tricity", 1000014, "6 Spark St.", "Barrie", "L3S 1A7", LocalDate.of(2004, Month.JANUARY, 01), LocalDate.of(1976, Month.SEPTEMBER, 6));
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: Professor Alec Tricity is not qualified to teach COMP2008");
        System.out.printf("%nActual output:   ");
        try {
            CourseWithLab comp2008 = new CourseWithLab(alec, "COMP2008", "UI Design", "E208", DayOfWeek.THURSDAY,
                    LocalTime.parse("13:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
            
            failedTest.add("Test 35");
        
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks += 2;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);




/**Test 36  **/           
        System.out.printf("%n%n~~~~~~~Test 36: Test creating a course with unqualified Lab Tech: (2 marks)~~~~~~~");
        alec.addCourseToInstructorAbilities("COMP2008");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: The Lab Tech is not qualified to host the lab");
        System.out.printf("%nActual output:   ");
        try {
            CourseWithLab comp2008 = new CourseWithLab(alec, "COMP2008", "UI Design", "E208", DayOfWeek.THURSDAY, 
                    LocalTime.parse("13:00"), 3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("15:00"));
            
            failedTest.add("Test 36");        
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks += 2;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
        
        
/**Test  37 **/           
        System.out.printf("%n%n~~~~~~~Test 37: Test creating a course with invalid lab time: (2 marks)~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: The lab start time must be between 08:00-18:00");
        System.out.printf("%nActual output:   ");
        labGuy.addCourseToInstructorAbilities("COMP2008-LAB");
        try {
            CourseWithLab comp2008 = new CourseWithLab(alec, "COMP2008", "UI Design", "E208", DayOfWeek.THURSDAY, LocalTime.parse("13:00"),
                    3, labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("19:00"));
            
            failedTest.add("Test 37");
        
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks += 2;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        

/**Test  38 **/           
        System.out.printf("%n%n~~~~~~~Test 38: Test returning the lab room, day and time: (2 marks)~~~~~~~");
        System.out.printf("%nExpected output: room: E204, WEDNESDAY starting at 15:00");
        System.out.printf("%nActual output:   %s", comp2004.getLabClassAndTime());
        if (comp2004.getLabClassAndTime().equals("room: E204, WEDNESDAY starting at 15:00")) {
            marks += 2;
        } else {
            failedTest.add("Test 38");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
        
/**Test  39 **/   
        System.out.printf("%n%n~~~~~~~Test 39: Test returning the Instructor and lab tech name: (2 marks)~~~~~~~");
        System.out.printf("%nExpected output: Course: COMP2004-FX GUIs with lab, Instructor: Karen Vader, lab tech: Dan Gerus");
        System.out.printf("%nActual output:   Course: %s, Instructor: %s, lab tech: %s", comp2004, comp2004.getInstructorToTeach(), comp2004.getLabTech());
        if (comp2004.getInstructorToTeach().equals(karenV) && comp2004.getLabTech().equals(labGuy)) {
            marks += 2;
        } else {
            failedTest.add("Test 39");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
/**Test   40 **/   
        System.out.printf("%n%n~~~~~~~Test 40: Test adding a CoursesCompleted to a Student: (2 marks)~~~~~~~");
        st1.addCompletedCourse(comp1008, 88);
        System.out.printf("%nExpected output: student 223, has completed the following courses: [COMP1008-Intro to OOP grade=88]");
        System.out.printf("%nActual output:   student %s, has completed the following courses: %s", st1.getStudentNumber(), st1.getCoursesCompleted());
        if (st1.getCoursesCompleted().equals("[COMP1008-Intro to OOP grade=88]")) {
            marks += 2;
        } else {
            failedTest.add("Test 40");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
        
        
/**Test  41  **/           
        System.out.printf("%n%n~~~~~~~Test 41: Test adding a Course with a prerequisite: (2 marks)~~~~~~~");
        frank.addCourseToInstructorAbilities("COMP2020");
        Course comp2020 = new Course(frank, "COMP2020", "Swift 101", "B230", DayOfWeek.THURSDAY, LocalTime.parse("13:00"), 20, "COMP1008");
        System.out.printf("%nExpected output: Course: COMP2020-Swift 101 has prerequisite: COMP1008");
        System.out.printf("%nActual output:   Course: %s has prerequisite: %s", comp2020, comp2020.checkPrerequisite());
        if (comp2020.checkPrerequisite().equals("COMP1008")) {
            marks += 2;
        }else {
            failedTest.add("Test 41");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
        
/**Test   42 **/           
        System.out.printf("%n%n~~~~~~~Test 42: Test adding a Student with the required prerequisite: (2 marks)~~~~~~~");
        comp2020.addStudent(st1);
        System.out.printf("%nExpected output: Course: COMP2020-Swift 101 has the following students: Colin Allcars, student number: 223");
        System.out.printf("%nActual output:   Course: %s has the following students: %s", comp2020, comp2020.displayTheClassList());
        if (comp2020.displayTheClassList().equals("Colin Allcars, student number: 223")) {
            marks += 2;
        }
        else {
            failedTest.add("Test 42");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
        
/**Test  43  **/           
        System.out.printf("%n%n~~~~~~~Test 43: Test creating a valid CourseWithLab object with prerequisite: (2 marks)~~~~~~~");
        alec.addCourseToInstructorAbilities("COMP2018");
        labGuy.addCourseToInstructorAbilities("COMP2018-LAB");
        CourseWithLab comp2018 = new CourseWithLab(alec, "COMP2018", "Nifty Stuff", "E208", DayOfWeek.FRIDAY, LocalTime.parse("15:00"), 3, "COMP1008", labGuy, "E204", DayOfWeek.WEDNESDAY, LocalTime.parse("09:00"));
        System.out.printf("%nExpected output: The course is COMP2018-Nifty Stuff with lab, prerequisite is COMP1008");
        System.out.printf("%nActual output:   The course is %s, prerequisite is %s", comp2018, comp2018.checkPrerequisite());
        if (comp2018.toString().equals("COMP2018-Nifty Stuff with lab") && comp2018.checkPrerequisite().equals("COMP1008")) {
            marks += 2;
        }
        else {
            failedTest.add("Test 43");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
        
/**Test  44 **/   
        System.out.printf("%n%n~~~~~~~Test 44: Test adding a Student without the required prerequisite to a CourseWithLab: (2 marks)~~~~~~~");
        System.out.printf("%nExpected output: Student has not completed the prerequisite course: COMP1008");
        System.out.printf("%nActual output:   %s", comp2020.addStudent(st2));
        if (comp2020.addStudent(st2).equals("Student has not completed the prerequisite course: COMP1008")) {
            marks += 2;
        }
        else {
            failedTest.add("Test 44");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
/**Test  45 **/   
        System.out.printf("%n%n~~~~~~~Test 45: Test the Student.hasCompleted method with a failing grade: (2 marks)~~~~~~~");
        st2.addCompletedCourse(comp1008, 47);
        System.out.printf("%nExpected output: Testing st2.hasCompleted(COMP1008) returns: false");
        System.out.printf("%nActual output:   Testing st2.hasCompleted(COMP1008) returns: %s", st2.hasCompleted("COMP1008"));
        if (!st2.hasCompleted("COMP1008")) {
            marks += 2;
        }
        else {
            failedTest.add("Test 45");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
        
        
/**Test  46 **/           
        System.out.printf("%n%n~~~~~~~Test 46: Test the hasCompleted() method after retaking a course and getting a passing grade: (2 marks)~~~~~~~");
        st2.addCompletedCourse(comp1008, 88);
        System.out.printf("%nExpected output: Testing st2.hasCompleted(COMP1008) returns: true");
        System.out.printf("%nActual output:   Testing st2.hasCompleted(COMP1008) returns: %s", st2.hasCompleted("COMP1008"));
        if (st2.hasCompleted("COMP1008")) {
            marks += 2;
        }
        else {
            failedTest.add("Test 46");
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
/**Test  47  **/   
        System.out.printf("%n%n~~~~~~~Test 47: Test adding an invalid grade for a student (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: grade must be 0-100 inclusive");
        System.out.printf("%nActual output:   ");
        try {
            st2.addCompletedCourse(comp2020, -10);
            failedTest.add("Test 47");
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks++;
        }
        
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);
        
        
        
/**Test 48  **/   
        System.out.printf("%n%n~~~~~~~Test 48: Test adding an invalid grade for a student (1 mark)~~~~~~~");
        System.out.printf("%nExpected output: java.lang.IllegalArgumentException: grade must be 0-100 inclusive");
        System.out.printf("%nActual output:   ");
        try {
            st2.addCompletedCourse(comp2020, 101);
            failedTest.add("Test 48");
        } catch (IllegalArgumentException e) {
            System.out.print(e);
            marks++;
        }
        System.out.printf("%nYour total marks are now: %.0f/%.0f=%.1f%%", marks, totalMarks, marks / totalMarks * 100);

        
        
/****                       Important                *******/           
        System.out.printf("%n%n~~~~~~~Test 49: Code comments (5 marks)~~~~~~~");
        System.out.printf("%nBe sure EVERY method has a comment prior to it in Javadoc style "
                + "that describes what the method will do.  ");
        
        if (!failedTest.isEmpty()) {
            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~List of failed tests~~~~~~~~~~~~~");
            failedTest.forEach((str) -> {
                System.out.print(str+", ");
            });  
        }
            else {
            failedTest.add("Test 40");
        
        }
         System.out.println("\n\n");
    }
}