package slmt;

import tree.BinaryTree;
import tree.Node;

public class Main {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(new Node(1));

        Node four = new Node(4);
        Node five = new Node(5);
        Node seven = new Node(7);

        Node three = new Node(3, four, five);
        Node two = new Node(2, null, seven);

        bt.getRoot().setLeft(three);
        bt.getRoot().setRight(two);

        //bt.breadthFirstSearch();
        bt.deepthFirstTravelsal(bt.getRoot());
    }
}
