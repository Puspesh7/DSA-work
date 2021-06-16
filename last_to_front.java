/*
you are given a linked list containing N elements, your task is to bring the last node to the front.
*/


// Complete the lastElementFirst function below.

/*
For your reference:

SinglyLinkedListNode {
int data;
SinglyLinkedListNode next;
}
To create a new node use below constructor
public SinglyLinkedListNode(int nodeData)
*/
static SinglyLinkedListNode lastElementFirst(SinglyLinkedListNode head) 
{
  if(head==null)  return head;
  else if(head.next==null)  return head;
  else
  {
    SinglyLinkedListNode temp1 = head;
    SinglyLinkedListNode temp2 = head;
    while(temp2.next != null) 
      temp2 = temp2.next;
    while(temp1.next.next != null)
      temp1 = temp1.next;
    temp1.next = null;
    temp2.next = head;
    head = temp2;
    return head;
  }

}

