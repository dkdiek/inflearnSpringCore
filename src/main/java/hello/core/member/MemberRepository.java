package hello.core.member;

/**
 * hello.core.member
 * MemberRepository
 *
 * @author : K
 */
public interface MemberRepository {
  
  void save(Member member);
  
  Member findById(Long memberId);
}
