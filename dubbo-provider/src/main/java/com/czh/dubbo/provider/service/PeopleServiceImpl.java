package com.czh.dubbo.provider.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
import com.czh.dubbo.common.entity.People;
import com.czh.dubbo.common.service.PeopleService;

//注意，这里的service注解用的不是spring的注解，而是com.alibaba.dubbo.config.annotation.Service;
@Service
public class PeopleServiceImpl implements PeopleService{
	private static final Logger logger = LoggerFactory.getLogger(PeopleServiceImpl.class);
	/**
	 * 这个方法的作用是接收传过来的People实体，将其ID赋为随机数
	 */
	@Override
	public People getPeople(People people) {
		people.setId(new Random().nextInt(10000));
		logger.debug("People:{},ID:{}",people.getName(),people.getId());
		return people;
	}

}
