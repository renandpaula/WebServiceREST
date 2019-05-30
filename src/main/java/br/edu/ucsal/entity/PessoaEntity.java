package br.edu.ucsal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class PessoaEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
 
	@Column(name="nome")	
	private String  nome;
 
	@Column(name="turma")
	private String  turma;
 
	public Integer getCodigo() {
		return codigo;
	}
 
	public void setCodigo(Integer codigo) {
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