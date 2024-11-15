package co.kr.redis.controller;

import co.kr.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/redis/string")
    public void  setValue(String key, String value){
        redisService.setValue(key, value);
    }

    @GetMapping("/redis/string/{key}")
    public ResponseEntity getValue(@PathVariable("key") String key){
        String value = redisService.getValue(key);
        return ResponseEntity.ok().body(value);
    }


    @PostMapping("/redis/list-right")
    public void  addToListFramRight(String key, String value){
        redisService.addToListFramRight(key, value);
    }

    @PostMapping("/redis/list-left")
    public void  addToListFramLeft(String key, String value){
        redisService.addToListFramLeft(key, value);
    }


    @GetMapping("/redis/list/{key}/{index}")
    public ResponseEntity  getFromList(@PathVariable("key") String key,
                             @PathVariable("index") int index){
        String value = redisService.getFromList(key, index);
        return ResponseEntity.ok().body(value);
    }

    @GetMapping("/redis/list/{key}/{start}/{end}")
    public ResponseEntity  getRangFromList(@PathVariable("key") String key,
                                 @PathVariable("start") int start,
                                 @PathVariable("end") int end){
        List<String> values = redisService.getRangFromList(key, start, end);
        return ResponseEntity.ok().body(values);
    }


    @PostMapping("/redis/set")
    public void  addToSet(String key, String[] values){}

    @GetMapping("/redis/set/{key}")
    public void  getFromSet(@PathVariable("key") String key){}


    @PostMapping("/redis/hash")
    public void  addToHash(String key, String hashKey, String value){}

    @PostMapping("/redis/hash/{key}/{hashKey}")
    public void  getFromHash(@PathVariable("key") String key,
                             @PathVariable("hashKey") String hashKey){}

}
