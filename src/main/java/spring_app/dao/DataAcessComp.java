package spring_app.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component()
public class DataAcessComp implements IDataAcessComp {

    public List<String> getNames() {
        return new ArrayList<>(Arrays.asList("Vin", "Tim", "Randy"));
    }
}
