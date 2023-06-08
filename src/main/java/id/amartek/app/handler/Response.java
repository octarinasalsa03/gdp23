package id.amartek.app.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static ResponseEntity<Object> generate(String message, HttpStatus status, Object response) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status);
        map.put("data", response);

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generate(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status);

        return new ResponseEntity<Object>(map, status);
    }

}
