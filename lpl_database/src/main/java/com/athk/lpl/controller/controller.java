package com.athk.lpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/")
public class controller {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    //@ResponseBody
    //@RequestMapping("/")
    public String hello(){
        return "hello";
    }

    //@RequestMapping(value = "/lplmenber/{team}",method = RequestMethod.GET)
    public String team(@PathVariable("team") String team, Model model){
        //model.addAttribute("teams",)
        return "team";
    }

    //@ResponseBody
    //@RequestMapping("/lplmenber/player")
    public List<Map<String, Object>> get() {
       // public String get() {
        String sql = "select * from player";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            if (entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key + ":" + value);
                }

            }
        }return list;
    }
}
