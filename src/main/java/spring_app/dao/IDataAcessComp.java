package spring_app.dao;

import java.util.List;

public interface IDataAcessComp {
    public List<String> getNames();

    public void update(Integer i, String value);
}
