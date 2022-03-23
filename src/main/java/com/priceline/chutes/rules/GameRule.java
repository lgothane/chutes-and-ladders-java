package com.priceline.chutes.rules;

import com.priceline.chutes.Player;

public interface GameRule {
    public RuleStatus ruleExecutor(Player player);
}
