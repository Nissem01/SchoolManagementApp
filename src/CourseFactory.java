public class CourseFactory {

    public static Course createCourse(String courseName, Teacher teacher) {
        Course course = new Course(courseName);
        course.setTeacher(teacher);
        return course;
    }

}
