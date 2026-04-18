package com.upc.pc.controllers;

import com.upc.pc.dtos.ClienteDTO;
import com.upc.pc.dtos.PedidoDTO;
import com.upc.pc.servicios.ClienteServicio;
import com.upc.pc.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping("/pilco/pedido")
    public PedidoDTO insertar(@RequestBody PedidoDTO pedidoDTO)
    {
        return pedidoServicio.insertar(pedidoDTO);
    }

    @GetMapping("/pilco/pedidos")
    public List<PedidoDTO> listarCliente()
    {
        return pedidoServicio.listarPedido();
    }

    @DeleteMapping("/pilco/pedidos/{pcid}")
    public void eliminarPedido(@PathVariable Long pcid)
    {
        pedidoServicio.eliminarPedido(pcid);
    }
}
