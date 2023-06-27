package hello.core.member;

import hello.core.member.Member;
import hello.core.member.MemberMemberRepository;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;

public class MemberServiceImpl implements MemberService {

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
