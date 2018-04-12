/**
 * @filename UserApi.java
 * @author  qianye.zheng
 * 	@version 1.0
 */
package com.hua.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hua.bean.ResultBean;

/**
 * @type UserApi
 * @description  
 * @author qianye.zheng
 */
@Path("/user")
public interface UserApi
{
	
	@GET
	@Path("/get/{id}")
	/* 数据请求格式 */
	@Consumes({MediaType.APPLICATION_JSON})
	/* 数据响应格式 */
	@Produces({MediaType.APPLICATION_JSON})
	public ResultBean get(@PathParam("id") final String id);
}
