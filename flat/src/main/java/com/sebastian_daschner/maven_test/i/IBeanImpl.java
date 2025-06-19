package com.sebastian_daschner.maven_test.i;

import jakarta.ejb.Stateless;

@Stateless
public class IBeanImpl implements IBean {

    @Override
    public String get() {
        return "i";
    }

    @Override
    public I get(String id) {
        return new I(id);
    }

}
