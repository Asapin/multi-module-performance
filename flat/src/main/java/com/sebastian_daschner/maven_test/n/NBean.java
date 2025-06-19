package com.sebastian_daschner.maven_test.n;

import jakarta.ejb.Local;

@Local
public interface NBean {

    String get();

    N get(String id);

}

