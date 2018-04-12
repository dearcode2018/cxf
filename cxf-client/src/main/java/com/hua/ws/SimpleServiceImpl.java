package com.hua.ws;

import javax.jws.WebService;

/**
  * @filename SimpleServiceImpl.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */

 /**
 * @type SimpleServiceImpl
 * @description 
 * @author qye.zheng
 */
@WebService
public class SimpleServiceImpl implements SimpleService {

	/**
	 * 
	 * @description 
	 * @param name
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public String getGreeting(final String name)
	{
		
		return "hi, " + name;
	}
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	@Override
	public int getPrice()
	{
		return new java.util.Random().nextInt(1000);
	}
	
}
