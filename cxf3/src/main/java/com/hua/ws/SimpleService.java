/**
  * @filename SimpleService.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.ws;

 /**
 * @type SimpleService
 * @description 
 * @author qye.zheng
 */
public interface SimpleService {

	
	/**
	 * 
	 * @description 
	 * @param name
	 * @return
	 * @author qye.zheng
	 */
	public String getGreeting(final String name);
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qye.zheng
	 */
	public int getPrice();
}
