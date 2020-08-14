package com.stock.demo.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.stock.demo.enums.EmpresaEnum;
import com.stock.demo.enums.TipoProdutoEnum;

import java.io.IOException;

public class EmpresaDeserialize extends StdDeserializer<EmpresaEnum> {

    public EmpresaDeserialize() {
        super(EmpresaEnum.class);
    }

    public EmpresaDeserialize(Class<?> t) {
        super(t);
    }

    @Override
    public EmpresaEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int codigo = (Integer) ((IntNode) node.get("codigo")).numberValue();
        return EmpresaEnum.valueOf(codigo);
    }


}
