package com.upc.pc.servicios;

import com.upc.pc.dtos.ClienteDTO;
import com.upc.pc.dtos.PedidoDTO;
import com.upc.pc.entidades.Cliente;
import com.upc.pc.entidades.Pedido;
import com.upc.pc.repositorios.ClienteRepositorio;
import com.upc.pc.repositorios.PedidoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicio
{
    @Autowired
    PedidoRepositorio pedidoRepositorio;
    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public PedidoDTO insertar(PedidoDTO pedidoDTO)
    {
        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido =pedidoRepositorio.save(pedido);
        return modelMapper.map(pedido, PedidoDTO.class);
    }

    public List<PedidoDTO> listarPedido()
    {
        return pedidoRepositorio.findAll().stream()
                .map(pedido -> modelMapper.map(pedido, PedidoDTO.class)).toList();
    }

    @Transactional
    public void eliminarPedido(Long pcid)
    {
        if(pedidoRepositorio.existsById(pcid))
        {
            pedidoRepositorio.deleteById(pcid);
        }
    }

}
