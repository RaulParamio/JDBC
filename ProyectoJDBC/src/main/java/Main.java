
public class Main {

	public static void main(String[] args) {

		Cliente cliente1 = new Cliente("123456789", "Raul", "Paramio");

		RepositorioClienteImplJDBC repo = new RepositorioClienteImplJDBC();

		// PRUEBA METODOS JDBC

		repo.count();
		System.out.println(repo.save(new Cliente("CCCCCCCCC", "Elena", "ELENA@GMAIL.COM")));
		// repo.deleteById(3L);
		// System.out.println(repo.deleteAll());
		System.out.println(repo.existsById(1L));
		System.out.println(repo.getById(1L));
		System.out.println(repo.findAll());
		System.out.println(repo.getMapAll());
		System.out.println(repo.getByDNI("AAAAAAAAA"));

	}

}
