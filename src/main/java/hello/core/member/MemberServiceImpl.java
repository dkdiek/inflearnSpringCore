package hello.core.member;

/**
 * hello.core.member
 * MemberServiceImpl
 *
 * @author : K
 */
public class MemberServiceImpl implements MemberService{
  
  private final MemberRepository memberRepository = new MemberRepositoryImpl();
  
  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }
  
  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
