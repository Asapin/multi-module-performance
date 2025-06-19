package com.sebastian_daschner.maven_test.r;

import jakarta.ejb.Local;

@Local
public interface RBean {

    String get();

    R get(String id);

}

