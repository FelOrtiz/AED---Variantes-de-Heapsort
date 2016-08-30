/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author HoLeX
 */
public class HeapSort
{
    private String tipo;
    private boolean verbosa;
    private String filename;
    private int[] heap;
    private int ultimo;
    private int size;
    private Scanner sc;
    
    private int cantidad;
    
    public HeapSort(int n, String tipo, boolean verbosa, String filename)
    {
        this.tipo = tipo;
        this.verbosa = verbosa;
        this.filename = filename;
        this.size = (int)((1024*n)+1);
        this.ultimo = 0;
        this.heap = new int[size];
        this.heap[0] = Integer.MIN_VALUE;
        
        this.cantidad = 15;
        this.sc = new Scanner(System.in);
    }
    
    public void insert(int n)
    {
        ultimo++;
        int aux = ultimo;
        int padre = (ultimo/2);
        
        while(n < heap[padre])
        {
            heap[aux] = heap[padre];
            aux = padre;
            padre = (aux/2);
        }
        heap[aux] = n;
    }
    
    public int extractMin()
    {
        int aux = heap[1];
        heap[1] = heap[ultimo];
	heap[ultimo] = aux;
        
        ultimo--;
        this.percolateDown(1);
        
        return aux;
    }
    
    public void percolateDown(int pos)
    {
        int aux = heap[pos];
        
        while(true)
        {
            int hijoIzq = 2*pos;
            int hijoDer = (2*pos)+1;
            int pequeno;
            
            if(hijoIzq > ultimo)
            {
                break;
            }
            else if(hijoIzq == ultimo || heap[hijoIzq] < heap[hijoDer])
            {
                pequeno = hijoIzq;
            }
            else
            {
                pequeno = hijoDer;
            }
            if(heap[pequeno] < aux)
            {
                heap[pos] = heap[pequeno];
                pos = pequeno;
            }
            else
            {
                break;
            }
        }
        heap[pos] = aux;
    }    
    
    public void heapSortS()
    {
        if(verbosa)
        {
            System.out.println(">>> Se construye el heap en base a inserciones");
        }
        //Construimos el heap en base a inserciones sucesivas
        for (int i = 1; i < size; i++)
        {            
            this.insert(sc.nextInt());
        }		
        if(verbosa)
        {
            System.out.println(">>> Se aplica Heapsort para odenar el arreglo mediante extracciones");
        }
        //Ordenamos el arreglo en base a extracciones sucesivas
        for (int j = ultimo; j > 0; j--)
        {
            int num = this.extractMin();
            if(this.filename == null)
            {
                System.out.println(num);
            }
        }
        //Si el archivo no es null (es decir, eligieron la opción de exportar)
        if(filename != null)
        {
            if(verbosa)
            {
                System.out.println(">>> Se comienza a escibir el arreglo ordenado en el archivo");
            }
            this.exportarOrden();
        }
        if(verbosa)
        {
            System.out.println(">>> Ejecucion terminana con exito");
        }
    }
    
    /**
     * Función que utilizar el percolateDown y extractMin normal para realizar el heapsort.
     */
    public void heapSortF()
    {
        if(verbosa)
        {
            System.out.println(">>> Llenamos el heap...");
        }
        for (int i = 1; i < size; i++)
        {
            heap[i] = sc.nextInt();
            ultimo++;
        }
        if(verbosa)
        {
            System.out.println(">>> Se reconstruye el heap mediante PercolateDown");      
        }      
        //Se reconstruye el heap, usando percolatedown por cada padre del heap
        while (ultimo > 0)
        {
            for (int i = (ultimo/2); i >= 0; i--)
            {
                this.percolateDown(i);
            }
            int num = this.extractMin();
            if(this.filename == null)
            {
                System.out.println(num);
            }
        }        
        //Si el archivo no es null (es decir, eligieron la opción de exportar)
        if(filename != null && verbosa)
        {
            System.out.println(">>> Se comienza a escibir el arreglo ordenado en el archivo");
            this.exportarOrden();
        }        
        if(verbosa)
        {
            System.out.println(">>> Ejecucion terminada con exito");
        }
    }
   
    public int extractMinWegener()
    {
        int min = heap[1];

        int posMenor;
        if(heap[2] < heap[3])
        {
            posMenor = 2;
        }
        else
        {
            posMenor = 3;
        }            
        heap[1] = heap[posMenor];
        heap[posMenor] = heap[ultimo];
        percolateDown(posMenor);
        
        heap[ultimo] = min;
        
        ultimo--;
        return min;
    }    
    
    public void heapSortW()
    {
        if(verbosa)
        {
            System.out.println(">>> Se construye el heap en base a inserciones");
        }
        //Construimos el heap en base a inserciones sucesivas
        for (int i = 1; i < size; i++)
        {            
            this.insert(sc.nextInt());
        }
        if(verbosa)
        {
            System.out.println(">>> Se aplica Heapsort usando extracciones de wegner");
        }
        //Ordenamos el arreglo en base a extracciones sucesivas
        for (int j = ultimo; j >= 0; j--)
        {
            int num = this.extractMinWegener();
            if(this.filename == null)
            {
                System.out.println(num);
            }
        }
        //Si el archivo no es null (es decir, eligieron la opción de exportar)
        if(filename != null)
        {
            if(verbosa)
            {
                System.out.println(">>> Se comienza a escibir el arreglo ordenado en el archivo");
            }
            this.exportarOrden();
        }
        if(verbosa)
        {
            System.out.println(">>> Ejecucion terminana con exito");
        }
    }
    
    public void heapSortWF()
    {
        if(verbosa)
        {
            System.out.println(">>> Llenamos el heap...");
        }
        for (int i = 1; i < size; i++)
        {
            heap[i] = sc.nextInt();
            ultimo++;
        }
        if(verbosa)
        {
            System.out.println(">>> Se reconstruye el heap mediante PercolateDown y ExtractMinWegener");      
        }      
        while (ultimo > 0)
        {
            for (int i = (ultimo/2); i > 0; i--)
            {
                this.percolateDown(i);
            }
            int num = this.extractMinWegener();
            if(this.filename == null)
            {
                System.out.println(num);
            }
        }          
        if(filename != null && verbosa)
        {
            System.out.println(">>> Se comienza a escibir el arreglo ordenado en el archivo");
            this.exportarOrden();
        }        
        if(verbosa)
        {
            System.out.println(">>> Ejecucion terminada con exito");
        }
    }
    
    public void exportarOrden()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(filename+".txt");
            pw = new PrintWriter(fichero);        

            for (int i = size-1; i > 0; i--)
            {
                pw.println(heap[i]);
            }
        }
        catch (Exception e) {} 
        finally 
        {
            try 
            {
                if (null != fichero)
                {
                    fichero.close();
                }
            }
            catch (Exception e2) {}
        }          
    }
    	    
    public void comenzar()
    {
        System.out.println(" ");
        
        if(this.tipo.equals("s"))
        {
            this.heapSortS();
        }
        else if(this.tipo.equals("f"))
        {
            this.heapSortF();
        }
        else if(this.tipo.equals("w"))
        {
            this.heapSortW();
        }
        else if(this.tipo.equals("wf") || this.tipo.equals("fw"))
        {
            this.heapSortWF();
        }
    }
}