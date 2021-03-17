package tech.guyi.component.flows.db.converter;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import tech.guyi.component.flows.db.entry.FlowEndpoints;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
@Component
@Converter(autoApply = true)
public class EndpointsConverter implements AttributeConverter<FlowEndpoints, String> {

    private final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(FlowEndpoints endpoints) {
        return Optional.ofNullable(endpoints).map(gson::toJson).orElse(null);
    }

    @Override
    public FlowEndpoints convertToEntityAttribute(String s) {
        return Optional.ofNullable(s)
                .map(json -> gson.fromJson(json, FlowEndpoints.class))
                .orElse(null);
    }

}
