package com.adobe.people.jedelson.slingmodels.demo.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;

import com.adobe.people.jedelson.slingmodels.demo.OldModel;

@Component
@Service
@Properties({
    @Property(name=AdapterFactory.ADAPTABLE_CLASSES, value="org.apache.sling.api.Resource"),
    @Property(name=AdapterFactory.ADAPTER_CLASSES, value="com.adobe.people.jedelson.slingmodels.demo.OldModel")
})
public class OldModelAdapterFactory implements AdapterFactory {

    @SuppressWarnings("unchecked")
    public <AdapterType> AdapterType getAdapter(Object adaptable, Class<AdapterType> type) {
        if (adaptable instanceof Resource && type.equals(OldModel.class)) {
            OldModel model = new OldModel();
            ValueMap map = ResourceUtil.getValueMap((Resource) adaptable);
            model.setTitle(map.get("title", String.class));
            model.setDescription(map.get("description", String.class));
            return (AdapterType) model;
        } else {
            return null;
        }
    }

}
