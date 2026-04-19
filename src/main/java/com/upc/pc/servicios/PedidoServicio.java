package com.upc.pc.servicios;

import com.upc.pc.dtos.*;
import com.upc.pc.entidades.Cliente;
import com.upc.pc.entidades.Pedido;
import com.upc.pc.repositorios.ClienteRepositorio;
import com.upc.pc.repositorios.PedidoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    @Autowired
    PedidoRepositorio pedidoRepositorio;
    @Autowired
    ClienteRepositorio clienteRepositorio;
    @Autowired
    ModelMapper modelMapper;

    @Transactional
    public PedidoResponseDTO insertar(PedidoRequestDTO pedidoDTO) {
        // Buscar cliente manualmente como en ArticuloService de api-rest
        Cliente cliente = clienteRepositorio.findById(pedidoDTO.getClienteId())
                .orElse(null);

        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido.setCliente(cliente);
        pedido = pedidoRepositorio.save(pedido);

        // Mapeo de respuesta asegurando el ID
        PedidoResponseDTO respuesta = modelMapper.map(pedido, PedidoResponseDTO.class);
        if (pedido.getCliente() != null) {
            respuesta.setClienteId(pedido.getCliente().getPcid());
        }
        return respuesta;
    }

    public List<PedidoResponseDTO> listarPedido() {
        return pedidoRepositorio.findAll().stream()
                .map(pedido -> {
                    PedidoResponseDTO dto = modelMapper.map(pedido, PedidoResponseDTO.class);
                    // Seteo manual para evitar el null en el listado
                    if (pedido.getCliente() != null) {
                        dto.setClienteId(pedido.getCliente().getPcid());
                    }
                    return dto;
                }).toList();
    }

    @Transactional
    public void eliminarPedido(Long pcid)
    {
        if(pedidoRepositorio.existsById(pcid))
        {
            pedidoRepositorio.deleteById(pcid);
        }
    }

    // Reporte de Rango de Fechas
    public List<PedidoDTO> pcListarPedidosRangoFechas(Date pcFechaInicio, Date pcFechaFin) {
        List<Pedido> pcLista = pedidoRepositorio.findByPcfechaBetween(pcFechaInicio, pcFechaFin);
        return pcLista.stream()
                .map(pedido -> {
                    // 1. Mapeo automático básico
                    PedidoDTO dto = modelMapper.map(pedido, PedidoDTO.class);
                    // 2. Seteo manual del ID para que no sea null (Metodología simple)
                    if (pedido.getCliente() != null) {
                        dto.setClienteId(pedido.getCliente().getPcid());
                    }
                    return dto;
                }).toList();
    }

    // Reporte de Suma por Ciudad
    public List<SumaMontoCiudadDTO> pcObtenerSumaPorCiudad() {
        // El repositorio ya hace el trabajo pesado con la consulta JPQL
        return pedidoRepositorio.pcObtenerSumaPorCiudad();
    }
}
