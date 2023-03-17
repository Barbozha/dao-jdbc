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
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		
		System.out.println("\n==== TESTE 03 Inserindo Departament ====");
		Department dep = new Department(null,"Ofice");
		departmentDao.insert(dep);
		System.out.println("Registro cadastrado com sucesso.");
		
		System.out.println("\n==== TESTE 04 Update Departament ====");
		dep = departmentDao.findById(7);
		dep.setName("Sport");
		departmentDao.update(dep);
		System.out.println("Update Realizado com Sucesso!");
		
		
		System.out.println("\n==== TESTE 05 Delete Departament ====");
		departmentDao.deleteById(8);
		System.out.println("Registro Excluído com sucesso!");
	}

}
