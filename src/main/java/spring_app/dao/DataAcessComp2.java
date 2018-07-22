package spring_app.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component//THis will get picked up when the other one is deleted or @component for
//other class is commented out.
public class DataAcessComp2 implements IDataAcessComp {
    @Override
    public List<String> getNames() {
        return new ArrayList<>(Arrays.asList("Joseph", "Time"));
    }

    @Override public Map<Integer, String> update(int id, String value) {
        return null;
    }

    @Override public Map<Integer, String> addName(int id, String value) {
        return null;
    }
}
