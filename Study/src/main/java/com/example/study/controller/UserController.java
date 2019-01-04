package com.example.study.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Eva
 * @date 2018年5月14日
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {


	
	@PostMapping("add")
	@ResponseBody
	public String add() {
		return "hello world!!";
	}
}

		