import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAvFunktion {

    SchoolClass sc =  new SchoolClass();
    List<Student> klassEtt=new ArrayList<>();


    Course course = new Course();





    Teacher klas = new Teacher("klas", "klasse@themail.com", "jensÄrBäst!");
    Course matte = new Course("Matte");
    Student jenny = new Student("Jenny", "jennis@themail.com", "hästar123");
    Student lasse = new Student("janne", "hej@hej.se", "hejehe");
    SchoolClass ettan = new SchoolClass("Ettan", klas, klassEtt);

    void main(){
        System.out.println(klassEtt);
        System.out.println(ettan.getT());
//        System.out.println(klassEtt.size());
//        sc.addStudentToClass(jenny, klassEtt);
//        sc.addStudentToClass(lasse, klassEtt);

        ettan.addStudentToClass(jenny, klassEtt,"ettan");
        System.out.println(klassEtt.size());
        System.out.println(klassEtt);
//        sc.ettan.add(lasse);
//          sc.addStudentToClass(lasse, sc.getEttan());
//          sc.addStudentToClass(jenny, sc.getEttan());


//        sc.ettan.add(jenny);
//        System.out.println(sc.ettan);

//        lasse.viewGrades();

//        jenny.courses.add(matte);
//        klas.setGrades(jenny,"matte", "MVG");






    }
}
