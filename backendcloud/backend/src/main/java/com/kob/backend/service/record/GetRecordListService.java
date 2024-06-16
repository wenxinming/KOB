package com.kob.backend.service.record;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:Smart7 Description:
 */
public interface GetRecordListService {
    JSONObject getList(Integer page);
}
