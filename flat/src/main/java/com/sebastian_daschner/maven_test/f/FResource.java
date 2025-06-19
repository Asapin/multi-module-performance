package com.sebastian_daschner.maven_test.f;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("f")
public class FResource {

    @Inject
    FBean f;

    @GET
    public String get() {
        return f.get();
    }

    @GET
    @Path("{id}")
    public F get(@PathParam("id") String id) {
        return f.get(id);
    }

}
