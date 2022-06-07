import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MyTestCases {
	@Test(timeout=2000)
	public void testSizeAfterInsert() {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(1);
		int size = bst.size();	
		assertEquals("Size returned should be 1", 1, size);
	}
	
	@Test(expected = DuplicateItemException.class)
	public void testDuplicateItemInsert() {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(1);
		bst.insert(1);
		assertEquals("Size should be 2", 2, bst.size);
	}
	
	@Test(timeout=2000)
	public void testConstructor() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertEquals("Root should be null on creation", null, bst.root);
		assertEquals("Size should be 0 on creation", 0, bst.size);
	}

	@Test(timeout=2000)
	public void testRemoveSizeAndRoot() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		bst.insert(1);
		bst.insert(2);		
		assertEquals("Size should be 2",2, bst.size);
		bst.remove(1);
		assertEquals("Size should be 1", 1, bst.size);
		bst.remove(2);
		assertEquals("Root should be null", null, bst.root);
		assertEquals("Size should be 0", 0, bst.size);		
	}
	
	@Test(timeout = 2000)
	public void testRemoveAgain() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		bst.insert(1);
		bst.insert(2);
		bst.insert(9);
		bst.insert(4);
		assertEquals("New root should be node 2", bst.root.right, bst.remove(9,bst.root.right));
		assertEquals("New root should be node 1", bst.root, bst.remove(2,bst.root));
		assertEquals("New root should be node 4", bst.root.right, bst.remove(1, bst.root));
	}
	
	@Test(timeout = 2000)
	public void testRemoveParameters() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		bst.insert(1);
		bst.insert(2);
		
		bst.remove(2, bst.root);		
		assertEquals("Left child of root should be null", null, bst.root.left);
		assertEquals("Right child of root should be null", null, bst.root.right);	

		
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testRemoveEmpty() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		assertEquals("Should return ItemNotFoundException for emtpty tree", null, bst.remove(1,bst.root));
			
	}
	@Test(timeout = 2000)
	public void testRemoveMinAgain() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		bst.insert(2);
		bst.insert(0);
		bst.insert(1);
		assertEquals("Should return the left node of provided root", bst.root, bst.removeMin(bst.root));	
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testRemoveMinException() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		assertEquals("Should return ItemNotFoundException for emtpty tree", null, bst.removeMin(bst.root));
			
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testRemoveNotFound() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.remove(1);	
		assertEquals("Size should be 0", 0, bst.size);
	}
	
	
	
	@Test(expected = ItemNotFoundException.class)
	public void testRemoveMinWhenEmpty() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		bst.removeMin();
	}
	
	@Test(timeout = 2000)
	public void testRemoveMin() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();		
		bst.insert(1);
		bst.insert(2);
		bst.removeMin();
		assertEquals("Size should be 1",1,bst.size);
		bst.remove(2);
		assertEquals("Size shoule be 0", 0, bst.size);
	}
	

	@Test(timeout = 2000)
	public void testFindMin() {
	
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertEquals("When empty method should return null", null, bst.findMin());
		bst.insert(1);
		bst.insert(2);
		assertEquals("Minimum value should be root", 1, bst.findMin().byteValue());
		assertEquals("Size should be 2", 2, bst.size);
	
	}
	
	@Test(timeout = 2000)
	public void testFindMax() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertEquals("When empty method should return null", null, bst.findMax());
		bst.insert(1);
		assertEquals("Minimum value should be root", 1, bst.findMax().byteValue());
		assertEquals("Size should be 1", 1, bst.size);
		bst.insert(2);
		bst.insert(9);
		bst.insert(4);
		assertEquals("Maximum value should be 9", 9, bst.findMax().byteValue());
		assertEquals("Size should be 0", 4, bst.size);
	}
	

	@Test(timeout = 2000)
	public void testFind() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertEquals("Returns null when not found", null, bst.find(1));
		bst.insert(1);
		assertEquals("Should find 1", 1, bst.find(1).byteValue());	
		assertEquals("Size should be 1", 1, bst.size);
	}
	
	@Test(timeout = 2000)
	public void testMakeEmpty() {	
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(2);
		bst.insert(9);
		bst.insert(4);
		bst.makeEmpty();
		assertEquals("Root should be null", null, bst.root);
		assertEquals("Size should be 0", 0 , bst.size);	
	}
	
	@Test(timeout = 2000)
	public void testIsEmpty() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertEquals("Tree should be empty, should be true", true, bst.isEmpty());
		bst.insert(1);
		assertEquals("Tree is not empty, should be false", false, bst.isEmpty());
		assertEquals("Size should be 1", 1, bst.size);
		bst.remove(1);
		assertEquals("Tree should be empty, should be true", true, bst.isEmpty());
		assertEquals("Size should be 0", 0, bst.size);
		bst.insert(1);
		bst.removeMin();
		assertEquals("Tree should be empty, should be true", true, bst.isEmpty());
		assertEquals("Size should be 0", 0, bst.size);
		bst.insert(2);
		bst.insert(9);
		bst.insert(4);
		bst.makeEmpty();
		assertEquals("Tree should be empty, should be true", true, bst.isEmpty());
		assertEquals("Size should be 0", 0, bst.size);
		
	}

	
	@Test(timeout = 2000)
	public void testIterator() {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		assertEquals("Tree should be empty, should be true", true, bst.isEmpty());
		bst.insert(1);
		bst.insert(2);
		bst.insert(9);
		bst.insert(4);
		String string = "";
		if(bst.root != null)
		for(Integer num:bst) {
			string += num + " "; 
		}
		
		assertEquals("Output should be 1 2 9 4 ", "1 2 9 4 ", string);
		
		bst.remove(2);
		string = "";
		for(Integer num:bst) {
			string += num + " "; 
		}
		assertEquals("Output should be 1 9 4 ", "1 9 4 ", string);
		
		bst.removeMin();
		string = "";
		for(Integer num:bst) {
			string += num + " "; 
		}
		assertEquals("Output should be 9 4 ", "9 4 ", string);
		
		bst.makeEmpty();
		string = "";
		for(Integer num:bst) {
			string += num + " "; 
		}
		assertEquals("Output should be nothing", "", string);
	}
	
	
	
	
	
	//run the unit tests
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("MyTestCases");
	}
}