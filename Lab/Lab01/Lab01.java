import java.util.Scanner;
public class Lab01                                                     //Design Overview
{
    public static void main(String[] args) {                           //main function
        int n;                                                         //declare int variables n
        Scanner s = new Scanner(System.in);                            //declare Scanner variables s
        System.out.print("Enter value of n (positive integer) : ");    //output statement to input positive integer n
        n = s.nextInt();                                               //store input integer form Scanner s to int n
        int []arr = new int[n];                                        //declare array of int arr with length of n
        for(int i=0; i < n;i++){                                       //for loop statement while i < n
            arr[i] = s.nextInt();                                      //store input integer form Scanner s to int arr[i]
        }
        s.close();                                                     //close Scanner s
        SAO(arr);                                                      //calling static function SAO with input int[]arr
        System.out.println("Sorted elements by ascending order is :"); //output statement to output ascending order elements
        for(int x : arr){                                              //for each loop while int x is each element of arr
            System.out.println(x);                                     //output each element of arr by line
        }
    }

    public static void SAO(int[] arr) {                                //SAO (Sort by Ascending Order) function
        int temp;                                                      //declare int variable temp
        for (int j = 0; j < arr.length; j++) {                         //for loop statement while j < arr.length
            for (int k = j + 1; k < arr.length; k++) {                 //for loop statement while k = j + 1 & k < arr.length
                if (arr[j] > arr[k]) {                                 //if before element is more than current element
                    temp = arr[j];                                     //assign before element to temp
                    arr[j] = arr[k];                                   //assign current element to before element
                    arr[k] = temp;                                     //assign temp (formerly before element) to current element
                }
            }
        }
    }
    /*basically swapping between before element and current element
    if before element is more than current element.
    Then,array will have sorted element by ascending order*/
}
