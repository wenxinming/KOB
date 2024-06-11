package com.kob.backend.service.user.account;

import java.util.Map;

/**
 * @Author:Smart7 Description:
 */
public interface LoginService {
    Map<String ,String> getToken(String username, String password);

}
