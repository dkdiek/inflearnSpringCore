package hello.core.dicsount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
  
  private int discountFixAmount = 1000;
  
  @Override
  public int discount(Member member, int price) {
    //enum 타입은 ==쓰는게 맞다
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }
    return 0;
  }
  
}
