package springstudy.firstproject.service;

import springstudy.firstproject.domain.Member;
import springstudy.firstproject.domain.Order;
import springstudy.firstproject.policy.DiscountPolicy;
import springstudy.firstproject.policy.FixDiscountPolicy;
import springstudy.firstproject.policy.RateDiscountPolicy;
import springstudy.firstproject.repository.MemberRepository;
import springstudy.firstproject.repository.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
