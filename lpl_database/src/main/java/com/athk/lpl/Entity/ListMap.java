package com.athk.lpl.Entity;

import java.util.List;
import java.util.Map;

public class ListMap {
    private List<Map<String,Object>> list;
    public ListMap(List<Map<String,Object>> list){
        this.list = list;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }
}
