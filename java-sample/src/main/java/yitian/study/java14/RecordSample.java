package yitian.study.java14;

public class RecordSample {
  public static void main(String[] args) {
    System.out.println(new Person("张", "三"));
  }
}

record Person(String firstName, String lastName) {

}