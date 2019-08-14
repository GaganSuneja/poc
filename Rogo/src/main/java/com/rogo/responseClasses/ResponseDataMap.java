package com.rogo.responseClasses;

import java.util.HashMap;

public class ResponseDataMap extends  ResponseMap{
    private HashMap<String, Object> data;

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }


    public ResponseDataMap() {
        data = new HashMap<>();
    }

    public Object getData(String key) {
        return data.get(key);
    }

    public void putData(String key, Object value) {
        data.put(key, value);
    }


}
