package com.upc.pc.dtos;

import com.upc.pc.entidades.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long pcid;
    private Long pccodigoPedido;
    private Date pcfecha;
    private Double pcmonto;
    private Long clienteId;
}
