package springstudy.firstproject.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springstudy.firstproject.AppConfig;
import springstudy.firstproject.service.MemberService;

class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        // 조회 : SingletonService의 static 에서 인스턴스 생성 후 가져옴
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();


        // 참조값이 동일한 것을 확인
        System.out.println("singletonService1 = " + instance1);
        System.out.println("singletonService2 = " + instance2);

        assertThat(instance1).isSameAs(instance2);
        // same과 Equals 차이 참고 : https://velog.io/@0008mari/Java-equal%EA%B3%BC-%EC%9D%98-%EC%B0%A8%EC%9D%B4
    }
}
