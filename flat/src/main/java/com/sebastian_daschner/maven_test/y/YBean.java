package com.sebastian_daschner.maven_test.y;

import jakarta.ejb.Local;

@Local
public interface YBean {

    String get();

    Y get(String id);

}

