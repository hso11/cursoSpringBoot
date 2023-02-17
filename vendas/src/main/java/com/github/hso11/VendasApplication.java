package com.github.hso11;

import com.github.hso11.domain.entity.Cliente;
import com.github.hso11.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args ->{
            System.out.println("Criando clientes...");
            clientes.salvar(new Cliente("Joao"));
            clientes.salvar(new Cliente("Maria"));
            clientes.salvar(new Cliente("Jose"));
            clientes.salvar(new Cliente("Felipe"));
            clientes.salvar(new Cliente("Maria Helena"));
            clientes.salvar(new Cliente("Joao Felipe"));
            clientes.salvar(new Cliente("Jose Felipe"));

            System.out.println("Listar Todos:");
            List<Cliente> todosClientes =  clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando...");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome()+" -||-");
                clientes.atualizar(c);
                    });
            System.out.println("Listar Todos:");
            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Excluindo Maria:");
            clientes.deletar(2);

            System.out.println("Listar Todos:");
            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscar por Felipe:");
            todosClientes =  clientes.buscarPorNome("Felipe");
            todosClientes.forEach(System.out::println);



        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}