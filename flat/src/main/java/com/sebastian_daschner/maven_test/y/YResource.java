package com.sebastian_daschner.maven_test.y;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("y")
public class YResource {

    @Inject
    YBean y;

    @GET
    public String get() {
        return y.get();
    }

    @GET
    @Path("{id}")
    public Y get(@PathParam("id") String id) {
        return y.get(id);
    }

}
