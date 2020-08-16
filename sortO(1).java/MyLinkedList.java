
public class MyLinkedList<E> extends MyAbstractClass<E> {
	public Node<E> head,tail = null;
	
	public MyLinkedList(){
		
	}
	public void addFirst(E e) {
		Node<E> newNode=new Node<E>(e);
		newNode.next=head;
		head=newNode;
		size++;
		if(tail==null) {
			tail=head;
		}
		this.sort();
	}
	
	public boolean addLast(E e) {
		if(this.contains(e)) {
			return false;
		}else {
		Node<E> newNode=new Node<E>(e);
		if(tail==null) {//开始时什么节点都没有时，新开辟一个节点
			head=tail=newNode;
		}else {
			tail.next=newNode;//有节点存在时，指针如何指向一个新节点
			tail=tail.next;
		}
		size++;
		return true;
		}
	}
	
	public void add(int index,E e) {
		if(index==0) addFirst(e);
		else if (index>=size) addLast(e);//超过size也添加到最后
		else {
			Node<E>current=head;
			for(int i=1;i<index;i++) 
				current=current.next;
			Node<E> temp=current.next;
			current.next=new Node<E>(e);
			(current.next).next=temp;
			size++;
		}
	}
	
	public void addTwoWay(int index,E e) {
		if(index==0) addFirst(e);
		else if (index>=size) addLast(e);//超过size也添加到最后
		else {
			if(index<=size/2) {
			Node<E>current=head;
			for(int i=1;i<index;i++) 
				current=current.next;
			Node<E> temp=current.next;
			current.next=new Node<E>(e);
			(current.next).next=temp;
			size++;
			}else {
			Node<E>current=tail;
			for(int i=1;i<size-index;i++) 
				current=current.prev;
			Node<E> temp=current.prev;
			current.prev=new Node<E>(e);
			(current.prev).prev=temp;
			size++;
			}
		}
	}
	
	public E removeFirst() {
		if(size==0) return null;
		else if(size==1) {
			Node<E>temp=head;
			head=tail=null;
			size=0;
			return temp.element;
		}else {
			Node<E>temp=head;
			head=head.next;
			size--;
			return temp.element;
		}
	}
	
	public E removeLast() {
		if(size==0) return null;
		else if(size==1) {
			Node<E>temp=head;
			head=tail=null;
			size=0;
			return temp.element;
		}else {
			Node<E>current=head;
			for(int i=0;i<size-2;i++) {
				current=current.next;
			}
			Node<E>temp=tail;
			tail=current;
			tail.next=null;
			size--;
			return temp.element;
		}
	}
	
	public E remove(int index) {
		if(index<0||index>=size) return null;
		else if(index==0) return removeFirst();
		else if(index==size-1) return removeLast();
		else {
			Node<E>previous=head;
			for(int i=1;i<index;i++) {
				previous=previous.next;
			}
			Node<E>current=previous.next;
			previous.next=current.next;
			size--;
			return current.element;
		}
	}
	
	public E removeTwoWay(int index) {
		if(index<0||index>=size) return null;
		else if(index==0) return removeFirst();
		else if(index==size-1) return removeLast();
		else {
			if(index<=size/2) {
			Node<E>previous=head;
			for(int i=1;i<index;i++) {
				previous=previous.next;
			}
			Node<E>current=previous.next;
			previous.next=current.next;
			size--;
			return current.element;
			}else {
				Node<E>previous=tail;
				for(int i=1;i<size-1-index;i++) {
					previous=previous.prev;
				}
				Node<E>current=previous.prev;
				previous.prev=current.prev;
				size--;
				return current.element;
			}
		}
	}
	
	public void clear() {
//		for(int i=0;i<size;i++) {
//			remove(i);
//		}
		head=tail=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public E getFirst() {
		if(size==0) {
			return null;
		}else {
			return head.element;
		}
	}
	
	public E get(int index) {
		if(index<0||index>=size) return null;
		else if(index==0) return head.element;
		else if(index==size-1) return tail.element;
		Node<E>current=head;
		for(int i=1;i<index;i++) {
			current=current.next;
		}
		Node<E>temp=current.next;
		return temp.element;
	}
	
	public boolean addAll( MyList<String> cStorage) {
		if(cStorage==this) {
			return false;
		}else {
			for(int index=0;index<cStorage.size();index++) {
				this.addLast( (E) cStorage.get(index));	
			}
				return true;
	    }
	}
	
	public String[] toArray() {
		String []str=new String[this.size()];
		for(int index=0;index<this.size();index++) {
			str[index]=(String)this.get(index);
			//System.out.println(str[index]);
		}
		return str;
	}
	
	public boolean removeAll( MyList<String> cStorage) {
		int getIndex=0;
		String []str=cStorage.toArray();
		String astr=str[0];
			for(int index=0;index<this.size();index++) {
				String aString=(String)(this.get(index));
				if(aString.equals(astr)) {
					getIndex=index;
					break;
				}
			}
			int size=this.size();
			for(int i=0;i<size-getIndex;i++) {
				this.removeLast();
			}
				return true;
	    }
	
	public boolean contains(E e) {
		//String str=(String)e;
		for(int index=0;index<this.size();index++) {
			if(this.get(index).equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	public void sort() {
		int num[]=new int[this.size()];
		String newnum []=new String [this.size];
		int temp=0;
		String newtemp="";
		for(int index=0;index<this.size();index++) {
			//num[index]=Integer.parseInt((String) this.get(index));//cast into Integer
			num[index]=this.get(index).hashCode();
			newnum[index]=(String)this.get(index);
		}
		this.clear();
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				if(num[j]>=num[i]) {
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
					newtemp=newnum[i];
					newnum[i]=newnum[j];
					newnum[j]=newtemp;
				}
			}
		}
		for(int k=0;k<newnum.length;k++) {
			String str=""+newnum[k];
			this.addLast((E)str);
		}
	}
	
	public boolean isEmpty() {
		if(this.size()==0) {
			return true;
		}else {
			return false;
		}
	}

	 public String getClassName() {
		 String name="MyLinkedList<E>";
		 return name;
	 }
	 
	 public void sortNew() {
		 for(int i=0;i<this.size();i++) { 
	        	System.out.println("BStorage: " +this.get(i) );
	        }
	 }
	
}
