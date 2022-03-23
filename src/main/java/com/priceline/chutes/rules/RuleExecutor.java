package com.priceline.chutes.rules;

import com.priceline.chutes.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class RuleExecutor {
    Queue<GameRule> rules = new LinkedBlockingQueue<>();
    public void ruleExecutor(Player player,RuleStatusProcessor processor){
        rules.stream().forEach(rule -> {
            processor.processRuleResult(rule.ruleExecutor(player),player);
          }
        );
        processor.nextPlayer(player);
    }
    public void addRules(GameRule gameRule){
        rules.add(gameRule);
    }
}
