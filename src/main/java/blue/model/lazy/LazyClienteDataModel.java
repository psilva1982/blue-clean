package blue.model.lazy;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import blue.model.Cliente;
import blue.repository.Clientes;

public class LazyClienteDataModel extends LazyDataModel<Cliente> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Clientes clientes;
	
	public LazyClienteDataModel(Clientes clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		
		List<Cliente> listaClientes = clientes.getLazyClientes(first, pageSize, sortField, sortOrder, filters);
		
		this.setRowCount(clientes.getTotalClientes(filters).intValue());
		
		return listaClientes;
	}
}
