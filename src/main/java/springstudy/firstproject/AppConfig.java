package springstudy.firstproject;

import springstudy.firstproject.policy.FixDiscountPolicy;
import springstudy.firstproject.repository.MemoryMemberRepository;
import springstudy.firstproject.service.MemberService;
import springstudy.firstproject.service.MemberServiceImpl;
import springstudy.firstproject.service.OrderService;
import springstudy.firstproject.service.OrderServiceImpl;

public class AppConfig {

    // 역할에 대한 기능을 수행하는 구현체에 대한 설정을 해당 클래스에서 진행

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
