package com.dominio.biblioteca.controlador;

import com.dominio.biblioteca.entidade.Cliente;
import com.dominio.biblioteca.entidade.Pessoa;
import com.dominio.biblioteca.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Controller;
import com.dominio.biblioteca.servico.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@Log4j2
@Controller
public class ClienteControlador {
    private final ClienteServico servico;
    @GetMapping("/clientes")
    public String obterClientes(Model model){
        List<Cliente> clientes = servico.obterClientes();
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/clientes/filtrarCliente")
    public String buscarCliente(Model model,@RequestParam(name = "nome", required = false) String nome){
        List<Cliente> clientes = servico.buscarCliente(nome);
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/clientes/SaldoPositivo")
    public String buscarClienteSaldoPositivo(Model model){
        List<Cliente> clientes = servico.buscarClienteSaldoPositivo();
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/clientes/SaldoNegativo")
    public String buscarClienteSaldoNegativo(Model model){
        List<Cliente> clientes = servico.buscarClienteSaldoNegativo();
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/clientes/SaldoVariavel")
    public String buscarClienteSaldoMaiorQueX(Model model,@RequestParam(name = "valor", required = true) Double var){
        List<Cliente> clientes = servico.buscarClienteSaldoMaiorQueX(var);
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/clientes/OrdenarPorSaldo")
    public String ordenarPorSaldo(Model model){
        List<Cliente> clientes = servico.ordenarPorSaldo();
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/clientes/ClientesCompraOuVenda")
    public String buscarClientesQueCompraramOuVenderam(Model model){
        List<Cliente> clientes = servico.buscarClientesQueCompraramOuVenderam();
        model.addAttribute("clientes",clientes);
        return "clientes";
    }

    @GetMapping("/clientes/ClientesCompraEVenda")
    public String buscarClientesQueCompraramEVenderam(Model model) {
        List<Cliente> clientes = servico.buscarClientesQueCompraramEVenderam();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/clientes/ClientesSaldoMaiorAlgumID")
    public String buscarClientesComSaldoMaiorQueAlgumIDX(Model model,@RequestParam(name = "valor", required = true) Integer x) {
        List<Cliente> clientes = servico.buscarClientesComSaldoMaiorQueAlgumIDX(x);
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/clientes/ClientesSaldoMaiorTodosID")
    public String buscarClientesComSaldoMaiorQueTodosIDX(Model model,@RequestParam(name = "valor", required = true) Integer x) {
        List<Cliente> clientes = servico.buscarClientesComSaldoMaiorQueTodosIDX(x);
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/clientes/concatenarNomeSobrenome")
    public String concatenarNomeSobrenome(Model model,String nome) {
        List<String> nomesCompletos = servico.concatenarNomeSobrenome(nome);
        model.addAttribute("nomesCompletos", nomesCompletos);
        return "clientes";
    }

    @GetMapping("/clientes/adicionarCliente")
    public String adicionarCliente() {
        return "adicionarCliente";
    }

    @PostMapping("/clientes/cadastrar")
    public String cadastrarCliente(@RequestBody Pessoa cliente) {
        servico.cadastrarCliente(cliente);
        return "adicionarCliente";
    }


}
