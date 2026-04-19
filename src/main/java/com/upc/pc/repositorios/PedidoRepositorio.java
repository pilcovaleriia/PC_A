package com.upc.pc.repositorios;

import com.upc.pc.dtos.SumaMontoCiudadDTO;
import com.upc.pc.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

    List<Pedido> findByPcfechaBetween(Date pcfechaInicio, Date pcfechaFin);

    @Query("SELECT new com.upc.pc.dtos.SumaMontoCiudadDTO(p.cliente.pcciudad, SUM(p.pcmonto)) " +
            "FROM Pedido p GROUP BY p.cliente.pcciudad")
    List<SumaMontoCiudadDTO> pcObtenerSumaPorCiudad();
}
