package com.upc.pc.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long pcid;
    private String pcnombre;
    private String pcemail;
    private String pcciudad;
}
