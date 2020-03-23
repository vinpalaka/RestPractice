package spring_app;

import java.util.Map;

public class JsonDiff {
    class Json {
        String stringValue;
        Number number;
        Map<String, Json> map;
    }


    public void printDiff(Json old, Json newJson) {
        printDiffCurr(old, newJson, "");
    }

    private void printDiffCurr(Json old, Json newJson, String path) {
        if(!old.stringValue.equals(newJson.stringValue) ) {
            System.out.println("-$." +path + old.stringValue);
            System.out.println("+$." + path + newJson.stringValue);
        }
        if(!old.number.equals(newJson.number)) {
            System.out.println("-$." + path + old.number);
            System.out.println("+$." + path + newJson.number);
        }

        for(String key : old.map.keySet()) {
            if(newJson.map.containsKey(key)) {
                printDiffCurr(old.map.get(key), newJson.map.get(key), key);
            } else {
                printDiffCurr(old.map.get(key), path, "-");
            }
        }

        for(String key : newJson.map.keySet()) {
            if(!old.map.containsKey(key)) {
                printDiffCurr(newJson.map.get(key), path, "+");
            }
        }

    }

    private void printDiffCurr(Json curr, String path, String sign) {
        if(curr.stringValue != null ) {
            System.out.println(sign + "$." +path + curr.stringValue);
        }
        if( curr.number != null) {
            System.out.println(sign + "$." + path + curr.number);
        }
    }
}
