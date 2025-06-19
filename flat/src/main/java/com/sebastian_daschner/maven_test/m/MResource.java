package com.sebastian_daschner.maven_test.m;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("m")
public class MResource {

    @Inject
    MBean m;

    @GET
    public String get() {
        return m.get();
    }

    @GET
    @Path("{id}")
    public M get(@PathParam("id") String id) {
        return m.get(id);
    }

}
