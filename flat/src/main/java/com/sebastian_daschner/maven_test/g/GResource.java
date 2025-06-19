package com.sebastian_daschner.maven_test.g;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("g")
public class GResource {

    @Inject
    GBean g;

    @GET
    public String get() {
        return g.get();
    }

    @GET
    @Path("{id}")
    public G get(@PathParam("id") String id) {
        return g.get(id);
    }

}
