
public interface MyList<E> {
	public boolean add(E e);
	public void add(int index,E e);
	public boolean addLast(E e);
	public void addFirst(E e);
	public void clear();
	public E remove(int index);
	public E getFirst();
	public E remove();
	public E removeLast();
	public E removeFirst();
	public int size();
	public boolean addAll(MyList<String> bStorage);
	public E get(int index);
	public String[] toArray();
	public boolean contains(E e);
	public boolean removeAll(MyList<String> bStorage);
	public void sort();
	public void addTwoWay(int index,E e);
	public E removeTwoWay(int index);
	public boolean isEmpty();
	public String getClassName();
	public void sortNew();
}
