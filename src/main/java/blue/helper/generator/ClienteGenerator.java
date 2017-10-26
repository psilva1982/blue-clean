package blue.helper.generator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import blue.model.Cliente;
import blue.model.Endereco;
import blue.model.TipoPessoa;

public class ClienteGenerator {

	private String calcDigVerif(String num) {  
        Integer primDig, segDig;  
        int soma = 0, peso = 10;  
        for (int i = 0; i < num.length(); i++)  
                soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;  
        if (soma % 11 == 0 | soma % 11 == 1)  
            primDig = new Integer(0);  
        else  
            primDig = new Integer(11 - (soma % 11));  
        soma = 0;  
        peso = 11;  
        for (int i = 0; i < num.length(); i++)  
                soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;  
        soma += primDig.intValue() * 2;  
        if (soma % 11 == 0 | soma % 11 == 1)  
            segDig = new Integer(0);  
        else  
            segDig = new Integer(11 - (soma % 11));  
        return primDig.toString() + segDig.toString(); 
	}
	
	public void geraCPF(Cliente c) {
		String cpf = "";
		String iniciais = "";  
        Integer numero;  
        for (int i = 0; i < 9; i++) {  
            numero = new Integer((int) (Math.random() * 10));
            iniciais += numero.toString();
            cpf += numero.toString();
            if(i==2 || i==5) {
            	cpf += ".";
            }
        }  
        
        c.setCpfOuCnpj(cpf+ "-" +calcDigVerif(iniciais));
        
	}
	
	public void geraNome(Cliente c) {
		String[] nome = {"Paulo ", "Hugo ", "Marcelo ", "Vanessa ", "Lucia ", "Arnaldo ", "Luciano ", 
				"Daniele ", "Ana ", "Juliana ", "Roberto ", "Renato ", "Francisco ", "Carlos ", "Lucas "};
		
		String[] segundoNome = {"Aline ", "Cesar ", "Pedro ", "Maria ", "Vitor ", "Cleber "}; 
		
		String[] sobrenome = {"da Silva", "Pinto", "Pinheiro", "Fonseca", "Massaneiro", "Philippsen", 
				"Severo", "Monteiro", "Torres", "Jardim", "Torvalds", "Gates", "Skywalker"};
		
		int nomeSorteado = (int)(Math.random() * nome.length);
		int segundoNomeSorteado = (int)(Math.random() * segundoNome.length);
		int sobrenomeSorteado = (int)(Math.random() * sobrenome.length);		
		
		c.setNome(nome[nomeSorteado] + segundoNome[segundoNomeSorteado] + sobrenome[sobrenomeSorteado]);
	}
	
	public void geraNascimento(Cliente c) {
		
	    long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
	    long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
	    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
	    	
		c.setNascimento(LocalDate.ofEpochDay(randomDay));
	}
	
	public void geraEndereco(Cliente c) {
		String[] logradouro = {"Rua Pernanbuco", "Rua Maranhão", "Avenida Brasília", "Rua Mato Grosso", "Rua José de Alencar", "Avenida Brasil", 
				"Rua Osvaldo Cruz", "Rua Rio de Janeiro", "Rua Salvador", "Avenida Bahia", "Rua Ayrton Senha", "Travessa das orquídeas", 
				"Zona Rural", "Rua Sergipe"};
		
		int logradouroIndex = (int)(Math.random() * logradouro.length);
		
		Random r = new Random();
		
		String numero = "" +(r.nextInt(3000 - 500) + 500);
		
		int cep_inicio = (r.nextInt(99999-10000) + 10000);
		int cep_fim = (r.nextInt(999));
		
		String cep = cep_inicio+ "-" +cep_fim;
	
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro[logradouroIndex]);
		endereco.setNumero(numero);
		endereco.setCep(cep);
		
		c.setEndereco(endereco);
		
	}
	
	public void geraEmail(Cliente c) { 
		String[] dominios = {"@gmail.com", "@uol.com.br", "@altavista.com", "@yahoo.com", "@amazon.com", 
					"@ibm.com", "@google.com", "@terra.com", "@globo.com", "@hotmail.com", "@xbox.com", "@steam.com",
					"@geek.com", "@starwars.com"};
		
		int index = (int)(Math.random() * dominios.length);
		
		String email = c.getNome().replaceAll(" ", "").toLowerCase().substring(0, 5);
		
		email += c.getNascimento().getYear() +dominios[index];
		c.setEmail(email);
	}	
	
	public void geraTelefone(Cliente c) {
		String[] ddd = {"(41) ", "(45) ", "(43) ", "(61) ", "(69) ", "(84) ", "(67) ", "(21) "};
		int indexDdd = (int)(Math.random() * ddd.length); 
		
		Random r = new Random(); 
		String prefixo = "" +(r.nextInt(99999 - 10000) + 1000);
		String numero = "" +(r.nextInt(9999-1000) + 1000);
		
		String telefone = ddd[indexDdd] +prefixo+ "-" +numero;
		
		c.setTelefone(telefone);
	}
	
	public Cliente geraNovoCliente() {

		
		Cliente c = new Cliente();
		c.setTipoPessoa(TipoPessoa.FISICA);
		geraNome(c);
		geraCPF(c);
		geraNascimento(c);
		geraEmail(c);
		geraEndereco(c);
		geraTelefone(c);
		
		return c;
	}

	public List<Cliente> gerarQuantos(int quantidade) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		int i = 0; 
		while(i<quantidade) {
			clientes.add(geraNovoCliente());
			i++;
		}
		
		return clientes;
	}
}
