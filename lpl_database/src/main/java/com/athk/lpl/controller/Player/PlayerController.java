package com.athk.lpl.controller.Player;

import com.athk.lpl.Entity.ListMap;
import com.athk.lpl.Entity.player;
import com.athk.lpl.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class PlayerController {
    @Autowired
    PlayerMapper playerMapper;

    @GetMapping("/allplayer")
    public ListMap getAllPlayer(){
        return new ListMap(playerMapper.getAllPlayer());
    }

    @GetMapping("/player/{p_name}")
    public player getPlayer(String p_name){
        return playerMapper.getPlayerByName(p_name);
    }

    @GetMapping("/player")
    public player insertPlayer(player player){
        playerMapper.insertPlayer(player);
        return player;
    }

    @GetMapping("/player/{p_name}/{place}")
    public String  updatePlayer(String place,String p_name){
        playerMapper.updatePlayer(place,p_name);
        return place;
    }

    @GetMapping("/player/delete/{p_name}")
    public player deletePlayer(String p_name){
        player player = playerMapper.getPlayerByName(p_name);
        if(player==null) return null;
        playerMapper.deletePlayerByName(p_name);
        return player;
    }
}
