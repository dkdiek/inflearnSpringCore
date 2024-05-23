package hello.core.member;

/**
 * hello.core.member
 * MemberService
 *
 * @author : K
 */
public interface MemberService {
  
  void join(Member member);
  
  Member findMember(Long meberId);
}
