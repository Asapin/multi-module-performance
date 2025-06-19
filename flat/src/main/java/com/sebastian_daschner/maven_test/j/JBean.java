package com.sebastian_daschner.maven_test.j;

import jakarta.ejb.Local;

@Local
public interface JBean {

    String get();

    J get(String id);

}

