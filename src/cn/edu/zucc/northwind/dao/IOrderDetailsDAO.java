package cn.edu.zucc.northwind.dao;

import java.util.List;

import cn.edu.zucc.northwind.model.*;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DbException;
public interface IOrderDetailsDAO {
	public  void createOrderDetail(OrderDetails od) throws BaseException;//创建订单详细信息
	public void modifyOrderDetail(OrderDetails od) throws BaseException;//修改订单详细信息
	public void deleteOrderDetail(OrderDetails od)throws BaseException;//删除相应的订单详细信息
	public List< OrderDetails > getOrderDetails(String orderID) throws DbException;//根据订单编号，获取订单详细信息

}
