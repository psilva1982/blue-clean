import java.util.List;

import org.junit.Before;
import org.junit.Test;

import blue.helper.generator.ClienteGenerator;
import blue.model.Cliente;

public class GeradorClientes {
	
	private ClienteGenerator gen;
	
	@Before
	public void init() {
		
		gen = new ClienteGenerator();
	}

	
	@Test
	public void geraNomes() throws Exception {

		List<Cliente> listaClientes = gen.gerarQuantos(20);
		for(Cliente c : listaClientes) {
			System.out.println(">>>>> NOME: " +c.getNome());
			System.out.println(">>>>> CPF: " +c.getCpfOuCnpj());
			System.out.println(">>>>> NASCIDO: " +c.getNascimento());
			System.out.println(">>>>> TELEFONE: " +c.getTelefone());
			System.out.println(">>>>> EMAIL: " +c.getEmail());
			System.out.println(">>>>> LOGRADOURO: " +c.getEndereco().getLogradouro());
			System.out.println(">>>>> NUMERO: " +c.getEndereco().getNumero());
			System.out.println(">>>>> CEP: " +c.getEndereco().getCep());
			System.out.println("-----------------------------");
		}
	}
}
