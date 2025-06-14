package io.samancore.hierarchy.client.rest;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import io.samancore.hierarchy.client.HierarchyClient;
import io.samancore.hierarchy.model.EntityModel;
import io.samancore.hierarchy.model.RelationshipModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class HierarchyRestClientWrapper implements HierarchyClient {

    @Inject
    Logger log;

    @ConfigProperty(name = "api.url-prefix")
    String urlPrefix;

    @ConfigProperty(name = "api.url-suffix")
    String urlSuffix;

    @Override
    public EntityModel getEntity(String moduleName, String entityId) {
        log.debugf("HierarchyRestClientWrapper.getEntity %s; %s", moduleName, entityId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getEntity(entityId);
    }

    @Override
    public RelationshipModel getRelationship(String moduleName, String relationshipId) {
        log.debugf("HierarchyRestClientWrapper.getRelationship %s; %s", moduleName, relationshipId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getRelationship(relationshipId);
    }

    @Override
    public List<RelationshipModel> getRelationshipsFromEntity(String moduleName, String entityId) {
        log.debugf("HierarchyRestClientWrapper.getRelationshipsFromEntity %s; %s", moduleName, entityId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getRelationshipsFromEntity(entityId);
    }

    @Override
    public EntityModel getTargetEntity(String moduleName, String relationshipId) {
        log.debugf("HierarchyRestClientWrapper.getTargetEntity %s; %s", moduleName, relationshipId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getTargetEntity(relationshipId);
    }

    @Override
    public EntityModel getSourceEntity(String moduleName, String relationshipId) {
        log.debugf("HierarchyRestClientWrapper.getSourceEntity %s; %s", moduleName, relationshipId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getSourceEntity(relationshipId);
    }

    @Override
    public Set<EntityModel> getEntitiesNotTarget(String moduleName) {
        log.debugf("HierarchyRestClientWrapper.getEntitiesNotTarget %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getEntitiesNotTarget();
    }

    private String generateUrl(String moduleName) {
        return urlPrefix.concat(moduleName).concat("-hierarchy").concat(urlSuffix);
    }
}
