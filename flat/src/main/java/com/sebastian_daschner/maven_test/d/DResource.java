package com.sebastian_daschner.maven_test.d;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("d")
public class DResource {

    @Inject
    DBean d;

    @GET
    public String get() {
        return d.get();
    }

    @GET
    @Path("{id}")
    public D get(@PathParam("id") String id) {
        return d.get(id);
    }

}
