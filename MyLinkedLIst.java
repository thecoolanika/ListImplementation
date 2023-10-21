import java.util.Iterator;
 
public class MyLinkedList<E>
{
    private DoubleNode first;
    private DoubleNode last;
    private int size;
    private int version;
    
    public MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
        this.version = 0;
    }
    
    @Override
    public String toString() {
        DoubleNode node = this.first;
        if (node == null) {
            return "[]";
        }
        String s = "[";
        while (node.getNext() != null) {
            s = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;, s, node.getValue());
            node = node.getNext();
        }
        return invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;, s, node.getValue());
    }
    
    private DoubleNode getNodeFromFirst(final int index) {
        DoubleNode current = this.first;
        for (int i = 0; i < index; ++i) {
            current = current.getNext();
        }
        return current;
    }
    
    private DoubleNode getNodeFromLast(final int index) {
        DoubleNode current = this.last;
        for (int i = this.size - 1; i > index; --i) {
            current = current.getPrevious();
        }
        return current;
    }
    
    private DoubleNode getNode(final int index) {
        if (2 * index < this.size) {
            return this.getNodeFromFirst(index);
        }
        return this.getNodeFromLast(index);
    }
    
    public int size() {
        return this.size;
    }
    
    public E get(final int index) {
        return (E)this.getNode(index).getValue();
    }
    
    public E set(final int index, final E obj) {
        final E temp = (E)this.getNode(index).getValue();
        this.getNode(index).setValue((Object)obj);
        return temp;
    }
    
    public boolean add(final E obj) {
        this.add(this.size, obj);
        return true;
    }
    
    public E remove(final int index) {
        final DoubleNode after = this.getNode(index + 1);
        final DoubleNode temp = this.getNode(index);
        final DoubleNode before = this.getNode(index - 1);
        if (this.size == 0) {
            this.first = null;
            this.last = null;
        }
        else if (index == 0) {
            (this.first = temp.getNext()).setPrevious((DoubleNode)null);
        }
        else if (index == this.size - 1) {
            this.last = temp.getPrevious();
            temp.getPrevious().setNext((DoubleNode)null);
        }
        else {
            before.setNext(after);
            after.setPrevious(before);
        }
        --this.size;
        return (E)temp.getValue();
    }
    
    public void add(final int index, final E obj) {
        final DoubleNode temp = new DoubleNode((Object)obj);
        if (this.size == 0) {
            this.first = temp;
            this.last = temp;
        }
        else if (index == 0) {
            temp.setNext(this.first);
            this.first.setPrevious(temp);
            this.first = temp;
        }
        else if (index == this.size) {
            temp.setPrevious(this.last);
            this.last.setNext(temp);
            this.last = temp;
        }
        else {
            final DoubleNode before = this.getNode(index - 1);
            final DoubleNode after = this.getNode(index);
            temp.setNext(after);
            temp.setPrevious(before);
            after.setPrevious(temp);
            before.setNext(temp);
        }
        ++this.size;
    }
    
    public void addFirst(final E obj) {
        this.add(0, obj);
    }
    
    public void addLast(final E obj) {
        this.add(this.size, obj);
    }
    
    public E getFirst() {
        return (E)this.first.getValue();
    }
    
    public E getLast() {
        return (E)this.last.getValue();
    }
    
    public E removeFirst() {
        return this.remove(0);
    }
    
    public E removeLast() {
        return this.remove(this.size - 1);
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public Iterator<E> iterator() {
        return (Iterator<E>)new MyLinkedList.MyLinkedListIterator(this, this);
    }
}
