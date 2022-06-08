import java.util.*;

public class BinaryTree{
    private Node root;
    private int size;

    public BinaryTree(){
        this.root = null;
        this.size = 0;
    }
    public BinaryTree(int a){
        this.root = new Node(a);
    }
    public Node getRoot(){
        return this.root;
    }

    public void insertRoot(int a){
        root = new Node(a);
    }
    public void insert(Node node, int value){
        if (value <= node.value) { 
            if (node.left != null) { 
                insert(node.left, value); 
            }else { 
                System.out.println(" Inserted " + value + " to left of " + node.value); 
                node.left = new Node(value); 
            } 
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            }else{
                System.out.println("  Inserted " + value + " to right of "+ node.value);
                node.right = new Node(value);
            }
        }
    }
    
    /* TRAVERSING */
    public void preOrder(Node node){
        if(node!=null){
            System.out.print(node.value+ " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.value+ " ");
            inOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value+ " ");
        }
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.value);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }

    }

    public static void main(String[] args){
        BinaryTree Tree = new BinaryTree(25);
        Tree.insert(Tree.getRoot(), 20);
        Tree.insert(Tree.getRoot(), 30);
        Tree.insert(Tree.getRoot(), 23);
        Tree.insert(Tree.getRoot(), 19);

        System.out.println("PreOrder:");
        Tree.preOrder(Tree.getRoot());
        System.out.println();

        System.out.println("InOrder");
        Tree.inOrder(Tree.getRoot());
        System.out.println();

        System.out.println("PostOrder");
        Tree.postOrder(Tree.getRoot());
        System.out.println();

        System.out.println("LevelOrder");
        Tree.levelOrder(Tree.getRoot());
        System.out.println();



    }
}