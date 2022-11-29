package com.example.statisticservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.statisticservice.entity.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Long>{

}
