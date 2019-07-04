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
 * 
 */
 
public class Survey {
    
    final int SURVEY_ITEMS ;
    final  int RESPONSE_SIZE ;
    String[] surveyIsues ;
    int[][] surveyResponse ; 
    double[] averageResponse ;
    int[] sumOfResponse ;
    Scanner input = new Scanner(System.in);
    
    public Survey(int SURVEY_ITEMS , int RESPONSE_SIZE){
        
        this.SURVEY_ITEMS = SURVEY_ITEMS ;
        this.RESPONSE_SIZE = RESPONSE_SIZE ;
        surveyIsues = new String[SURVEY_ITEMS] ; 
        surveyResponse  = new int[SURVEY_ITEMS][RESPONSE_SIZE] ;
        averageResponse = new double[SURVEY_ITEMS] ;
        sumOfResponse = new int[SURVEY_ITEMS] ;
    
    }
    
    public void setItemsToBeSurveyed(){
    
        for(int items = 0 ; items<SURVEY_ITEMS ; items++){
        System.out.printf("Enter Item you want to conduct pull on below %n") ;
        surveyIsues[items] = input.nextLine() ;        
        }
      }
    
    public void setSurveyResponse(){
         for(int items = 0 ; items<SURVEY_ITEMS ; items++){
            System.out.printf("This rating is for:%15s%n " ,surveyIsues[items] ) ;
            for(int response = 0 ; response<RESPONSE_SIZE ; response++){
                System.out.printf("%s%d%s%s%n ","You are the number ",response+1, " person, Enter your rating on a scale"
                        + " of 1-10 for  " , surveyIsues[items] ) ;
                surveyResponse[items][response] = input.nextInt() ;  
            }
        }
         average() ;
    }
    
    public void average(){
          int sum  ;
          for(int items = 0 ; items<SURVEY_ITEMS ; items++){
              sum = 0 ;
            for(int response = 0 ; response<RESPONSE_SIZE ; response++){
                sum += surveyResponse[items][response] ;
               }
            sumOfResponse[items] = sum ;
            System.out.println("sum is: " + sum) ;
            averageResponse[items] = (double)sum/RESPONSE_SIZE ;
          }  
    }
    
    public void getHighestPoint(){
    int highestIndex = 0 ;    
    int highest = sumOfResponse[0] ;
    for(int point :sumOfResponse)
      highest = (highest < point) ? point : highest ;
    System.out.println("The highest VALUE IS : " + highest);
    for(int point = 0 ; point<sumOfResponse.length ; point++)
      if (highest == sumOfResponse[point]){
         highestIndex = point  ;
         break ;
      }
    System.out.println("The issue with the highest point is: " + surveyIsues[highestIndex]);
    }
    
   public void getLowestPoint(){
    int lowestIndex = 0 ;    
    int lowest = sumOfResponse[0]  ;
    for(int point :sumOfResponse){
      lowest = (lowest > point) ? point : lowest ;
      
    }
    System.out.println("The LOWES VALUE IS : " + lowest);
    for(int point = 0 ; point<sumOfResponse.length ; point++)
      if (lowest == sumOfResponse[point]){
         lowestIndex = point  ;
         break ;
      }
    System.out.println("The issue with the lowest point is: " + surveyIsues[lowestIndex]);
    }
    
    public void getTableHeading(){
        System.out.printf("%15s", "Topic");
        for(int colunm =1 ; colunm<=RESPONSE_SIZE ; colunm++ )
            System.out.printf("%17s%d","Response", colunm);
        System.out.printf("   Average %n");
    
    }
    
    public void getSurveyData(){
        
        for(int items = 0 ; items<SURVEY_ITEMS ; items++){
            System.out.printf("%15s",surveyIsues[items]);
            for(int response = 0 ; response<RESPONSE_SIZE ; response++){
               System.out.printf("%18d",surveyResponse[items][response]);
          }
            System.out.printf("%10.2f%n",averageResponse[items]);
       }
    }    
}
