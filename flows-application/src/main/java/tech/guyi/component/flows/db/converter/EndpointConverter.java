package tech.guyi.component.flows.db.converter;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import tech.guyi.component.flows.api.endpoint.Endpoint;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
@Component
@Converter(autoApply = true)
public class EndpointConverter implements AttributeConverter<Endpoint, String> {

    private final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(Endpoint endpoints) {
        return Optional.ofNullable(endpoints).map(gson::toJson).orElse(null);
    }

    @Override
    public Endpoint convertToEntityAttribute(String s) {
        return Optional.ofNullable(s)
                .map(json -> gson.fromJson(json, Endpoint.class))
                .orElse(null);
    }

}
