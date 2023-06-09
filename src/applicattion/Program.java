package applicattion;

import java.util.List;
import java.util.Locale;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

public class Program {

	public static void main(String[] args) {
		// Nome Jorge Paulo
		// Data: 14/03/2022
		
		Locale.setDefault(Locale.US);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TESTE 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TESTE 2: seller findByDEpartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findBydepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TESTE 3: seller findAll ====");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		/*System.out.println("\n==== TESTE 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inerted! New Id = "+newSeller.getId());*/
		
		
		/*System.out.println("\n==== TESTE 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Ang�lica");
		seller.setBaseSalary(3000.0);
		sellerDao.update(seller);
		System.out.println("Update Realizado com Sucesso!");*/
		
		System.out.println("\n==== TESTE 6: seller delete ====");
		sellerDao.deleteById(9);
		System.out.println("Registro Exclu�do com sucesso!");
	}

}
