package br.com.rafaelsoto.spring.bean;

import java.io.Serializable;

public class Todo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7048880621597084252L;

	private String descricao;

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Todo createTodo(String descricao)
	{
		Todo todo = new Todo();
		todo.setDescricao(descricao);
		
		return todo;
		
	}
	
}
