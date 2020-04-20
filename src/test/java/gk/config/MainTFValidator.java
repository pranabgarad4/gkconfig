package gk.config;


import com.google.gson.Gson;
import gk.config.validators.IValidator;
import gk.config.validators.PatternValidator;
import gk.config.validators.ThrottleKv;
import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MainTFValidator {
    private Map<String, IValidator> kv = new HashMap<>();

    public MainTFValidator() {
        kv.putIfAbsent("service/app/k1", new PatternValidator(Pattern.compile("([5-9]|10)")));
        kv.putIfAbsent("service/app/k2", new PatternValidator(Pattern.compile("(2[5-9]|30)")));
        kv.putIfAbsent("service/app/k3", new PatternValidator(Pattern.compile("(3[5-9]|40)")));
        kv.putIfAbsent("gk/throttling", new ThrottleKv());
    }

    @Test
    public void testKeyValue() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource("config/main.tf.json").toURI()));
            Root root = new Gson().fromJson(reader, Root.class);
            List<Key> keys = root.getResource().get(0).getConsul_keys().get(0).getApp().get(0).getKey();

            for (Key k : keys) {
                Assert.assertTrue("Invalid key", kv.containsKey(k.getPath()));
                System.out.println(" key validated");
                String value = k.getValue();
                IValidator validator = kv.get(k.getPath());
                validator.validate(k);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
