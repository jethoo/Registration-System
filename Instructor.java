/**
 *
 * @author Jeewan Bhusal
 * Instructor class
 */

package registrationsystem;

//all the imports
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;


public class Instructor {
	private String fName;
        private String lName;
        private String street;
        private String city;
        private String postCode;
        //arraylist to store instructor's ability to teach course
	private ArrayList<String> ableToTeach = new ArrayList<String>();
        //instructor's id
	private int InstructorNum;
	private LocalDate hireDate;
        private LocalDate birthDate;

	/**
         * Creates Instructor object 
         * @param firstName         -firstName of the instructor
         * @param lastName          -lastName of the instructor
         * @param InstructorNum     - id of the instructor
         * @param streetAddress     - street address of the instructor
         * @param city              - city of the instructor
         * @param postalCode        - postal code of the instructor
         * @param hireDate          - date when instructor was hired
         * @param birthDate         - date of birth of instructor
         */
	public Instructor(String firstName, String lastName, int InstructorNum, String streetAddress, String city,
			String postalCode, LocalDate hireDate, LocalDate birthDate) {
		
                this.fName = firstName;
		this.lName = lastName;
		this.InstructorNum = InstructorNum;
		this.street = streetAddress;
		this.city = city;
		this.postCode = postalCode;
                
		checkHireDate(hireDate); //validates hiring date of the instructor
		checkBirthday(birthDate); //validates bithday of the instructor
	} // End of constructor
        
        
        /**
         * Returns instructors firstName and lastName
         * @return 
         */
	@Override
	public String toString() {
		return this.fName + " " + this.lName;
	}
        
        /**
         * Method to add courses to instructor abilities
         * Adds to ableToTeach arrayList
         * @param course 
         */
	public void addCourseToInstructorAbilities(String course) {
		if (!ableToTeach.contains(course)){
                    this.ableToTeach.add(course);
                }
			
	} 
        
	/**
         * Method to check if instructor can teach a certain course
         * @param courseCode
         * @return Boolean
         */
	public boolean InstructorcanTeach(String courseCode) {
		if (this.ableToTeach.contains(courseCode)){
                    return true;
                }else{
                    return false;
                }
			
	} 

	/**
         * Checks if instructor has qualification to teach courses 
         * if yes returns the courses he/she able to teach
         * @return String
         */
	public String listOfSubjectsCertifiedToTeach() {
		if(ableToTeach.isEmpty()){
                    return "not qualified to teach courses yet.";
                }else{
                    return Arrays.toString(ableToTeach.toArray());
                }
	}

	

	/**
         * Checks if instructor is too old or not
         * @param birthDate 
         */
	public void checkBirthday(LocalDate birthDate) {
		long year = birthDate.getYear();
                
		if (year > 1919) {
			this.birthDate = birthDate;
		} else {
			throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
		} 
	} 
        
        
	/**
         * Checks if the hiring date of the instructor is wrong or right
         * @param hireDate 
         */
	public void checkHireDate(LocalDate hireDate) {
		long timeAtCollege = ChronoUnit.YEARS.between(hireDate, LocalDate.now());

		if (timeAtCollege < 80) {
			this.hireDate = hireDate;
		} else {
			throw new IllegalArgumentException(
			 hireDate + " as a hire date would mean " + this.fName + " started working over 80 years ago");
		} 
	}
        
        
	/**
         * Returns age of the instructor
         * @return age
         */
	public long getAgeInYears() {
		long age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
                return age;
	} 
        
        /**
         * Returns instructor's full address
         * @return street, city, postCode
         */
	public String getInstructorAddress() {
		return this.street + ", " + this.city + ", " + this.postCode;
	}
        
	/**
         * Changes address of the instructor to new address
         * @param newStreetAddress   - new street address of the instructor
         * @param newCity           - new city of the instructor
         * @param newPostCode     - new postal code of the instructor
         */
	public void changeAddress(String newStreetAddress, String newCity, String newPostCode) {
		this.street = newStreetAddress;
		this.city = newCity;
		this.postCode = newPostCode;
	} 
        
        /**
         * Returns total number instructor spent at the college
         * @return timeAtCollege
         */
	public long NoOfYearsAtCollege() {
		long timeAtCollege = ChronoUnit.YEARS.between(hireDate, LocalDate.now());

		return timeAtCollege;
	} 

	
	
} 