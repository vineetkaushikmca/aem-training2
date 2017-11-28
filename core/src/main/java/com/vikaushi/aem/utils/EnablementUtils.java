package com.vikaushi.aem.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;

public class EnablementUtils {
	public static List<String> splitWithNewLine(String line) {
		return Arrays.asList(line.split("\\r?\\n"));
	}

	public static void closeResourceResolver(final ResourceResolver resourceResolver) {
		if (resourceResolver != null && resourceResolver.isLive()) {
			resourceResolver.close();
		}
	}
}
