package spring_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import spring_app.dao.IDataAcessComp;
import spring_app.dao.OrderRepository;
import spring_app.entity.Order;

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

    @Autowired
    OrderRepository orderRepository;

    class Input {
        public String getInput() {
            return input;
        }

        public Input setInput(String input) {
            this.input = input;
            return this;
        }

        private String input;

        public Input() {

        }
    }

    private static final String VALID_NUMBERS = "1234567890";

    private static final String VALID_OPERATOR = "+-";

    private static  String expression = "";

    public OrdersService() {

    }

    @PostMapping("/input")
    public Input input(@RequestBody Input input) throws Exception {
        //input validation
        if(input.input == null || input.input.length() != 1 || (!VALID_NUMBERS.contains(input.input) &&
                !VALID_OPERATOR.contains(input.input))) {
            throw new Exception("Invalid input" + input.input);
        }

        if(VALID_NUMBERS.contains(input.input)) {
            if(expression.length() > 0 && VALID_NUMBERS.contains(String.valueOf(expression.charAt(expression.length() -1)))) {
                throw new Exception("Multiple numbers entered" + input.input);
            } else {
                expression+=input.input;
            }
        } else {
            if(expression.length() == 0) {
                throw new Exception("Operator entered before expression started without number" + input.input);
            }
            if(VALID_OPERATOR.contains(String.valueOf(expression.charAt(expression.length() -1)))) {
                throw new Exception("Multiple operators entered" + input.input);
            }

            expression+=input.input;

        }
        return input;
    }

    //@GetMapping(/result)


    @RequestMapping("/names")
    public List<String> names() {
        return dataAcessComp.getNames();
    }


    /**
     * If you keep hitting this uri, then list will eventually be empty
     * Breaking the rule of state less.
     */
    @GetMapping("/testState/{orderId}")
    public Order testState(@PathVariable Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    /**
     * If you keep hitting this uri, then list will eventually be empty
     * Breaking the rule of state less.
     */
    @GetMapping("/createState")
    public Order create() {
        Order order = new Order();
        order.setName("Vin");
        order.setUpdatedBy(3323l);
        return orderRepository.save(order);
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
