//Jorell Socorro
import java.text.DecimalFormat;
import java.util.Scanner;
public class PrattParkingGarage
{
  static Scanner sc = new Scanner(System.in);
  public static void main(String args[])
  {
    // the local variables declared and initialized
    char answer = 'Y', specEvent = 'N', rateCode = '\0';
	
    //userInput
    int ticketNum = 0;
    //userInput
    int timeIn = 0, timeOut = 0, timeDiff = 0;
    //userInput
    double amountTendered = 0.0, changeDue = 0.0;
    double flatFee = 0.0, monthFee = 0.0;
    double EXTRA_CHARGE = 0.0;
    //userInput
    double coupon = 0.0, tip = 0.0;
    double flatTax = 3.00, totalDueFromCust = 0.0;
    
   //My code modification
    int couponCount = 0, ticketCount = 0;
    String couponAsk = " ";
    double previousTotal = 0.0, totalTax = 0.0, totalTip = 0.0;

    
    
    System.out.println("");
    System.out.println("");
    System.out.println("***************************");
    System.out.println("----Pratt Parking Garage---");
    System.out.println("***************************");
    System.out.println("");
    System.out.println("");
    while(answer == 'Y' || answer == 'y')
    {
      System.out.println("--------- M E N U ---------");
      System.out.println("data entry process: enter each of these");
      ticketCount++;
      System.out.println("customer ticket number ->");
      ticketNum = sc.nextInt();
      System.out.println("ticket number " + (ticketNum));
      System.out.println("time in (military)");
      timeIn = sc.nextInt();
      System.out.println("time out (military)");
      timeOut = sc.nextInt();
      timeDiff = timeOut - timeIn;
      System.out.println("time difference " + (timeDiff));
    
      System.out.println("rate code: (F or M)");
      rateCode = sc.next().charAt(0);
      System.out.println("rate code: " + rateCode);
      if (rateCode == 'F')
      {
        flatFee = 10.00;
        previousTotal = flatFee;
      }
      if (rateCode == 'M')
      {
        monthFee = 90.00;
        previousTotal = monthFee;
        // monthly fee is deferred 
        previousTotal = 0;	
      }
      System.out.println("tip amount");
      tip = sc.nextDouble();
      System.out.printf("tip: $%.2f\n", tip);
      previousTotal += tip;
    
      System.out.printf("flat tax: $%.2f\n", flatTax);
      previousTotal += flatTax;
    
      System.out.println("special event(Y or N)?");
      specEvent = sc.next().charAt(0);
      if(specEvent == 'Y') EXTRA_CHARGE = 10;
        totalDueFromCust += EXTRA_CHARGE;
      
      //Made a if statement to help keep count
      System.out.println("Did you use a coupon(Y or N)?");
      couponAsk = sc.next();	  
      if(couponAsk.contentEquals("Y") || couponAsk.contentEquals("y")) {  
    	  couponCount++;
	      System.out.println("coupon amount");
	      coupon = sc.nextDouble();
	      previousTotal -= coupon;
      }
    
      System.out.printf("total charge: $%.2f\n", previousTotal);
      System.out.println("amount tendered from customer");
      amountTendered = sc.nextDouble();
      changeDue = amountTendered - previousTotal;
      System.out.printf("change: $%.2f\n", changeDue);
      System.out.println("***************************");
      System.out.println("run again(Y or N)?");
      answer = sc.next().charAt(0);
      // reset all pertinent variables before the next loop 
      // i.e. prior to servicing the next customer
      // by assigning a zero to the appropriate variables
      
      /*Test values before reset
      System.out.println("TicketNum:"+ticketNum +"TimeIn and Out" +timeIn + timeOut);
      System.out.println("AmountTendered:"+amountTendered +"ChangeDue" +changeDue +"coupon:" +coupon +"tip:"+tip);
      */
 
     /*Test Values after reset
      System.out.println("TicketNum:"+ticketNum +"TimeIn and Out" +timeIn + timeOut);
      System.out.println("AmountTendered:"+amountTendered +"ChangeDue" +changeDue +"coupon:" +coupon +"tip:"+tip);
    */
      
      //Increments the total of the necessary variables
      totalDueFromCust = totalDueFromCust + previousTotal;
      totalTax = flatTax + totalTax;
      totalTip = totalTip + tip;
      
      //RESET ALL VARIABLES TO 0
      
      ticketNum = 0;
      timeIn = 0;
      timeOut = 0;
      amountTendered = 0;
      changeDue = 0;
      coupon = 0.0;
      tip = 0.0;
    }
    //outside the while loop
    //Displays everything when the program ends
    System.out.println("***********The Final TOTAL***************");
    System.out.println("TicketCount:"+ticketCount+"\nCouponCount:"+couponCount);
    System.out.printf("TotalDueFromCustomers: $%.2f\n", totalDueFromCust);
    System.out.printf("TotalTax: $%.2f\n",totalTax);
    System.out.printf("TotalTp: $%.2f\n",totalTip);
  }// end main()
}// end class


