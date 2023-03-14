package applicattion;

import java.util.Date;
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
		Department dep = new Department(1, "Books");
		
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, dep);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(seller);

	}

}
