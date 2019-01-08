package com.ruoyi.envents.drools.droolsTest;

import java.util.HashMap;
import java.util.Map;

import com.ruoyi.envents.drools.bean.Refuse;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
    public static final void main(String[] args) {
        try {
            Map<String,String> refuseDate=new HashMap<String, String>();
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("session-base");
            Refuse refuse=new Refuse();
            refuse.setAge(80);
            kSession.setGlobal("refuseDate",refuseDate);
            kSession.insert(refuse);
            int count=kSession.fireAllRules();
            System.out.println("规则执行条数：--------"+count);
            System.out.println("规则执行完成--------"+refuse.toString());
            System.out.println(kSession.getGlobals().toString());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
