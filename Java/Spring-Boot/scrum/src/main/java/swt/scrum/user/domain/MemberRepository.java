package swt.scrum.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import swt.scrum.project.domain.Project;

public interface MemberRepository extends JpaRepository<Member, Project> {
}
