package com.blade.test;

import com.blade.jdbc.UserDao;
import com.blade.model.User;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));

    }
}
