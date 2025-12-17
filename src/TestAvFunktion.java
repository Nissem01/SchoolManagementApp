import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAvFunktion {
    SchoolClass s;

    void main(){


//        List<Student> students = s.getStudents();
//        List<Student>ys1 = new ArrayList<>();
//        List<Course>yc1 = new ArrayList<>();
        SchoolClass year1 = new SchoolClass("Årskurs 1");
//        SchoolClass year2 = new SchoolClass("Årskurs 2");


        Teacher klas = new Teacher("klas", "klasse@themail.com", "jensÄrBäst!");
        Teacher samme = new Teacher("Samme", "sampaboi@grus.se", "F0tBaLLisLaJF2k7");

        Course matte = new Course("Matte", klas);
        Course engelska = new Course("Engelska", klas);
        Course idrott = new Course("Idrott");

        Student jenny = new Student("Jenny", "jennis@themail.com", "hästar123");
        Student janne = new Student("janne", "hej@hej.se", "hejehe");
        Student ludde = new Student("Ludde", "dsad@hej.se", "hej");
        Student george = new Student("George", "gegge@yesmail.com", "hampa");


        year1.addStudent(janne);
        year1.addStudent(jenny);
        year1.addStudent(ludde);
        year1.addCourse(engelska);
        year1.addCourse(idrott);
        year1.addCourse(matte);


//        ludde.viewGrades();


//        year2.addStudent(george);

        for (Student student : year1.getStudents()){
            System.out.println(student);
        }


        idrott.setTeacher(samme);

        matte.setGrades(janne, 5);
        engelska.setGrades(janne, 4);
        System.out.println(matte.getGrades(janne));

        for (Course c : klas.getCourses()){
//            System.out.println(c);
//            System.out.println(c.getGrades(janne));
        }

        for (Course c : year1.getCourses()){
            if(c.getGrades(janne) == null){
                String s = "finns ej";
                System.out.println(s);

            } else  {
                System.out.println(c.getGrades(janne));
            }
//            System.out.println(c);

        }
        System.out.println(janne.getSchoolClass().toString());
        if(janne.getSchoolClass().equals(year1)){
            System.out.println("japp");
        }else {
            System.out.println("ej");
        }














    }
}
