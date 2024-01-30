package springstudy.firstproject.repository;

import springstudy.firstproject.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
