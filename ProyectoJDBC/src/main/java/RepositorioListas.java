import java.util.List;
import java.util.Map;

	public interface RepositorioListas extends IRepositorioCliente <Cliente, Long> {
		
		Map<String,Cliente> getMapAll();
		
		Cliente getByDNI(String DNI);
		
		List<Cliente> findByProvincia(String provincia);
		
	}


