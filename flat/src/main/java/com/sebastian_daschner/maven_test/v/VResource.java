package com.sebastian_daschner.maven_test.v;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("v")
public class VResource {

    @Inject
    VBean v;

    @GET
    public String get() {
        return v.get();
    }

    @GET
    @Path("{id}")
    public V get(@PathParam("id") String id) {
        return v.get(id);
    }

}
