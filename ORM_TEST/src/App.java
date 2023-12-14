import ORM.JRelate;
import Objects.User;

public class App {
    public static void main(String[] args) throws Exception {
       JRelate jr = new JRelate();
		User utilisateur = new User();
		utilisateur.setid(1);
		Object u = jr.SelectObjectByID(utilisateur, "jdbc:mysql://localhost:3306/testdb", "toto", "bob");
		System.out.println(u.toString());
    }
}
