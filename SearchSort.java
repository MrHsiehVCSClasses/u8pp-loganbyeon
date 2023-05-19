package u8pp;

import java.util.ArrayList;

/**
 * SearchSort does selectioSort, insertion sort, and merge sort
 */
public class SearchSort {
    /**
     * Sorts integer array in ascending order using selection sort algorithm
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if(arr.length > 0){
            for(int i = 0; i < arr.length; i++){
                int minIndex = i;
                for(int j = i; j < arr.length; j++){
                    if(arr[minIndex] > arr[j]){
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    /**
     * Sorts ArrayList of Student objects in ascending order using selection sort algorithm
     * Sorting based on year, last name, and first name of students
     * @param arl
     * @return
     */
    public static ArrayList<Student> selectionSort(ArrayList<Student> arl){
        ArrayList<Student> arr = new ArrayList<Student>(arl);
        if(arr.size() > 0){
            for(int i = 0; i < arr.size(); i++){
                Student maxStud = arr.get(i);
                int maxdex = i;
                for(int j = i; j < arr.size(); j++){
                    if(maxStud.getYear() < arr.get(j).getYear()){
                        maxStud = arr.get(j);
                        maxdex = j;
                    } 
                    else if(maxStud.getYear() == arr.get(j).getYear()){
                        if(maxStud.getLastName().compareTo(arr.get(j).getLastName()) > 0){
                            maxStud = arr.get(j);
                            maxdex = j;
                        } 
                        else if(maxStud.getLastName().compareTo(arr.get(j).getLastName()) == 0){
                            if(maxStud.getFirstName().compareTo(arr.get(j).getFirstName()) > 0){
                                maxStud = arr.get(j);
                                maxdex = j;
                            }
                        }
                    }
                }
                arr.remove(maxdex);
                arr.add(i, maxStud);
            }
        }
        return arr;
    }
    /**
     * Sorts integer array in ascending order using insertion sort algorithm
     * @param arr
     */
    public static void insertionSort(int[] arr){
        if(arr.length > 1){
            for(int i = 0; i < arr.length; i++){
                for(int j = i + 1; j < arr.length; j++){
                    if(arr[i] > arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        
    }
    /**
     * Sorts ArrayList of Student objects in ascending order using insertion sort algorithm
     * Sorting based on year, last name, and first name of students
     * @param arl
     * @return
     */
    public static ArrayList<Student>  insertionSort(ArrayList<Student> arl){
        ArrayList<Student> arr = new ArrayList<Student> (arl);
        if(arr.size() > 1){
            for(int i = 0; i < arr.size(); i++){
                for(int j = i; j < arr.size(); j++){
                    if(arr.get(i).getYear() < arr.get(j).getYear()){
                        Student temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    }
                    else if (arr.get(i).getYear() == arr.get(j).getYear()){
                        if(arr.get(i).getLastName().compareTo(arr.get(j).getLastName()) > 0){
                            Student temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                        }
                        else if (arr.get(i).getLastName().compareTo(arr.get(j).getLastName()) == 0){
                            if (arr.get(i).getFirstName().compareTo(arr.get(j).getFirstName()) > 0){
                                Student temp = arr.get(i);
                                arr.set(i, arr.get(j));
                                arr.set(j, temp);
                            }
                        }
                    }
                }
            }
        }
        return arr;
    }
    /**
     * Sorts integer array in ascending order using merge sort algorithm
     * @param arr
     */
    public static void mergeSort(int[] arr){
        if(arr.length > 1){
            int leg = arr.length;
            int mid = leg/2;
            int[] front = new int[mid];
            int[] back = new int[leg - mid];
            if(arr.length <= 1){
                return;
            }
            else{
                for(int i = 0; i < front.length; i++){
                    front[i] = arr[i];
                }
                
                for(int i = back.length; i > 0; i--){
                    back[back.length - i] = arr[leg - i];
                }
                mergeSort(front);
                mergeSort(back);
                merge(front,back, arr);
            }
        }
    }
    /**
     * Sorts ArrayList of Student objects in ascending order using merge sort algorithm
     * Sorting based on year, last name, and first name of students
     * @param arr1
     * @param arr2
     * @param arr3
     */
    private static void merge(int[] arr1, int[] arr2, int[] arr3){
        int f = 0;
        int b = 0;
        for(int i = 0; i < arr3.length; i++){
            if(f == arr1.length && b != arr2.length){
                arr3[i] = arr2[b];
                b++;
            }
            else if(b == arr2.length && f != arr1.length){
                arr3[i] = arr1[f];
                f++;
            }
            else if(b != arr2.length && f != arr1.length){
                if(arr1[f] < arr2[b]){
                    arr3[i] = arr1[f];
                    f ++;
                }
                else{
                    arr3[i] = arr2[b];
                    b ++;
                }
            }
        }
    }
    public static ArrayList<Student>  mergeSort(ArrayList<Student> arl){
        ArrayList<Student> arr = new ArrayList<Student>(arl);
        if(arr.size() > 1){
            int leg = arr.size();
            int mid = leg/2;
            ArrayList<Student> front = new ArrayList<>();
            ArrayList<Student> back = new ArrayList<>();
            if(arr.size() <= 1){
                return arr;
            }
            else{
                for(int i = 0; i < mid; i++){
                    front.add(arr.get(i));
                }
                
                for(int i = leg - mid; i > 0; i--){
                    back.add(arr.get(leg - i));
                }
                ArrayList<Student> a = new ArrayList<Student>(mergeSort(front));
                ArrayList<Student> b = new ArrayList<Student>(mergeSort(back));
                merge(a,b, arr);
            }
        }
        return arr;
    }
    private static ArrayList<Student> merge(ArrayList<Student> arr1,ArrayList<Student> arr2,ArrayList<Student> arr3){
        int f = 0;
        int b = 0;
        for(int i = 0; i < arr3.size(); i++){
            if(f == arr1.size() && b != arr2.size()){
                arr3.set(i, arr2.get(b));
                b++;
            }
            else if(b == arr2.size() && f != arr1.size()){
                arr3.set(i, arr1.get(f));
                f++;
            }
            else if(b != arr2.size() && f != arr1.size()){
                if(compare(arr1.get(f),arr2.get(b)) == 1){
                    arr3.set(i,arr1.get(f));
                    f++;
                }
                else{
                    arr3.set(i,arr2.get(b));
                    b++;
                }
            }
        }
        return arr3;
    }
    /**
     * Compares two Student objects based on year, last name, and first name
     * Returns 1 if student1 has greater year or comes first in alphabet
     * Returns -1 if student2 has greater year or comes first in alphabet
     * Returns 0 if both students are same
     * @param one
     * @param two
     * @return
     */
    private static int compare(Student one, Student two){
        if(one.getYear() > two.getYear()){
            return 1;
        }
        else if(one.getYear() < two.getYear()){
            return - 1;
        }
        else if(one.getLastName().compareTo(two.getLastName()) < 0){
            return 1;
        }
        else if( two.getLastName().compareTo(one.getLastName()) < 0){
            return - 1;
        }
        else if(two.getFirstName().compareTo(one.getFirstName()) < 0){
            return - 1;
        }
        else if(one.getFirstName().compareTo(two.getFirstName()) < 0){
            return 1;
        }
        return 0;
    }
}