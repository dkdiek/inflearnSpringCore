package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * hello.core.singleton
 * StatefulServiceTest
 *
 * @author : K
 */

class StatefulServiceTest {
  
  @Test
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);
    
    int userAprice = statefulService1.order("userA", 10000);
    int userBprice = statefulService1.order("userB", 20000);
    
    // ThreadA: 사용자 A 주문 금액 조회
//    int price = statefulService1.getPrice();
    System.out.println("price = " + userAprice);
    
//    Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
  }
  
  static class TestConfig {
    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }
  }
  
}