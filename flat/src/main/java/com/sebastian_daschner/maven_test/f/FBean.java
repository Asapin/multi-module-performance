package com.sebastian_daschner.maven_test.f;

import jakarta.ejb.Local;

@Local
public interface FBean {

    String get();

    F get(String id);

}

