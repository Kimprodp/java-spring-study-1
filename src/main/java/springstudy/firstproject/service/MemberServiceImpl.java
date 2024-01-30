package springstudy.firstproject.service;

import lombok.AllArgsConstructor;
import springstudy.firstproject.domain.Member;
import springstudy.firstproject.repository.MemberRepository;

@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
