package com.sebastian_daschner.maven_test.g;

import jakarta.ejb.Local;

@Local
public interface GBean {

    String get();

    G get(String id);

}

