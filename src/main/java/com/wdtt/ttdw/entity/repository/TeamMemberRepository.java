package com.wdtt.ttdw.entity.repository;

import com.wdtt.ttdw.entity.Member;
import com.wdtt.ttdw.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TeamMemberRepository extends JpaRepository<Member, Long> {
}
