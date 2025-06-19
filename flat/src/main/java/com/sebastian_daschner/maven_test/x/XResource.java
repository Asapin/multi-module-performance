package com.sebastian_daschner.maven_test.x;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("x")
public class XResource {

    @Inject
    XBean x;

    @GET
    public String get() {
        return x.get();
    }

    @GET
    @Path("{id}")
    public X get(@PathParam("id") String id) {
        return x.get(id);
    }

}
