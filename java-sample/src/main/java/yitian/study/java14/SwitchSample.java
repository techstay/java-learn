package yitian.study.java14;

public class SwitchSample {
  public static void main(String[] args) {
    var score = 70;
    System.out.println(switch (score / 10) {
      case 0, 1, 2, 3, 4, 5 -> "差劲";
      case 6, 7 -> "一般";
      case 8, 9 -> "优秀";
      case 10 -> "完美";
      default -> throw new RuntimeException("参数应该是0-100间的整数");
    });
  }
}
