package gk.config;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonUnitTest {

    @Test
    public void validateMaintf() {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource("config/main.tf.json").toURI()));
///Users/pggarad/work/terraformtf/terraformconsul/main.tf.json
            // convert JSON file to map

            Root root = gson.fromJson(reader, Root.class);
            List<Key> keys = root.getResource().get(0).getConsul_keys().get(0).getApp().get(0).getKey();
            System.out.println(" keys " + keys);
            MainTFValidator mainTFValidator = new MainTFValidator();
            mainTFValidator.validate(keys);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
