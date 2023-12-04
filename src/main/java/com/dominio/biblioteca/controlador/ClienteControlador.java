package com.dominio.biblioteca.controlador;

import com.dominio.biblioteca.entidade.Cliente;
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
    private final ClienteRepositorio repositorio;

}
