package queue;

public class ListQueue<T> implements Queue<T>
{

    public ListQueue( )
    {
        front = back = null;
    }

    public boolean isEmpty( )
    {
        return front == null;
    }

    public void enqueue( T x )
    {
        if( isEmpty( ) )    // Make queue of one element
            back = front = new ListNode<T>( x );
        else                // Regular case
            back = back.setNext(new ListNode<T>( x ));
    }

    public T dequeue( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( "ListQueue dequeue" );

        //TODO:Complete the implementation of dequeue.
    }

    public T getFront( ) 
    {
        if( isEmpty( ) )
            throw new UnderflowException( "ListQueue getFront" );
        return front.getElement();
    }

    public void clear( )
    {
        front = null;
        back = null;
    }

    private ListNode<T> front;
    private ListNode<T> back;

}
