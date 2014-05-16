package com.adobe.people.jedelson.slingmodels.demo;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public interface NewModel2 {

    @Inject
    public String getTitle();

    @Inject
    public String getDescription();

}
