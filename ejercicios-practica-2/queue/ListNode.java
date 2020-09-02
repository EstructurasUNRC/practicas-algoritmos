package queue;

class ListNode<T>
{
      // Constructors
    public ListNode( T theElement )
    {
        this( theElement, null );
    }

    public ListNode( T theElement, ListNode<T> n )
    {
        setElement(theElement);
        setNext(n);
    }

    public ListNode<T> getNext() {
		return next;
	}

	public ListNode<T> setNext(ListNode<T> next) {
		this.next = next;
		return next;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	private T   element;
    private ListNode<T> next;
}
