package com.sebastian_daschner.maven_test.e;

import jakarta.ejb.Local;

@Local
public interface EBean {

    String get();

    E get(String id);

}

