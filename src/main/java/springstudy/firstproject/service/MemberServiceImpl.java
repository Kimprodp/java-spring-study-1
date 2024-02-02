package springstudy.firstproject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import springstudy.firstproject.domain.Member;
import springstudy.firstproject.repository.MemberRepository;

@AllArgsConstructor
@Getter // 테스트 용도
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
