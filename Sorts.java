package Ordenamiento;

import java.util.Arrays;

public class Sorts {
	
	public static int[] burbuja(int[] d){//Metodo Burbuja[1]
		int[] data=d.clone();//Clonacion de Arreglo para Replicar datos			
		int position, scan;
		int temp;
		for(position=data.length-1; position>=0; position--){
			for(scan=0; scan<=position-1; scan++){
				if(data[scan]>data[scan+1]){
					//intercambiar los valores
					temp = data[scan];
					data[scan] = data[scan+1];
					data[scan+1]=temp;
				}
			}
		}
		return data;
	}
	
	public static int[] insercion(int[] d){//Metodo de Inserción[2]
		int[] data=d.clone();//Clonacion de Arreglo para Replicar datos	
		for(int index = 1; index<data.length; index++){
			int key = data[index];
			int position = index;
			while(position>0 && data[position-1]>key){//Cambiar los valores a la derecha
				data[position] = data[position-1];
				position--;
			}
			data[position] = key;
		}
		return data;
	}
	
	public static int[] seleccion(int[] d){//Metodo de Seleccion[3]
		int[] data=d.clone();//Clonacion de Arreglo para Replicar datos
		int min;
		int temp;
		for(int index = 0; index<data.length-1;index++){
			min=index;
			for(int scan = index+1; scan<data.length; scan++)
				if(data[scan]<data[min])
					min = scan;
			//Intercambiar los valores
			temp=data[min];
			data[min]=data[index];
			data[index] = temp;
		}
		return data;
	}
	
//---------------------Cuentas
	public static int[] cuentas(int[] d){//Ordenamiento por Cuentas[4]
		//Referencia http://rosettacode.org/wiki/Sorting_algorithms/Counting_sort
		int[] data=d.clone();
        int max = data[0], min = data[0];
        for (int i = 1; i < data.length; i++){//Ciclo para encontrar a el menor y al mayor
            if (data[i] > max)
                max = data[i];
            if (data[i] < min)
                min = data[i];
        }
        return cuentas(data,min,max);
	}	
	private static int[] cuentas(int[] arr, int min, int max){//Ordenamiento por Cuentas
		int[] count= new int[max - min + 1];
		for(int number : arr){
			count[number - min]++;
		}
		int z= 0;
		for(int i= min;i <= max;i++){
			while(count[i - min] > 0){
				arr[z]= i;
				z++;
				count[i - min]--;
			}
		}
		return arr;
     }
//---------------------End Cuentas
	
