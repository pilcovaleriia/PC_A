package com.upc.pc.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {
    private Long pccodigoPedido;
    private Date pcfecha;
    private Double pcmonto;
    private Long clienteId;
}
