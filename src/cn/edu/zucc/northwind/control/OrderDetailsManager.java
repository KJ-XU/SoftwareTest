package cn.edu.zucc.northwind.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.edu.zucc.northwind.util.*;
import cn.edu.zucc.northwind.model.*;
public class OrderDetailsManager<OrdersDetails> {
	public List<OrderDetails> loadAllOrderDetails(String orderID) throws BaseException {
		//根据订单号，查询详细信息
		List<OrderDetails> result=new ArrayList<OrderDetails>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from orderdetails where orderID=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, orderID);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				OrderDetails a=new OrderDetails();
				a.setOrderID(rs.getInt(1));
				a.setProductID(rs.getInt(2));
				a.setUnitPrice(rs.getFloat(3));
				a.setQuantity(rs.getInt(4));
				a.setDiscount(rs.getFloat(5));
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
	public void createOrderDetail(OrderDetails od) throws BaseException{
		//新增订单详细信息
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into OrderDetails(OrderID,ProductID,UnitPrice,Quantity,Discount) values(?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, od.getOrderID());
			pst.setInt(2, od.getProductID());
			pst.setFloat(3, od.getUnitPrice());
			pst.setInt(4, od.getQuantity());
			pst.setFloat(5, od.getDiscount());
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
	public void deleteOrderDetail(String orderID) throws BaseException{
		//根据订单号，删除订单详细信息
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from orderdetails where orderID=?";
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
	public List<OrderDetails> qryOrderDetails(int orderID) throws BaseException{
		//根据客户编号，查询订单详细信息
		List<OrderDetails> result=new ArrayList<OrderDetails>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from orderdetails where orderID=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, orderID);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				OrderDetails a=new OrderDetails();
				a.setOrderID(rs.getInt(1));
				a.setProductID(rs.getInt(2));
				a.setUnitPrice(rs.getFloat(3));
				a.setQuantity(rs.getInt(4));
				a.setDiscount(rs.getFloat(5));
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
