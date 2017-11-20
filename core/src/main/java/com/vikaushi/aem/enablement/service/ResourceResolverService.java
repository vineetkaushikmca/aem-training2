package com.vikaushi.aem.enablement.service;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

public interface ResourceResolverService {

	public abstract ResourceResolver getResourceResolver(String userType) throws LoginException;
}
