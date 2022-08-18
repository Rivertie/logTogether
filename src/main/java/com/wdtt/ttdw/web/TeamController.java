package com.wdtt.ttdw.web;

import com.wdtt.ttdw.entity.Member;
import com.wdtt.ttdw.entity.Team;
import com.wdtt.ttdw.entity.service.TeamService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Team 컨트롤러
 */
@Controller
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    /**
     * 팀 목록
     */
    @RequestMapping("/team")
    public String findTeam(Model model) {
        model.addAttribute("teams", teamService.findTeam());
        return "team/list";
    }

    /**
     * 팀 저장 폼
     */
    @RequestMapping("/team/form")
    public String createForm(Model model) {
        return "team/form";
    }

    /**
     * 팀 저장
     */
    @RequestMapping("/team/save")
    public String createTeam(Team team) {
        team.setName("test");
        teamService.createTeam(team);
        return "redirect:/team";
    }

    /**
     * 팀 수정
     */
    @RequestMapping("/team/update")
    public String updateTeam(Team team) {
        teamService.updateTeam(team);
        return "redirect:/team";
    }

    /**
     * 팀 삭제
     */
    @RequestMapping("/team/delete")
    public String deleteTeam(Team team) {
        teamService.deleteTeam(team);
        return "redirect:/team";
    }


}
