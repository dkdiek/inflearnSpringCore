package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * hello.core.beanfind
 * ApplicationContextExtendsFindTest
 *
 * @author : K
 */
public class ApplicationContextExtendsFindTest {
  
  AnnotationConfigApplicationContext ac = new
          AnnotationConfigApplicationContext(TestConfig.class);
  
//  @Test
//  @DisplayName("부모 타입으로 조회, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
//  void findBeanByParentTypeDuplicate() {
//    DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
//    assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
//  }
  @Test
  @DisplayName("이름으로 조회")
  void findBeanByParentTypeBeanName() {
    DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
    assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
  }
  
  @Test
  @DisplayName("구체 타입으로 조회")
  void findBeanBySubType() {
    DiscountPolicy rateDiscountPolicy = ac.getBean(RateDiscountPolicy.class);
    assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
  }
  
  @Test
  @DisplayName("부모 타입으로 모두 조회하기")
  void findAllBeanByParentType() {
    Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
    assertThat(beansOfType.size()).isEqualTo(2);
    for (String s : beansOfType.keySet()) {
      System.out.println(s + beansOfType.get(s));
    }
  }
  
  @Test
  @DisplayName("부모 타입으로 모두 조회하기 - Object, 스프링 내부 빈까지 다 출력된다")
  void findAllBeanByObjectType() {
    Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
    for (String s : beansOfType.keySet()) {
      System.out.println(s + beansOfType.get(s));
    }
  }
  
  @Configuration
  static class TestConfig{
    @Bean
    public DiscountPolicy rateDiscountPolicy() {
      return new RateDiscountPolicy();
    }
    
    @Bean
    public DiscountPolicy fixDiscountPolicy() {
      return new FixDiscountPolicy();
    }
    
  }
}
