package springstudy.firstproject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import springstudy.firstproject.domain.Member;
import springstudy.firstproject.domain.Order;
import springstudy.firstproject.policy.DiscountPolicy;
import springstudy.firstproject.repository.MemberRepository;

@AllArgsConstructor
@Getter // 테스트 용도
public class OrderServiceImpl implements OrderService{

    // final : 기본 or 생성자를 통해서 무조건 할당 필요
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
