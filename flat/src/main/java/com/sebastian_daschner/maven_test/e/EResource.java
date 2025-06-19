package com.sebastian_daschner.maven_test.e;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("e")
public class EResource {

    @Inject
    EBean e;

    @GET
    public String get() {
        return e.get();
    }

    @GET
    @Path("{id}")
    public E get(@PathParam("id") String id) {
        return e.get(id);
    }

}
