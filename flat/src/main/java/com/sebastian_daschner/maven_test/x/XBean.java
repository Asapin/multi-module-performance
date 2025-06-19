package com.sebastian_daschner.maven_test.x;

import jakarta.ejb.Local;

@Local
public interface XBean {

    String get();

    X get(String id);

}

