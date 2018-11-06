/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimalpager;

import java.util.Scanner;

/**
 *
 * @author HaithamGamal
 */
public class OptimalPageR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n, m, i, j, k, mn, flag = 0, pgfault = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of pages");
        n = sc.nextInt(); //enter number of pages where n is page number
        System.out.println("enter page nos");
        int a[] = new int[n];//enter the page numbers data into array of size n
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter no of frames");
        m = sc.nextInt();//enter number of frames
        int frm[] = new int[m];//create array of same size of number of frames
        int whn[] = new int[m];//array that stores index of hit and miss pages and to know  how longest will be used
        for (i = 0; i < m; i++) {
            frm[i] = a[i];//loopig over frames and pages fill the empty frames first until full
            whn[i] = 0;//stores zeros since it fills the empty frame spaces first
        }
        for (; i < n; i++) {
            for (j = 0; j < m; j++) {//compare every page with the frame if hit equals flag=1 and break  inner loop and so on
                if (frm[j] == a[i]) {
                    flag = 1;
                    break;
                } else {
                    flag = 0;
                }
            }
            if (flag == 0) {//if the flag is zero no hits it compares every page with the frame if it hits stores its index
                for (j = 0; j < m; j++) {
                    for (k = i + 1; k < n; k++) {
                        if (frm[j] == a[k]) {
                            whn[j] = k;
                        } else {
                            whn[j] = 0;//if it miss stores index equals zero
                        }
                    }
                }
                mn = ltr(whn, m);//after finishing loop send number of frames and index array of hit and miss to func itr
                frm[mn] = a[i];//recieve the farthest index and replace its pointed element
                pgfault++;//increment page fault
            }
        }
        pgfault = pgfault + m;//it adds the number of frames thatthe pages added first+number of new replacements
        System.out.println("Optimal algorithm");
        System.out.println("page fault is::"+pgfault);
        System.out.println("page hits are:" + (n - pgfault));
    }

    private static int ltr(int[] whn, int m) {
        int i, mn = 0;
        for (i = 1; i < m; i++) {
            if ((whn[i] > whn[i - 1]) && (whn[i] != 0)) { //loops over index array to know largest index farthest index
                mn = i;
            }
        }
        return mn;//it returns farthest index

    }
//*********Reference***********
//https://alkatankblog.wordpress.com/tag/optimal-page-replacement-program-in-java/
//****************************************************************************    
}
