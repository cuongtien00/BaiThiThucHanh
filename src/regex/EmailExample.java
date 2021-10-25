package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private Pattern pattern;
    private Matcher matcher;
    private  static  final String EMAIL_EXAMPLE = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailExample() {
        pattern = pattern.compile(EMAIL_EXAMPLE);
    }
    public boolean validateEmail(String email){
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
