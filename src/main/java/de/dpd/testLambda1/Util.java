/*
 * DPD Deutschland GmbH (c) 2018
 *
 * Author      : Sebastian Meyer
 * Created     : 12.07.2018
 */

package de.dpd.testLambda1;

public class Util
{
   public static long addOnePrintAndReturn(long a)
   {
      long c = a+1;
      System.out.println("Ergebnis addOnePrintAndReturn(long a): " + c);
      return c;
   }
}
