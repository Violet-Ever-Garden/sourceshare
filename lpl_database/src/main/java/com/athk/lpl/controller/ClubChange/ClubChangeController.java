package com.athk.lpl.controller.ClubChange;

import com.athk.lpl.Entity.ListMap;
import com.athk.lpl.Entity.club_change;
import com.athk.lpl.mapper.ClubChangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClubChangeController {
    @Autowired
    ClubChangeMapper clubChangeMapper;

    @GetMapping("/allChange")
    public ListMap getAllClubChange(){
        return new ListMap(clubChangeMapper.getAllChange());
    }

    @GetMapping("/ClubChange/{p_name}")
    public club_change getClubChangeByp_name(String p_name){
        return clubChangeMapper.getClubChangeByp_name(p_name);
    }

    @GetMapping("/ClubChange/{tname}")
    public club_change getClubChangeBytname(String tname){
        return clubChangeMapper.getClubChangeBytname(tname);
    }

    @GetMapping("/club_change")
    public club_change insertClubChange(club_change club_change){
        clubChangeMapper.insertclub_change(club_change);
        return club_change;
    }

}
