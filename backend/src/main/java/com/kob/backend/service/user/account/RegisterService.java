package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * @Author:Smart7 Description:
 */
public interface RegisterService {
    public Map<String,String> register(String username, String password, String confirmedPassword);
}
