package yitian.study;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface MyConfig extends Config {
  int port();

  String username();

  String password();

  @Key("shit.foo.bar")
  String fooBar();
}
