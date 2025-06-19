package com.sebastian_daschner.maven_test.a;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("a")
public class AResource {

    @Inject
    ABean a;

    @GET
    public String get() {
        return a.get();
    }

    @GET
    @Path("{id}")
    public A get(@PathParam("id") String id) {
        return a.get(id);
    }

}
