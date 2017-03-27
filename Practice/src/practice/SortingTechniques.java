/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author ayush
 */
public class SortingTechniques
{

    
    public static void main(String[] args) {
       

        int array[] =  new int[100];
        for(int i=0;i<array.length;i++)
         array[i]=i;
        Sort is = new Sort();

        System.out.println("");
        
//        int unsortedPartially[] = new int[array.length/2];
//        int j= array.length/2;
//        for(int i=0;i<array.length/2;i++)
//        {   
//            unsortedPartially[i] = j++;
//        }
//        is.shuffleArray(unsortedPartially);
//        int k= array.length/2;
//        for(int i=0;i<array.length/2;i++)
//        {
//            array[k] = unsortedPartially[i];
//        }
       // is.printArray(array);

       // is.shuffleArray(array);
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------");



        int copyArray[] = new int[array.length]; 



        
        long startTime, endTime, averageTime=0;
        System.out.println("Insertion Sort");
        for(int i=0;i<10;i++)
        {
        copyArray = is.copyArray(array);
        startTime = System.nanoTime();
        is.insertionSort(copyArray);
        endTime = System.nanoTime();
        //is.printArray(copyArray);
        averageTime = averageTime + endTime -startTime;
        System.out.println((endTime-startTime));
        }
        
        System.out.println((averageTime/10));
        System.out.println("---------------------------------------------------------------------------------------------");

        averageTime= 0;
        System.out.println("Selection Sort");
        for(int i=0;i<10;i++)
        {
        copyArray = is.copyArray(array);
        startTime = System.nanoTime();
        is.selectionSort(copyArray);
        endTime = System.nanoTime();
        //is.printArray(copyArray);
        averageTime = averageTime + endTime -startTime;
        System.out.println((endTime-startTime));
        }
        System.out.println((averageTime/10));
        System.out.println("---------------------------------------------------------------------------------------------");

        averageTime= 0;
        System.out.println("Merge Sort");
        for(int i=0;i<10;i++)
        {
        copyArray = is.copyArray(array);
        startTime = System.nanoTime();
        is.mergeSort(copyArray, 0,copyArray.length-1);
        endTime = System.nanoTime();
        averageTime = averageTime + endTime -startTime;
        System.out.println((endTime-startTime));
        }
        System.out.println((averageTime/10));
        System.out.println("---------------------------------------------------------------------------------------------");

        averageTime= 0;
        System.out.println("Quick Sort");
        for(int i=0;i<10;i++)
        {
        copyArray = is.copyArray(array);
        startTime = System.nanoTime();
        is.quickSort(copyArray, 0,copyArray.length-1);
        endTime = System.nanoTime();
        averageTime = averageTime + endTime -startTime;
        System.out.println((endTime-startTime));
        }
        System.out.println((averageTime/10));
        System.out.println("---------------------------------------------------------------------------------------------");
        //is.printArray(copyArray);

        averageTime= 0;
        System.out.println("Heap Sort");
        for(int i=0;i<10;i++)
        {
        copyArray = is.copyArray(array);
        startTime = System.nanoTime();
        is.heapSort(copyArray);
        endTime = System.nanoTime();
        averageTime = averageTime + endTime -startTime;
        System.out.println((endTime-startTime));
        }
        System.out.println((averageTime/10));
        System.out.println("---------------------------------------------------------------------------------------------");

        averageTime= 0;
        System.out.println("Combined Sort");
        for(int i=0;i<10;i++)
        {
        copyArray = is.copyArray(array);
        startTime = System.nanoTime();
        is.combinedQuickSort(copyArray, 0,copyArray.length-1);
        endTime = System.nanoTime();
        averageTime = averageTime + endTime -startTime;
        System.out.println((endTime-startTime));
        }
        System.out.println((averageTime/10));
        System.out.println("---------------------------------------------------------------------------------------------");
        //is.printArray(copyArray);
 }
}
 
