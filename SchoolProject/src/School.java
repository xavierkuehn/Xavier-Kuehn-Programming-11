import java.util.ArrayList;

public class School {

    //School class has constructor, print function, add and delete teacher methods,
    //add and delete student methods and getters and setters for all private fields

    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> courses = new ArrayList<>();

    private String name;
    private int numberOfStudents;
    private int numberOfTeachers;

    //Constructor for School class with name, number of students and number of teachers field
    public School(String name, int numberOfStudents, int numberOfTeachers){
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.numberOfTeachers = numberOfTeachers;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    public void setNumberOfStudents(int newNum){
        this.numberOfStudents = newNum;
    }

    public int getNumberOfTeachers(){
        return numberOfTeachers;
    }

    public void setNumberOfTeachers(int newNum){
        this.numberOfTeachers = newNum;
    }

    //Adds teacher to teacher array list
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //Deletes teacher from array list
    public void deleteTeacher(Teacher teacher){
        teachers.remove(teacher);
    }

    //Adds student to student array list
    public void addStudent(Student student){
        students.add(student);
    }

    //Deletes student from student array list
    public void deleteStudent(Student student){
        students.remove(student);
    }

    //Loops through teachers array list and uses print teacher method from Teacher class
    public void showTeachers(){
        for(int i = 0; i < teachers.size(); i++){
            teachers.get(i).printTeacher(teachers.get(i));
        }
    }

    //Loops through students array list and uses print student method from Student class
    public void showStudents(){
        for(int i = 0; i < students.size(); i++){
            students.get(i).printStudent(students.get(i));
        }
    }

}
