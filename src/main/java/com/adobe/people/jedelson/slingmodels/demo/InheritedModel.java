package com.adobe.people.jedelson.slingmodels.demo;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public interface InheritedModel {
    
    @Inject @Named("cq:designPath")
    public String getDesignPath();

}
