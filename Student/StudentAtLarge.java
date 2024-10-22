package Question3;

public class StudentAtLarge extends Student {
  public StudentAtLarge(String studentID, String lastName) {
      super(studentID, lastName);
      setTuition();
  }

  @Override
  public void setTuition() {
      this.tuition = 2000;
  }
}
