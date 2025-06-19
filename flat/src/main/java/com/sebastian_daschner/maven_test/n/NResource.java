package com.sebastian_daschner.maven_test.n;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("n")
public class NResource {

    @Inject
    NBean n;

    @GET
    public String get() {
        return n.get();
    }

    @GET
    @Path("{id}")
    public N get(@PathParam("id") String id) {
        return n.get(id);
    }

}
