package swt.scrum.user.service;

import swt.scrum.user.domain.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();

    void addNewMember(Member member);

    void removeMember(Member member);

}
