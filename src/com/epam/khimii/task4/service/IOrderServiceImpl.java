package com.epam.khimii.task4.service;

import java.time.LocalDateTime;
import java.util.Map;

public interface IOrderServiceImpl {
    Map<String, Integer> findOrderByTime(LocalDateTime date);

    Map<String, Integer> findOrderByTimeRange(LocalDateTime date1,
                                              LocalDateTime date2);
}
