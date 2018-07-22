package spring_app.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component()
public class DataAcessComp implements IDataAcessComp {

    Map<Integer, String> map = new HashMap<>();


    public DataAcessComp() {
        map.put(1, "Vin");
        map.put(2, "Earl");
        map.put(3, "Tim");
        map.put(4, "Celery");
        map.put(5, "Candy");
    }

    public List<String> getNames() {
        return new ArrayList<>(Arrays.asList("Vin", "Tim", "Randy"));
    }

    public String getName(int id) {
        return map.get(id);
    }

    public Map<Integer, String> update(int id, String value) {
        if(map.containsKey(id))
            map.put(id, value);
        return map;
    }

    public Map<Integer, String> addName(int id, String value) {
        if(!map.containsKey(id)) {
            map.put(id, value);
        }
        return map;
    }
}
