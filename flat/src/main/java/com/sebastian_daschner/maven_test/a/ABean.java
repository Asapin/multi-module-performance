package com.sebastian_daschner.maven_test.a;

import jakarta.ejb.Local;

@Local
public interface ABean {

    String get();

    A get(String id);

}

