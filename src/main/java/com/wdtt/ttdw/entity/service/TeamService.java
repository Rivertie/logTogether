package com.wdtt.ttdw.entity.service;

import com.wdtt.ttdw.entity.Notice;
import com.wdtt.ttdw.entity.Team;
import com.wdtt.ttdw.entity.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Team 서비스를 처리합니다.
 */
@Service
public class TeamService {

    private TeamRepository teamRepositiory;

    public TeamService(TeamRepository teamRepositiory) {
        this.teamRepositiory = teamRepositiory;
    }

    public List<Team> findTeam() {
        return teamRepositiory.findAll();
    }

    public void createTeam(Team team) {
        teamRepositiory.save(team);
    }

    public void updateTeam(Team team) {
        teamRepositiory.save(team);
    }

    public void deleteTeam(Team team) {
        teamRepositiory.delete(team);
    }
}
