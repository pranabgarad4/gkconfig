package gk.config.validators;

import gk.config.Key;

import java.util.regex.Pattern;

public interface IValidator {
    void validate(Key k);
}
