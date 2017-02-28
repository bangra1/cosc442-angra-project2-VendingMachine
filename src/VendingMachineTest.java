

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	    VendingMachineItem item;
		VendingMachine b;
	   
		/*
		 * Vending machine follows a series of steps and that is what we use to test the Vending machine 
		 * class/constructor/methods. Firstly we need to add items and insert balance to the machine to 
		 * vending machine. Then we can test other following functions like  removing item
		 * Purchasing and checking balance (before and after buying an item), checking return after a 
		 * purchase
		 */
		
		@Before
		public void setUp() throws Exception {
			b = new VendingMachine();
			
		}

		@After
		public void tearDown() throws Exception {
		}
		
		/*
		 * We are adding an item to the vending machine and we can check if the item was 
		 * added successfully using get item method
		 */
		
		@Test 
		public void testadditem()  {
			
		     	item = new VendingMachineItem("chips", 5.0);
		     	b.addItem(item, "A");
				b.getItem("A");
				assertEquals( b.itemArray[0] ,b.getItem("A"));
	
			  }

		/* Test for balance(), Since we have added no balance in the vending machine the balance is zero
		 */
		
		@Test
		public void testbalance() {
			assertEquals(0,b.getBalance(),0.001);
		}
		
		/*
		 * Here we test insert money and balance together. If we insert money balance increases 
		 */
		
		
		@Test 
		public void testinsertmoney() {
			b.insertMoney(20.0);
			assertEquals(20.0,b.getBalance(),0.001);
		}
		
		/*
		 * Here we test insert money and balance together. If we insert money balance increases 
		 */
		
		
		@Test 
		public void testinsertmoneyagain() {
			b.insertMoney(20.0);
			b.insertMoney(20.0);
			assertEquals(40.0,b.getBalance(),0.001);
		}
		
		
		/*
		 * In the following 2 test we test adding item to a machine and them making a purchase.
		 * and then checking the return change
		 */
		
		@Test
		public void testreturnchange() {
			item = new VendingMachineItem("chips", 5.0);
	     	b.addItem(item, "A");
	        b.insertMoney(35.0);
	        b.makePurchase("A");
		  
			assertEquals(30.0, b.returnChange(),0.001);
		}
		
		@Test
		public void testreturnchangeagain() {
			item = new VendingMachineItem("chips", 15.0);
	     	b.addItem(item, "A");
	        b.insertMoney(35.0);
	        b.makePurchase("A");
		  
			assertEquals(20.0, b.returnChange(),0.001);
		}
	
		/*
		 * Here we test making a purchase from the vending machine. The following two tests 
		 * one is when we make a purchase and the item is present and the other is when the item is 
		 * not in the vending machine 
		 */
		
		@Test
		public void testmakepurchase() {
			item = new VendingMachineItem("chips", 5.0);
	     	b.addItem(item, "A");
	        b.insertMoney(40.0);
		    assertTrue(b.makePurchase("A"));
		}
		
		@Test
		public void testmakepurchasefalse() {
			item = new VendingMachineItem("chips", 5.0);
	     	b.addItem(item, "A");
	        b.insertMoney(40.0);
		    assertFalse(b.makePurchase("B"));
		}
	
		/*
		 * This test is to remove an item from vending machine. The following throws an exception 
		 * therefore no asserts required. 
		 */
		
		
		@Test(expected = VendingMachineException.class)
		public void testremoveitem() throws VendingMachineException {
			
			b.removeItem("A");
			
		}	
					
}
