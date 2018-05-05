package se.kth.ood.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.ood.daniel.duner.procesSale.model.Address;

public class AdressTest {
	private Address add;
	
	@Before
	public void setUp() throws Exception {
		add = new Address("street", 1, "city", 1);
	}

	@After
	public void tearDown() throws Exception {
		add = null;
	}

	@Test
	public void testInstantiatedCorrect() {
		assertEquals("Attribute street inoccorrectly created","street",add.getStreet());
		assertEquals("Attribute streetNo inoccorrectly created",1,add.getStreetNo());
		assertEquals("Attribute city inoccorrectly created","city",add.getCity());
		assertEquals("Attribute zipCode inoccorrectly created",1,add.getZipCode());
	}

}
