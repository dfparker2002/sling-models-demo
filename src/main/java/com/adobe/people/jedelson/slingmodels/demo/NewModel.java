package com.adobe.people.jedelson.slingmodels.demo;

import javax.inject.Inject;

import org.apache.sling.api.adapter.Adaptable;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class NewModel {

    @Inject
    private String title;
    
    @Inject
    private String description;
    
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

}
