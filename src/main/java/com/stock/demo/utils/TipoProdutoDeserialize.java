package com.stock.demo.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.stock.demo.enums.TipoProdutoEnum;

import java.io.IOException;

public class TipoProdutoDeserialize extends StdDeserializer<TipoProdutoEnum> {

    public TipoProdutoDeserialize() {
        super(TipoProdutoEnum.class);
    }

    public TipoProdutoDeserialize(Class<?> t) {
        super(t);
    }

    @Override
    public TipoProdutoEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int codigo = (Integer) ((IntNode) node.get("codigo")).numberValue();
        return TipoProdutoEnum.valueOf(codigo);
    }


}
