package springstudy.firstproject.policy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springstudy.firstproject.annotation.MainDiscountPolicy;
import springstudy.firstproject.domain.Grade;
import springstudy.firstproject.domain.Member;

@Component
//@Primary
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
