package Modulo_Compras.Interface.Rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public ObjectMapperContextResolver() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        /*Esto indica que las fechas deben representarse como texto ISO (por ejemplo "2024-06-05") y no como timestamps (por ejemplo 1717555200000).*/
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}


//CLASE QUE PUEDE AYUDAR A SER UTLIZADA PARA QUE ENTIENDA COMO UTILIZAR LOS LOCALDATE