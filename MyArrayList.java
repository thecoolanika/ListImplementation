import java.util.ListIterator;
import java.util.Iterator;

public class MyArrayList<E>
{
    private int size;
    private Object[] values;
    private int version;
    
    public MyArrayList() {
        this.size = 0;
        this.values = new Object[1];
        this.version = 0;
    }
    
    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        String s = "[";
        for (int i = 0; i < this.size - 1; ++i) {
            s = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;, s, this.values[i]);
        }
        return invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;, s, this.values[this.size - 1]);
    }
    
    private void doubleCapacity() {
        final Object[] newValues = new Object[2 * this.getCapacity()];
        for (int i = 0; i < this.size; ++i) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }
    
    public int getCapacity() {
        return this.values.length;
    }
    
    public int size() {
        return this.size;
    }
    
    public E get(final int index) {
        final E temp = (E)this.values[index];
        return temp;
    }
    
    public E set(final int index, final E obj) {
        final E temp = this.get(index);
        this.values[index] = obj;
        return temp;
    }
    
    public boolean add(final E obj) {
        this.add(this.size, obj);
        return true;
    }
    
    public E remove(final int index) {
        final E temp = this.get(index);
        for (int i = index; i < this.size() - 1; ++i) {
            this.values[i] = this.values[i + 1];
        }
        --this.size;
        ++this.version;
        return temp;
    }
    
    public Iterator<E> iterator() {
        return (Iterator<E>)new MyArrayList.MyArrayListIterator(this);
    }
    
    public ListIterator<E> listIterator() {
        return (ListIterator<E>)new MyArrayList.MyArrayListListIterator(this);
    }
    
    public void add(final int index, final E obj) {
        if (this.size() >= this.getCapacity()) {
            this.doubleCapacity();
        }
        for (int i = this.size; i > index; --i) {
            this.values[i] = this.values[i - 1];
        }
        this.values[index] = obj;
        ++this.size;
        ++this.version;
    }
    
    private int getVersion() {
        return this.version;
    }
}
