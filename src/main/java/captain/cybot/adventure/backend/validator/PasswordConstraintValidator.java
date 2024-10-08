package captain.cybot.adventure.backend.validator;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.passay.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

@NoArgsConstructor
public class PasswordConstraintValidator {

    @SneakyThrows
    public boolean isValid(String password) {

        //customizing validation messages
        Properties props = new Properties();
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("passay.properties");

        props.load(inputStream);
        MessageResolver resolver = new PropertiesMessageResolver(props);

        PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(

                // length between 8 and 24 characters
                new LengthRule(8, 24),

                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, 1),

                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, 1),

                // at least one symbol (special character)
                new CharacterRule(EnglishCharacterData.Special, 1),

                // no whitespace
                new WhitespaceRule()
        ));

        RuleResult result = validator.validate(new PasswordData(password));
        return result.isValid();
    }
}