package br.com.rafaelsoto.spring.bean;

import java.io.Serializable;

public class TodoList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3227669793693349571L;
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TodoList createTodo(String descricao)
	{
		TodoList list = new TodoList();
		list.setDescricao(descricao);
		
		return list;
		
	}
	
	
	
	

}
