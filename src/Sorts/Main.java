/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorts;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner leer=new Scanner(System.in);
	static int[] lista;
	
	public static void main(String[] args){
		menuStart();
	}	
	
	private static void menuStart(){
		System.out.print("Algoritmos de Ordenamiento");
		System.out.println("\n1.-Iniciar\n2.-Salir");
		int opc=leer.nextInt();
		if(opc==1){
			System.out.println("Ingresa el Tamaño Del Arreglo : ");
			int cant=leer.nextInt();
			int[] origin=genArr(cant);
			System.out.println("Arreglo Creado!..\n"+Arrays.toString(origin));
			menuSorts(origin);
		}
	}
	
	private static void menuSorts(int[] arreglo){
		System.out.println("\nOrdenar Mediante: ");
		System.out.println("1.-Burbuja");
		System.out.println("2.-Inserción");
		System.out.println("3.-Selección");
		System.out.println("4.-Cuentas");
		System.out.println("5.-Shell");
		System.out.println("6.-Radix");
		System.out.println("7.-Mezcla");
		System.out.println("8.-QuickSort");
		System.out.println("9.-Todos");
		System.out.println("10.-Atras");
		System.out.println("0.-Salir");
		
		int opc=leer.nextInt();
		switch(opc){
                    
			case 1:long startTime = System.nanoTime();
                                System.out.println("1.-Ordenamiento por Burbuja-> "+Arrays.toString(Sorts.burbuja(arreglo)));
                                long time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
                            
				break;	
			case 2:
				startTime = System.nanoTime();
                                System.out.println("1.-Ordenamiento por Insercion-> "+Arrays.toString(Sorts.insercion(arreglo)));
                                time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
				break;
			case 3:
				startTime = System.nanoTime();
                                System.out.println("1.-Ordenamiento por Seleccion-> "+Arrays.toString(Sorts.seleccion(arreglo)));
                                time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
				break;
			case 4://Cuentas
				startTime = System.nanoTime();
                                System.out.println("1.-Ordenamiento por Cuentas-> "+Arrays.toString(Sorts.cuentas(arreglo)));
                                time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
				break;
			case 5://Shell
				startTime = System.nanoTime();
                                System.out.println("1.-Ordenamiento por Shell-> "+Arrays.toString(Sorts.shell(arreglo)));
                                time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
				break;
			case 6:
				startTime = System.nanoTime();
                                System.out.println("1.-Ordenamiento por Radix-> "+Arrays.toString(Sorts.radix(arreglo)));
                                time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
				break;
			case 7:
				startTime = System.nanoTime();
                                System.out.println("1.-Ordenamiento por Mezcla-> "+Arrays.toString(Sorts.mezcla(arreglo)));
                                time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
				break;
			case 8:
				startTime = System.nanoTime();
                                System.out.print("1.-Ordenamiento por Quicksort-> "+Arrays.toString(Sorts.quickSort(arreglo)));
                                time = System.nanoTime() - startTime;
                                System.out.print("Tiempo: "+time);
				break;
			case 9:
				Sorts.useAll(arreglo);
				menuStart();
				break;
			case 10:
				menuStart();
				break;
			default:
				break;
		}
	}
	public static int[] genArr(int cant){//Crea un arreglo Random
		int arr[]=new int[cant];
		int value;
		Random rdn=new Random();
		for(int i=0;i<cant;i++){
			value=rdn.nextInt(cant*7);
			if(exist(value,arr,i))
				i--;//No avanza hasta que se genere uno diferente
			else
				arr[i]=value;				
		}		
		return arr;
	}

	private static boolean exist(int value, int[] arr,int indMax) {//Para generar el Arreglo Random
		for(int i=0;i<indMax;i++){
			if(arr[i]==value)
				return true;
		}
		return false;
	}
}
