package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    @PostMapping
    public PriorityRule create(@RequestBody PriorityRule rule) {
        return priorityRuleService.createRule(rule);
    }

    @GetMapping("/{id}")
    public PriorityRule getById(@PathVariable Long id) {
        return priorityRuleService.getRuleById(id);
    }

    @GetMapping
    public List<PriorityRule> getAll() {
        return priorityRuleService.getAllRules();
    }

    @PutMapping("/{id}")
    public PriorityRule update(@PathVariable Long id, @RequestBody PriorityRule rule) {
        return priorityRuleService.updateRule(id, rule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        priorityRuleService.deleteRule(id);
    }
}
