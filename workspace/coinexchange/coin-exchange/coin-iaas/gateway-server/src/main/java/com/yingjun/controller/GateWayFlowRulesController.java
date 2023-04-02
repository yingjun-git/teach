package com.yingjun.controller;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @ClassName GateWayFlowRulesController
 * @Description
 * @Author 陈英俊
 * @Date 2023/4/2 21:46
 * @Version 1.0
 */
@RestController
public class GateWayFlowRulesController {
	/**
	 * 获取当前系统的限流策略
	 */
	@GetMapping("/gw/flow/rules")
	public Set<GatewayFlowRule> getCurrentGatewayFlowRules() {
		return GatewayRuleManager.getRules();
	}

	/**
	 * 获取自定义的api分组
	 */
	@GetMapping("/gw/api/groups")
	public Set<ApiDefinition> getApiGroup() {
		return GatewayApiDefinitionManager.getApiDefinitions();
	}
}
