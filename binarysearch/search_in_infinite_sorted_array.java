
// only for understanding purpose and can'tbe compiled
import java.io.*;

class search_in_infinite_sorted_array {
	public static void main (String[] args) {
// 	search in infinite sorted Array
    int slow=0;
    int fast=slow+1;
    
    while(arr[fast]<target){
        slow=fast;
        fast=fast*2;
    }


// apply binary search as normal 

    binarySearch(arr,slow,fast,target);

	}
}