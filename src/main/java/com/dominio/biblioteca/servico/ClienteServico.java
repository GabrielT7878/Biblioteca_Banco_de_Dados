package com.dominio.biblioteca.servico;



import com.dominio.biblioteca.entidade.Cliente;
import com.dominio.biblioteca.entidade.Pessoa;
import com.dominio.biblioteca.entidade.TelefonesP;
import com.dominio.biblioteca.repositorio.ClienteRepositorio;
import com.dominio.biblioteca.repositorio.PessoaRepositorio;
import com.dominio.biblioteca.repositorio.TelefonePRepositorio;
import lombok.AllArgsConstructor;
import org.hibernate.collection.spi.PersistentSortedMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ClienteServico {
    private final ClienteRepositorio repositorio;
    private final PessoaRepositorio repositorioPessoa;
    private  final TelefonePRepositorio repositorioTelefone;
    public List<Cliente> obterClientes(){
        return repositorio.obterClientes();
    }

    public List<Cliente> buscarCliente(String nome){
        return repositorio.buscarCliente(nome);
    }

    public List<Cliente> buscarClienteSaldoPositivo(){
        return repositorio.buscarClientesSaldoPositivo();
    }

    public List<Cliente> buscarClienteSaldoNegativo(){
        return repositorio.buscarClientesSaldoNegativo();
    }

    public List<Cliente> buscarClienteSaldoMaiorQueX(Double var){
        if(var == 0){
            return buscarClienteSaldoPositivo();
        } else if (var == -1) {
            return buscarClienteSaldoNegativo();
        }
        return repositorio.buscarClientesSaldoMaiorQueX(var);
    }

    public List<Cliente> ordenarPorSaldo(){return repositorio.ordenarPorSaldo();}

    public List<Cliente> buscarClientesQueCompraramOuVenderam(){return repositorio.buscarClientesQueCompraramOuVenderam();}

    public List<Cliente> buscarClientesQueCompraramEVenderam(){return repositorio.buscarClientesQueCompraramEVenderam();}

    public List<Cliente> buscarClientesComSaldoMaiorQueAlgumIDX(Integer x){return repositorio.buscarClientesComSaldoMaiorQueAlgumIDX(x);}

    public List<Cliente> buscarClientesComSaldoMaiorQueTodosIDX(Integer x){return repositorio.buscarClientesComSaldoMaiorQueTodosIDX(x);}

    public List<String> concatenarNomeSobrenome(String nome) { return repositorio.concatenarNomeSobrenome(nome);}

    public void inserirCliente(String nome, String ultNome, String cpf, String telefone){
            Cliente cliente = new Cliente();
    }

    public boolean cadastrarCliente(String nome, String ultimoNome,String cpf, String telefone){
        if(Objects.isNull(cpf) || cpf.isEmpty()){
            return false;
        }
        if(Objects.isNull(nome) || nome.isEmpty()){
            return false;
        }
        if(Objects.isNull(ultimoNome) || ultimoNome.isEmpty()){
            return false;
        }
        Pessoa pessoa  = new Pessoa();
        Cliente clienteNovo = new Cliente();

        pessoa.setCpf(cpf);
        pessoa.setNome(nome);
        pessoa.setUltimoNome(ultimoNome);
        repositorioPessoa.save(pessoa);
        if(!Objects.isNull(telefone) || !telefone.isEmpty()){
            TelefonesP telefonesP = new TelefonesP();
            telefonesP.setTelefone(telefone);
            telefonesP.setPessoa(pessoa);
            telefonesP.setPessoaId(pessoa.getIdPessoa());
            repositorioTelefone.save(telefonesP);
        }
        clienteNovo.setPessoa(pessoa);
        clienteNovo.setSaldo(0.0);
        repositorio.save(clienteNovo);
        return true;
    }

    public Integer buscarTotalClientes(){return repositorio.buscarTotalClientes();}

    public Double buscarMediaSaldo(){return repositorio.buscarMediaSaldo();}
}
