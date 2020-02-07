package com.athk.lpl.controller.WorldList;

import com.athk.lpl.Entity.ListMap;
import com.athk.lpl.Entity.worldlist;
import com.athk.lpl.mapper.WorldListMapper;
import com.athk.lpl.mapper.WorldgameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;



@RestController
public class WorldListController {
    @Autowired
    WorldListMapper worldListMapper;

    @GetMapping("/alllist")
    public ListMap getAlllist(){
        return   new ListMap( worldListMapper.getAlllist());
    }

    @GetMapping("/worldlist/{tname}")
    public ListMap getlistbytname(String tname){
        return new ListMap(worldListMapper.getworldlistBytName(tname));
    }

    @GetMapping("/worldlist/{wname}")
    public ListMap getlistbywname(String wname){
        return new ListMap(worldListMapper.getworldlistBywName(wname));
    }

    @GetMapping("/worldlist/insert/{worldlist}")
    public worldlist insertWorldList(worldlist worldlist){
        worldListMapper.insertworldlist(worldlist);
        return worldlist;
    }

    @GetMapping("/worldlist/delete/{tname}/{wname}")
    public worldlist deleteWorldList(String tname,String wname){
        return  worldListMapper.deleteWorldlist(tname,wname);
    }

    @GetMapping("/worldlist/update/{tname}/{wname}/{wplace}")
    public worldlist updateWorldList(String tname,String wname,String wplace){
        return worldListMapper.updateWorldlist(tname,wname,wplace);
    }
}
