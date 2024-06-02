package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

/**
 * hello.core.autowired
 * AutowiredTest
 *
 * @author : K
 */
public class AutowiredTest {
  
  @Test
  void AutowiredOption() {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
  }
  
  static class TestBean{
    @Autowired(required = false)
    public void setNoBean1(Member noBean1) {
      System.out.println(noBean1);
    }
    
    @Autowired
    public void setNoBean2(@Nullable Member noBean1) {
      System.out.println(noBean1);
    }
    
    @Autowired
    public void setNoBean3(Optional<Member> noBean3) {
      System.out.println(noBean3);
    }
  }
  
  
}
