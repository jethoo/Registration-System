
/**
 * @author Jeewan
 * CourseWithLab Class
 */
package registrationsystem;

//all the imports
import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseWithLab extends Course {
	private Instructor labTeacher;
	private String Room;
	private DayOfWeek Day;
	private LocalTime StartTime;

	/**
         * Constructor to create course with lab also extends Course 
         * This constructor does not contain preRequired course
         * 
         * @param Teacher           - Teacher of the course
         * @param courseCode        - code of the course
         * @param courseName        - name of the course
         * @param classRoom         - room of the class
         * @param classDay          - day of the class
         * @param startTime         - starting time of the class
         * @param maximumStudents   - maximum students allowed in the course
         * @param labTeacher        - teacher for lab
         * @param Room              - class room for lab 
         * @param Day               - day of lab
         * @param StartTime         - starting time for lab
         */
	public CourseWithLab(Instructor Teacher, String courseCode, String courseName, String classRoom, DayOfWeek classDay,
			LocalTime startTime, int maximumStudents, Instructor labTeacher, String Room, DayOfWeek Day,
			LocalTime StartTime) {
		super(Teacher, courseCode, courseName, classRoom, classDay, startTime, maximumStudents);

		checkLabTech(labTeacher);    //validates the qualification of lab teacher
                checkLabStartTime(StartTime); //validates the starting time for lab
		this.Room = Room;
		this.Day = Day;
		
	} // End of first constructor
        
	/**
         * Constructor to create lab course with preRequired course
         * @param Teacher
         * @param courseCode
         * @param courseName
         * @param classRoom
         * @param classDay
         * @param startTime
         * @param maximumStudents
         * @param preRequired
         * @param labTeacher
         * @param labRoom
         * @param labDay
         * @param StartTime 
         */
	public CourseWithLab(Instructor Teacher, String courseCode, String courseName, String classRoom, DayOfWeek classDay,
			LocalTime startTime, int maximumStudents, String preRequired, Instructor labTeacher, String labRoom, DayOfWeek labDay,
			LocalTime StartTime) {
		super(Teacher, courseCode, courseName, classRoom, classDay, startTime, maximumStudents);
                
                checkLabTech(labTeacher);    //validates the qualification of lab teacher
                checkLabStartTime(StartTime); //validates the starting time for lab
		
		this.Room = Room;
		this.Day = Day;
		this.preRequired = preRequired;
                
	} // End of second constructor

	/**
         * Returns course details
         * @return 
         */
	@Override
	public String toString() {
		return super.toString() + " with lab";
	} 
        
        /**
         * Checks if the lab teacher is qualified or not
         * @param labTeacher 
         */
	public void checkLabTech(Instructor labTeacher) {
		if (labTeacher.InstructorcanTeach(this.courseCode + "-LAB")){
                        this.labTeacher = labTeacher;
                }
		else {
			throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
		} 
	} 
        
        /**
         * Method to return teacher of the lab course
         * @return labTeacher
         */
	public Instructor getLabTech() {
		return labTeacher;
	}
        
	/**
         * Checks if the lab start time is correct
         * @param startTime 
         */
	public void checkLabStartTime(LocalTime startTime) {
		if (startTime.isAfter(LocalTime.of(7, 59)) && startTime.isBefore(LocalTime.of(16, 1))) {
			this.startTime = startTime;
		} else {
			this.startTime = LocalTime.of(8, 0);
			throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
		} 
	} 

	
        /**
         * Method to return starting time for lab
         * @return startTime
         */
	public LocalTime getLabStartTime() {
		return StartTime;
	}

	/**
         * Returns lab class time and day
         * @return 
         */
	public String getLabClassAndTime() {
		return "room: " + this.Room + ", " + this.Day.toString() + " starting at " + this.startTime();
	} 
} 