package gk.config;


import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MainTFValidator {

    private Map<String, Object> kv = new HashMap<>();

    public MainTFValidator() {
        kv.putIfAbsent("service/app/k1", Pattern.compile("([5-9]|10)"));
        kv.putIfAbsent("service/app/k2", Pattern.compile("(2[5-9]|30)"));
        kv.putIfAbsent("service/app/k3", Pattern.compile("(3[5-9]|40)"));
    }

    public void validate(List<Key> keys) {
        System.out.println(" validating ... ");
        for (Key k : keys) {
            Assert.assertTrue("Invalid key", kv.containsKey(k.getPath()));
            System.out.println(" key validated");
            String value = k.getValue();
            Pattern pattern = (Pattern) kv.get(k.getPath());
            Assert.assertTrue("Invalid value should be like " + pattern.pattern(), pattern.matcher(value).matches());
        }
    }
}
