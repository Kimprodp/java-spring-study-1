package springstudy.firstproject.singleton;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springstudy.firstproject.AppConfig;
import springstudy.firstproject.repository.MemberRepository;
import springstudy.firstproject.service.MemberServiceImpl;
import springstudy.firstproject.service.OrderServiceImpl;

class ConfigurationSingletonTest {

    @Test
    void configurationSingletonTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberServiceImpl = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderServiceImpl = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepository2 = memberServiceImpl.getMemberRepository();
        MemberRepository memberRepository3 = orderServiceImpl.getMemberRepository();


        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository3 = " + memberRepository3);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository1).isSameAs(memberRepository3);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
