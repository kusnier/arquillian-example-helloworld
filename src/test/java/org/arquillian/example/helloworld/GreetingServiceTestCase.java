package org.arquillian.example.helloworld;


import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreetingServiceTestCase {

	@Deployment
	public static WebArchive deployService() {
		return ShrinkWrap.create(WebArchive.class)
				.addClass(GreetingService.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml"); // jboss 7.1.1 - jee6
	}

	@Inject
	private GreetingService service;

	@Test
	public void shouldGreetTheWorld() throws Exception {
		Assert.assertEquals("Hello, World!", service.greet("World"));
	}
}
