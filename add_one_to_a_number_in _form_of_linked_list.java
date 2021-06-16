/*
You are given a linked list representing a number such that each individual node acts as a digit of the number. The list HEAD->1->2->3->NULL
corresponds to the number 123. Your task is to add 1 to this number.
*/

// Complete the addOneToList function below.

/*
For your reference:

SinglyLinkedListNode {
int data;
SinglyLinkedListNode next;
}
To create a new node use below constructor
public SinglyLinkedListNode(int nodeData)

*/
static SinglyLinkedListNode addOneToList(SinglyLinkedListNode head) 
{
  SinglyLinkedListNode head1 = reverseLinkedList(head);
  SinglyLinkedListNode temp1 = head1;
  while(temp1 != null)
  {
    if(temp1.data == 9)
    {
      temp1.data = 0;
      temp1 = temp1.next;
    }
    else
    {
      temp1.data = temp1.data + 1;
      break;
    }
  }
  if(temp1 == null)
  {
    SinglyLinkedListNode temp2 = head1;
    while(temp2.next != null)
      temp2 = temp2.next;
    SinglyLinkedListNode one = new SinglyLinkedListNode(1);
    temp2.next = one;
  }
  SinglyLinkedListNode head2 = reverseLinkedList(head1);
  return head2;
}
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
