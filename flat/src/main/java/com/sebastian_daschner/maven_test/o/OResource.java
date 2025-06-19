package com.sebastian_daschner.maven_test.o;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("o")
public class OResource {

    @Inject
    OBean o;

    @GET
    public String get() {
        return o.get();
    }

    @GET
    @Path("{id}")
    public O get(@PathParam("id") String id) {
        return o.get(id);
    }

}
