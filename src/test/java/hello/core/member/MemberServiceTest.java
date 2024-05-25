package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * hello.core.member
 * MemberServiceTest
 *
 * @author : K
 */
@SpringBootTest
class MemberServiceTest {
  
  MemberService memberService = new MemberServiceImpl();
  
  @Test
  void join () throws Exception {
    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);
    Member findMember = memberService.findMember(1L);
    Assertions.assertThat(member).isEqualTo((findMember));
  }
  
}