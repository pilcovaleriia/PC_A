package com.upc.pc.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pcid;
    @Column(unique = true, nullable = false)
    private Long pccodigoPedido;
    private Date pcfecha;
    private Double pcmonto;
    @ManyToOne
    @JoinColumn(name = "clienteid")
    private Cliente cliente;

// Tipo de producto --> 1 a muchos productos                Productos(muchoss) many to one (tipo de producto)
// Cliente --> 1 a muchos pedidos                           Pedidos(muchos) many to one (cliente)


    //DANIEL lo unico q falta son los 2 reportes PEEEEEEEEEEERO el problema
    //es que el profe pide en la pc q las 2 entidades tengan dto y se registren en swagger o postman
    //PEEEEEEEEEEEEEEEEEEEEERO el no hizo eso en el cod de ejemplo, se ahorro cod usando el database del intellij
    //pero nos pide eso a nosotros loodiocontodamialma yyyyyyyyy ya se puede registrar/listar/eliminar las 2 entidades pero
    //cuando quieres regitrar pedido tienes q asignarlo a un cliente mediante idcliente y no se como se hace eso en post/swagger pq elPROFENO LOHZIOLO ODIO
    //asi q en el dto puse idcliente en vez del objeto para q aparezca y funciona pero no tan bien
    // me rindo DANIEL, dejo el resto en tus manos jjk referencia c:
    //
}
