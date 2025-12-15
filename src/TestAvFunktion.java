public class TestAvFunktion {


    Teacher klas = new Teacher("klas", "klasse@themail.com", "jensÄrBäst!");
    Course matte = new Course("Matte");
    Student jenny = new Student("Jenny", "jennis@themail.com", "hästar123");


    void main(){

        jenny.courses.add(matte);
        klas.setGrades(jenny,"matte", "MVG");






    }
}
