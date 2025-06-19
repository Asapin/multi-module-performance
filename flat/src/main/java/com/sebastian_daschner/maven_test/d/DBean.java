package com.sebastian_daschner.maven_test.d;

import jakarta.ejb.Local;

@Local
public interface DBean {

    String get();

    D get(String id);

}

