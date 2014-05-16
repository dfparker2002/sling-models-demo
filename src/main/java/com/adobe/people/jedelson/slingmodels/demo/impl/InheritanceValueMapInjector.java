package com.adobe.people.jedelson.slingmodels.demo.impl;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.spi.DisposalCallbackRegistry;
import org.apache.sling.models.spi.Injector;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;

@Component
@Service
@Property(name = Constants.SERVICE_RANKING, intValue = 4050)
public class InheritanceValueMapInjector implements Injector {

    private static final Logger log = LoggerFactory.getLogger(InheritanceValueMapInjector.class);

    public String getName() {
        return "inheritance-valuemap";
    }

    public Object getValue(Object adaptable, String name, Type type, AnnotatedElement element,
            DisposalCallbackRegistry callbackRegistry) {
        Resource resource = getResource(adaptable);
        if (resource == null) {
            return null;
        } else if (type instanceof Class<?>) {
            InheritanceValueMap inheritanceMap = new HierarchyNodeInheritanceValueMap(resource);
            return inheritanceMap.getInherited(name, (Class<?>) type);
        } else {
            log.debug("ValueMapInjector doesn't support non-class types {}", type);
            return null;
        }
    }

    private Resource getResource(Object adaptable) {
        if (adaptable instanceof Resource) {
            return (Resource) adaptable;
        } else if (adaptable instanceof SlingHttpServletRequest) {
            return ((SlingHttpServletRequest) adaptable).getResource();
        } else {
            return null;
        }
    }

}
