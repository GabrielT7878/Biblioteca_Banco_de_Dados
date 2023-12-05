package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.TelefonesE;
import com.dominio.biblioteca.entidade.TelefonesP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonePRepositorio extends JpaRepository<TelefonesP,Integer> {
}
