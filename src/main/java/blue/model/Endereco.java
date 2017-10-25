package blue.model;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Endereco {
	
	@NotBlank(message = "Informe o endereço")
	private String logradouro;
	private String numero;
	private String complemento;
	@NotBlank(message = "Informe o cep do endereço")
	private String cep; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade")
	private Cidade cidade;
	
	@Transient			//Esse objeto não vai para o banco de dados
	private Estado estado;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String getNomeCidadeSiglaEstado() {
		if(this.cidade != null) {
			return this.cidade.getNome()+ " - " +this.cidade.getEstado().getSigla();
		}
		
		return null;
	}
}
