/**
  * @filename UserServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.hua.service.UserService;

/**
 * @type UserServiceImpl
 * @description 
 * @author qianye.zheng
 */
@WebService
@Path("/user")
public class UserServiceImpl implements UserService
{

	/**
	 * @description 
	 * @param content
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String say(String content)
	{
		System.out.println("UserServiceImpl.say()");
		
		return null;
	}

}
