package com.sebastian_daschner.maven_test.l;

import jakarta.ejb.Local;

@Local
public interface LBean {

    String get();

    L get(String id);

}

