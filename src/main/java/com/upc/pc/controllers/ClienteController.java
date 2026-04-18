package com.upc.pc.controllers;

import com.upc.pc.dtos.ClienteDTO;
import com.upc.pc.repositorios.ClienteRepositorio;
import com.upc.pc.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/pilco")
public class ClienteController {
    @Autowired
    ClienteServicio clienteServicio;

    @PostMapping("/pilco/cliente")
    public ClienteDTO insertar(@RequestBody ClienteDTO clienteDTO)
    {
        return clienteServicio.insertar(clienteDTO);
    }

    @GetMapping("/pilco/clientes")
    public List<ClienteDTO> listarCliente()
    {
        return clienteServicio.listarCliente();
    }

    @DeleteMapping("/pilco/{pcid}")
    public void eliminarCliente(@PathVariable Long pcid)
    {
        clienteServicio.eliminarCliente(pcid);
    }


}
