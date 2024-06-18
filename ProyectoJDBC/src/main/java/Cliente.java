
public class Cliente {
	
	 String dni;
	 String nombre;
	 String apellido;
	 String listadetelf;
	 String email;
	 
	//ConstructorObligatorioCliente
	public Cliente(String dni, String nombre, String email) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
	}

	//ConstructorOpcionalCliente
	public Cliente(String dni, String nombre, String email, String listadetelf, String apellido) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.listadetelf = listadetelf;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", listadetelf=" + listadetelf
				+ ", email=" + email + "]";
	}

}
