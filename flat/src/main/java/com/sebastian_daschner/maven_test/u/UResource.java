package com.sebastian_daschner.maven_test.u;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("u")
public class UResource {

    @Inject
    UBean u;

    @GET
    public String get() {
        return u.get();
    }

    @GET
    @Path("{id}")
    public U get(@PathParam("id") String id) {
        return u.get(id);
    }

}
