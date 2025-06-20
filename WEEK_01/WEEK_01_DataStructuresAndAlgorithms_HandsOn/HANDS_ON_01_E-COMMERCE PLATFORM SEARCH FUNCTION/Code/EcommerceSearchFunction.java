package com.productsearch;
import java.util.*;
class Product{
	int productId;
	String productName;
	String category;
	public Product(int productId,String productName,String category)
	{
		this.productId=productId;
		this.productName=productName;
		this.category=category;
	}
	@Override
	public String toString()
	{
		return productId+" - "+productName+" ("+category + ")";
	}
}
public class Main {
//Linear Search Implementation
	public static Product linearSearch(Product[] products,String name) {
		for(Product product:products)
			
		{
			if(product.productName.equalsIgnoreCase(name))
			{
				return product;
			}
		}
		return null;

	}
	//Binary Search Implementation
	public static Product binarySearch(Product[] products,String name)
	{
		int low=0,high=products.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			int comparison=products[mid].productName.compareToIgnoreCase(name);
			if(comparison==0)
			{
				return products[mid];
			}
			else if(comparison<0)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		return null;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Product[] products= {
				new Product(101,"Mobile-Phone","Electronics"),
				new Product(102,"T-Shirt","Fashion"),
				new Product(103,"Chair","Furniture"),
				new Product(104,"Headset","Electronics"),
				new Product(105,"Sport-Shoes","Footwear")
		};
		System.out.println("Available Products List:");
		for(Product p:products)
		{
			System.out.println("- "+p.productName);
		}
		System.out.print("Enter product name to search: ");
		String searchName=sc.nextLine();
		System.out.println("You entered: "+searchName);
		long startLinear=System.nanoTime();//for time analysis
		Product foundLinear=linearSearch(products,searchName);
		long endLinear=System.nanoTime();
		if(foundLinear!=null)
		{
			System.out.println("Product found using Linear Search: "+foundLinear);
		}
		else
		{
			System.out.println("Product not found using Linear Search.");
		}
		System.out.println("Linear Search Time: "+(endLinear-startLinear)+"ns");
		Arrays.sort(products,Comparator.comparing(p->p.productName.toLowerCase()));
		long startBinary=System.nanoTime();
		Product foundBinary=binarySearch(products,searchName);
		long endBinary=System.nanoTime();
		//note that in small datasets Linear Search might bring faster results
		//but in large ,huge datasets binary search is a faster and optimized approach
		if(foundBinary!=null)
		{
			System.out.println("Product found using Binary Search: "+foundBinary);
		}
		else
		{
			System.out.println("Product not found using Binary Search.");
		}
		System.out.println("Binary Search Time: "+(endBinary-startBinary)+"ns");
		sc.close();
	}

}

