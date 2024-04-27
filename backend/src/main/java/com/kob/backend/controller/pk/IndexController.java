package com.kob.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Smart7 Description:
 */

@Controller
@RequestMapping("/pk/")
public class IndexController {

    @RequestMapping("index/")
    public String index(){
        return "pk/index.html";
    }
}
