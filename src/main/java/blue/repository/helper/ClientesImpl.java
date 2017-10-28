package blue.repository.helper;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.primefaces.model.SortOrder;

import blue.model.Cliente;

public class ClientesImpl implements ClientesQueries {

	@Inject
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> getLazyClientes(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		
		String jpql = "select c from Cliente c where 1=1 ";

		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			String atributo = it.next();
			Object valor = filters.get(atributo);
			if (valor != null) {
				
				String parametro = atributo;
								
				if (valor.getClass() == String.class) {					
					jpql += " and lower(c." +atributo+ ") like :"  +parametro;
				
				} else {
					
					jpql += " and c." +atributo+ " = :"  +parametro;
				}
			}
		}
		
		if (sortField != null && sortOrder != null) {
			
			if (sortOrder.equals(SortOrder.ASCENDING)) {
				jpql += " order by c." + sortField + " asc";
			} else if (sortOrder.equals(SortOrder.DESCENDING)) {
				jpql += " order by c." + sortField + " desc";
			}
		}		

		Query query = manager.createQuery(jpql);

		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			String atributo = it.next();
			Object valor = filters.get(atributo);
			if (valor != null) {
								
				if (valor.getClass() == String.class) {
					query.setParameter(atributo, "%" + String.valueOf(valor).toLowerCase() + "%");
				
				} else {
					query.setParameter(atributo, valor);
				}
			}
		}

		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		
		return query.getResultList();	
	}

	public Long getTotalRegistrosAdvogadoProjecao(Map<String, Object> filters) {
		String jpql = "SELECT COUNT(c.codigo) FROM Cliente c where 1=1 ";
		
		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			String atributo = it.next();
			Object valor = filters.get(atributo);

			String parametro = atributo;
						
			if (valor != null) {
				if (valor.getClass() == String.class) {
					jpql += " AND LOWER(c." +atributo+ ") like :" +parametro;
				} else {
					jpql += " AND c." +atributo+ " = :" +parametro;
				}
			}
		}

		Query query = manager.createQuery(jpql);

		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			String atributo = it.next();
			Object valor = filters.get(atributo);
						
			if (valor != null) {
				if (valor.getClass() == String.class) {
					query.setParameter(atributo, "%" + String.valueOf(valor).toLowerCase() + "%");
				} else {
					query.setParameter(atributo, valor);
				}
			}
		}
		return (Long) query.getSingleResult();
	}
	
}
