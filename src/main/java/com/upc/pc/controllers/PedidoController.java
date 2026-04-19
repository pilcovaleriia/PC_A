package com.upc.pc.controllers;

import com.upc.pc.dtos.*;
import com.upc.pc.servicios.ClienteServicio;
import com.upc.pc.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping("/pilco/pedido")
    public PedidoResponseDTO insertar(@RequestBody PedidoRequestDTO pedidoDTO) {
        return pedidoServicio.insertar(pedidoDTO);
    }

    @GetMapping("/pilco/pedidos")
    public List<PedidoResponseDTO> listarPedido() {
        return pedidoServicio.listarPedido();
    }

    @DeleteMapping("/pilco/pedidos/{pcid}")
    public void eliminarPedido(@PathVariable Long pcid)
    {
        pedidoServicio.eliminarPedido(pcid);
    }

    @GetMapping("/pilco/reporte-fechas")
    public List<PedidoDTO> listarPorRango(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fin) {
        return pedidoServicio.pcListarPedidosRangoFechas(inicio, fin);
    }

    @GetMapping("/pilco/reporte-ciudad")
    public List<SumaMontoCiudadDTO> listarSumaPorCiudad() {
        return pedidoServicio.pcObtenerSumaPorCiudad();
    }

}
