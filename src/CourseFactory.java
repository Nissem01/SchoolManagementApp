
public class CourseFactory {

    public static Course createCourse(String courseName, Teacher teacher, SchoolClass schoolClass) {
        Course course = new Course(courseName);
        course.setTeacher(teacher);
        schoolClass.addCourse(course);
        return course;
    }

}
