

public class Storage {
	 public static boolean testAdd()     {
		 MyList<String> aStorage = new MyLinkedList<String>();
	        String theStrings[] = { "a", "b", "c" };
	        boolean rValue = true;
	        for ( int index = 0; index < theStrings.length; index ++ )
	                aStorage.addLast(theStrings[index]);
	        for ( int index = 0; index < theStrings.length; index ++ )
	                rValue &= aStorage.removeFirst().equals(theStrings[index]);
//	        rValue &= aStorage.removeLast() == null;
//	        aStorage.add("c");
	        if(rValue) {
	        	System.out.println("testAdd success");
	        }
	        return rValue;
	    }
	   
	   public static boolean testRemoveIndex() {
		   MyList<String> aStorage = new MyLinkedList<String>();
		   String theStrings[] = { "a", "b", "c" };
	        boolean rValue = true;
	        for ( int index = 0; index < theStrings.length; index ++ )
                aStorage.addLast(theStrings[index]);
	        rValue &= aStorage.remove(0).equals(theStrings[0]);
	        aStorage.clear();
	        if(rValue) {
	        	System.out.println("testRemoveIndex success");
	        }
	        return rValue;
	   }
	   
	   public static boolean testRemoveAll(MyLinkedList<String> cStorage) {
		   MyList<String> bStorage = new MyLinkedList<String>();
		   String theStr[] = { "a", "b", "c" };
		   String str[] = { "d", "e", "f" };
	       boolean rValue = true;
	       for ( int j = 0; j < theStr.length; j ++ )
               cStorage.addLast(str[j]);
	       for ( int index = 0; index < theStr.length; index ++ )
               bStorage.addLast(theStr[index]);
	       for ( int k = 0; k< str.length; k ++ )
               bStorage.addLast(str[k]);
	       	   bStorage.removeAll(cStorage);
	       if(bStorage.get(theStr.length)==null) {
	    	   System.out.println("testRemoveAll success");
	    	   return true;
	       }else {
	    	   return false;
	       }
	   }
	   
	   public static boolean testAddAll() {
		   MyList<String> aStorage = new MyLinkedList<String>();
		   MyList<String> bStorage = new MyLinkedList<String>();
		   String theStr[] = { "a", "b", "c" };
		   String str[] = { "d", "e", "f" };
	       boolean rValue = true;
	       for ( int j = 0; j < theStr.length; j ++ )
               aStorage.addLast(str[j]);
	       for ( int index = 0; index < theStr.length; index ++ )
               bStorage.addLast(theStr[index]);
	       aStorage.addAll(bStorage);
	       aStorage.removeAll(bStorage);
	       for ( int k = 0; k< aStorage.size(); k ++ ) {
	    	   if(aStorage.get(k)!=str[k]) {	   
	    		   return false;
	    	   }
	       }
	    	   	   System.out.println("testAddAll success");
	    		   return true;
	       } 
	   
	   public static boolean testAddIndex() {
		   MyList<String> aStorage = new MyLinkedList<String>();
		   String theStrings[] = { "a", "b", "c" };
	        boolean rValue = true;
	        for ( int index = 0; index < theStrings.length; index ++ )
                aStorage.addLast(theStrings[index]);
	        aStorage.add(1, "d");
	        rValue &= aStorage.remove(1).equals("d");
	        if(rValue) {
	        	System.out.println("testAddIndex success");
	        }
	        return rValue;
	   }
	   
	   public static boolean testContains() {
		   MyList<String> dStorage = new MyLinkedList<String>();
		   String newStrings[] = { "a", "b", "c" };
	        boolean rValue = true;
	        for ( int index = 0; index < newStrings.length; index ++ )
                dStorage.addLast(newStrings[index]);
	        if(dStorage.contains("a")) {
	        	System.out.println("testContains success");
	        	return true;
	        }else {
	        	return false;
	        }
	   }
	   
	   public static boolean testClear() {
		   MyList<String> aStorage = new MyLinkedList<String>();
		   String theStrings[] = { "a", "b", "c" };
	        boolean rValue = true;
	        for ( int index = 0; index < theStrings.length; index ++ )
                aStorage.addLast(theStrings[index]);
	        aStorage.clear();
	        if(aStorage.removeLast()==null) {
	        	System.out.println("testClear success");
	  	    	return true;
	        }else {
	        	return false;
	        }
	   }
	      
	   
	   public static void exampleOfHowToUseIt( MyLinkedList<String> aStorage)   {
	        aStorage = new MyLinkedList<String>();
	        MyList<String> bStorage = new MyLinkedList<String>();
	        bStorage.addFirst("a");
	        bStorage.addFirst("d");
	        bStorage.addFirst("g");
	        bStorage.addFirst("f");
	        bStorage.addFirst("h");
	        bStorage.addFirst("5");
	        bStorage.sortNew();
	        //bStorage.removeTwoWay(2);
	        //bStorage.removeTwoWay(3);
	        //bStorage.removeTwoWay(4);//return null,注意size时刻变化
	    }
	    public static void test(MyLinkedList<String> bStorage)   {
	                if ( ! testRemoveIndex() )
	                        System.err.println("testRemove failed");
	                if ( ! testRemoveAll(bStorage) )
	                        System.err.println("testRemove failed");
	                if ( ! testContains() )
	                        System.err.println("testContains failed");
	                if ( ! testAdd() )
	                        System.err.println("testAdd failed");
	                if ( ! testAddAll() )
	                        System.err.println("testAddAll failed");
	                if ( ! testClear() )
	                        System.err.println("testClear failed");
	    }
	    public static void main(String args[] ){
	    	MyList<String> aStorage = new MyLinkedList<String>();
	        MyList<String> bStorage = new MyLinkedList<String>();
	        test(new MyLinkedList<String>());
	        System.out.println();
	        exampleOfHowToUseIt(new MyLinkedList<String>());
	    }
	}


