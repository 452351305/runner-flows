package tech.guyi.component.flows.service;

import tech.guyi.component.flows.db.entity.Flow;
import tech.guyi.web.quick.service.service.QuickService;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
public interface FlowService extends QuickService<Flow,String> {

    void start(String flowId);

    void stop(String flowId);

}
