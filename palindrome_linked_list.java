// check wheteher given linked list is palindrome or not.

// Complete the palindromeLlist function below.
/*
For your reference:

public SinglyLinkedListNode {
int data;
SinglyLinkedListNode next;
}

To create a new node use below constructor
public SinglyLinkedListNode(int nodeData)
*/

static boolean palindromeLlist(SinglyLinkedListNode head) 
{
  SinglyLinkedListNode temp = head;
  Stack<Integer> s = new Stack<Integer>();
  if(head==null)  return false;
  else
  {
    while(temp != null)
    {
      s.push(temp.data);
      temp = temp.next;
    }
    SinglyLinkedListNode temp1 = head;
    while(temp1 != null)
    {
      if(temp1.data == s.peek())  s.pop();
      temp1 = temp1.next;
    }
    if(s.empty()) return true;
    else return false;
  }
}

