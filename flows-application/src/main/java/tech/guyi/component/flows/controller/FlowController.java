package tech.guyi.component.flows.controller;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.guyi.component.flows.db.entity.Flow;
import tech.guyi.component.flows.service.FlowService;
import tech.guyi.web.quick.core.controller.ResponseContent;
import tech.guyi.web.quick.core.controller.ResponseEntities;
import tech.guyi.web.quick.service.controller.QuickServiceController;

import javax.annotation.Resource;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
@RestController
@RequestMapping("flow")
public class FlowController implements QuickServiceController<Flow,String> {

    @Getter
    @Resource
    private FlowService service;

    @GetMapping("/start/{id}")
    public ResponseEntity<ResponseContent<Boolean>> start(@PathVariable("id") String flowId){
        try{
            this.service.start(flowId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntities.ok(true);
    }

    @GetMapping("/stop/{id}")
    public ResponseEntity<ResponseContent<Boolean>> stop(@PathVariable("id") String flowId){
        this.service.stop(flowId);
        return ResponseEntities.ok(true);
    }

}
