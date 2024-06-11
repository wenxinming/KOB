package com.kob.matchingsystem.service;

/**
 * @Author:Smart7 Description:
 */
public interface MatchingService {
    String addPlayer(Integer userId, Integer rating);
    String removePlayer(Integer userId);
}
