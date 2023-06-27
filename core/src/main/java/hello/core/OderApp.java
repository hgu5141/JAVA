package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.oder.Oder;
import hello.core.oder.OrderService;
import hello.core.oder.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OderApp {
    public static void main(String[] args) {
//        AppConfig appconfig = new AppConfig();
//        MemberService memberService = appconfig.memberService();
//        OrderService oderservice = appconfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Oder oder = orderService.createOder(memberId,  "itemA", 20000);
        System.out.println("oder = " + oder);
    }
}
