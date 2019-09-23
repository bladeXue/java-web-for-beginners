package com.blade.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {

    public static void main(String[] args) {

        String s = "薛志健";
        s = URLEncoder.encode(s);

        System.out.println(s);
        System.out.println(URLDecoder.decode(s));

    }
}
