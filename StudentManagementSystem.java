import java.util.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManagement s = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        int ch=0;
        while(ch != 6){
            
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student");
            System.out.println("3. Display all students");
            System.out.println("4. Edit a student");
            System.out.println("5. Remove a student entry");
            System.out.println("6. Exit");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            switch(ch){
                case 1: System.out.print("Rollno:");
                        int rollno = sc.nextInt();
                        System.out.print("Name:");
                        String name = sc.next();
                        System.out.print("Grade:");
                        String grade = sc.next();
                        System.out.print("phone:");
                        long phone = sc.nextLong();
                        s.addStudent(rollno, name, grade, phone);
                        break;
                case 2: System.out.print("Enter the student's rollno:");
                        Student stdFound = s.findStudent(sc.nextInt());
                        if(stdFound != null){
                            System.out.println("Found student " + stdFound.name);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                case 3: s.displayStudents();
                        break;
                case 4: System.out.print("Rollno:");
                        int rol = sc.nextInt();
                        System.out.print("Name:");
                        String Name = sc.next();
                        System.out.print("Grade:");
                        String Grade = sc.next();
                        System.out.print("phone:");
                        long Phone = sc.nextLong();
                        s.editStudent(rol, Name, Grade, Phone);
                        break;
                case 5: Student s1 = new Student();
                        System.out.println("Enter rollno:");
                        int Rollno = sc.nextInt();
                        s1.remove(Rollno);
                        break;
                case 6: System.out.println("Exiting...");
                        break;
                default: System.out.println("Invalid choice!");
            }
        }
        sc.close(); 
    }
    
}
class Student{
    String name;
    int rollno;
    String grade;
    long phone;
    void add(String name, int rollno,String grade,long phone){
        this.name = name;
        this.rollno = rollno;
        this.grade = grade;
        this.phone = phone;
    }
    int remove(int rollno){
        int print = rollno;
        this.name=null;
        this.grade=null;
        this.phone = 0;
        this.rollno=0;
        return print;
    }

}

class StudentManagement{
    private Map<Integer, Student> students;
    public StudentManagement(){
        students = new HashMap<>();
    }

    public void addStudent(int rollno, String name, String grade, long phone){
        Student student = new Student();
        student.add(name, rollno, grade, phone);
        students.put(rollno, student);
    }
    public Student findStudent(int rollno){
        return students.get(rollno);
    }
    public void displayStudents(){
        if(!students.isEmpty()){
            System.out.println("All students:");
            System.out.println("Rollno \t Name \t Grade \t Phone");
            for(Map.Entry<Integer, Student> entry : students.entrySet()){
                Student student = entry.getValue();
                System.out.println(student.rollno + " \t" + student.name + " \t" + student.grade + " \t" + student.phone);
            }
        } else{
            System.out.println("No student record!");
        }
    }
    public void editStudent(int rollno, String newName, String newGrade, long newPhone){
        Student student = students.get(rollno);
        if(student != null){
            student.name = newName;
            student.grade = newGrade;
            student.phone = newPhone;
            System.out.println("Student edited");
        } else{ 
            System.out.println("Student not found!");
        }
    }
}
