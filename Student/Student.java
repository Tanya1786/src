package Question3;

public abstract class Student {
  private String studentID;
  private String lastName;
  protected double tuition;

  public Student(String studentID, String lastName) {
      this.studentID = studentID;
      this.lastName = lastName;
  }

  public String getStudentID() {
      return studentID;
  }
  public void setStudentID(String studentID) {
      this.studentID = studentID;
  }
  public String getLastName() {
      return lastName;
  }
  public void setLastName(String lastName) {
      this.lastName = lastName;
  }
  public double getTuition() {
      return tuition;
  }
  public abstract void setTuition();
}
