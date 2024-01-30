package springstudy.firstproject;

import springstudy.firstproject.domain.Grade;
import springstudy.firstproject.domain.Member;
import springstudy.firstproject.service.MemberService;
import springstudy.firstproject.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) { // PSVM
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "Kim", Grade.VIP); // 변수 자동 지정 단축키 : 컨트롤+알트+V
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member.toString());
        System.out.println(findMember.toString());
    }
}
