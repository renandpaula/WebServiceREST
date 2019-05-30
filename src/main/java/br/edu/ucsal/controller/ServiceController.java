package br.edu.ucsal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.edu.ucsal.entity.MateriaEntity;
import br.edu.ucsal.entity.PessoaEntity;
import br.edu.ucsal.http.Materia;
import br.edu.ucsal.http.Pessoa;
import br.edu.ucsal.repository.MateriaRepository;
import br.edu.ucsal.repository.PessoaRepository;


	/**
	 * Essa classe vai expor os nossos métodos para serem acessasdos via http
	 * 
	 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
	 * */
	@Path("/service")
	public class ServiceController {
	 
	 
	 
	 
		private final  PessoaRepository repositoryPessoa = new PessoaRepository();
		private final  MateriaRepository repositoryMateria = new MateriaRepository();
	 
		/**
		 * @Consumes - determina o formato dos dados que vamos postar
		 * @Produces - determina o formato dos dados que vamos retornar
		 * 
		 * Esse método cadastra uma nova pessoa
		 * */
		@POST	
		@Consumes("application/json; charset=UTF-8")
		@Produces("application/json; charset=UTF-8")
		@Path("/cadastrarPessoa")
		public String Cadastrar(Pessoa pessoa){
	 
			PessoaEntity entity = new PessoaEntity();
	 
			try {
	 
				entity.setNome(pessoa.getNome());
				entity.setTurma(pessoa.getTurma());
	 
				repositoryPessoa.Salvar(entity);
	 
				return "Registro cadastrado com sucesso!";
	 
			} catch (Exception e) {
	 
				return "Erro ao cadastrar um registro " + e.getMessage();
			}
	 
		}
		
		/**
		 * @Consumes - determina o formato dos dados que vamos postar
		 * @Produces - determina o formato dos dados que vamos retornar
		 * 
		 * Esse método cadastra uma nova materia
		 * */
		@POST	
		@Consumes("application/json; charset=UTF-8")
		@Produces("application/json; charset=UTF-8")
		@Path("/cadastrarMateria")
		public String Cadastrar(Materia materia){
	 
			MateriaEntity entity = new MateriaEntity();
	 
			try {
	 
				entity.setNome(materia.getNome());
				entity.setTurma(materia.getTurma());
				entity.setSala(materia.getSala());
	 
				repositoryMateria.Salvar(entity);
	 
				return "Registro cadastrado com sucesso!";
	 
			} catch (Exception e) {
	 
				return "Erro ao cadastrar um registro " + e.getMessage();
			}
	 
		}
	 
		/**
		 * Essse método altera uma pessoa já cadastrada
		 * **/
		@PUT
		@Produces("application/json; charset=UTF-8")
		@Consumes("application/json; charset=UTF-8")	
		@Path("/alterarPessoa")
		public String Alterar(Pessoa pessoa){
	 
			PessoaEntity entity = new PessoaEntity();
	 
			try {
	 
				entity.setCodigo(pessoa.getCodigo());
				entity.setNome(pessoa.getNome());
				entity.setTurma(pessoa.getTurma());
	 
				repositoryPessoa.Alterar(entity);
	 
				return "Registro alterado com sucesso!";
	 
			} catch (Exception e) {
	 
				return "Erro ao alterar o registro " + e.getMessage();
	 
			}
	 
		}
		
		/**
		 * Essse método altera uma matéria já cadastrada
		 * **/
		@PUT
		@Produces("application/json; charset=UTF-8")
		@Consumes("application/json; charset=UTF-8")	
		@Path("/alterarMateria")
		public String Alterar(Materia materia){
	 
			MateriaEntity entity = new MateriaEntity();
	 
			try {
	 
				entity.setCodigo(materia.getCodigo());
				entity.setNome(materia.getNome());
				entity.setTurma(materia.getTurma());
				entity.setSala(materia.getSala());
	 
				repositoryMateria.Alterar(entity);
	 
				return "Registro alterado com sucesso!";
	 
			} catch (Exception e) {
	 
				return "Erro ao alterar o registro " + e.getMessage();
	 
			}
	 
		}
		
		/**
		 * Esse método lista todas pessoas cadastradas na base
		 * */
		@GET
		@Produces("application/json; charset=UTF-8")
		@Path("/todasPessoas")
		public List<Pessoa> TodasPessoas(){
	 
			List<Pessoa> pessoas =  new ArrayList<Pessoa>();
	 
			List<PessoaEntity> listaEntityPessoas = repositoryPessoa.TodasPessoas();
	 
			for (PessoaEntity entity : listaEntityPessoas) {
	 
				pessoas.add(new Pessoa(entity.getCodigo(), entity.getNome(),entity.getTurma()));
			}
	 
			return pessoas;
		}
		
		/**
		 * Esse método lista todas pessoas matérias na base
		 * */
		@GET
		@Produces("application/json; charset=UTF-8")
		@Path("/todasMaterias")
		public List<Materia> TodasMaterias(){
	 
			List<Materia> materia =  new ArrayList<Materia>();
	 
			List<MateriaEntity> listaEntityPessoas = repositoryMateria.TodasMaterias();
	 
			for (MateriaEntity entity : listaEntityPessoas) {
	 
				materia.add(new Materia(entity.getCodigo(), entity.getNome(),entity.getTurma(), entity.getSala()));
			}
	 
			return materia;
		}
	 
		/**
		 * Esse método busca uma pessoa cadastrada pelo código
		 * */
		@GET
		@Produces("application/json; charset=UTF-8")
		@Path("/getPessoa/{codigo}")
		public Pessoa GetPessoa(@PathParam("codigo") Integer codigo){
	 
			PessoaEntity entity = repositoryPessoa.GetPessoa(codigo);
	 
			if(entity != null)
				return new Pessoa(entity.getCodigo(), entity.getNome(),entity.getTurma());
	 
			return null;
		}
	 
		/**
		 * Excluindo uma pessoa pelo código
		 * */
		@DELETE
		@Produces("application/json; charset=UTF-8")
		@Path("/excluir/{codigo}")	
		public String Excluir(@PathParam("codigo") Integer codigo){
	 
			try {
	 
				repositoryPessoa.Excluir(codigo);
	 
				return "Registro excluido com sucesso!";
	 
			} catch (Exception e) {
	 
				return "Erro ao excluir o registro! " + e.getMessage();
			}
	 
		}
	 
	}
