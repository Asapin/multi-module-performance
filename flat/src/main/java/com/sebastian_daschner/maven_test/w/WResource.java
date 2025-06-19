package com.sebastian_daschner.maven_test.w;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("w")
public class WResource {

    @Inject
    WBean w;

    @GET
    public String get() {
        return w.get();
    }

    @GET
    @Path("{id}")
    public W get(@PathParam("id") String id) {
        return w.get(id);
    }

}
