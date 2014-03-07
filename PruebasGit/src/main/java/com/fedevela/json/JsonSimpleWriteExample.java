package com.fedevela.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * http://javahash.com/read-write-json-using-json-simple-library/
 */

public class JsonSimpleWriteExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("planet", "earth");
        obj.put("diameter", new Double(12756.2));

        JSONArray list = new JSONArray();
        JSONObject info= new JSONObject();
        info.put("age", "4.6 billion years");
        info.put("water", "70.8%");
        info.put("land", "29.2%");
        list.add(info);
        obj.put("facts", list);

        try {

            FileWriter file = new FileWriter("C:\\Users\\fvelazquez\\Documents\\earth.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}
