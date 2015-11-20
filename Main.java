package Ordenamiento;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import All.Sorts;

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
			case 1:
				System.out.println("Ordenamiento por 'BURBUJA'->: ");
				System.out.println(Arrays.toString(Sorts.burbuja(arreglo))+"\n");
				menuSorts(arreglo);
				break;	
			case 2:
				System.out.println("Ordenamiento por 'INSERCIÓN'->: ");
				System.out.println(Arrays.toString(Sorts.insercion(arreglo))+"\n");
				menuSorts(arreglo);
				break;
			case 3:
				System.out.println("Ordenamiento por 'SELECCIÓN'->: ");
				System.out.println(Arrays.toString(Sorts.seleccion(arreglo))+"\n");
				menuSorts(arreglo);
				break;
			case 4://Cuentas
				System.out.println("Ordenamiento por 'CUENTAS'->: ");
				System.out.println(Arrays.toString(Sorts.cuentas(arreglo))+"\n");
				menuSorts(arreglo);
				break;
			case 5://Shell
				System.out.println("Ordenamiento por 'SHELL'->: ");
				System.out.println(Arrays.toString(Sorts.shell(arreglo))+"\n");
				menuSorts(arreglo);
				break;
			case 6:
				System.out.println("Ordenamiento por 'RADIX'->: ");
				System.out.println(Arrays.toString(Sorts.radix(arreglo))+"\n");
				menuSorts(arreglo);
				break;
			case 7:
				System.out.println("Ordenamiento por 'MEZCLA'->: ");
				System.out.println(Arrays.toString(Sorts.mezcla(arreglo))+"\n");
				menuSorts(arreglo);
				break;
			case 8:
				System.out.println("Ordenamiento por 'QUICKSORT'->: ");
				System.out.println(Arrays.toString(Sorts.quickSort(arreglo))+"\n");
				menuSorts(arreglo);
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