package com.example.statisticservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.statisticservice.model.StatisticDTO;
import com.example.statisticservice.service.StatisticService;

@RestController
public class StatisticController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StatisticService statisticService;
	
	@PostMapping("/statistic")
	public StatisticDTO add(@RequestBody StatisticDTO statisticDTO) {
		logger.debug("add statistic");
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		statisticService.add(statisticDTO);
		return statisticDTO;
	}
	
	@GetMapping("/statistic")
	public List<StatisticDTO> getAll(){
		logger.debug("get all statistic");
		return statisticService.getAll();
	}
}
