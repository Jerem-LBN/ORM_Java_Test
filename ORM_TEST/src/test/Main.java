package test;

import java.util.ArrayList;
import java.util.List;

import ORM.JRelate;

public class Main {

	public static void main(String[] args) throws Exception {
		JRelate jr = new JRelate();
		//CREATION OBJECTS
		User user1 = new User(1, "Teddy", "Rinner");
		User user2 = new User(2, "Kilian", "Mbappe");
		User user3 = new User(3, "Romain", "Grosjean");
		
		UserWithDecorator UserDeco1 = new UserWithDecorator(1, "Zinedine", "Zidane");
		UserWithDecorator UserDeco2 = new UserWithDecorator(2, "Edith", "Piaf");
		UserWithDecorator UserDeco3 = new UserWithDecorator(3, "Omar", "Sy");
		
		//INSERTION
		jr.InsertObject(user1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		jr.InsertObject(user2, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		jr.InsertObject(user3, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		jr.InsertObject(UserDeco1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		jr.InsertObject(UserDeco2, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		jr.InsertObject(UserDeco3, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		//SELECT ALL
		List<Object> lstUsers = new ArrayList<Object>();
		List<Object> lstUsersDeco = new ArrayList<Object>();
		lstUsers = jr.SelectAllData(user1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		lstUsersDeco = jr.SelectAllData(UserDeco1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		for(Object o : lstUsers) {
			System.out.println(o.toString());
		}
		
		System.out.println("------------------------------------");
		
		for(Object o : lstUsersDeco) {
			System.out.println(o.toString());
		}
		
		System.out.println("------------------------------------");
	
		//UPDATE : 
		User user4 = new User(3, "Charles", "Leclerc");
		UserWithDecorator UserDeco4 = new UserWithDecorator(2, "Angele", "Van Laeken");
		
		jr.UpdateObject(user4, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		jr.UpdateObject(UserDeco4, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		lstUsers = jr.SelectAllData(user1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		lstUsersDeco = jr.SelectAllData(UserDeco1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		for(Object o : lstUsers) {
			System.out.println(o.toString());
		}
		
		System.out.println("------------------------------------");
		
		for(Object o : lstUsersDeco) {
			System.out.println(o.toString());
		}
		
		System.out.println("------------------------------------");
		
		//SELECT BY ID
		Object ObjectUser = new Object();
		Object ObjectUserDeco = new Object();
		
		ObjectUser = jr.SelectObjectByID(user3, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		ObjectUserDeco = jr.SelectObjectByID(UserDeco2, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		System.out.println(ObjectUser.toString());
		System.out.println("---------------------------------");
		System.out.println(ObjectUserDeco.toString());
		
		//DELETE 
		jr.DeleteObject(user1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		jr.DeleteObject(UserDeco3, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		//SELECT ORDER BY
		List<Object> lstUsersDESC = new ArrayList<Object>();
		List<Object> lstUsersDecoDESC = new ArrayList<Object>();
		List<Object> lstUsersASC = new ArrayList<Object>();
		List<Object> lstUsersDecoASC = new ArrayList<Object>();
		lstUsers = jr.SelectObjectOrdered(user1, "firstname", 0, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		lstUsersASC = jr.SelectObjectOrdered(user1, "firstname", 1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		lstUsersDeco = jr.SelectObjectOrdered(UserDeco1, "prenom", 0, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		lstUsersDecoASC = jr.SelectObjectOrdered(UserDeco1, "prenom", 1, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
		System.out.println("-----DESC-----");
		
		for(Object o : lstUsersDESC) {
			System.out.println(o.toString());
		}
		
		System.out.println("-----ASC-----");
		
		for(Object o : lstUsersASC) {
			System.out.println(o.toString());
		}
		
		System.out.println("");
		
		System.out.println("-----DESC deco-----");
		
		for(Object o : lstUsersDecoDESC) {
			System.out.println(o.toString());
		}
		
		System.out.println("-----ASC deco-----");
		
		for(Object o : lstUsersDecoASC) {
			System.out.println(o.toString());
		}
		
		//Test du lengthMax 
		UserWithDecorator u = new UserWithDecorator(4, "Christopher", "Thompson");
		jr.InsertObject(u, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		
	}

}
