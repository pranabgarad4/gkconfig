package gk.config;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import gk.config.validators.IValidator;
import gk.config.validators.ThrottleKv;
import org.junit.Ignore;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThrottlingTfValidator {
    private Map<String, IValidator> kv = new HashMap<>();

    public ThrottlingTfValidator() {
        kv.putIfAbsent("gk/throttling", new ThrottleKv());
    }

    @Ignore
    public void testKeyValue() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource("config/throttling.tf.json").toURI()));

//            Map<?, ?> config = new Gson().fromJson(reader, Map.class);
            LinkedTreeMap treeMap = new Gson().fromJson(reader, LinkedTreeMap.class);
            reader.close();
            List resources = (ArrayList) treeMap.get("resource");
            System.out.println(" resources " + treeMap.toString());
            Resource resource = new Gson().fromJson(resources.toString(), Resource.class);
            System.out.println(" Resource " + resource);

//            for(Object key: config.keySet()) {
//                if(key.equals("resource")) {
//                    LinkedTreeMap treeMap = (LinkedTreeMap)((ArrayList)config.get(key)).get(0);
//                    System.out.println(" treeMap " + treeMap);
//
//
////                    Resource resource = new Gson().fromJson((Object) config.get(key), Resource.class);
////                    System.out.println("Resource " + resource);
//                }
////                System.out.println(" key " + key);
//            }
////            Root root = new Gson().fromJson(reader, Root.class);
////            List<Key> keys = root.getResource().get(0).getConsul_keys().get(0).getApp().get(0).getKey();
////
////            for (Key k : keys) {
////                Assert.assertTrue("Invalid key", kv.containsKey(k.getPath()));
////                System.out.println(" key validated");
////                IValidator validator = kv.get(k.getPath());
////                validator.validate(k);
////            }
//            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ThrottlingTfValidator().testKeyValue();
    }
}
