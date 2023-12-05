package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {
    @Query("select c from Cliente c")
    List<Cliente> obterClientes();

    @Query("select c from Cliente c where c.pessoa.nome like :nome%")
    List<Cliente> buscarCliente(String nome);

    @Query("select c from Pessoa as p, Cliente as c where p.idPessoa = c.idPessoa AND c.saldo > 0")
    List<Cliente> buscarClienteSaldoPostivo();

    // (Exemplo de renomeação) Encontrar nomes de clientes com saldo positivo
    @Query("select c from Pessoa as p, Cliente as c where p.idPessoa = c.idPessoa AND c.saldo > 0")
    List<Cliente> buscarClientesSaldoPositivo();

    // (Exemplo de renomeação) Encontrar nomes de clientes com saldo negativo
    @Query("select c from Pessoa as p, Cliente as c where p.idPessoa = c.idPessoa AND c.saldo < 0")
    List<Cliente> buscarClientesSaldoNegativo();

    // (Exemplo de renomeação) Encontrar nomes de clientes com saldo maior a variavel
    @Query("select c from Pessoa as p, Cliente as c where p.idPessoa = c.idPessoa AND c.saldo > :var")
    List<Cliente> buscarClientesSaldoMaiorQueX(Double var);
    @Query("select t from TelefonesP as t")
    List<Cliente> obterTelefones();

    // (Exemplo de ordenação) Ordernar clientes por saldo
    @Query("select c from Cliente as c order by c.saldo")
    List<Cliente> ordenarPorSaldo();

    // (Exemplo de operação de conjunto) Encontrar clientes que compraram OU venderam um livro
    @Query("select distinct c from Pessoa as p, Cliente as c, Vende as v where c.idPessoa = p.idPessoa and v.pessoaId = p.idPessoa union select distinct c from Pessoa as p, Cliente as c, Compra as co where c.idPessoa = p.idPessoa and co.pessoaId = p.idPessoa")
    List<Cliente> buscarClientesQueCompraramOuVenderam();

    // (Exemplo de operação de conjunto) Encontrar clientes que compraram E venderam um livro
    @Query("select distinct c from Pessoa as p, Cliente as c, Vende as v where c.idPessoa = p.idPessoa and v.pessoaId = p.idPessoa intersect select distinct c from Pessoa as p, Cliente as c, Compra as co where c.idPessoa = p.idPessoa and co.pessoaId = p.idPessoa")
    List<Cliente> buscarClientesQueCompraramEVenderam();

    //(Exemplo de operação de multiconjunto) Encontrar clientes que possuem saldo maior que qualquer cliente com ID acima de x;
    @Query("select c from Cliente c where c.saldo > any (select distinct c.saldo from Cliente c where c.idPessoa < :x)")
    List<Cliente> buscarClientesComSaldoMaiorQueAlgumIDX(Integer x);

    //(Exemplo de operação de multiconjunto) Encontrar clientes que possuem saldo maior que todos clientes com ID acima de x;
    @Query("select c from Cliente c where c.saldo > any(select distinct c.saldo from Cliente c where c.idPessoa < :x)")
    List<Cliente> buscarClientesComSaldoMaiorQueTodosIDX(Integer x);

    @Query("select CONCAT(c.pessoa.nome, ' ', c.pessoa.ultimoNome) from Cliente c")
    List<String> concatenarNomeSobrenome(String nome);

}
