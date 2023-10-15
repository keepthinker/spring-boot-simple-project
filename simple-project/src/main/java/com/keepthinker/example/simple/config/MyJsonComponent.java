package com.keepthinker.example.simple.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.keepthinker.example.simple.vo.Phone;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class MyJsonComponent {

    public static class Serializer extends JsonSerializer<Phone> {

        @Override
        public void serialize(Phone value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
            jgen.writeStartObject();
            jgen.writeStringField("name", "name: " + value.getName());
            jgen.writeNumberField("price", value.getPrice());
            jgen.writeEndObject();
        }

    }

    public static class Deserializer extends JsonDeserializer<Phone> {

        @Override
        public Phone deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
            ObjectCodec codec = jsonParser.getCodec();
            JsonNode tree = codec.readTree(jsonParser);
            String name = "name: " + tree.get("name").textValue();
            int price = tree.get("price").intValue();
            return new Phone(name, price);
        }

    }

}