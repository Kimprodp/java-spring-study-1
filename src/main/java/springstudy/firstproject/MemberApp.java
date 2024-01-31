package springstudy.firstproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springstudy.firstproject.domain.Grade;
import springstudy.firstproject.domain.Member;
import springstudy.firstproject.service.MemberService;
import springstudy.firstproject.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) { // PSVM
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // ApplicationContext : 스프링 컨테이너
        // 기존에는 개발자가 AppConfig를 사용해서 직접 객체를 사용하고 DI를 했지만, 스프링 컨테이너를 통해서 사용 가능
        // 스프링 컨테이너는 @Configuration이 붙은 AppConfig를 설정(구성) 정보로 사용
        // @Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록 -> 컨테이너에 등록된 객체를 스프링 빈이라 함
        // 스프링 컨테이너를 통해 필요한 스프링 빈(객체)를 찾아서 사용 가능(applicationContext.getBean() 메서드 사용)
        // 스프링 빈 이름의 디폴트 값은 메서드명으로 사용함

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "Kim", Grade.VIP); // 변수 자동 지정 단축키 : 컨트롤+알트+V
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.toString());
        System.out.println(findMember.toString());
    }
}
