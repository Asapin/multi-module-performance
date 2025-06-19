package com.sebastian_daschner.maven_test.i;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("i")
public class IResource {

    @Inject
    IBean i;

    @GET
    public String get() {
        return i.get();
    }

    @GET
    @Path("{id}")
    public I get(@PathParam("id") String id) {
        return i.get(id);
    }

}
