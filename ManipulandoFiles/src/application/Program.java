package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		File path = new File("C:\\temp\\Produtos.txt");
		String path2 = "C:\\temp\\out\\summary.txt";
		
		boolean success = new File("C:\\temp\\out").mkdir();
		System.out.println("Directory created successfully: " + success);
		
		try (BufferedReader br = new BufferedReader(new FileReader(path) )){

			String line = br.readLine();
			do {
			//	line = br.readLine();
				String [] vect = line.split(",");
				String name = vect[0];
				Double price = Double.parseDouble(vect[1]);
				Integer quantity = Integer.parseInt(vect[2]);
				
				Product prod = new Product(name, price ,quantity);
				list.add(prod);
				prod.total(price, quantity);
				line = br.readLine();
			
			}while (line != null);
			
			
	/*		for ( Product p : list ) {
				//System.out.printf("\n %s %.2f",p.getName(),p.getSuned());
				System.out.printf(p.toString());

			}*/
		} catch (IOException e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){
			for ( Product p : list ) {
				bw.write(p.toString());

			}
		}
		catch (IOException e) {
			System.out.println("Error: " +e.getMessage());
		}
		

		
		sc.close();
	}

}
