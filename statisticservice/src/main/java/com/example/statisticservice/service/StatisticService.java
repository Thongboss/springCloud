package com.example.statisticservice.service;

import java.util.List;

import com.example.statisticservice.model.StatisticDTO;

public interface StatisticService {

	List<StatisticDTO> getAll();

	void add(StatisticDTO statisticDTO);

}
