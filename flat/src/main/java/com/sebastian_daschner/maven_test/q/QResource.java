package com.sebastian_daschner.maven_test.q;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("q")
public class QResource {

    @Inject
    QBean q;

    @GET
    public String get() {
        return q.get();
    }

    @GET
    @Path("{id}")
    public Q get(@PathParam("id") String id) {
        return q.get(id);
    }

}
