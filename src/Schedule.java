public class Schedule {

    private String day;
    private String startTime;
    private String endTime;
    private Course course;

    public Schedule(String day, String startTime, String endTime, Course course){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
    }

    public String getDay(){
        return day;
    }

    public String getStartTime(){
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }

    public Course getCourse(){
        return course;
    }
}
