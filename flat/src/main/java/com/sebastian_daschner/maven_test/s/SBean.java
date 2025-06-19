package com.sebastian_daschner.maven_test.s;

import jakarta.ejb.Local;

@Local
public interface SBean {

    String get();

    S get(String id);

}

