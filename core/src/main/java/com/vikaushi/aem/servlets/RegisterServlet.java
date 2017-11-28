package com.vikaushi.aem.servlets;

import com.adobe.cq.account.api.AccountManagementService;
import com.vikaushi.aem.process.ImageCroppingProcess;

import java.util.HashMap;
import java.util.Map;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(paths = "/bin/registeration", methods = "post")
public class RegisterServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 4069551924749113874L;
	private final Logger LOGGER = LoggerFactory.getLogger(RegisterServlet.class);

	@Reference
	private AccountManagementService accountManagementService;

	@Override
	public void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		LOGGER.debug("Vineet - doppost");
		String fname = "vinay";
		String password = "Test@123";
		try {
			LOGGER.debug("Vineet - in side try");

			Map<String, RequestParameter[]> profilemap = new HashMap<String, RequestParameter[]>();
			profilemap.put("email", new RequestParameter[] { new Parameters("vineet.kaushik.mca@gmail.com") });
			profilemap.put("familyName", new RequestParameter[] { new Parameters("Vineet") });

			boolean flag = accountManagementService.requestAccount(fname, password, profilemap, "http://localhost:4502",
					"/content/properties");
			LOGGER.debug("vineet - flag {}", flag);
			LOGGER.debug("Vineet - after requestAccount()");
			response.getWriter().print("Please Check your EmailId and verify the mail for complete account creation");
			LOGGER.debug("Vineet - written to writter)");
		} catch (Exception e) {
			LOGGER.debug("Vineet - inside catch and exception is {}", e);
		}
	}
}