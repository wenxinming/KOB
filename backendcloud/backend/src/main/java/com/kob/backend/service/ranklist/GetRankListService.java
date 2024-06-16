package com.kob.backend.service.ranklist;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:Smart7 Description:
 */
public interface GetRankListService {
    JSONObject getList(Integer page);
}
