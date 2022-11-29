package com.example.statisticservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.statisticservice.entity.Statistic;
import com.example.statisticservice.model.StatisticDTO;
import com.example.statisticservice.repository.StatisticRepository;
import com.example.statisticservice.service.StatisticService;

public class StatisticServiceImpl implements StatisticService{
	@Autowired
	StatisticRepository statisticRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void add(StatisticDTO statisticDTO) {
		Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
		statisticRepository.save(statistic);
	}
	
	@Override
	public List<StatisticDTO> getAll(){
		List<StatisticDTO> statisticDTOs = new ArrayList<>();
		
		statisticRepository.findAll().forEach(statistic -> {
			statisticDTOs.add(modelMapper.map(statistic, StatisticDTO.class));
		});
		
		return statisticDTOs;
	}
}
