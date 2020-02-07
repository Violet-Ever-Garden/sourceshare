package com.athk.lpl.controller.Match;

import com.athk.lpl.Entity.ListMap;
import com.athk.lpl.Entity.match;
import com.athk.lpl.mapper.MatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MatchController {
    @Autowired
    MatchMapper matchMapper;

    @GetMapping("/allmatch")
    public ListMap getAllmatch(){
        return new ListMap(matchMapper.getAllMatch());
    }

    @GetMapping("/match/{mID}")
    public match getmatch(String mID){
        return matchMapper.getmatchByName(mID);
    }

    @GetMapping("/match")
    public match insertmatch(match match){
        matchMapper.insertmatch(match);
        return match;
    }

    @GetMapping("/match/{mID}/{mvp}")
    public String  updatematch(String mID,String mvp){
        matchMapper.updatematch(mvp,mID);
        return mvp;
    }

    @GetMapping("/match/delete/{mID}")
    public match deleteMatch(String mID){
        match match = matchMapper.getmatchByName(mID);
        matchMapper.deletematchByName(mID);
        return match;
    }
}
