package com.sebastian_daschner.maven_test.v;

import jakarta.ejb.Local;

@Local
public interface VBean {

    String get();

    V get(String id);

}

