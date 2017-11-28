package com.vikaushi.aem.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;


@Model(adaptables = Resource.class, resourceType = { "training/components/content/heroimage" , "training/components/content/contactus"}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", options = { @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "true") })

public class ModelComponent {

	@Inject
	String title;

	@Inject
	String heading;

	@Inject
	String buttonLabel;

	@Inject
	String buttonLinkTo;

	@Inject
	String fileReference;

	@Inject
	@Named("sling:resourceType")
	String slingResourceType;
	
	@Inject
	String fileName;

	public String getHeading() {
		return heading + "-Custom Heading";
	}

	public String getButtonLabel() {
		return buttonLabel +"-Button Label";
	}

	public String getButtonLinkTo() {
		return buttonLinkTo;
	}

	public String getSlingResourceType() {
		return slingResourceType + "custom";
	}

	public String getTitle() {
		return title + "Custom";
	}

	public String getFileReference() {
		return fileReference;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
