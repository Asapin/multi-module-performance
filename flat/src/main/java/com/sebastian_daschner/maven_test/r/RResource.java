package com.sebastian_daschner.maven_test.r;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("r")
public class RResource {

    @Inject
    RBean r;

    @GET
    public String get() {
        return r.get();
    }

    @GET
    @Path("{id}")
    public R get(@PathParam("id") String id) {
        return r.get(id);
    }

}
