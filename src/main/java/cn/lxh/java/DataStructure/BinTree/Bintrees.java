package cn.lxh.java.DataStructure.BinTree;

import java.util.LinkedList;
import java.util.List;

/**
 * ������
 * Created by starlin
 * on 2017/02/20 10:25.
 *
 * ������ʽ
 ǰ����������ڵ� -> ������ -> ������

 ��������������� -> ���ڵ� -> ������

 ��������������� -> ������ -> ���ڵ�

   �������ص㣺
     �ǿն������ĵ�n����������2^(n-1)��Ԫ�أ�
     ���Ϊh�Ķ�����������2^h-1����㣻
     ����һ����ȫ����������һ���ڵ�Ϊi�����丸�ڵ�Ϊi/2��2iΪ���ӽڵ㣬2i+1Ϊ���ӽڵ㡣
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

    //����������
    public void createBintree(){
        nodeList = new LinkedList<Node>();
        //������ת��Ϊnode
        for(int nodeIndex = 0;nodeIndex < array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        // �Գ����һ�����ڵ㰴�ո��ڵ�ͺ��ӽڵ�����ֹ�ϵ����������
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        // ���һ�����ڵ�
        int lastParentIndex = array.length / 2 - 1;
        // ����
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        // ���Ϊ�����������Һ���
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }

    // ǰ�����
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    // �������
    public static void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    // �������
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

        System.out.println("ǰ�������");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("���������");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("���������");
        postOrderTraverse(root);
    }
}
