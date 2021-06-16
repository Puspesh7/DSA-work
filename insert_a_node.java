// insert a node in sorted manner in linked list

// Complete the insertSortedNode function below.

/*
For your reference:

SinglyLinkedListNode {
int data;
SinglyLinkedListNode next;
}
To create a new node use below constructor
public SinglyLinkedListNode(int nodeData)
*/
static SinglyLinkedListNode insertSortedNode(SinglyLinkedListNode head,int value) 
{
  SinglyLinkedListNode newnode = new SinglyLinkedListNode(value);
  if(head == null)  return newnode;
  else if(head.data > value)
  {
    newnode.next = head;
    head = newnode;
    return head;
  }
  else
  {
    SinglyLinkedListNode temp1 = head;
    while(temp1.next != null && temp1.next.data < value)
      temp1 = temp1.next;
    SinglyLinkedListNode temp2 = temp1.next;
    temp1.next = newnode;
    newnode.next = temp2;
    return head;
  }
}

