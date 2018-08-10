package spring_app.dao;

import org.springframework.stereotype.Component;

import java.util.*;

@Component()
public class DataAcessComp implements IDataAcessComp {
    Map<Integer, String> map = new HashMap<>();

    public DataAcessComp() {
        map.put(1, "James");
        map.put(2, "Lance");
        map.put(3, "Randy");
        map.put(4, "tim");

    }
    public List<String> getNames() {
        List<String> s = new ArrayList<>();
        for(Integer i : map.keySet()) {
            s.add(map.get(i));
        }
        return s;
    }

    public void update(Integer i, String value) {
        if(map.containsKey(i)) {
            map.put(i, value);
        }
    }
}
