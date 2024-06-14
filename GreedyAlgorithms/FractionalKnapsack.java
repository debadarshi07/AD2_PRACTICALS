package GreedyAlgorithms;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Item {
	String name;
	double weight,value,valuePerWeight;
	
	Item(String name,double weight,double value){
		this.name=name;
		this.weight=weight;
		this.value=value;
		this.valuePerWeight=value/weight;
	}
}
public class FractionalKnapsack {
	public static List<Item> fractionalKnapsack(List<Item> items,double capacity){
		Collections.sort(items,Comparator.comparingDouble(o -> -o.valuePerWeight));
		
		List<Item> knapsack=new ArrayList<>();
		double totalValue=0;
		for(Item item:items) {
			if(capacity>=item.weight) {
				knapsack.add(item);
				totalValue += item.value;
				capacity -= item.weight;
			}else {
				double fraction=capacity/item.weight;
				knapsack.add(new Item(item.name,capacity,fraction*item.value));
				totalValue+=fraction*item.value;
				break;
			}
		}
		System.out.println("Total Value in the knapsack: "+totalValue);
		return knapsack;
	}
	
	public static void main(String[] args) {
		
		List<Item> items=new ArrayList<>();
		items.add(new Item("Item1",10,12));
		items.add(new Item("Item2",20,100));
		items.add(new Item("Item3",30,120));
		double capacity=80;
		
		List<Item> selectedItems=fractionalKnapsack(items,capacity);
		
		for(Item item:selectedItems) 
			System.out.println("Name:"+item.name+",Weight:"+item.weight+",Value:"+item.value);
	}
}
