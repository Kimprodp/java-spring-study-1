package springstudy.firstproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import springstudy.firstproject.domain.Grade;
import springstudy.firstproject.domain.Member;
import springstudy.firstproject.domain.Order;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Member member = new Member(1L, "Kim", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}