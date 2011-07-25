
public class TreeTraversal {
  public static void main(String[] args) {
    Node parentNode = createTree();
    System.out.println("\nPre-Order traversal");
    preOrderTraversal(parentNode);

    System.out.println("\nIn-Order traversal");
    inOrderTraversal(parentNode);

    System.out.println("\nPost-Order traversal");
    postOrderTraversal(parentNode);
  }

  /**
   * Pre Order Traversal (root, left, right)
   */
  public static void preOrderTraversal(Node node) {
    System.out.print(node.value + " ");
    if(node.leftNode != null) preOrderTraversal(node.leftNode);
    if(node.rightNode != null) preOrderTraversal(node.rightNode);
  }

  /**
   * In Order Traversal (left, root, right)
   */
  public static void inOrderTraversal(Node node) {
    if(node.leftNode != null) inOrderTraversal(node.leftNode);
    System.out.print(node.value + " ");
    if(node.rightNode != null) inOrderTraversal(node.rightNode);
  }

  /**
   * Post Order traversal (left, right, root)
   */
  public static void postOrderTraversal(Node node) {
    if(node.leftNode != null) postOrderTraversal(node.leftNode);
    if(node.rightNode != null) postOrderTraversal(node.rightNode);
    System.out.print(node.value + " ");
  }

  /**
   * Recreates the Wikipedia example tree structure
   * http://en.wikipedia.org/wiki/Tree_traversal.
   */
  public static Node createTree() {
    Node a = new Node('A');
    Node b = new Node('B');
    Node c = new Node('C');
    Node d = new Node('D');
    Node e = new Node('E');
    Node f = new Node('F');
    Node h = new Node('H');
    Node i = new Node('I');
    Node g = new Node('G');

    // Recreating the Wikipedia tree example.
    f.leftNode = b; f.rightNode = g;
    b.leftNode = a; b.rightNode = d;
    d.leftNode = c; d.rightNode = e;
                    g.rightNode = i;
    i.leftNode = h;

    return f;
  }
}

/**
 * Basic binary tree node structure.
 *
 * Note: Not showing best practices of OO
 * for the sake of conciseness for ease
 * of presentation.
 */
class Node {
  char value;

  Node leftNode;
  Node rightNode;

  Node(char value) {
    this.value = value;
  }
}
