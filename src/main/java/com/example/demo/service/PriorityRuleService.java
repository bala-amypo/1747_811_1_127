package com.example.demo.service;

import com.example.demo.entity.PriorityRule;
import java.util.List;

public interface PriorityRuleService {

    PriorityRule createRule(PriorityRule rule);

    PriorityRule getRuleById(Long id);

    List<PriorityRule> getAllRules();

    PriorityRule updateRule(Long id, PriorityRule rule);

    void deleteRule(Long id);
}
