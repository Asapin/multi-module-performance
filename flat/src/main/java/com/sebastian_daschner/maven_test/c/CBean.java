package com.sebastian_daschner.maven_test.c;

import jakarta.ejb.Local;

@Local
public interface CBean {

    String get();

    C get(String id);

}

