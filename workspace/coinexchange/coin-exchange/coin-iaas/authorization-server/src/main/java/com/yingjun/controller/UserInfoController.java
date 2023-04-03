package com.yingjun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @ClassName UserInfoController
 * @Description
 * @Author 陈英俊
 * @Date 2023/4/3 21:47
 * @Version 1.0
 */
@RestController
public class UserInfoController {

	/**
	 * 当前的登陆的用户对象
	 * @param principal
	 * @return
	 */
	@GetMapping("/user/info")
	public Principal userInfo(Principal principal){
		//使用threadLocal来实现的
//		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		return principal;
	}
}
