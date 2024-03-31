package org.surikov.homework9.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class RegistrationBase {
    private static Map<String, String> map;

    public RegistrationBase(){
    }

    public static Map getMap(){
        if(map==null){
            map = new HashMap<>();
            map.put("admin","admin");
        }
        return map;
    }


}
