package applicattion;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entites.Department;

public class Program02 {

	public static void main(String[] args) {
		// Operações com a base de dados department
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TESTE 01 Lista todos os Departamentos ====");
		//Department dep = new Department();
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TESTE 02 Lista Departamento por ID ====");
		Department department = departmentDao.findById(8);
		System.out.println(department);
		

	}

}
