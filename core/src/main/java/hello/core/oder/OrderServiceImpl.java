package hello.core.oder;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberMemberRepository;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Oder createOder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Oder(memberId, itemName, itemPrice, discountPrice);
    }
}
