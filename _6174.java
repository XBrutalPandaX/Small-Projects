/* 
    Welcome to KAPREKAR'S Constant
        This program does KAPREKAR'S contant by 
        1. Taking 4 digit numbers 
        2. Checking no same digit is availabe and the input int hsa 4 digit
        3. Sort the int
        4. Substaract the biggest sort to the smallest sort until it gets 6174
*/

import java.util.Scanner;
public class _6174{
    public static void main(String[] args){
        int length,c=0;
        int input;
        String n="";
        //Input Handler
        do{ 
            if(c!=0){
                n="again (must be 4 Digit!!)";
            }
            System.out.printf("Enter a number %s: ",n);
            Scanner in = new Scanner(System.in);
            input = in.nextInt();
            length=Integer.toString(input).length();
            c++;
        }while(length != 4 );
        
        //Start The calculation
        calc(input);
    }
    public static int calc(int input){
        int result=0, count=0;;
        int[] array=new int[4];
        System.out.println("Given number is: "+input);
        //Separate int to Array 
        for(int i=0;i<4;i++){
            array[i]=(input%10);
            input=input/10;
        }
               
        //Sort
        int temp;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                 if(array[j]>array[j+1]){
                     temp=array[j];
                     array[j]=array[j+1];
                     array[j+1]=temp;
                }
            }
        }

        // Change to int Biggest & Smallest order
        int big=0,small=0,pow=1,less=1000;
        for(int i=0;i<4;i++){
            big=big+array[i]*pow;
            small=small+array[i]*less;
            pow=pow*10;
            less=less/10;
        }
        result=big-small;
        //System.out.printf("%d \n%d \n----\n = %d\n" ,big,small,result);
        
        System.out.println("Order biggest = "+ big+"\nSmallest numebr ="+small+"\nAnd result is " +result+"\n-----------------------");
        while(result != 6174){
            
            int[] array2=new int[4];
            //Separate int to Array 
            for(int i=0;i<4;i++){
                array2[i]=(result%10);
                result=result/10;
            }
                   
            //Sort
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                     if(array2[j]>array2[j+1]){
                         temp=array2[j];
                         array2[j]=array2[j+1];
                         array2[j+1]=temp;
                    }
                }
            }
    
            // Change to int Biggest & Smallest order
            big=0;small=0;pow=1;less=1000;
            for(int i=0;i<4;i++){
                big=big+array2[i]*pow;
                small=small+(array2[i]*less);
                pow=pow*10;
                less=less/10;
            }
            result=big-small;
            count++;
            System.out.println("Order biggest = "+ big+"\nSmallest numebr ="+small+"\nAnd result is " +result+"\n-----------------------");

        }
        
        return result;
    }

}