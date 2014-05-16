package com.adobe.people.jedelson.slingmodels.demo;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public interface ResourcePathModel {

    @Inject @ResourcePath("/content/dam")
    Resource getResource();
}
