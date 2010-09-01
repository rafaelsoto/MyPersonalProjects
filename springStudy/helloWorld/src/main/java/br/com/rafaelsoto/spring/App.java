package br.com.rafaelsoto.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.rafaelsoto.spring.bean.Todo;
import br.com.rafaelsoto.spring.bean.TodoList;
import br.com.rafaelsoto.spring.dao.TodoListDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// create and configure beans
    	ApplicationContext context =    new ClassPathXmlApplicationContext(new String[] {"services.xml"});
    	// retrieve configured instance
    	TodoListDAOImpl service = context.getBean("todoListDAO", TodoListDAOImpl.class);
    	// use configured instance
    	service.adicionarTodo(Todo.createTodo("Estudar IOC Spring"), TodoList.createTodo("Estudo de Spring"));
    	
    	
    	

    }
}
