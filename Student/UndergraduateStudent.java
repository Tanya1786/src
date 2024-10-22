package Question3;

public class UndergraduateStudent extends Student {
  public UndergraduateStudent(String studentID, String lastName) {
      super(studentID, lastName);
      setTuition();
  }

  @Override
  public void setTuition() {
      this.tuition = 4000;
  }
}
