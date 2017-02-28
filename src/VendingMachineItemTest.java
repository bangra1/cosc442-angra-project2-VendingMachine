

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Vending Machine item is used to add items to vending machine. We test adding item and its price 
 * using the following tests. 
 */

public class VendingMachineItemTest 
{

  	 VendingMachineItem a,b,c;
	
	@Before
	public void setUp() throws Exception {
		a= new VendingMachineItem("chips",5.0);
		b=new VendingMachineItem("chocolate",0.0);
	
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/*
	 * In the following test we test the name of the item that we added to the vendingmachineitem
	 */
	
	@Test
	public void testname() {
		assertEquals("chips", a.getName());
		assertEquals("chocolate", b.getName());
	
			
}
	
	/*
	 * In the following test we test the price of the item that we added to the vendingmachineitem
	 */
	
	@Test
	public void testprice() {
		assertEquals(5.0, a.getPrice(),0.001);
		assertEquals(0.0, b.getPrice(),0.001);
		
		
}
	/*
	 * In the following test we test an exception that is thrown if the price is less than 0
	 * when we add an item
	 */
	
	@Test(expected = VendingMachineException.class)
	public void testcons() throws VendingMachineException {

		c = new VendingMachineItem("chips", -5.0);
	
}
	

	@Test
	public void complete() {

		c = new VendingMachineItem("chips", 5.0);
		c.getName();
		c.getPrice();
		assertEquals("chips", c.getName());
		assertEquals(5.0,c.getPrice(),0.001);
	
}


	
	
	
}
