public class Point<T> {
  protected T x, y;
  public Point(T x, T y) {
      this.x = x;
      this.y = y;
  }
  T getX() { return x; }
  T getY() { return y; }
  public String toString() {
      return "(" + x.toString() + "," + y.toString() + ")";
  }
}

static int sqLength(Point<Integer> p) {
  int x = p.getX();
  int y = p.getY();
  return x * x + y * y;
}
int i = sqLength(new Point<Integer>(3, 4)); // i = 3*3 + 4*4 = 25

static double sqLength(Point<?> p) {
  Number n1 = (Number) p.getX(); // Needs cast to Number
  Number n2 = (Number) p.getY();
  double x = n1.doubleValue();
  double y = n2.doubleValue();
  return x * x + y * y;
}

//compare eployees by rank
public interface Comparable<T> {
  int compareTo(T o);
}

class Employee implements Comparable<Employee> {
  private int rank;
  private String name;
  public int compareTo(Employee e) {
      return this.rank - e.rank;
  }
  public Employee(String n, int r) {
      rank = r;
      name = n;
  }
  public String toString() {
      return name + " : " + rank;
  }
}


//find minimum in array
public MyClass
{
   public static <T extends Comparable<T>> T arrayMinimum(T[] anArray)
   {
      T minimum = anArray[0];
      for (T arrayEntry : anArray)
      {
         if (arrayEntry.compareTo(minimum) < 0)
            minimum = arrayEntry;
      } // end for

      return minimum;
   } // end arrayMinimum
   // . . .
} // end MyClass

