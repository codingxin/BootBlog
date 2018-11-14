package com.zhang.myblog.config;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by ASUS on 2018/6/30
 *
 * @Authod Grey Wolf
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
