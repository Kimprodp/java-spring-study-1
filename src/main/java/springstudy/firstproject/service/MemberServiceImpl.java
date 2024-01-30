package springstudy.firstproject.service;

import springstudy.firstproject.domain.Member;
import springstudy.firstproject.repository.MemberRepository;
import springstudy.firstproject.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
