package springstudy.firstproject.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import springstudy.firstproject.domain.Member;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 실무에서는 동시성 이슈로 인하여 Concurrent 해시맵을 사용!

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
