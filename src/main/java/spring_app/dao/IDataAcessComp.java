package spring_app.dao;

import java.util.List;
import java.util.Map;

public interface IDataAcessComp {
    public List<String> getNames();
    public Map<Integer, String> update(int id, String value);
    public Map<Integer, String> addName(int id, String value);
}
