package model.dao;

import java.util.List;

import model.entites.Department;
import model.entites.Seller;

public interface SellerDao {
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer obj);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findBydepartment(Department department);
}
