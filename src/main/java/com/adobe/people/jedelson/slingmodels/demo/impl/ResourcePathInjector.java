package com.adobe.people.jedelson.slingmodels.demo.impl;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.spi.DisposalCallbackRegistry;
import org.apache.sling.models.spi.Injector;
import org.osgi.framework.Constants;

import com.adobe.people.jedelson.slingmodels.demo.ResourcePath;

@Component
@Service
@Property(name = Constants.SERVICE_RANKING, intValue = 4070)
public class ResourcePathInjector implements Injector {

    public String getName() {
        return "resource-path";
    }

    public Object getValue(Object adaptable, String name, Type declaredType, AnnotatedElement element,
            DisposalCallbackRegistry callbackRegistry) {
        ResourcePath path = element.getAnnotation(ResourcePath.class);
        if (path == null) {
            return null;
        }
        ResourceResolver resolver = getResourceResolver(adaptable);
        if (resolver == null) {
            return null;
        }
        return resolver.getResource(path.value());
    }

    private ResourceResolver getResourceResolver(Object adaptable) {
        if (adaptable instanceof Resource) {
            return ((Resource) adaptable).getResourceResolver();
        } else {
            return null;
        }
    }

}
