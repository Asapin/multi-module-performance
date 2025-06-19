package com.sebastian_daschner.maven_test.b;

import jakarta.ejb.Local;

@Local
public interface BBean {

    String get();

    B get(String id);

}

