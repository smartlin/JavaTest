package cn.lxh.java.DataStructure.BinTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树
 * Created by starlin
 * on 2017/02/20 10:25.
 *
 * 遍历方式
 前序遍历：根节点 -> 左子树 -> 右子树

 中序遍历：左子树 -> 根节点 -> 右子树

 后序遍历：左子树 -> 右子树 -> 根节点

   二叉树特点：
     非空二叉树的第n层上至多有2^(n-1)个元素；
     深度为h的二叉树至多有2^h-1个结点；
     对于一个完全二叉树，设一个节点为i，则其父节点为i/2，2i为左子节点，2i+1为右子节点。
 */
public class Bintrees {
    private int[] array = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;

    private static class Node{
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData){
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    //创建二叉树
    public void createBintree(){
        nodeList = new LinkedList<Node>();
        //将数组转换为node
        for(int nodeIndex = 0;nodeIndex < array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对除最后一个父节点按照父节点和孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        // 最后一个父节点
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        // 如果为奇数，建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    // 前序遍历
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    // 中序遍历
    public static void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    // 后序遍历
    public static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Bintrees binTree = new Bintrees();
        binTree.createBintree();
        Node root = nodeList.get(0);

        System.out.println("前序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }
}
