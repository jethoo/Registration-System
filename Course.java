/**
 * 
 * @author Jeewan
 * 
 * Course Class
 */

package registrationsystem;

//all the imports
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;


public class Course {
	private Instructor Teacher;
	protected String courseCode;
	protected String preRequired;
	private String courseName;
	private String classRoom;
        
        //arraylist to store students
	private ArrayList<Student> classList = new ArrayList<>();
        //maximum students allowed in the course
	private int maximumStudents;
        //total students enrolled in the course
        private int enrolledStudents;
        //boolean value to check if class is full or not
	private boolean classIsFull;
        
	private DayOfWeek classDay;
	protected LocalTime startTime;

	
	 /**
          * Constructor to create Course object without prerequisite course
          * @param Teacher          - Teacher of the course
          * @param courseCode       - code of the course
          * @param courseName       - name of the course
          * @param classRoom        - class room for the course
          * @param classDay         - day when class takes place
          * @param startTime        - startTime of the class
          * @param maximumStudents  - maximum students allowed in the class
          */
	public Course(Instructor Teacher, String courseCode, String courseName, String classRoom, DayOfWeek classDay,
			LocalTime startTime, int maximumStudents) {
		
                this.courseCode = courseCode;
                checkTeacher(Teacher);       //input validation to check if teacher is qualified enough
                checkTime(startTime);     //validates starting time 
		setClassSize(maximumStudents); //validates maximum student allowed
                
                this.courseName = courseName;
		this.classRoom = classRoom;
		this.classDay = classDay;
		
		
	} // End of first constructor 

	/**
         * Constructor to create Course object with prerequisite course
         * @param Teacher
         * @param courseCode
         * @param courseName
         * @param room
         * @param classDay
         * @param startTime
         * @param maxStudents
         * @param preRequired   -preRequired course
         */
	public Course(Instructor Teacher, String courseCode, String courseName, String classRoom, DayOfWeek classDay,
			LocalTime startTime, int maximumStudents, String preRequired) {
		
                this.courseCode = courseCode;
		checkTeacher(Teacher);       //input validation to check if teacher is qualified enough
                checkTime(startTime);     //validates starting time 
                setClassSize(maximumStudents);
                
		this.courseName = courseName;
		this.classRoom = classRoom;
		this.classDay = classDay;
                this.preRequired = preRequired;
                
	} // End of second constructor
        
        
        /**
         * Returns coureDetails with code and name of the course
         * @return courseCode, courseName
         */
        @Override
	public String toString() {
		return courseCode + "-" + courseName;
	} 
        
        /**
         * Returns starting time of the class
         * @return startTime
         */
	public LocalTime startTime() {
		return startTime;
	}
        
        
	/**
         * Method to check maximum number of students for the class
         * @param maximumStudents
         * @return String
         */
	public String setClassSize(int maximumStudents) {
		if (maximumStudents < 41) {
			this.maximumStudents = maximumStudents;
			return "Class size was set to " + maximumStudents;
		} else {
			this.maximumStudents = 40;
			return "Max class size = 40, it has been set to 40";
		}
	}
        
        /**
         * Method to check if starting time for the course is valid
         * If valid, assigns @param to startTime
         * @param startTime
         */
	public void checkTime(LocalTime startTime) {
		if (startTime.isAfter(LocalTime.of(7, 59)) && startTime.isBefore(LocalTime.of(16, 1))) {
			this.startTime = startTime;
		} else {
			this.startTime = LocalTime.of(8, 0);
			throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
		} 
	} 

	/**
         * Method to check if teacher is qualified
         * If qualified assigns @param to Teacher
         * @param Teacher 
         */
	public void checkTeacher(Instructor Teacher) {
		if (Teacher.InstructorcanTeach(this.courseCode)){
                        this.Teacher = Teacher;
                }
                else {
                    throw new IllegalArgumentException("Professor " + Teacher.toString() + " is not qualified to teach " + this.courseCode);
		} 
	} 

        
        /**
         * Returns maximum students in the course
         * @return maximumStudents
         */
	public int getClassSize() {
		return this.maximumStudents;
	}

	/**
         * Returns day of the week when class takes place
         * @return classDay
         */
	public String getDayOfCourse() {
		return classDay.name();
	}

	/**
         * Returns classRoom for the course
         * @return classRoom
         */
	public String getClassRoom() {
		return this.classRoom;
	}

	/**
         * Method to add Student in the course
         * @param student
         * @return 
         */
	public String addStudent(Student student) {
		if (student.StudentInGoodStanding()) {
                    if (!this.classIsFull) {
			if (this.preRequired != null) {  // there is prerequired course 
                            if (student.getCoursesCompleted().contains(this.preRequired)) { 
                                    this.classList.add(student); //adds student to the course list
                                    this.enrolledStudents++; 
					if (this.enrolledStudents == this.maximumStudents){
                                                this.classIsFull = true;
                                            }
						return "Student was added to the course.";
					} else{
                                                return "Student has not completed the prerequisite course: " + this.checkPrerequisite();
                                              }
						
				} // end of checking if preRequired is null or not
				else { 
					this.classList.add(student); 
					this.enrolledStudents++; 
					if (this.enrolledStudents == this.maximumStudents){
                                                this.classIsFull = true;
                                        }
                                    return "Student was added to the course";
				} // if prerequired student is added
			} // end of checking if class is full or not
                        else{
                            return "Student was not added because the course is full";
                        } 
				
		} // end of checking if student is in good standing or not
                else{
                    return "The Student is not in good standing and cannot join the course.";
                }
        } // End of addStudent

	/**
         * Returns the class list 
         * @return list
         */
	public String displayTheClassList() {
		String list = "";
		for (int i = 0; i < this.classList.size(); i++) {
			list = list + this.classList.get(i).toString();
			// Add a new-line when the loop is about to end
			if (!(i == this.classList.size() - 1))
				list += "\n";
		}
		return list;
	} 

	

	/**
         * Returns instructor of the course
         * @return Teacher
         */
	public Instructor getInstructorToTeach() {
		return this.Teacher;
	}

	/**
         * Returns date and time of the course
         * @return classDay, startTime
         */
	public String getCourseDayAndTime() {
		return this.classDay + "'s, starting at " + this.startTime.toString();
	} 

	/**
         * 
         * @return 
         */
	public boolean matureClass() {
		long totalAge = 0;
                long average = 0;
		
		for (int i = 0; i < this.classList.size(); i++) {
			totalAge = totalAge + classList.get(i).getStudentAge();
		} 
			
		average = totalAge / this.enrolledStudents;

		if (average > 25){
                    return true;
                }else{
                    return false;
                }
          }

        /**
         * Returns the preRequired course
         * 
         * @return preRequired
         */
	
	public String checkPrerequisite() {
		return preRequired;
	}
} 