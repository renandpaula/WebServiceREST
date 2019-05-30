package br.edu.ucsal.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Materia {
	
	private int codigo;
	private String nome;
	private String turma;
	private String sala;
	
	
	public Materia() {
	}


	public Materia(int codigo, String nome, String turma, String sala) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.turma = turma;
		this.sala = sala;
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


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}
	
	
	
	

}
