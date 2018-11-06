/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfis;

import java.util.Scanner;

/**
 *
 * @author HaithamGamal
 */
public class FCFIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int pageNumber; //declare the page data no of pages no of frames frames data
        int[] pageData;
        int framesNumber;
        int[] frameData;
        int counter = -1; //counter to indicate the index of the frame that you will put pagedata into it according to the queue
        boolean flag = false; //flag that will be false if the page data is not in the frame
        int pageFaults = 0;
        System.out.println("Enter Page Number:");
        pageNumber = sc.nextInt();
        pageData = new int[pageNumber];
        System.out.println("Enter Page Data:");
        for (int i = 0; i < pageData.length; i++) {
            pageData[i] = sc.nextInt();
        }
        System.out.println("Enter Frames Number:");
        framesNumber = sc.nextInt();
        frameData = new int[framesNumber];
        for (int i = 0; i < frameData.length; i++) {//fill all position of the frames with the page data
            frameData[i] = pageData[i];
            counter++;
            pageFaults++;

        }
        for (int i = 0; i < pageData.length; i++) {
            flag = false;
            for (int j = 0; j < frameData.length; j++) {
                if (pageData[i] == frameData[j]) { //if pageData is in the frame page hit and flag =true
                    flag = true;

                }

            }
            if (!flag) {//if the flag is false new pagedata not in the frame
                if (counter == frameData.length-1) {//if the counter points to last index make it ewqiual zero and assign page data to first index
                    counter = 0;
                    frameData[counter] = pageData[i];
                    pageFaults++;

                } else {
                    counter++;
                    frameData[counter] = pageData[i];//if the counter not point to the last index icrement it anfd assign pagedata
                    pageFaults++;//inc pagefaults

                }

            }

        }
        System.out.println("PageFaults is:" + "   " + pageFaults);

    }

}
