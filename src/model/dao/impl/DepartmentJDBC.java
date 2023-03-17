package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO Department(Name) "
					+ "VALUE(?)",Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			
			int linhaGerada = st.executeUpdate();
			
			if(linhaGerada > 0) {
				rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			
		}catch(SQLException e) {
			throw new DbException("Error! "+e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE Department "
					+ "SET Name = ? "
					+ "WHERE id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException("Error! "+e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE from Department "
					+"WHERE id = ?");
			st.setInt(1, id);
			
			int linha = st.executeUpdate();
			
			if(linha == 0) {
				throw new DbException("Error ! Registro não localizado" );
			}
			
		}catch(SQLException e) {
			throw new DbException("Error! "+e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT Id,Name as Nome from department "
					+"WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("ID"));
				dep.setName(rs.getString("Nome"));
				return dep;
			}else {
				throw new DbException("Registro NÃO localizado.");
			}
			
			
		}catch(SQLException e) {
			throw new DbException("Error !"+e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
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
