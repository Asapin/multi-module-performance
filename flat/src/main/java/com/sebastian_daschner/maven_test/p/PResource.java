package com.sebastian_daschner.maven_test.p;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("p")
public class PResource {

    @Inject
    PBean p;

    @GET
    public String get() {
        return p.get();
    }

    @GET
    @Path("{id}")
    public P get(@PathParam("id") String id) {
        return p.get(id);
    }

}
