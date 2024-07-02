package com.kob.backend.service.user.account.acwing;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:Smart7 Description:
 */
public interface WebService {
    JSONObject applyCode();
    JSONObject receiveCode(String code, String state);
}
