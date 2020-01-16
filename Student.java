/**
 *
 * @author Jeewan
 * 
 * Student Class
 */

package registrationsystem;

//all the imports
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
	private String fName;
        private String lName;
        private String street;
        private String city;
        private String postCode;
        private String program;
        private int studentNumber;
	private LocalDate startDate;
        private LocalDate birthDate;
        //boolean variable to check student's good standing
	private boolean goodStanding = true;
        //arraylist to add completed courses of the student
	private ArrayList<String> completedCourses = new ArrayList<>();

	/**
         * Constructor to create Student object
         * @param firstName             - firstName of the student
         * @param lastName              - lastName of the student
         * @param streetAddress         - street address of the student
         * @param city                  - city of the student
         * @param postalCode            - postal code of the student
         * @param program               - program in which student is enrolled
         * @param studentNumber         - student number /id
         * @param startDate             - start date in the college
         * @param birthDate             - day of birth of student
         */
	public Student(String firstName, String lastName, String streetAddress, String city, String postalCode,
			String program, int studentNumber, LocalDate startDate, LocalDate birthDate) {
		
                this.fName = firstName;
		this.lName = lastName;
		this.program = program;
		this.studentNumber = studentNumber;
		this.startDate = startDate;
		setBirthday(birthDate); //validates birthdate of the student
                this.street = streetAddress;
		this.city = city;
		this.postCode = postalCode;
		
	} 

	/**
         * Returns first, last name of student and also student number
         * @return firstName, lastName, studentNumber
         */
	@Override
	public String toString() {
		return this.fName + " " + this.lName + ", student number: " + studentNumber;
	}
        
        
	/**
         * Returns age of the student
         * @return age
         */
	public long getStudentAge() {
		long age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
                return age;
	} 
        
        /**
         * Returns year when student was born
         * @return birthYear
         */
	public int getYearBorn() {
		return this.birthDate.getYear();
	}

        /**
         * Returns if student is in good standing or not
         * @return goodStanding
         */
	public boolean StudentInGoodStanding() {
		return this.goodStanding;
	}
        
        
	/**
         * Method to return student address
         * @return street, city, postCODE
         */
	public String getStudentAddress() {
		return this.street + " " + this.city + " " + this.postCode;
	}

	/**
         * Returns number of years student in college
         * @return year
         */
	public int getNoOfYearEnrolled() {
		return this.startDate.getYear();
	}
        
        /**
         * assigns new student address 
         * @param newStreetAddress   - new street address
         * @param newCity            - new city 
         * @param newPostalCode      - new post code
         */
	public void changeAddress(String newStreetAddress, String newCity, String newPostalCode) {
		this.street = newStreetAddress;
		this.city = newCity;
		this.postCode = newPostalCode;
	} 

	/**
         * Checks if birth Day is valid or not
         * @param birthDate 
         */
	public void setBirthday(LocalDate birthDate) {
		long year = birthDate.getYear();

		if (year > 1919) {
			this.birthDate = birthDate;
		} else {
			throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
		}
	} 

	/**
         * Returns date of birth
         * @return birthDate
         */
	public LocalDate getStudentBirthday() {
		return this.birthDate;
	}

	/**
         * Returns student number
         * @return studentNumber
         */
	public int getStudentNumber() {
		return this.studentNumber;
	}

	/**
         * Method to suspend student
         */
	public void suspendStudent() {
		this.goodStanding = false;
	}
        
        /**
         * Method to re-enroll student
         */
	public void reinstateStudent() {
		this.goodStanding = true;
	}

	/**
         * Method to add completed course with grade in completed list
         * @param course
         * @param grade 
         */
	public void addCompletedCourse(Course course, int grade) {
            String subject = course.toString();
            String mark = Integer.toString(grade);
            String message = subject + " grade=" + mark;
		if (grade > 0 && grade < 101) {
			if (grade > 49) {
				
				completedCourses.add(message);
			}
		} else
			throw new IllegalArgumentException("grade must be 0-100 inclusive");
	} 
        
        /**
         * Method to give list of completed courses
         * @return 
         */
	public String getCoursesCompleted() {
               if(completedCourses.isEmpty()){
                   return "Student has not completed any course.";
               }else{
                   return Arrays.toString(completedCourses.toArray());
               }
	} 
        
        /**
         * Method to check if student has completed certain course or not
         * @param courseCode
         * @return 
         */
	public boolean hasCompleted(String courseCode) {
		if (this.getCoursesCompleted().contains(courseCode)){
                    return true;
                }
                else{
                    return false;
                }
			
	} 
  }