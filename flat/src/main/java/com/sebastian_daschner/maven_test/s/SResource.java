package com.sebastian_daschner.maven_test.s;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("s")
public class SResource {

    @Inject
    SBean s;

    @GET
    public String get() {
        return s.get();
    }

    @GET
    @Path("{id}")
    public S get(@PathParam("id") String id) {
        return s.get(id);
    }

}
