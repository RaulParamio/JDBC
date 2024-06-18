
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class RepositorioClienteImplJDBC implements RepositorioListas {

	Connection conn = null;

	public RepositorioClienteImplJDBC() {

		try {
			conn = ConexionBD.getConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.conn = conn;
	}

//Metodo para contar los clientes
	public long count() {

		long cantclientes = 0;

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Cliente");

			while (rs.next()) {
				cantclientes++;
			}

		} catch (SQLException e) {
			System.out.println("ERROR AL CONTAR LOS CLIENTES....");
			e.printStackTrace();
		}
		System.out.println(cantclientes);
		return cantclientes;
	}

//Metodo para borrar clientes por ID
	public void deleteById(Long id) {

		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM Cliente WHERE id = ?");
			pst.setLong(1, id);
			pst.executeUpdate();
			System.out.println("Cliente borrado...");

		} catch (SQLException e) {

			System.out.println("Error al borrar cliente");
			e.printStackTrace();
		}
	}

//Metodo para borrar todos los clientes
	public void deleteAll() {

		try {

			Statement st = conn.createStatement();
			String sentenciaborra = "DELETE FROM Cliente";
			st.executeUpdate(sentenciaborra);
			System.out.println("Todos los Cliente han sido borrados...");
		} catch (SQLException e) {
			System.out.println("Error al borrar todos los clientes");
			e.printStackTrace();
		}
	}

//Metodo para saber si existe el cliente
	public boolean existsById(Long id) {

		PreparedStatement pst;
		boolean existe = false;
		try {
			pst = conn.prepareStatement("SELECT nombre FROM Cliente WHERE idCliente = ?");

			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.equals(null)) {
					existe = false;
				} else {
					existe = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR AL ENCONTRAR EL ID....");
		}

		System.out.println("El cliente es: " + existe);

		return existe;
	}

//Metodo para retornar cliente a traves de su id
	public Cliente getById(Long id) {

		Cliente clienteret = null;

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT dni, nombre, email FROM Cliente WHERE idCliente = ?");
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String dni = rs.getString(1);
				String nombre = rs.getString(2);
				String email = rs.getString(3);

				clienteret = new Cliente(dni, nombre, email);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR AL BUSCAR EL ID");
		}

		if (clienteret == null) {
			System.out.println("NO EXISTE NINGUN CLIENTE CON ESE ID");
		}
		System.out.println("El cliente es: " + clienteret);
		return clienteret;
	}

	// Metodo para retornar una lista de clientes

	public List<Cliente> findAll() {

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT dni, nombre, email FROM Cliente");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				lista.add(new Cliente(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL MOSTRAR LISTA DE CONTACTOS");
			e.printStackTrace();
		}
		return lista;
	}

	// Metodo para guardar los clientes
	public <S extends Cliente> S save(S entity) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO Clientes(dni, nombre, email)values()");

		} catch (SQLException e) {
			System.out.println("ERROR AL GUARDAR CLIENTE");
			e.printStackTrace();
		}

		return null;
	}

	// Coleccion Mapa que almacena todos los clientes
	public Map<String, Cliente> getMapAll() {

		PreparedStatement pst;
		Map<String, Cliente> mapa = new HashMap<String, Cliente>();

		try {
			pst = conn.prepareStatement("SELECT dni, nombre, email FROM Cliente");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String dni = rs.getString(1);
				mapa.put(dni, new Cliente(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL RETORNAR EL MAPA DE CLIENTES");
			e.printStackTrace();
		}

		return mapa;
	}

	public List<Cliente> findByProvincia(String provincia) {

		ArrayList<Cliente> lista = null;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT dni, nombre, email FROM Cliente");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

			}
		} catch (SQLException e) {
			System.out.println("ERROR AL ENCONTRAR EL USUARIO POR SU PROVINCIA...");
			e.printStackTrace();
		}

		return lista;
	}

	// Metodo que devuelve el cliente con dni introducido
	public Cliente getByDNI(String DNI) {
		PreparedStatement pst;
		Cliente clientexdni = null;
		try {
			pst = conn.prepareStatement("SELECT dni, nombre, email FROM Cliente WHERE dni =?");
			pst.setString(1, DNI);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String dni = rs.getString(1);
				String nombre = rs.getString(2);
				String email = rs.getString(3);

				clientexdni = new Cliente(dni, nombre, email);
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL ENCONTRAR DNI");
			e.printStackTrace();
		}

		return clientexdni;
	}

}
