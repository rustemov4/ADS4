
package com.company;
import java.util.Objects;
import java.util.Scanner;
class Node<K,V>{
    K key;
    V value;
    Node<K,V> next;

    public Node(K key,V value){
        this.key = key;
        this.value = value;
        Node<K,V> next = null;
    }
}
 class HashTable<K,V> {

     Node nodes[] = new Node[10];


     public void put(K key,V value){
         Node<K,V> entry = new Node<>(key, value);
         Integer hash = hashCode(key);
         if(nodes[hash] == null){
             nodes[hash] = entry;
             return;
         }
         Node<K,V> temp = nodes[hash];
         while(temp != null) {
             if(temp.key.equals(key)){
                 temp.value = value;
                 return;
             }
             temp = temp.next;
         }
         temp.next = entry;
     }
     public boolean remove(K key){
         Integer hash = hashCode(key);
         if(nodes[hash] == null){
             return false;
         }
         if(nodes[hash] != null && (nodes[hash].key).equals(key)) {
             nodes[hash] = nodes[hash].next;
             return true;
         }

         Node<K,V> temp  = nodes[hash];
         Node<K,V> prevTemp  = nodes[hash];
         while(temp!=null){
             if(temp.key.equals(key)) {
                 prevTemp.next = temp.next;
                 return true;
             }
             prevTemp = temp;
             temp = temp.next;
         }
         return false;
     }
     private int hashCode(K key){
         int hashcode = Objects.hashCode(key);
         int index = hashcode % 10;
         return Math.abs(index);
     }
     public V get(K key){
         Integer hash = hashCode(key);
         if(nodes[hash] == null){
             return null;
         }
         if(nodes[hash].next != null && (nodes[hash].key).equals(key))
             return (V) nodes[hash].value;

         Node<K,V> temp  = nodes[hash];
         while(temp!=null){
             if(temp.key.equals(key))
                 return temp.value;
             temp=temp.next;
         }
         return null;
     }


 }
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("One","1");

        System.out.println(hashTable.get("One"));
    }
}





