package swt.scrum.user.service;

import swt.scrum.user.domain.Member;
import swt.scrum.user.domain.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void addNewMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void removeMember(Member member) {
        memberRepository.delete(member);
    }
}
