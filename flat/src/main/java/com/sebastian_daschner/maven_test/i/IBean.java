package com.sebastian_daschner.maven_test.i;

import jakarta.ejb.Local;

@Local
public interface IBean {

    String get();

    I get(String id);

}

