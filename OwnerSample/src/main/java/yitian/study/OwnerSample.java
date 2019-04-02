package yitian.study;

import org.aeonbits.owner.ConfigFactory;

public class OwnerSample {
  public static void main(String[] args) {
    MyConfig config = ConfigFactory.create(MyConfig.class);
    System.out.println("Username:" + config.username());
    System.out.println("Password:" + config.password());
    System.out.println("Port:" + config.port());
    System.out.println("FooBar:" + config.fooBar());
  }
}
