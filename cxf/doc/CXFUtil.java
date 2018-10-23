/**
 * CXFUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * CXFUtil
 * 描述: Apache CXF - 工具类
 * @author  qye.zheng
 */
public final class CXFUtil
{

	/**
	 * 构造方法
	 * 描述: 私有 - 禁止实例化
	 * @author  qye.zheng
	 */
	private CXFUtil()
	{
	}

	/**
	 * 
	 * @description 发布WebService服务，基于CXF JaxWs
	 * @param serviceClass ws 服务实现类
	 * @param clazz
	 * @author qye.zheng
	 */
	public static final void publish(final String address, final Class<?> serviceClass)
	{
		final JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.setServiceClass(serviceClass);
		factoryBean.setAddress(address);
		try {
			factoryBean.setServiceBean(serviceClass.newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// ws 服务器
		final Server server = factoryBean.create();
		// 启动
		//server.start();
	}
	
	/**
	 * 
	 * @description 创建客户端，
	 * @param address
	 * @param serviceClass ws服务接口类
	 * @return
	 * @author qye.zheng
	 */
	@SuppressWarnings({"unchecked"})
	public static final <T> T getClient(final String address, final Class<T> serviceClass)
	{
		final JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
		factoryBean.setServiceClass(serviceClass);
		factoryBean.setAddress(address);
		
		return (T) factoryBean.create();
	}
}
