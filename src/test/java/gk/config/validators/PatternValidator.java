package gk.config.validators;

import gk.config.Key;
import org.junit.Assert;

import java.util.regex.Pattern;

public class PatternValidator implements IValidator {
    private Pattern pattern;

    public PatternValidator(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public void validate(Key k) {
        Assert.assertTrue("Invalid value should be like " + pattern.pattern(), pattern.matcher(k.getValue()).matches());
    }
}
