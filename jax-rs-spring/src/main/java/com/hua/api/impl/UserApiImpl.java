/**
 * @filename UserApiImpl.java
 * @author  qianye.zheng
 * 	@version 1.0
 */
package com.hua.api.impl;

import com.hua.api.UserApi;
import com.hua.bean.ResultBean;
import com.hua.entity.User;

/**
 * @type UserApiImpl
 * @description  
 * @author qianye.zheng
 */
public class UserApiImpl implements UserApi
{

	/**
	 * @description 
	 * @author qianye.zheng
	 * @param id
	 * @return
	 */
	@Override
	public ResultBean get(String id)
	{
		System.out.println("UserApiImpl.get()");
		ResultBean resultBean = new ResultBean();
		User user = new User();
		user.setId(id);
		user.setUsername("zhangsan");
		resultBean.setData(user);
		
		return resultBean;
	}

}
