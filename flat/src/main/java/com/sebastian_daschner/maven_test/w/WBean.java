package com.sebastian_daschner.maven_test.w;

import jakarta.ejb.Local;

@Local
public interface WBean {

    String get();

    W get(String id);

}

