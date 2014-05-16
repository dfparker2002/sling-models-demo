package com.adobe.people.jedelson.slingmodels.demo;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;

import org.apache.sling.models.annotations.Model;

@Model(adaptables = Object.class)
public class MyComponent {

    @Inject
    private List<Filter> filters;
    
    public int getFilterNumber() {
        return filters.size();
    }
}
