/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.Random;

/**
 *
 * @author ayush
 */
public class Sort {
    
    public void shuffleArray(int array[])
    {
        Random random = new Random();
        for(int i= array.length-1;i>=0;i--)
        {
            int index = random.nextInt(i+1);
            int a =array[index];
            array[index] = array[i];
            array[i] = a;
            
        }
            
    }
    
    public int[] copyArray(int array[])
    {
        int copyArray[] = new int[array.length];
        for(int i=0;i<array.length;i++)
            {
   
                copyArray[i] = array[i];
   
            }
        return copyArray;
    }
    
    public void printArray(int array[])
    {
       for(int i=0;i<array.length;i++)
        {
           
            System.out.print(array[i]+" ");

        }
        System.out.println("");
    }
    
    
    public int[] insertionSort(int array[])
    {
          int n =array.length;
          for(int i=1;i<n;i++)
          {
              int key = array[i];
              int j = i-1;
              
              
              // moving the elements of array that are greater than key to one position ahead
              while(j>=0 && array[j]>key)
              {
                  array[j+1] = array[j];
                  j = j-1;                  
              }
              array[j+1]= key;
          }
          
          return array;
    }
    
    public int[] selectionSort(int array[])
    {
        int n=array.length;
        // looping over entire array
        for(int i= 0;i<n-1;i++)
        {
            //setting min value as the i index always
            int min = i;
            
            //searching from the next index i+1 position to end to find min value in unsorted array
            for(int j=i+1; j<n;j++)
            {
                if(array[j]< array[min])
                   min = j;
            }
            
            // swapping min element with first element
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
            
            
        }
        
        return array;
    }
    
    
    public void quickSort(int array[], int low,int high)
    {
//        if(low < high)
//        {
//           int pi = partition(array,low,high);
//           
//       
//           
//           quickSort(array,low,pi-1);
//           quickSort(array,pi+1,high);
//           
//          
//        }
        
        int pivot = partition(array, low, high);
          if (low < pivot - 1)
                quickSort(array, low, pivot - 1);
          if (pivot < high)
                quickSort(array, pivot, high);
    
    }
    
    public int partition(int array[],int low,int high)
    {
//        // setting last index value of array as pivot element
//        int pivot = array[(low+high)/2];
//        
//        // intializing index of smaller element
//        int i = low-1;
//        
//        //looping over each value in arraylist
//        for(int j=low;j<=high-1;j++)
//        {
//            // if cuurent element is lower than pivot element
//            if(array[j]<=pivot)
//            {
//                //incrementing index of i;
//                i++;
//                //swapping  i and j;
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//            }
//            
//        }
//        // placing pivot element at its exact position (i+1) by swaaping it
//        int temp = array[i+1];
//        array[i+1] = array[high];
//        array[high] = temp;
//        
//        // returning index of pivot element
//        return i+1;
         int i = low, j = high;
          int tmp;

          Random random = new Random();
          int pivot = array[low + random.nextInt(high - low)];
         // int pivot = array[(low + high) / 2];

          while (i <= j) {
                while (array[i] < pivot)
                      i++;
                while (array[j] > pivot)
                      j--;
                if (i <= j) {
                      tmp = array[i];
                      array[i] = array[j];
                      array[j] = tmp;
                      i++;
                      j--;
                }
          };

          return i;
    }
    
    // heapify subtree rooted with root node i
    // maxheap function 
    public void heapify(int array[],int n,int i)
    {
        // Intialzing root left and right
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        
       //left child greater than largest
        if(left < n && array[left] > array[largest])
            largest = left;
       
        //right child greater than largest
        if(right < n && array[right] > array[largest])
            largest = right;
        
        // larget is not root node i
        if(largest!=i)
        {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            
            // Recursively heapifying affected subtree 
            heapify(array,n,largest);
        }   
        
    }
    
    public void heapSort(int array[])
    {
        int n  = array.length;
        
        //building maxheap which stores the max node at root
       for(int i= n/2-1;i>=0;i--)
           heapify(array, n, i);
       
        //extracting elements from heap
       for(int i=n-1;i>=0;i--)
       {
           //moving current root node to end
           int temp = array[0];
           array[0] = array[i];
           array[i] = temp;
           
           // heapfiying the reduced heap
           heapify(array,i,0);
       }
           
       
    }
    
    public void mergeSort(int array[], int l,int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;
            
            mergeSort(array,l,m);
            mergeSort(array,m+1,r);
            
            merge(array,l,m,r);
                    
        }
    }
    
    public void merge(int array[],int l, int m, int r)
    {
        
        int n1 = m-l+1;
        int n2 = r-m;
        
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for(int i=0;i<n1;i++)
            L[i]= array[l+i];
        for(int j=0;j<n2;j++)
            R[j] = array[m+1+j];
        
        
        int i=0,j=0;
        
        int k=l;
        
        while(i<n1 && j<n2)
        {
            if(L[i] <= R[j])
            {
                array[k] = L[i];
                i++;
            }
            else
            {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i<n1)
        {
            array[k] = L[i];
            k++;
            i++;
        }
        
        while(j<n2)
        {
            array[k] = R[j];
            k++;
            j++;
        }
    }
    
    public void combinedQuickSort(int array[],int low, int high)
    {
//        int pivot = partition(array, low, high);
//          if (low < pivot - 1)
//                quickSort(array, low, pivot - 1);
//          if (pivot < high)
//                quickSort(array, pivot, high);
//    
        
        if(low < high)
        {
            if((high-low) < 9)
                combinedInsertionSort(array,low,high+1);
            else
            {
                 int pivot = partition(array, low, high);
                 if (low < pivot - 1)
                  quickSort(array, low, pivot - 1);
                 if (pivot < high)
                  quickSort(array, pivot, high);
            }
        }
    }
    
    public void combinedInsertionSort(int array[],int low,int high)
    {
        for(int i=low+1;i<high;i++)
        {
            int min = array[i];
            int  j = i-1;
            
            while(j>=0 && min<array[j])
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = min;
        }
    }
}
