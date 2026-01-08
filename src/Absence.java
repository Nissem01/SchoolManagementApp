import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class Absence {

    private static HashMap<Student, List<String>> absenceByStudent = new HashMap<>();

    public void reportAbsence (Student student, String day){
        day = day.trim();
        day = day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase();

        absenceByStudent.putIfAbsent(student, new ArrayList<>());

        if (!absenceByStudent.get(student).contains(day)){
            absenceByStudent.get(student).add(day);
        }
    }

    public List<String> getAbsenceDays(Student student){
        if(absenceByStudent.containsKey(student)) {
            return absenceByStudent.get(student);
        } else{
            return new ArrayList<>();
        }
    }

    public HashMap<String, List<Student>> getAbsenceByDayForStudents(List<Student> students) {
        HashMap<String, List<Student>> result = new HashMap<>();

        for (Student s : students) {
            List<String> days = getAbsenceDays(s);
            for (String day : days){
                day = day.trim();
                day = day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase();
                result.putIfAbsent(day, new ArrayList<>());

                if (!result.get(day).contains(s)) {
                    result.get(day).add(s);
                }
            }
        }
        return result;
    }
}
