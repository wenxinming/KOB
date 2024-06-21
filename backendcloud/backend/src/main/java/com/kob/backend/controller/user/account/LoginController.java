package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author:Smart7 Description:
 */
@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @PostMapping("/api/user/account/token/")
    public Map<String,String> getToken(@RequestParam Map<String,String> map) {
        String username = map.get("username");
        String password = map.get("password");
        return loginService.getToken(username,password);
    }
}
