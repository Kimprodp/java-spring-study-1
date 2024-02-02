package springstudy.firstproject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springstudy.firstproject.domain.Member;
import springstudy.firstproject.repository.MemberRepository;

@Component
@AllArgsConstructor
@Getter // 테스트 용도
public class MemberServiceImpl implements MemberService{

    @Autowired // 해당 타입과 동일한 타입의 빈을 찾아 주입
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
