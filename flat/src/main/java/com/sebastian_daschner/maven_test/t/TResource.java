package com.sebastian_daschner.maven_test.t;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("t")
public class TResource {

    @Inject
    TBean t;

    @GET
    public String get() {
        return t.get();
    }

    @GET
    @Path("{id}")
    public T get(@PathParam("id") String id) {
        return t.get(id);
    }

}
