import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAvFunktion {


    void main(){

        SchoolClass year1 = new SchoolClass("Årskurs 1");
        SchoolClass year2 = new SchoolClass("Årskurs 2");


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

        year2.addStudent(george);

        for (Student student : year1.getStudents()){
            System.out.println(student);
        }


        idrott.setTeacher(samme);

        matte.setGrades(janne, 5);
        engelska.setGrades(janne, 4);
        System.out.println(matte.getGrades(janne));

        for (Course c : klas.getCourses()){
            System.out.println(c);
        }












    }
}
