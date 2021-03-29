package br.com.controle.academico.rubem.dao;

public interface Cadastro {

	public Object Adicionar(Object novo);
	public Object Editar(Object atual,Object editado); 
	public boolean Deletar(Object item);
	public Object Listar(Object item);
	public Object Buscar(Object item);

}
