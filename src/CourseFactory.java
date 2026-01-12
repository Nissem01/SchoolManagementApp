
public class CourseFactory {

    public static Course createCourse(CourseType courseType, Teacher teacher, SchoolClass schoolClass) {
        Course course = new Course(courseType);
        course.setTeacher(teacher);
        schoolClass.addCourse(course);
        return course;
    }
}
