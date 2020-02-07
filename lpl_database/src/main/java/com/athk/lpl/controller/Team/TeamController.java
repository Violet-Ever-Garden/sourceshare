package com.athk.lpl.controller.Team;

import com.athk.lpl.Entity.ListMap;
import com.athk.lpl.Entity.team;
import com.athk.lpl.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TeamController {
    @Autowired
    TeamMapper teamMapper;

    @GetMapping("/allteam")
    public ListMap getAllTeam(){
        return new ListMap(teamMapper.getallteam());
    }

    @GetMapping("/team/{tname}")
    public team getTeam(String tname){
        return teamMapper.getteamByName(tname);
    }

    @GetMapping("/team")
    public team insertTeam(team team){
        teamMapper.insertteam(team);
        return team;
    }

    @GetMapping("/team/{tname}/{location}")
    public String  updateTeam(String location,String tname){
        teamMapper.updateteam(location,tname);
        return location;
    }

    @GetMapping("/team/delete/{tname}")
    public team deleteTeam(String tname){
        team team = teamMapper.getteamByName(tname);
        if(team==null) return null;
        teamMapper.deleteteamByName(tname);
        return team;
    }
}
