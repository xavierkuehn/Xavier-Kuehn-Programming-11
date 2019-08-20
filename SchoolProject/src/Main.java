public class Main {
    public static void main(String[] args) {

        School school = new School("Vancouver High", 0, 0);

        //Instantiate students
        Student student1 = new Student("Andy", "Bernard", "8");
        school.addStudent(student1);
        Student student2 = new Student("Gabe", "Lewis", "8");
        school.addStudent(student2);
        Student student3 = new Student("Phyllis", "Vance", "9");
        school.addStudent(student3);
        Student student4 = new Student("Stanley", "Hudson", "9");
        school.addStudent(student4);
        Student student5 = new Student("Ryan", "Howard", "10");
        school.addStudent(student5);
        Student student6 = new Student("Kevin", "Malone", "10");
        school.addStudent(student6);
        Student student7 = new Student("Jim", "Halpert", "11");
        school.addStudent(student7);
        Student student8 = new Student("Pam", "Halpert", "11");
        school.addStudent(student8);
        Student student9 = new Student("Xavier", "Kuehn", "12");
        school.addStudent(student9);
        Student student10 = new Student("Dwight", "Shrute", "12");
        school.addStudent(student10);

        //Instantiate teachers
        Teacher teacher1 = new Teacher("Robert", "California", "Economics");
        school.addTeacher(teacher1);
        Teacher teacher2 = new Teacher("Michael", "Scott", "English");
        school.addTeacher(teacher2);
        Teacher teacher3 = new Teacher("Oscar", "Martinez", "Math");
        school.addTeacher(teacher3);

        //Print both lists
        System.out.println("Students:");
        school.showStudents();
        System.out.println();
        System.out.println("Teachers:");
        school.showTeachers();
        System.out.println();

        //Remove two students (Gabe and Ryan)
        school.deleteStudent(student2);
        school.deleteStudent(student5);

        //Remove one teacher (Oscar)
        school.deleteTeacher(teacher3);

        //Print both updated lists
        System.out.println("Students:");
        school.showStudents();
        System.out.println();
        System.out.println("Teachers:");
        school.showTeachers();
        System.out.println();
    }

}
