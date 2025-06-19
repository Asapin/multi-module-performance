package com.sebastian_daschner.maven_test.c;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("c")
public class CResource {

    @Inject
    CBean c;

    @GET
    public String get() {
        return c.get();
    }

    @GET
    @Path("{id}")
    public C get(@PathParam("id") String id) {
        return c.get(id);
    }

}
