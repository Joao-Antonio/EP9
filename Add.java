package EP9;

import java.util.Scanner;

public class Add extends BinaryTree {
	
	public static Scanner kb = new Scanner(System.in);
	
	public static int num;
	
	public static int vet [] = {1,2,3,4,5,6,7};
	
	public static void insertArray(int [] vet, int start, int end){
		
		int positionMid = 0;
		
		if (start < end) {
			if (getBinaryTree() == null) {
				
				setBinaryTree(new Node(positionMid = breakingArray(vet, start, end)));
				
			}else {
				insertValue(getBinaryTree(), positionMid);
			}
			
			insertArray(vet, start, positionMid - 1);
			insertArray(vet, positionMid + 1, end);
			
		}
	}
	
	public static int breakingArray(int [] vet, int start, int end) {
		
		int mid = (start + end) / 2;
		
		return vet[mid];
	}
	
	public static void insertValue(Node node, int numAux){
		
		numAux = num;
		
		if (getBinaryTree() == null){
			System.out.println(" Inserindo " + num);
			
			setBinaryTree(new Node(num));
		}
		
		if (num < node.getValue()) {
			
			if (node.getLeft() != null) {
				insertValue(node.getLeft(), num);
//				se o nó está ocupado a recursão começa a partir desse nó
				
			} else {
				System.out.println(" Inserido o valor " + num + " a esquerda de " + node.getValue());
				node.setLeft(new Node(num));
//				Avança até achar um nó folha e adiciona a partir dele
			}
		} else if (num > node.getValue()) {
			
			if (node.getRight() != null) {
				insertValue(node.getRight(), num);
			} else {
				System.out.println(" Inserido o valor " + num + " a direita de " + node.getValue());
				node.setRight(new Node(num));
			}
		}
		
	}
	
	public static void addValue(){
		
		String aux1;
		try {
			
			
			if (getBinaryTree() == null) {
//				se a arvore estiver sem raiz aqui cria
				
				System.out.print("Insira o valor ou cancele digitando (x) : ");
				aux1 = kb.next();
				
				num = Integer.parseInt(aux1);
				
				setBinaryTree(new Node(num));
					
				System.out.println("Inserido " + num + "\n");
				
				addValue();
			}else {
				
				System.out.print("Insira o valor ou cancele digitando (x) : ");
				aux1 = kb.next();
				
				num = Integer.parseInt(aux1);
				
				insertValue(getBinaryTree(), num);
				
				addValue();
			}
			
		} catch (NumberFormatException e) {
			System.out.println("Parou de adicionar!");
			
			Menu();
		}
	}
	
	public static void printTree(Node node){
		if(node != null){
			printTree(node.getLeft());
			System.out.print(node.getValue() + " ");
			printTree(node.getRight());
		}
		
	}
	
	public static void Menu(){
		
		int menu = 0;
		
		System.out.print("Digite (1) para adicionar ou (2) para imprimir: ");
		menu = kb.nextInt();
		
		switch (menu) {
		case 1:
			addValue();
			
			break;
		case 2:
			printTree(getBinaryTree());
			
			break;
		}
	}
	
	public static void main(String[] args) {
		
		insertArray(vet, 0, vet.length);
		
		Menu();
		
	}
}