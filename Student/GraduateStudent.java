package Question3;
public class GraduateStudent extends Student {
  public GraduateStudent(String studentID, String lastName) {
      super(studentID, lastName);
      setTuition();
  }

  @Override
  public void setTuition() {
      this.tuition = 6000;
  }
}
