package io.samancore.hierarchy.client;

import io.samancore.hierarchy.model.EntityModel;
import io.samancore.hierarchy.model.RelationshipModel;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.Set;

public interface HierarchyReactiveClient {

    Uni<EntityModel> getEntity(String moduleName, String entityId);

    Uni<RelationshipModel> getRelationship(String moduleName, String relationshipId);

    Uni<List<RelationshipModel>> getRelationshipsFromEntity(String moduleName, String entityId);

    Uni<EntityModel> getTargetEntity(String moduleName, String relationshipId);

    Uni<EntityModel> getSourceEntity(String moduleName, String relationshipId);

    Uni<Set<EntityModel>> getEntitiesNotTarget(String moduleName);
}