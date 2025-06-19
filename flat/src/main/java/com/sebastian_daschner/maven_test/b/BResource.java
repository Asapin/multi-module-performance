package com.sebastian_daschner.maven_test.b;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("b")
public class BResource {

    @Inject
    BBean b;

    @GET
    public String get() {
        return b.get();
    }

    @GET
    @Path("{id}")
    public B get(@PathParam("id") String id) {
        return b.get(id);
    }

}
