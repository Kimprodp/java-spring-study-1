package springstudy.firstproject.service;

import springstudy.firstproject.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
