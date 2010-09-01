package br.com.rafaelsoto.spring.dao;

import br.com.rafaelsoto.spring.bean.Todo;
import br.com.rafaelsoto.spring.bean.TodoList;

public class TodoListDAOImpl implements TodoListDAO{

	public void adicionarTodo(Todo todo, TodoList list) {
		
		System.out.println("Adicionando a TodoList " + list.getDescricao() + " a tarefa " + todo.getDescricao());
		
	}

}
