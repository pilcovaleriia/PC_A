package com.upc.pc.servicios;

import com.upc.pc.dtos.ClienteDTO;
import com.upc.pc.entidades.Cliente;
import com.upc.pc.repositorios.ClienteRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;
    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public ClienteDTO insertar(ClienteDTO clienteDTO)
    {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente =clienteRepositorio.save(cliente);
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public List<ClienteDTO> listarCliente()
    {
        return clienteRepositorio.findAll().stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).toList();
    }
    @Transactional
    public void eliminarCliente(Long pcid)
    {
        if(clienteRepositorio.existsById(pcid))
        {
            clienteRepositorio.deleteById(pcid);
        }
    }


}
