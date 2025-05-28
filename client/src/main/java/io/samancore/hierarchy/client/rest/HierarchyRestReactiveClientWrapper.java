package io.samancore.hierarchy.client.rest;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import io.samancore.hierarchy.client.HierarchyReactiveClient;
import io.samancore.hierarchy.model.EntityModel;
import io.samancore.hierarchy.model.RelationshipModel;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class HierarchyRestReactiveClientWrapper implements HierarchyReactiveClient {

    @Inject
    Logger log;

    @ConfigProperty(name = "api.url-prefix")
    String urlPrefix;

    @ConfigProperty(name = "api.url-suffix")
    String urlSuffix;

    @Override
    public Uni<EntityModel> getEntity(String moduleName, String entityId) {
        log.debugf("HierarchyRestClientWrapper.getEntity %s; %s", moduleName, entityId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getEntityReactive(entityId);
    }

    @Override
    public Uni<RelationshipModel> getRelationship(String moduleName, String relationshipId) {
        log.debugf("HierarchyRestClientWrapper.getRelationship %s; %s", moduleName, relationshipId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getRelationshipReactive(relationshipId);
    }

    @Override
    public Uni<List<RelationshipModel>> getRelationshipsFromEntity(String moduleName, String entityId) {
        log.debugf("HierarchyRestClientWrapper.getRelationshipsFromEntity %s; %s", moduleName, entityId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getRelationshipsFromEntityReactive(entityId);
    }

    @Override
    public Uni<EntityModel> getTargetEntity(String moduleName, String relationshipId) {
        log.debugf("HierarchyRestClientWrapper.getTargetEntity %s; %s", moduleName, relationshipId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getTargetEntityReactive(relationshipId);
    }

    @Override
    public Uni<EntityModel> getSourceEntity(String moduleName, String relationshipId) {
        log.debugf("HierarchyRestClientWrapper.getSourceEntity %s; %s", moduleName, relationshipId);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getSourceEntityReactive(relationshipId);
    }

    @Override
    public Uni<Set<EntityModel>> getEntitiesNotTarget(String moduleName) {
        log.debugf("HierarchyRestClientWrapper.getEntitiesNotTarget %s", moduleName);
        var url = generateUrl(moduleName);
        var conditionTemplateRestClient = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(HierarchyRestClient.class);
        return conditionTemplateRestClient.getEntitiesNotTargetReactive();
    }

    private String generateUrl(String moduleName) {
        return urlPrefix.concat(moduleName).concat("-hierarchy").concat(urlSuffix);
    }
}
