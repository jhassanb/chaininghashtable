public class FinalP3 {

    // ****************************************************
    // Unless otherwise stated, DO NOT USE ANY JAVA LIBRARY
    // ****************************************************
    
   public static void main(String[] args) {

       // Problem statement:
       // 
       // Write code to conduct a computational experiement 
       // To study the maximum of the length of the chains
       // in a chaining hash table.

       // Define the number of items for the experiment
       
       int NoOfItems = 10000;          // set No. of data item

       // Task 1
       
       // Each data item is a (key, value) pair
       // Create the data items by adding them to two arrays of Strings
       // via the Dice function (given). Note that each data
       // item is a (key,value) pair of strings

       // Note:
       
       // You may use the valueOf function (from String class)
       // to help generating data. For example:
       // String.valueOf(100) tranforms an integer to its String
       // Representation  (Uncomment the following line to try)
       
       //System.out.println(String.valueOf(100)); 

       
       // *****  Put your code below:  *****

	String[] keys = new String[NoOfItems]; //array of strings to hold the keys
	String[] values = new String[NoOfItems]; //array of strings to hold the values
	
	ChainingHashTable hashTable1 = new ChainingHashTable();


	for(int i = 0; i < NoOfItems; i++){
		keys[i] = String.valueOf(hashTable1.dice(100000)); // generate random key
		values[i] = String.valueOf(hashTable1.dice(1000)); // generate random value
	}
	

       // Task 2: Set the capacity (no. of buckets) of
       //         the Chaining Hash Table

       // *****  Put your code below:  *****
	
	
	int hashTable2Capacity = 11; //change this value to test code with different num of buckets


       // Task 3: Create a chaining hash table

       // *****  Put your code below:  *****

	ChainingHashTable hashTable2 = new ChainingHashTable(hashTable2Capacity);

       
       // Task 4: Add the data generated to the chaining hash table

       // *****  Put your code below:  *****
	
	for(int i = 0; i < NoOfItems; i++){
		hashTable2.insert(keys[i], values[i]);
	}
       
	//used this toString function to make sure values were added to the hashTable2
        //System.out.print(hashTable2.toString());
       
       // Task 5: Display the length of each chain in the following form.
       //         For example, if the capacity is 11 and after inserting
       //         10000 key value pairs, the lengths of each chain in the
       //         hash table are shown as:  
       //               
       //         [ 835 840 877 860 861 855 842 872 915 900 867 ]


       // *****  Put your code below:  *****
       
   	int[] hashTable2ChainLengths = hashTable2.lengthHashTableChains();
	
	System.out.print("[ ");

	for(int i = 0; i < hashTable2Capacity; i++){
		System.out.print(hashTable2ChainLengths[i] + " ");
	}

       	System.out.println("]");
       
       // Task 6: Compute the maximum chain length and minimum chain length
       //         and display them as (with respect to chains shown earlier:
       // 
       // Maximum chain length: 915; Minimum chain length: 835.
       // Maximum difference between chain length: 80.


       // *****  Put your code below:  *****
 
       int maxChainLength = Integer.MIN_VALUE;
       int minChainLength = Integer.MAX_VALUE;
	
	//for loop iterates over every element in the hashTable2ChainLengths to find the minimum 
	//and to find the maximum chain lengths 
 	for (int length : hashTable2ChainLengths) {
		if (length > maxChainLength) {
			maxChainLength = length;
		}
		if (length < minChainLength) {
			minChainLength = length;
		}
	}
       
       System.out.println("Maximum chain length: " + maxChainLength);
       System.out.println("Minimum chain length: " + minChainLength);	
       System.out.println("Maximum difference between chain lengths: " + (maxChainLength - minChainLength));


       // Task 7: Remove 1000 randomly selected items from the chaining
       //         hash table.  
       //         Diaplay the chain lengths data, including the maximum chain
       //         length, minimum chain length etc..
       //         For example, the data you print may look like:

       //         After removing 1000 items:
       
       //         [ 761 748 787 769 782 777 748 786 818 813 784 ]
       // 
       //         Maximum chain length: 818; Minimum chain length: 748.
       //         Maximum difference between chain length: 70.

       
       // *****  Put your code below:  *****
	//removing 1000 randomly selected items from the chaining hash table
	for(int i = 0; i < 1000; i++){
		hashTable2.remove(String.valueOf(hashTable1.dice(100000)));
	} 
	
	//creating new array to store chain lengths after the 1000 elements removed 
	int[] hashTable2ChainLengthsAfterRemove = hashTable2.lengthHashTableChains();
	
	System.out.println(" ");
	System.out.println("After removing 1000 items:");

	System.out.print("[ ");

	for(int i = 0; i < hashTable2Capacity; i++){
		System.out.print(hashTable2ChainLengthsAfterRemove[i] + " ");
	}
	
	System.out.println("]");
	
	int newMaxChainLength = Integer.MIN_VALUE;
       	int newMinChainLength = Integer.MAX_VALUE;

 	for (int length : hashTable2ChainLengthsAfterRemove){
		if (length > newMaxChainLength) {
			newMaxChainLength = length;
		}
		if (length < newMinChainLength) {
			newMinChainLength = length;
		}
	}
       
       System.out.println("Maximum chain length: " + newMaxChainLength);
       System.out.println("Minimum chain length: " + newMinChainLength);	
       System.out.println("Maximum difference between chain lengths: " + (newMaxChainLength - newMinChainLength));

   }
}
