//Reverse a linked list

// Complete the reverseLinkedList function below.

/*
 For your reference:

 SinglyLinkedListNode {
     int data;
   SinglyLinkedListNode next;
 }
To create a new node use below constructor
public SinglyLinkedListNode(int nodeData)
*/

static SinglyLinkedListNode reverseLinkedList(SinglyLinkedListNode head) 
{

  if(head==null)  return head;
  else
  {
    SinglyLinkedListNode current = head;
    SinglyLinkedListNode prev = null;
    SinglyLinkedListNode next = null;
    while(current != null)
    {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return  prev;
  }

}
