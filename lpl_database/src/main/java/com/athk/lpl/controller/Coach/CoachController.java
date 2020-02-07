package com.athk.lpl.controller.Coach;

import com.athk.lpl.Entity.ListMap;
import com.athk.lpl.Entity.coach;
import com.athk.lpl.mapper.CoachMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CoachController {
    @Autowired
    CoachMapper coachMapper;

    @GetMapping("/allcoach")
    public ListMap getAllcoach(){
        return new ListMap(coachMapper.getAllcoach());
    }

    @GetMapping("/coach/{cname}")
    public coach getcoach(String cname){
        return coachMapper.getcoachByName(cname);
    }

    @GetMapping("/coach")
    public coach insertcoach(coach coach){
        coachMapper.insertcoach(coach);
        return coach;
    }

    @GetMapping("/coach/{cname}/{team}")
    public String  updatecoach(String cname,String team){
        coachMapper.updatecoach(team,cname);
        return team;
    }

    @GetMapping("/coach/delete/{cname}")
    public coach deletecoach(String cname){
        coach coach = coachMapper.getcoachByName(cname);
        if(coach==null) return null;
        coachMapper.deletecoachByName(cname);
        return coach;
    }
}
