package gk.config.validators;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import gk.config.Key;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.Map;

public class ThrottleKv implements IValidator {

    @Override
    public void validate(Key key) {
        try {
            Type configMapType = new TypeToken<Map<String, String>>() {
            }.getType();

            Map<String, String> configMap = new Gson().fromJson(key.getValue(), configMapType);


            if (configMap != null) {
                int maxThrottling = 0;
                int minThrottling = 0;
                int minQueueDelay = 0;
                int normalQueueDelay = 0;
                int queueSize = 0;

                try {
                    maxThrottling = Integer.valueOf(configMap.get("maxThrottling"));
                    minThrottling = Integer.valueOf(configMap.get("minThrottling"));
                    minQueueDelay = Integer.valueOf(configMap.get("minQueueDelay"));
                    normalQueueDelay = Integer.valueOf(configMap.get("normalQueueDelay"));
                    queueSize = Integer.valueOf(configMap.get("queueSize"));

                    System.out.println("maxThrottling: " + maxThrottling + "\n" +
                            "minThrottling: " + minThrottling + "\n" +
                            "minQueueDelay: " + minQueueDelay + "\n" +
                            "normalQueueDelay: " + normalQueueDelay + "\n" +
                            "queueSize: " + queueSize);

                    Assert.assertTrue("Min Throttling Value incorrect", minThrottling > 0);
                    Assert.assertTrue("Max Throttling Value incorrect", maxThrottling > minThrottling);
                    Assert.assertTrue("Min Queue Delay Value incorrect", minQueueDelay > 0);
                    Assert.assertTrue("Normal Queue Delay Value incorrect", normalQueueDelay > 0);
                    Assert.assertTrue("Queue size incorrect", queueSize > 0);

                } catch (NumberFormatException nfe) {
                    Assert.fail("Values incorrect " + nfe.getMessage());
                }
            }
        } catch (JsonSyntaxException jse) {
            Assert.fail("Json Syntax incorrect " + jse.getMessage());
        }
    }
}
