package blue.repository.helper;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import blue.model.Cliente;

public interface ClientesQueries {
	
	public List<Cliente> getLazyClientes(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters);
	public Long getTotalRegistrosAdvogadoProjecao(Map<String, Object> filters);
}