	public static int[] shell(int[] d) {//Ordenamiento por Shell[5]
		int[] data=d.clone();
		int increment = data.length / 2;
		while (increment > 0) {
			for (int i = increment; i < data.length; i++) {
				int j = i;
				int temp = data[i];
				while (j >= increment && data[j - increment] > temp) {
					data[j] = data[j - increment];
					j = j - increment;
				}
				data[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}
		return data;
	}

    public static int[] radix(int[] d){//Ordenamiento Por Radix[6]
    	int[] data=d.clone();//Clonacion de Arreglo para Replicar datos
        int i, m = data[0], exp = 1, n = data.length;
        int[] b = new int[data.length];

        for (i = 1; i < n; i++)
            if (data[i] > m)
                m = data[i];

        while (m / exp > 0){
            int[] bucket = new int[data.length];

            for (i = 0; i < n; i++)
                bucket[(data[i] / exp) % data.length]++;

            for (i = 1; i < data.length; i++)
                bucket[i] += bucket[i - 1];

            for (i = n - 1; i >= 0; i--)
                b[--bucket[(data[i] / exp) % data.length]] = data[i];

            for (i = 0; i < n; i++)
                data[i] = b[i];

            exp *= data.length;        
        }
        return data;
    }    
    
////////MEZCLA
    public static int[] mezcla(int[] d){
    	int[] data=d.clone();
    	return mezcla(data,0,data.length);
    }
    public static int[] mezcla(int[] arreglo,int indice,int tamanio){//Metodo de Ordenamiento MEZCLA[6]
		 int p1=0;  //Parte 1
	     int p2=0;  //Parte 2
	        if (tamanio > 1){  //Si el tamaño del arreglo es mayor a 1
	            p1 = tamanio / 2;  //Divide el arreglo a la mitad (Puede ser impar o par)
	            p2 = tamanio - p1;  //Asigna n2 restandole el tamaño del arreglo menos la mitad del arreglo
	            				//donde puede ser un par o impar
	            mezcla(arreglo, indice, p1);  //Llamada recursiva a 
	            mezcla(arreglo, indice + p1, p2);  
	        }
	        return  merge(arreglo, indice, p1, p2); 
	}
   
   private static int[] merge(int[ ] matrix, int init, int n1, int n2){  
       int[ ] buffer = new int[n1+n2];  
       int temp = 0;  
       int temp1 = 0;  
       int temp2 = 0;  
       int i;  
       while ((temp1 < n1) && (temp2 < n2)){  
           if (matrix[init + temp1] < matrix[init + n1 + temp2]){  
               buffer[temp++] = matrix[init + (temp1++)];  
           }else{  
               buffer[temp++] = matrix[init + n1 + (temp2++)];  
           }  
       }  
       while (temp1 < n1){  
           buffer[temp++] = matrix[init + (temp1++)];  
       }  
       while (temp2 < n2){  
           buffer[temp++] = matrix[init + n1 + (temp2++)];  
       }  
       for (i = 0; i < n1+n2; i++){  
           matrix[init + i] = buffer[i];  
       }  
       return matrix;
   }  
   ////////////////////////END///////////////////////MEZCLA///////////////////////////////
   
   //--------------METODOS de QUICKSORT------------------
   public static int[] quickSort(int[] d){//Metodo Principal de QuickSort[8]
	   int[] data=d.clone();
	   return quickSort(data,0,d.length-1);	   
   }
 
   private static int[] quickSort(int[] data,int lo,int hi){//Traducido apartir de https://en.wikipedia.org/wiki/Quicksort
	   int p=0;//Particiones
		if( lo < hi){
			  p = quickPart(data, lo, hi);
		   		quickSort(data, lo, p);
		   	return quickSort(data, p + 1, hi);
		}
		return data;
   }
   private static int quickPart(int[] a,int low,int high){//Particion de Metodo rapido
	   int pivot = a[low];
	   int i = low - 1;
	   int j = high + 1;
	   while (i < j){
	    for (i++; a[i] < pivot; i++);
	    for (j--; a[j] > pivot; j--);
		    if (i < j){
		    	int temp = a[i];
			    a[i] = a[j];
			    a[j] = temp;
		    }
	   }
	   return j;
   }
 //--------------------QuickSort-----------------
   
   public static void useAll(int[] data){//USa Todos
	   System.out.println("Arreglo Desordenado :	"+Arrays.toString(data)+"\n");
       long startTime = System.nanoTime();
       
       System.out.println("1.-Burbuja->		"+Arrays.toString(burbuja(data)));
       long time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");   
       
       startTime = System.nanoTime();
       System.out.println("2.-Inserción->		"+Arrays.toString(insercion(data)));
       time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");
       
       startTime = System.nanoTime();
       System.out.println("3.-Selección->		"+Arrays.toString(seleccion(data)));
       time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");
       
       startTime = System.nanoTime();
       System.out.println("4.-Cuentas->		"+Arrays.toString(cuentas(data)));
       time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");
       
       startTime = System.nanoTime();
       System.out.println("5.-Shell->		"+Arrays.toString(shell(data)));
       time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");
       
       startTime = System.nanoTime();
       System.out.println("6.-Radix->		"+Arrays.toString(radix(data)));
       time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");
       
       startTime = System.nanoTime();
       System.out.println("7.-Mezcla->		"+Arrays.toString(mezcla(data)));
       time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");
       
       startTime = System.nanoTime();
       System.out.println("8.-QuickSort->		"+Arrays.toString(quickSort(data)));
       time = System.nanoTime() - startTime;
       System.out.println("Tiempo: "+time+" Nanoseg...\n");
   }
   
}
