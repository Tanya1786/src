package Question3;

public class StudentDemo {
  public static void main(String[] args) {
      Student[] students = {
          new UndergraduateStudent("U1001", "Smith"),
          new GraduateStudent("G1002", "Jones"),
          new StudentAtLarge("S1003", "Taylor"),
          new UndergraduateStudent("U1004", "Davis"),
          new GraduateStudent("G1005", "Brown"),
          new StudentAtLarge("S1006", "Johnson")
      };

      for (Student student : students) {
          System.out.println("Student ID: " + student.getStudentID() + ", Name: " + student.getLastName() + ", Tuition: $" + student.getTuition());
      }
  }
}
