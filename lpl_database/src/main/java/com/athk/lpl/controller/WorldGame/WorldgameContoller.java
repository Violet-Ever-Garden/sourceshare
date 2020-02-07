package com.athk.lpl.controller.WorldGame;

import com.athk.lpl.Entity.ListMap;
import com.athk.lpl.Entity.worldgame;
import com.athk.lpl.mapper.WorldgameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WorldgameContoller {
    @Autowired
    private WorldgameMapper worldgameMapper;

    @GetMapping("/worldgame")
    public ListMap getAllWorldgame(){
        return new ListMap(worldgameMapper.getAllworldgame());
    }
    @GetMapping("/worldgame/{wname}")
    public worldgame getByName(String wname){
        return worldgameMapper.getworldgameByName(wname);
    }

    @GetMapping("/worldgame/insert/{worldgame}")
    public worldgame insertWorldgame(worldgame worldgame){
        worldgameMapper.insertworldgame(worldgame);
        return worldgame;
    }

    @GetMapping("/worldgame/delete/{wname}")
    public worldgame deleteWorldGame(String wname){
        worldgame worldgame = worldgameMapper.getworldgameByName(wname);
        worldgameMapper.deleteWorldGame(wname);
        return worldgame;
    }

    @GetMapping("/worldgame/{wname}/{wplace}")
    public worldgame updateWorldGame(String wname,String wplace){
        return  worldgameMapper.updateWorldGame(wname,wplace);
    }
}
