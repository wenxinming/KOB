package com.kob.botrunningsystem.service.impl.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:Smart7 Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bot {
    Integer userId;
    String botCode;
    String input;
}
