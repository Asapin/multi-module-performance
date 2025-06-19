package com.sebastian_daschner.maven_test.p;

import jakarta.ejb.Local;

@Local
public interface PBean {

    String get();

    P get(String id);

}

