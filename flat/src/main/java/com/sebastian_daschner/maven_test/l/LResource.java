package com.sebastian_daschner.maven_test.l;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("l")
public class LResource {

    @Inject
    LBean l;

    @GET
    public String get() {
        return l.get();
    }

    @GET
    @Path("{id}")
    public L get(@PathParam("id") String id) {
        return l.get(id);
    }

}
