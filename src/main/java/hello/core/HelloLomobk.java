package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * hello.core
 * HelloLomobk
 *
 * @author : K
 */

@Getter
@Setter
@ToString
public class HelloLomobk {
  private String name;
  private int age;
  
  public static void main(String[] args) {
    HelloLomobk helloLomobk;
  }
}
