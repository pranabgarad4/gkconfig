package gk.config;

import com.google.gson.Gson;
import gk.config.validators.IValidator;
import gk.config.validators.ThrottleKv;
import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThrottlingTfValidator {
    private Map<String, IValidator> kv = new HashMap<>();

    public ThrottlingTfValidator() {
        kv.putIfAbsent("gk/throttling", new ThrottleKv());
    }

    @Test
    public void testKeyValue() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource("config/throttling.tf.json").toURI()));
            Root root = new Gson().fromJson(reader, Root.class);
            List<Key> keys = root.getResource().get(0).getConsul_keys().get(0).getApp().get(0).getKey();

            for (Key k : keys) {
                Assert.assertTrue("Invalid key", kv.containsKey(k.getPath()));
                System.out.println(" key validated");
                IValidator validator = kv.get(k.getPath());
                validator.validate(k);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
