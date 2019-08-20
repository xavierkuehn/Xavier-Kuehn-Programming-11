public class Teacher {

    //Teacher class has constructor, print function and getters and setters for all private fields

    private String firstName;
    private String lastName;
    private String subject;

    //Constructor for Teacher class with first name, last name and subject
    public Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    //Prints first name, last name and student
    public void printTeacher(Teacher teacher){
        System.out.println("Name: " + teacher.firstName + " " + teacher.lastName + ", Subject: " + teacher.subject);
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String newLastName){
        this.firstName = newLastName;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String newSubject){
        this.subject = newSubject;
    }

}
