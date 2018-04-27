package se.kth.oop.daniel.duner.procesSale.test.integration;
import integration.Item;
import org.junit.*;


public class ItemTest {
	private Item newItem;
	
	@Before
	public void setUp() throws Exception {
		newItem = new Item();
	}
	@After
	public void tearDown() {
		newItem = null;
	}
	@Test
	public void test() {
		
	}

}
