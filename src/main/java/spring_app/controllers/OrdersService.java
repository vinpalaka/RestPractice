package spring_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import spring_app.dao.IDataAcessComp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class OrdersService {

    @Autowired
    IDataAcessComp dataAcessComp;


    @RequestMapping("/names")
    public List<String> names() {
        return dataAcessComp.getNames();
    }


    /**
     * If you keep hitting this uri, then list will eventually be empty
     * Breaking the rule of state less.
     */
    @RequestMapping("/testState")
    public List<String> testState() {
        dataAcessComp.getNames().remove(0);//If you keep hitting this, names will be empty.
        return dataAcessComp.getNames();
    }


    /**
     * To Test the input parameter annotation. To fill hit:
     * http://localhost:8080/info/Vin?token=date
     * @param key
     * @param token
     * @return
     */
    @RequestMapping("/info/{key}")
    public String info(@PathVariable String key, @RequestParam String token) {
        String value = "";
        if("1". equals(key)) {
            value = "That's my name";
        }
        if("date".equals(token)) {
            value += ": " + LocalDateTime.now().toString();
        }
        return value;
    }

    /**
     * To Test post. Adds name to list
     * http://localhost:8080/add
     * @return
     */
    @RequestMapping(value = "/names/{id}", method = RequestMethod.POST)
    public Map<Integer, String> addName(@PathVariable Integer id, @RequestParam("item") String item) {
        //if you a item in the url and item as a body item, it will add both as
        //as one item comma seperated. size goes up by 1.
        return dataAcessComp.addName(id, item);
    }

    /**
     * To Test post. Adds name to list
     * http://localhost:8080/add
     * @return
     */
    @RequestMapping(value = "/names/{id}", method = RequestMethod.PUT)
    public Map<Integer, String> update(@PathVariable Integer id, @RequestParam("item") String item) {
        //if you a item in the url and item as a body item, it will add both as
        //as one item comma seperated. size goes up by 1.
        return dataAcessComp.update(id, item);
    }
}
