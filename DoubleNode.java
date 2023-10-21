/**
* Double Node defines a data structure like a doubly linked list
* @author Riya Gupta with assistance from Ms. Datar
* @version 10/24/19
*/
public class DoubleNode
{
    private Object value;
    private DoubleNode previous;
    private DoubleNode next;

    /**
     * constructor that instantiates a DoubleNode object
     * @param v value to set in the DoubleNode
     */
    public DoubleNode(Object v)
    {
        value = v;
        previous = null;
        next = null;
    }

    /**
     * gets the value in the DoubleNode
     * @return value in the DoubleNode
     */
    public Object getValue()
    {
        return value;
    }

    /**
     * gets the previous DoubleNode 
     * @return previous DoubleNode 
     */
    public DoubleNode getPrevious()
    {
        return previous;
    }

    /**
     * gets the next DoubleNode
     * @return next DoubleNode
     */
    public DoubleNode getNext()
    {
        return next;
    }

    /**
     * sets the value of the DoubleNode to the passed Object
     * @param v Object to set DoubleNode to
     */
    public void setValue(Object v)
    {
        value = v;
    }

    /**
     * sets the value of the previous DoubleNode to the passed DoubleNode
     * @param p DoubleNode to set to previous
     */
    public void setPrevious(DoubleNode p)
    {
        previous = p;
    }

    /**
     * sets the value of the next DoubleNode to the passed DoubleNode
     * @param n DoubleNode to set to next
     */
    public void setNext(DoubleNode n)
    {
        next = n;
    }
}