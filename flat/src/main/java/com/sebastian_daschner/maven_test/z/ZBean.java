package com.sebastian_daschner.maven_test.z;

import jakarta.ejb.Local;

@Local
public interface ZBean {

    String get();

    Z get(String id);

}

