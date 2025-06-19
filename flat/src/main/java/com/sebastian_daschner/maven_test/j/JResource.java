package com.sebastian_daschner.maven_test.j;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("j")
public class JResource {

    @Inject
    JBean j;

    @GET
    public String get() {
        return j.get();
    }

    @GET
    @Path("{id}")
    public J get(@PathParam("id") String id) {
        return j.get(id);
    }

}
