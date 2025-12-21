package com.example.demo.service.impl;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public PriorityRule createRule(PriorityRule rule) {
        return priorityRuleRepository.save(rule);
    }

    @Override
    public PriorityRule getRuleById(Long id) {
        return priorityRuleRepository.findById(id).orElse(null);
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return priorityRuleRepository.findAll();
    }

    @Override
    public PriorityRule updateRule(Long id, PriorityRule rule) {
        PriorityRule existing = priorityRuleRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setRuleName(rule.getRuleName());
            existing.setDescription(rule.getDescription());
            existing.setWeight(rule.getWeight());
            existing.setActive(rule.isActive());
            return priorityRuleRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteRule(Long id) {
        priorityRuleRepository.deleteById(id);
    }
}
