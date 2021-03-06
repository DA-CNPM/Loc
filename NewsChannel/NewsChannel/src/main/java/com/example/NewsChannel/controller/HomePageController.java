package com.example.NewsChannel.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.NewsChannel.mapper.UserMapper;
import com.example.NewsChannel.model.User;
import com.example.NewsChannel.model.UserExample;

@Controller
public class HomePageController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		
		
		UserExample example = new UserExample();
		
		List<User> listUser = userMapper.selectByExample(example);
		
		for(User value : listUser) {
			System.out.println("User " +value.getId()+ " "+ value.getFullName());
		}
		
		
		
		return modelAndView;
	}
}
