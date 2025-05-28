package io.samancore.hierarchy.client.rest;

import io.samancore.hierarchy.model.EntityModel;
import io.samancore.hierarchy.model.RelationshipModel;
import io.smallrye.mutiny.Uni;
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
    @Path("entity/{entityId}")
    EntityModel getEntity(@PathParam("entityId") String entityId);

    @GET
    @Path("relationship/{relationshipId}")
    RelationshipModel getRelationship(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("entity/{entityId}/relationships")
    List<RelationshipModel> getRelationshipsFromEntity(@PathParam("entityId") String entityId);

    @GET
    @Path("relationship/{relationshipId}/target-entity")
    EntityModel getTargetEntity(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("relationship/{relationshipId}/source-entity")
    EntityModel getSourceEntity(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("origin-entities")
    Set<EntityModel> getEntitiesNotTarget();

    @GET
    @Path("entity/{entityId}")
    Uni<EntityModel> getEntityReactive(@PathParam("entityId") String entityId);

    @GET
    @Path("relationship/{relationshipId}")
    Uni<RelationshipModel> getRelationshipReactive(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("entity/{entityId}/relationships")
    Uni<List<RelationshipModel>> getRelationshipsFromEntityReactive(@PathParam("entityId") String entityId);

    @GET
    @Path("relationship/{relationshipId}/target-entity")
    Uni<EntityModel> getTargetEntityReactive(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("relationship/{relationshipId}/source-entity")
    Uni<EntityModel> getSourceEntityReactive(@PathParam("relationshipId") String relationshipId);

    @GET
    @Path("origin-entities")
    Uni<Set<EntityModel>> getEntitiesNotTargetReactive();
}
