package br.edu.ucsal.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pessoa {
 
	private int codigo;
	private String nome;
	private String turma;
 
	public Pessoa(){
 
	}

	public Pessoa(int codigo, String nome, String turma) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.turma = turma;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
	
}