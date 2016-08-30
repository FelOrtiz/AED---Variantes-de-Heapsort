/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HoLeX
 */
public class Tarea3
{
    public static void main(String[] args)
    {
		long startTime = System.currentTimeMillis();
	
        int kElem = Integer.parseInt(args[0]);
        String tipo = "s";        
        boolean verbosa = false;
        String filename = null;

        for (int i = 1; i < args.length; i++)
        {
            if(args[i].trim().toLowerCase().equals("--version"))
            {
                tipo = args[i+1].toLowerCase().trim();
            }
            if(args[i].trim().toLowerCase().equals("-v"))
            {
                verbosa = true;
            }
            if(args[i].trim().toLowerCase().equals("-o"))
            {
                filename = args[i+1];
            } 
        }
        HeapSort hs = new HeapSort(kElem, tipo, verbosa, filename);
        hs.comenzar();
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println(">>> Tiempo de ejecucion(ms): "+elapsedTime);		
		
    }
}