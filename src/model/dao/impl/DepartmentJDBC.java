package model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entites.Department;

public class DepartmentJDBC implements DepartmentDao{
	
	private Connection conn;
	
	public DepartmentJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		Statement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT Id as ID, Name as Nome from department");
			while(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("ID"));
				dep.setName(rs.getString("Nome"));
				list.add(dep);
			}
		return list;
		}catch(SQLException e) {
			throw new DbException("Error! "+e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

}
