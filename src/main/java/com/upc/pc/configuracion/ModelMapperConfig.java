package com.upc.pc.configuracion;

import com.upc.pc.dtos.PedidoDTO;
import com.upc.pc.dtos.PedidoResponseDTO;
import com.upc.pc.entidades.Pedido;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Configuración estricta como en api-rest
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Registrar los mapeos explícitamente
        modelMapper.createTypeMap(Pedido.class, PedidoResponseDTO.class);
        return modelMapper;
    }
}