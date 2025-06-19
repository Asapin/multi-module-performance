package com.sebastian_daschner.maven_test.t;

import jakarta.ejb.Local;

@Local
public interface TBean {

    String get();

    T get(String id);

}

