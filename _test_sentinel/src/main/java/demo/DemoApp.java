package demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.noear.solon.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author noear 2021/3/6 created
 */
public class DemoApp {
    public static void main(String[] args) throws Exception {
        initFlowRules("HelloWorld", 2);

        for (int i = 0; i < 100; i++) {
            Utils.pools.submit(() -> {
                try (Entry entry = SphU.entry("HelloWorld")) {
                    System.out.println("hello world");
                } catch (BlockException ex) {
                    System.out.println("blocked!");
                }
            });
        }
    }

    private static void initFlowRules(String breakerName, int permits) {
        List<FlowRule> ruleList = new ArrayList<>();
        FlowRule rule = null;

        rule = new FlowRule();
        rule.setResource(breakerName);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS); //qps
        rule.setCount(permits);
        ruleList.add(rule);

        rule = new FlowRule();
        rule.setResource(breakerName);
        rule.setGrade(RuleConstant.FLOW_GRADE_THREAD); //并发数
        rule.setCount(permits);
        ruleList.add(rule);

        FlowRuleManager.loadRules(ruleList);
    }
}
