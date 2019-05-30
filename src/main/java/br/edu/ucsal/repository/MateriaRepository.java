package br.edu.ucsal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ucsal.entity.MateriaEntity;
import br.edu.ucsal.entity.PessoaEntity;

public class MateriaRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public MateriaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADES DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
 
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(MateriaEntity materiaEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(materiaEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(MateriaEntity materiaEntity){
 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(materiaEntity);
		this.entityManager.getTransaction().commit();
	}
 
	/**
	 * RETORNA TODAS AS PESSOAS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<MateriaEntity> TodasMaterias(){
 
		return this.entityManager.createQuery("SELECT m FROM MateriaEntity m ORDER BY m.nome").getResultList();
	}
	
	/**
	 * RETORNA TODAS AS SALAS DE UMA DETERMINADA TURMA 
	 * */
	@SuppressWarnings("unchecked")
	public List<MateriaEntity> ConsultaSalaTurma(String codTurma){
 
		return this.entityManager.createQuery("SELECT sala, nome, turma FROM MateriaEntity m, WHERE turma = '"+codTurma+"' ORDER BY m.nome").getResultList();
	}
 
	/**
	 * CONSULTA UMA PESSOA CADASTRA PELO CÓDIGO
	 * */
	public MateriaEntity GetMateria(Integer codigo){
 
		return this.entityManager.find(MateriaEntity.class, codigo);
	}
 
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void Excluir(Integer codigo){
 
		MateriaEntity materia = this.GetMateria(codigo);
 
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(materia);
		this.entityManager.getTransaction().commit();
 
	}
}
