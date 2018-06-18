package spring_app.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component//THis will get picked up when the other one is deleted or @component for
//other class is commented out.
public class DataAcessComp2 implements IDataAcessComp {
    @Override
    public List<String> getNames() {
        return new ArrayList<>(Arrays.asList("Joseph", "Time"));
    }
}
