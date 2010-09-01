package br.com.rafaelsoto.spring.dao;

import br.com.rafaelsoto.spring.bean.Todo;
import br.com.rafaelsoto.spring.bean.TodoList;

public interface TodoListDAO {

	
	public void adicionarTodo(Todo todo, TodoList list);
}
