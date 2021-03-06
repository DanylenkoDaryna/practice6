package ua.nure.danylenko.practice6.part5;

import java.util.ArrayList;
import java.util.List;

public class Tree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;
    // вложенный класс, объекты этого класса составляют дерево
    private static class Node<E> {
        private Node<E> previous;
        private Node<E> leftChild;
        private Node<E> rightChild;
        StringBuilder spaces;
        private E value;

        Node(){  }

        Node(E val){
            value= val;
            previous= new Node<>();
            spaces = new StringBuilder();
        }
    }

    Tree(){    }

    // добавляет элемент в контейнер
    private boolean add(E element) {
        if(root==null){
            root=new Node<>(element);
            root.leftChild=null;
            root.rightChild=null;
            root.previous=null;
            root.spaces.append("");
            size=size+1;
            return true;
        }else{
            return findPlaceToAdd(root,element);

        }
    }

    private boolean findPlaceToAdd(Node<E> node, E element) {
        if(node.value.compareTo(element)>0){
            if(node.rightChild==null){
                node.rightChild=new Node<>(element);
                node.rightChild.previous=node;
                node.rightChild.spaces.append(node.spaces).append("  ");
                size=size+1;
                return true;
            }else{
                return findPlaceToAdd(node.rightChild,element);
            }
        } else if(node.value.compareTo(element)<0) {
            if (node.leftChild == null) {
                node.leftChild = new Node<>(element);
                node.leftChild.previous=node;
                node.leftChild.spaces.append(node.spaces).append("  ");
                size=size+1;
                return true;
            } else {
                return findPlaceToAdd(node.leftChild, element);
            }
        }
            return false;
    }

    // добавляет все элементы из массива в контейнер (вызов в цикле метода add, см. выше)
    public void add(E[] elements) {
        for(E el:elements){
            this.add(el);
        }
    }

    // удаляет элемент из контейнера
    // если удаляемого элемента в контейнере нет, то возвращает false
    // в противном случае удаляет элемент и возвращает true
    // ВАЖНО! при удалении элемента дерево не должно потерять свойства бинарного дерева поиска
    public boolean remove(E element) {
        Node<E> toRemove = findElement(root, element);
        return toRemove != null && this.delete(toRemove);
    }


    private boolean delete(Node<E> node) {
        Node<E> father = node.previous;
        if(node.rightChild==null&&node.leftChild==null){
            if(father.leftChild!=null&&father.leftChild.value.compareTo(node.value)==0){
                node.spaces=null;
                node.value=null;
                father.leftChild=null;
            }else{
                node.spaces=null;
                node.value=null;
                father.rightChild=null;
            }
            size=size-1;
            return true;
        }else if(node.leftChild!=null&&node.rightChild!=null){
            return hardDelete(node);
        }else{
            return ifOneChildNotNull(node,father);
        }
    }

    private boolean ifOneChildNotNull(Node<E> node, Node<E> father) {
         if(node.rightChild==null&&node.leftChild!=null){
            if(father.leftChild.value.compareTo(node.value)==0){
                father.leftChild=node.leftChild;
            }else{
                father.rightChild=node.leftChild;
            }
            size=size-1;
            return true;
        }else if(node.leftChild==null&&node.rightChild!=null){
            if(father.leftChild.value.compareTo(node.value)==0){
                father.leftChild=node.rightChild;
                father.leftChild.previous=node.previous;
                father.leftChild.spaces.setLength(father.leftChild.spaces.length()-2);

            }else{
                father.rightChild=node.rightChild;
                father.rightChild.previous=node.previous;
                father.rightChild.spaces.setLength(father.rightChild.spaces.length()-2);
            }
            size=size-1;
            return true;
        }
        return false;
    }

    //Если оба ребёнка присутствуют, то
    //Если "правый" узел m "левого" поддерева отсутствует (n->left->right)
    //Копируем из "левого" узла в удаляемый поля K, V и ссылку на "левый" узел "левого" потомка.
    //Иначе
    //Возьмём самый "правый" узел m, "левого" поддерева n->left
    //Скопируем данные (кроме ссылок на дочерние элементы) из m в n
    //Рекурсивно удалим узел m.
    private boolean hardDelete(Node<E> node) {
        Node<E> father;
        Node<E> temp=node;
        if(temp.leftChild.rightChild==null){
            temp=temp.leftChild;
            node.leftChild=temp.leftChild;
            node.value=temp.value;
            temp.value=null;
            temp.previous=null;
            temp.spaces=null;
        }else{
            temp=temp.leftChild.rightChild;
            node.value=temp.value;
            father=temp.previous;
            if(father.leftChild.value.compareTo(temp.value)==0){
                father.leftChild=null;
            }else{
                father.rightChild=null;
            }
            temp.value=null;
            temp.previous=null;
            temp.spaces=null;
        }
        size=size-1;
        return true;
    }

    private Node<E> findElement(Node<E> node, E element) {
        if(node.value.compareTo(element)==0){
            return node;
        }else if(node.value.compareTo(element)<0){
            return findDeeper(node.leftChild,element);

        } else if(node.value.compareTo(element)>0) {
            return findDeeper(node.rightChild,element);
        }
        return null;
    }

    private Node<E> findDeeper(Node<E> node, E element) {
        if(node.value.compareTo(element)==0){
            return node;
        }else {
            return findElement(node,element);
        }

    }

    // распечатывает дерево, так чтобы было видно его древовидную структуру, см. ниже пример
    public void print() {
        List<Node<E>> output = new ArrayList<>();
        Node<E> temp=this.root;
        Node<E> father=this.root;
        while(temp.rightChild!=null&&temp.leftChild!=null) {
            father=temp;
            temp=temp.rightChild;
        }
        output.add(temp);
        getLefts(father,output);

        output.add(root);

        Node<E> temp2=this.root;
        Node<E> father2=this.root;
        while(temp2.leftChild!=null) {
            father2=temp2;
            temp2=father2.leftChild;

        }
        getRights(father2, output);
        showTree(output);
    }

    private void showTree(List<Node<E>> output) {
        for(Node node:output){
            System.out.println(node.spaces.toString()+node.value);
        }
    }

    private void getRights(Node<E> father,List<Node<E>> output){
        List<Node<E>> reverse = new ArrayList<>();

            reverse.add(father.leftChild);
        if(father.leftChild.rightChild!=null){
            reverse.add(father.leftChild.rightChild);
        }

        if(father!=root) {
            reverse.add(father);
            if (father.rightChild != null) {
                Node<E> temp = father.rightChild;
                while (temp.leftChild != null && temp.rightChild != null) {
                    temp = temp.leftChild;
                }
                reverse.add(temp);
            }
        }

        for(int i=reverse.size()-1; i>=0; i--){
            output.add(reverse.get(i));
        }
    }

    private void getLefts(Node<E> father,List<Node<E>> output){
        if(!output.contains(father)){
            output.add(father);
        }
        if(father.leftChild!=null){
            Node<E> temp=father.leftChild;
            while (temp.rightChild != null && temp.leftChild != null) {
                temp = temp.rightChild;
            }
            if(!output.contains(temp)){
                output.add(temp);
            }

            if(father.leftChild.leftChild!=null){
                getLefts(father.leftChild,output);
            }
        }
    }

}

