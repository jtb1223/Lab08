
package com.mycompany.singlelinkedlist;

class Node {
   public int data;
   public Node next;

   public Node(int data) {
      this.data = data;
      this.next = null;
   }
}

class LinkedList {
   private Node head;
   private Node tail;
    
   public LinkedList() {
      head = null;
      tail = null;
   }
    
   public void append(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         tail.next = newNode;
         tail = newNode;
      }
   }
   
   public void prepend(Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else {
         newNode.next = head;
         head = newNode;
      }
   }
   

   
   public void insertAfter(Node currentNode, Node newNode) {
      if (head == null) {
         head = newNode;
         tail = newNode;
      }
      else if (currentNode == tail) {
         tail.next = newNode;
         tail = newNode;
      }
      else {
         newNode.next = currentNode.next;
         currentNode.next = newNode;
      }
   }
   

   public void removeAfter(Node currentNode) {
      if (currentNode == null && head != null) {
         // Special case: remove head
         Node succeedingNode = head.next;
         head = succeedingNode;
         if (succeedingNode == null) {
             // Last item was removed
             tail = null;
         }
      }
      else if (currentNode.next != null) {
         Node succeedingNode = currentNode.next.next;
         currentNode.next = succeedingNode;
         if (succeedingNode == null) {
            // Remove tail
            tail = currentNode;
         }
      }
   }
   public boolean checkPrime(int n) {
       
       if (n <=1) {
           return false;
       }
        for(int i=2; i < n; i++){
            if(n%i==0){
                return false;
            }
        }
         return true;
        }
   //check if prime helper method
   
    public void populateWithPrimes(int n) {
        for (int i = 2; i <= n; i++) { 
            if (checkPrime(i)) { //uses for loops to check prime and inserts new node to list
                Node newNode = new Node(i);
                insertAfter(head, newNode);
                head = newNode;
            }
        }
    }
   
   //add to list if prime 
   
   public boolean hasDigit3(int num) {
        while (num > 0) {
            if (num % 10 == 3) { 
                return true;
            }
            num /= 10;
        }
        return false;
    }
    //helper method to check if digit is 3
 
   public LinkedList addPrimesWithDigit3() {
    LinkedList newList = new LinkedList();
    Node current = head;
    while (current != null) {
        if (checkPrime(current.data) && hasDigit3(current.data)) { //
            Node newNode = new Node(current.data);
            newList.insertAfter(current, newNode);
        }
        current = current.next;
    }
    return newList;
}
    //if 3 digit is there those nums gets put into a new list
   
   
   public int getSumOfPrimes() {
    int sum = 0;
    Node current = addPrimesWithDigit3().head;
    while (current != null) {
        if (checkPrime(current.data)) {
            sum += current.data;
        }
        current = current.next;
    }
    return sum;
}
   //sums all branches that have the digit 3
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
   
    //create a singlelinkedlist that gets populated with primes from 0 to n
    //then any integer that has the digit 3 gets populated into another list
    //using the second list get the sum of all branches in the list
  
}
