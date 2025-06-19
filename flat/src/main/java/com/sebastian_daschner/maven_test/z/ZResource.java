package com.sebastian_daschner.maven_test.z;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("z")
public class ZResource {

    @Inject
    ZBean z;

    @GET
    public String get() {
        return z.get();
    }

    @GET
    @Path("{id}")
    public Z get(@PathParam("id") String id) {
        return z.get(id);
    }

}
