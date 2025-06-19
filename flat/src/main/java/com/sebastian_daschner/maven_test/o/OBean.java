package com.sebastian_daschner.maven_test.o;

import jakarta.ejb.Local;

@Local
public interface OBean {

    String get();

    O get(String id);

}

