package com.example.statisticservice.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticDTO {
	private Long id;
	private String message;
	private Date createDate;
}
