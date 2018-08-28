package de.dpd.testLambda1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Starter {
   
   /**test
    * 1: Externalisierung des Lamda's in eigene Methode
    * 2: Zuweisung des Lamdas zu einem Functional Interface, anschließender Aufruf
    * 3: Stream, einfach Bsp.
    * 4: Stream mit Filterung auf gerade Zahlen am Ende
    * 5: Stream mit Mapping:  + "_Test"
    * 6: Stream, einfach Bsp. mit Methodenreferenz
    * 7: Lambda durch Method-Ref abgekürzt
    */
   private static int process = 7;
   
	public static void main(String[] args)
	{
		System.out.println("Hello Maven World");	
		Starter tStarter = new Starter();
	}
	
	public Starter()
	{
	   if(process == 1)
	   {
	      System.out.println( myAddFunction().add( 3, 5 ));
	   }
	   else if(process == 2)
	   {
	      AddFunction tAddFunction = (c, d) -> {return c+d;};
	      System.out.println( "Summe: " + tAddFunction.add( 5, 6 ));
	   }
	   else if(process == 3)
	   {
	      List<String> tList = Arrays.asList( "e1", "e2", "e3", "e4", "e5", "e6", "e7" );
	      logList( tList );
	   }
	   else if(process == 4)
      {
         List<String> tList = Arrays.asList( "e1", "e2", "e3", "e4", "e5", "e6", "e7" );
         logListWithFiltering( tList );
      }
	   else if(process == 5)
      {
         List<String> tList = Arrays.asList( "e1", "e2", "e3", "e4", "e5", "e6", "e7" );
         logListWithMapping( tList );
      }
	   else if(process == 6)
      {
         List<String> tList = Arrays.asList( "e1", "e2", "e3", "e4", "e5", "e6", "e7" );
         logListWithMethodRef( tList );
      }
	   else if(process == 7)
      {
	      List<Long> tList = Arrays.asList( 1L, 2L, 3L, 4L);
	      // Mit Method-Ref
	      tList.stream().forEach( Util::addOnePrintAndReturn);
	      // Mit Lambda
	      //tList.stream().forEach( (a) -> Util.addOnePrintAndReturn( a ));
      }
	}
	
	private AddFunction myAddFunction()
	{
	   return (a,b) -> {System.out.println( a + "+" + b + " = "); return a+b;};

	}
	
	private void logList(List<String> pList)
	{
	   pList.stream().forEach( (element) -> {System.out.println(element);});
	}
	
	private void logListWithMethodRef(List<String> pList)
   {
      pList.stream().forEach( System.out::println);
   }
	
	private void logListWithFiltering(List<String> pList)
   {
	   Predicate<String> tPredicateGerade = (a) -> ( a.length() == 2) && Integer.parseInt( a.substring( 1 )) % 2 == 0;
      pList.stream().filter( tPredicateGerade ).forEach( (element) -> {System.out.println(element);});
   }
	
	private void logListWithMapping(List<String> pList)
   {
      Function<String, String> tFunction = (a) ->  a = a + "_Test";
      pList.stream().map(tFunction).forEach( (element) -> {System.out.println(element);});
	   
//	   Function<String, String> tFunction = (a) ->  a = a + "_Test";
//	   Consumer<String> tConsumer = (element) -> {System.out.println(element);};
//      pList.stream().map(tFunction).forEach(tConsumer);
   }
}
