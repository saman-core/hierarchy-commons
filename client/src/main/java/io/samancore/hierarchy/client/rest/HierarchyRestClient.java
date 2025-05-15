package io.samancore.hierarchy.client.rest;

import io.samancore.hierarchy.model.EntityModel;
import io.samancore.hierarchy.model.RelationshipModel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;

import java.util.List;
import java.util.Set;

@Path("")
@RegisterClientHeaders
public interface HierarchyRestClient {

    @GET
    @Path("relationships/{entityId}")
    List<RelationshipModel> getRelationshipsFromEntity(@PathParam("entityId") String entityId);

    @GET
    @Path("target-entity/{relationshipId}")
    EntityModel getTargetEntity(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("source-entity/{relationshipId}")
    EntityModel getSourceEntity(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("origin-entities")
    Set<EntityModel> getEntitiesNotTarget();
}
