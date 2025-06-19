package com.sebastian_daschner.maven_test.k;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("k")
public class KResource {

    @Inject
    KBean k;

    @GET
    public String get() {
        return k.get();
    }

    @GET
    @Path("{id}")
    public K get(@PathParam("id") String id) {
        return k.get(id);
    }

}
