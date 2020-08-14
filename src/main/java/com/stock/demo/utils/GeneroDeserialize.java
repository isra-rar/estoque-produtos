package com.stock.demo.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.stock.demo.enums.EmpresaEnum;
import com.stock.demo.enums.GeneroEnum;

import java.io.IOException;

public class GeneroDeserialize extends StdDeserializer<GeneroEnum> {

    public GeneroDeserialize() {
        super(GeneroEnum.class);
    }

    public GeneroDeserialize(Class<?> t) {
        super(t);
    }

    @Override
    public GeneroEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int codigo = (Integer) ((IntNode) node.get("codigo")).numberValue();
        return GeneroEnum.valueOf(codigo);
    }


}
