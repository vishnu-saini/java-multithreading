package com.vishnu.thread.t3join;
import java.math.BigInteger;

public class ComplexCalculation {
	
	public static void main(String[] args) {
		
	BigInteger base1 = BigInteger.TEN;
	BigInteger power1= BigInteger.TWO;
	BigInteger base2=BigInteger.TWO;
	BigInteger power2 = BigInteger.TEN;
        BigInteger result;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1,power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2,power2);
        
        thread1.start();
        thread2.start();
        try{
        thread1.join();
        thread2.join();
        }catch(Exception e){
            
        }
        result = thread1.getResult().add(thread2.getResult());
        
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
System.out.println(result);    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
        BigInteger i = BigInteger.ONE;
           for(; i.compareTo(power) <= 0 ; i=i.add(BigInteger.ONE)){
               result = result.multiply(base);
               System.out.println(i);
           }
        }
    
        public BigInteger getResult() { return result; }
    }
}