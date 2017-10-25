package cn.edu.zucc.northwind.dao;

import java.util.List;

import cn.edu.zucc.northwind.model.*;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DbException;
public interface IOrderDetailsDAO {
	public  void createOrderDetail(OrderDetails od) throws BaseException;//����������ϸ��Ϣ
	public void modifyOrderDetail(OrderDetails od) throws BaseException;//�޸Ķ�����ϸ��Ϣ
	public void deleteOrderDetail(OrderDetails od)throws BaseException;//ɾ����Ӧ�Ķ�����ϸ��Ϣ
	public List< OrderDetails > getOrderDetails(String orderID) throws DbException;//���ݶ�����ţ���ȡ������ϸ��Ϣ

}
