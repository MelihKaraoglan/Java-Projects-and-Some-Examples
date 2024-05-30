/*
Melih Karaoğlan - B2305.010116 
Arda Sakarya -B2205.010137
*/

import java.util.Scanner;

public class RecursiveBaseConverter {

        static long turntoten(long num,long ust,long basec){
            if(num>0){
                return ((num%10)*ust)+turntoten(num/10,ust*basec,basec);   
            }
            else{
                return num;
            }
            
        }
        static long turntowanted(long base10,long wantedbase){
            if(base10>=wantedbase){
                return base10%wantedbase + 10*turntowanted(base10/wantedbase,wantedbase);
            }
            else{
                return base10%wantedbase;
            }
        }
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the current base:");
        long currentbase=scan.nextLong();

        System.out.print("Enter the wanted base:");
        long wantedbase=scan.nextLong();

        System.out.printf("Enter your number in base - %d:",currentbase);
        long currentnumber=scan.nextLong();

        long base10=0;

        if(currentnumber<10 && currentnumber>0){
            while(currentnumber>currentbase){
                System.out.print("Please enter a valid number for the conversion:");
                currentnumber=scan.nextLong();
            }

            base10=currentnumber;
            System.out.println("Your number in base - 10: "+base10);

            if(currentbase>=wantedbase){
                    System.out.printf("Your number in base - %d: %d",wantedbase,turntowanted(base10,wantedbase));
            }
            else{
                    System.out.printf("Your number in base - %d: %d",wantedbase,currentnumber);
            }
        }
        else{

            long ust=1;

            boolean control=false;

            long tempcurrent=currentnumber;

            do{
                for(long i=tempcurrent;i>=9;i/=10){
                    long mod=i%10;
                    if(mod>=currentbase){
                        System.out.print("Invalid number for the operation. Please enter a valid number:");
                        tempcurrent=scan.nextLong();
                    }
                    else{
                    control=true;
                    }
                }
            }while(control==false);
            currentnumber=tempcurrent;

            System.out.println("Your number in base - 10: "+ turntoten(currentnumber,ust,currentbase));
            base10=turntoten(currentnumber,ust,currentbase);
            System.out.printf("Your number in base - %d: %d",wantedbase,turntowanted(base10,wantedbase));
        }
        scan.close();
    }
}