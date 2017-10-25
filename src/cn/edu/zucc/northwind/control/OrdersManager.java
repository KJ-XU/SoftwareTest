package cn.edu.zucc.northwind.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.zucc.northwind.util.*;
import cn.edu.zucc.northwind.model.*;

public class OrdersManager {
	public List<Orders> loadAllOrders() throws BaseException{  
		//查询所有订单
		List<Orders> result=new ArrayList<Orders>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from orders";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Orders a=new Orders();
				a.setOrderID(rs.getInt(1));
				a.setCustomerID(rs.getString(2));
				a.setEmployeeID(rs.getString(3));
				a.setOrderDate(rs.getTimestamp(4));
				a.setRequiredDate(rs.getTimestamp(5));
				a.setShippedDate(rs.getTimestamp(6));
				a.setShipVia(rs.getInt(7));
				a.setFreight(rs.getFloat(8));
				a.setShipName(rs.getString(9));
				a.setShipAddress(rs.getString(10));
				a.setShipCity(rs.getString(11));
				a.setShipRegion(rs.getString(12));
				a.setShipPostalCode(rs.getString(13));
				a.setShipCountry(rs.getString(14));
				result.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
	public void createOrder(Orders c) throws BaseException{
		//新增订单
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into orders(OrderID,CustomerID,EmployeeID,OrderDate,RequiredDate,ShippedDate,ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, c.getOrderID());
			pst.setString(2, c.getCustomerID());
			pst.setString(3, c.getEmployeeID());
			pst.setTimestamp(4, c.getOrderDate());
			pst.setTimestamp(5, c.getRequiredDate());
			pst.setTimestamp(6, c.getShippedDate());
			pst.setInt(7, c.getShipVia());
			pst.setFloat(8, c.getFreight());
			pst.setString(9,c.getShipName() );
			pst.setString(10,c.getShipAddress() );
			pst.setString(11, c.getShipCity());
			pst.setString(12, c.getShipRegion());
			pst.setString(13, c.getShipPostalCode());
			pst.setString(14, c.getShipCountry());
			pst.execute();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public void deleteOrder(String orderID) throws BaseException{
		//根据订单号，删除订单
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from orders where orderID=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, orderID);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public List< Orders >  qryOrders(String customerID,String employeeID)throws BaseException{
		//根据客户编号，员工编号模糊查询订单信息
		List<Orders> result=new ArrayList<Orders>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from orders where CustomerID like ? and EmployeeID like ?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, "%"+customerID+"%");
			pst.setString(2, "%"+employeeID+"%");
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Orders a=new Orders();
				a.setOrderID(rs.getInt(1));
				a.setCustomerID(rs.getString(2));
				a.setEmployeeID(rs.getString(3));
				a.setOrderDate(rs.getTimestamp(4));
				a.setRequiredDate(rs.getTimestamp(5));
				a.setShippedDate(rs.getTimestamp(6));
				a.setShipVia(rs.getInt(7));
				a.setFreight(rs.getFloat(8));
				a.setShipName(rs.getString(9));
				a.setShipAddress(rs.getString(10));
				a.setShipCity(rs.getString(11));
				a.setShipRegion(rs.getString(12));
				a.setShipPostalCode(rs.getString(13));
				a.setShipCountry(rs.getString(14));
				result.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
		
	}

}
