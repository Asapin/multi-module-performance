package com.sebastian_daschner.maven_test.m;

import jakarta.ejb.Stateless;

@Stateless
public class MBeanImpl implements MBean {

    @Override
    public String get() {
        return "m";
    }

    @Override
    public M get(String id) {
        return new M(id);
    }

}
