package io.samancore.hierarchy.client;

import io.samancore.hierarchy.model.EntityModel;
import io.samancore.hierarchy.model.RelationshipModel;

import java.util.List;
import java.util.Set;

public interface HierarchyClient {

    EntityModel getEntity(String moduleName, String entityId);

    RelationshipModel getRelationship(String moduleName, String relationshipId);

    List<RelationshipModel> getRelationshipsFromEntity(String moduleName, String entityId);

    EntityModel getTargetEntity(String moduleName, String relationshipId);

    EntityModel getSourceEntity(String moduleName, String relationshipId);

    Set<EntityModel> getEntitiesNotTarget(String moduleName);
}