package com.kob.backend.controller.pk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author:Smart7 Description:
 */
@RestController
@RequestMapping("/pk/")
public class BotInfoController {

    @RequestMapping("/getbotinfo/")
    public List<Map<String,String>> getBotInfo(){
        List<Map<String,String>> list = new LinkedList<>();
        HashMap<String, String> bot1 = new HashMap<>();
        bot1.put("name","tiger");
        bot1.put("age","21");
        HashMap<String, String> bot2 = new HashMap<>();
        bot2.put("name","lion");
        bot2.put("age","23");
        list.add(bot1);
        list.add(bot2);
        return list;
    }
}
