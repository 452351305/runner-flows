package tech.guyi.component.flows.db.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tech.guyi.component.flows.api.endpoint.Endpoint;
import tech.guyi.component.flows.db.entry.FlowEndpoints;
import tech.guyi.web.quick.service.entity.QuickUuidEntity;

import javax.persistence.Entity;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Flow extends QuickUuidEntity {

    private String name;
    private Endpoint start;
    private Endpoint end;
    private FlowEndpoints mid;

}
