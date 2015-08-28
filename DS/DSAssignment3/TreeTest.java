import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TreeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testPreOrder() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(2);
		tree.addNode(1);
		tree.addNode(3);
		tree.preOrder(tree.getRoot());
		String expected = "213";
		System.out.println(tree.getpreOrder());
		assertEquals(expected, tree.getpreOrder());

	}

	@Test
	public void testPreOrderLeanedLeft() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(1);
		tree.preOrder(tree.getRoot());
		String expected = "321";
		System.out.println(tree.getpreOrder());
		assertEquals(expected, tree.getpreOrder());

	}

	@Test
	public void testPreOrderLeanedRight() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(3);
		tree.preOrder(tree.getRoot());
		String expected = "123";
		System.out.println(tree.getpreOrder());
		assertEquals(expected, tree.getpreOrder());

	}

	@Test
	public void testPostOrder() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(2);
		tree.addNode(1);
		tree.addNode(3);
		tree.postOrder(tree.getRoot());
		String expected = "132";
		System.out.println(tree.getpostOrder());
		assertEquals(expected, tree.getpostOrder());

	}

	@Test
	public void testPostOrderLeanedLeft() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(1);
		tree.postOrder(tree.getRoot());
		String expected = "123";
		System.out.println(tree.getpostOrder());
		assertEquals(expected, tree.getpostOrder());

	}

	@Test
	public void testPostOrderLeanedRight() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(1);
		tree.postOrder(tree.getRoot());
		String expected = "123";
		System.out.println(tree.getpostOrder());
		assertEquals(expected, tree.getpostOrder());

	}

	@Test
	public void testCheckMirrorFalse() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(3);
		Tree<Integer> tree2 = new Tree<Integer>();
		assertEquals(false, tree.checkMirror(tree.getRoot(), tree2.getRoot()));

	}

	@Test
	public void testCheckMirrorTrue() {
		Tree<Integer> tree = new Tree<Integer>();
		tree.addNode(1);
		tree.addNode(2);
		tree.addNode(3);
		Tree<Integer> tree2 = new Tree<Integer>();
		tree2.addMirrorNode(1);
		tree2.addMirrorNode(2);
		tree2.addMirrorNode(3);
		assertEquals(true, tree.checkMirror(tree.getRoot(), tree2.getRoot()));

	}

}
