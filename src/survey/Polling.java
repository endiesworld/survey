/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package survey;

import java.util.Scanner;

/**
 *
 * @author emmanuel.okoro
 */
public class Polling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here7
        Scanner input = new Scanner(System.in);
        final int numberOfIssues ; 
        final int numberOfResponses ; 
        System.out.printf("Enter the numbers of Issues you want to sample: ") ;
        numberOfIssues = input.nextInt() ;
        System.out.printf("%nEnter the numbers of Responses you want to sample: ") ;
        numberOfResponses = input.nextInt() ;
        Survey sampleOne = new Survey(numberOfIssues, numberOfResponses) ;
        sampleOne.setItemsToBeSurveyed() ;
        sampleOne.setSurveyResponse() ;
        sampleOne.getTableHeading();
        sampleOne.getSurveyData();
        sampleOne.getHighestPoint();
        sampleOne.getLowestPoint();
        
    }
    
}
