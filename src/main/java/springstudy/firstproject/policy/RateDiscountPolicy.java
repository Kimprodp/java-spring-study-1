package springstudy.firstproject.policy;

import org.springframework.stereotype.Component;
import springstudy.firstproject.domain.Grade;
import springstudy.firstproject.domain.Member;

@Component
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
