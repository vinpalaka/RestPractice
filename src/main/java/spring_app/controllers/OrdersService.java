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
     * If you keep hitting this uri, then list will eventually be empty
     * Breaking the rule of state less.
     */
    @RequestMapping("/call")
    public List<String> callOther() throws IOException {
        URL url = new URL("http://localhost:8080/testState");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        List<String> s = new ArrayList<>();
        con.setRequestMethod("GET");
        int code = con.getResponseCode();
        if(code == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            while(in.ready()) {
                s.add(in.readLine());
            }

        }
        return s;
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
        if("Vin". equals(key)) {
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
    @RequestMapping(value = "/addName", method = RequestMethod.POST)
    public int addName(@RequestParam("item") String item) {
        //if you a item in the url and item as a body item, it will add both as
        //as one item comma seperated. size goes up by 1.
        dataAcessComp.getNames().add(item);
        return dataAcessComp.getNames().size();
    }

    @RequestMapping(value = "/name/{key}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer key, @RequestParam("item") String item) {
        //if you a item in the url and item as a body item, it will add both as
        //as one item comma seperated. size goes up by 1.
        dataAcessComp.update(key, item);

    }
}
