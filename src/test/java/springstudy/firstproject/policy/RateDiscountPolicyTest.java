package springstudy.firstproject.policy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springstudy.firstproject.domain.Grade;
import springstudy.firstproject.domain.Member;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void discount_VIP() {
        //given
        Member member = new Member(1L, "Kim", Grade.VIP);

        //when
        int discountPrice = discountPolicy.discount(member, 10000);

        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void discount_Basic() {
        //given
        Member member = new Member(1L, "Kim", Grade.BASIC);

        //when
        int discountPrice = discountPolicy.discount(member, 10000);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}