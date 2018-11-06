/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lastpr;

import java.util.Scanner;

/**
 *
 * @author HaithamGamal
 */
public class LastPR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int nPages;
        int[] frames = new int[3];
        int dataPage[];
        int counterA = 0; //counter for first frame position
        int counterB = 0;//counter for second frame position
        int counterC = 0;//counter for third frame position
        int pageFaults = 0;//page faults is default zero
        boolean flag = false;//flag its default false means page miss
        System.out.println("Enter Number Of Pages:");
        nPages = sc.nextInt();
        dataPage = new int[nPages];
        System.out.println("Enter Pages Data:");
        for (int i = 0; i < dataPage.length; i++) {
            dataPage[i] = sc.nextInt();
        }
        for (int i = 0; i < frames.length; i++) {
            if (i == 0) {
                counterA++;   //increment by one for fill of the first frame;
                frames[i] = dataPage[i];
                pageFaults++;
            } else if (i == 1) {
                counterB += 2; //increment by two for fill of the second frame
                frames[i] = dataPage[i];
                pageFaults++;
            } else if (i == 2) {
                counterC += 3;
                frames[i] = dataPage[i]; //increment by three for fill of the third frame; after all of these ibcrement pagefaults
                pageFaults++;

            }
        }
        for (int i = 3; i < dataPage.length; i++) {
            flag = false;
            for (int j = 0; j < frames.length; j++) {//if index j equals zero or one or two increment counter of a or b or c 
                if (dataPage[i] == frames[j]) {        //page hit occured  and setting flag to true
                    if (j == 0) {     
                        counterA++;
                        flag = true;
                    } else if (j == 1) {
                        counterB++;
                        flag = true;
                    } else if (j == 2) {
                        counterC++;
                        flag = true;
                    }
                }
            }
            if (!flag) { //if the flage is false no hits misses occurs only means page faults occurs only
                pageFaults++; //checks the least counter to increment and assign page to frame
                if (counterA < counterB && counterA < counterC) {
                    counterA++;
                    frames[0] = dataPage[i];
                } else if (counterB < counterA && counterB < counterC) {
                    counterB++;
                    frames[1] = dataPage[i];

                } else if (counterC < counterA && counterC < counterB) {
                    counterC++;
                    frames[2] = dataPage[i];

                }
            }

        }
        System.out.println("Page Fault is:" + pageFaults);

    }
}
