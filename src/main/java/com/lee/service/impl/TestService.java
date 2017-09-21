package com.lee.service.impl;

import java.io.Serializable;

import com.lee.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lee.mapper.UserMapper;

@Service
public class TestService {
    @Autowired
    private UserMapper userMapper;
	
    @Cacheable(value = "hour", key = "#id")
	public User selectById(Serializable id) {
		return userMapper.selectById(id);
	}
}
