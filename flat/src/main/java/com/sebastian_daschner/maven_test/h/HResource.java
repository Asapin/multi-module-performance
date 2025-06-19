package com.sebastian_daschner.maven_test.h;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("h")
public class HResource {

    @Inject
    HBean h;

    @GET
    public String get() {
        return h.get();
    }

    @GET
    @Path("{id}")
    public H get(@PathParam("id") String id) {
        return h.get(id);
    }

}
