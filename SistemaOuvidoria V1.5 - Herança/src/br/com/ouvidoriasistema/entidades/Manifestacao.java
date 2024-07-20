package br.com.ouvidoriasistema.entidades;

public abstract class Manifestacao{

	private final int codigo;
	private String descricao;
	private final String tipo;
	private String status;

	

	public Manifestacao(int codigo, String descricao, String tipo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.status = "Pendente";
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Protocolo: " + codigo + "\nDescrição: " + descricao + "\nTipo de Manifestação: "
				+ tipo + "\nStatus: " + status+"\n\n";
	}

}
