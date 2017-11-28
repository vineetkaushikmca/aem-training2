package com.vikaushi.aem.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vikaushi.aem.service.ResourceResolverService;

@Component(name = "com.vikaushi.aem.service.impl.ResourceResolverServiceImpl", label = "AEM Enablement - Resoure Resolver Service", immediate = true, metatype = false)
@Service(value = ResourceResolverService.class)
public class ResourceResolverServiceImpl implements ResourceResolverService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceResolverServiceImpl.class);

	@Reference
	private ResourceResolverFactory resolverFactory;
	private ResourceResolver resourceResolver;

	// TODO : check login functionality with
	// slingRepository.login(subService,workspace)
	
	@Override
	public ResourceResolver getResourceResolver(String subServiceName)
			throws LoginException {
		LOGGER.debug("start - getResourceResolver");
		final Map<String, Object> serviceMap = new ConcurrentHashMap<>();
		serviceMap.put(ResourceResolverFactory.SUBSERVICE, subServiceName);
		resourceResolver = resolverFactory.getServiceResourceResolver(serviceMap);
		LOGGER.debug("resourceResolver is {}", resourceResolver);
		return resourceResolver;
	}
}
