import java.util.List;
//import java.sql.Connection;

//Repositorio con los metodos que mas tarde se van a implementar



public interface IRepositorioCliente<T, ID> {
	
	long count();

	
	void deleteById(ID id);


	void deleteAll();


	boolean existsById(ID id);

	
	T getById(ID id);

	
	List<T> findAll();


	<S extends T> S save(S entity);

}


		    
		    
	


