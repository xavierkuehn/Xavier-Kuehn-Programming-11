import java.util.Random;

public class Student {

    //Student class has constructor, a random student number generator, print function
    //and getters and setters for all private fields

    private String firstName;
    private String lastName;
    private String grade;
    private int studentNumber;

    //Constructor fot student class with first name, last name, grade and student number field
    public Student (String firstName, String lastName, String grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;

        this.studentNumber = studentNumGen();
    }

    //Student number generator that uses Math.random to create random number then multiply it be 10000 to create a five
    //digit number for each instance created
    public int studentNumGen(){
        Random random = new Random(System.currentTimeMillis());
        return ((1 + random.nextInt(2)) * 10000 + random.nextInt(10000));
    }

    //Prints first name, last name and grade
    public void printStudent(Student student){
        System.out.println("Name: " + student.firstName + " " + student.lastName + ", Grade: " + student.grade);
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String newName){
        this.firstName = newName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String newName){
        this.lastName = newName;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String newGrade){
        this.grade = newGrade;
    }

    public int getStudentNumber(){
        return studentNumber;
    }

    public void setStudentNumber(){
        this.studentNumber = studentNumGen();
    }

}
