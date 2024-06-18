	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	class ConexionBD {
	    private static Connection connection = null;
	    private synchronized static void crearInstanciaConexion() throws SQLException {
	        if (connection == null) {
	            Properties connectionProps = new Properties();
	            connectionProps.setProperty("user", "root");
	            connectionProps.setProperty("password", "root");
	            connectionProps.setProperty("serverTimezone", "UTC");
	            connection = DriverManager.getConnection("jdbc:mysql://10.11.1.5:3306/AccesoaDatos", connectionProps);
	        }
	    }
	    public static Connection getConexion() throws SQLException {
	        if (connection == null)
	            crearInstanciaConexion();
	        return connection;
	    }
	}

