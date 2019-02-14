package com.revature.spark.todo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.revature.spark.beans.Product;
import com.revature.spark.beans.Warehouse;

/**
 * Within this class, you will implement the logic to calculate data for various
 * reports.
 * 
 * @author David Van Alstine
 * 
 */
public class AssociateImplementation {

	/**
	 * Find the sum of all product assets. Remember that quantity times price is the
	 * total value for a given product.
	 * 
	 * @param products
	 * @return
	 */
	public Double sum(List<Product> products) {
		double newSum = 0;
//		for(int i = 0; i < listSize; i++) {
//			newSum = newSum + products.get(i);
//		}			
		for(Product i : products) {
			double totalVal = i.getPrice() * i.getQuantity();
			newSum += totalVal;
		}		
		return newSum;	
	}

	/**
	 * Find the lowest product price out of all products.
	 * 
	 * @param products
	 * @return
	 */
	public Double min(List<Product> products) {
		double lowestPrice = 100;
		for(Product i : products) {
			double currentPrice = i.getPrice();
			if(currentPrice < lowestPrice) {
				lowestPrice = currentPrice;
			}	
		}
		return lowestPrice;
	}

	/**
	 * Find the highest product price out of all products.
	 * 
	 * @param products
	 * @return
	 */
	public Double max(List<Product> products) {
		double highestPrice = 0;
		for(Product i : products) {
			double currentPrice = i.getPrice();
			if(currentPrice > highestPrice) {
				highestPrice = currentPrice;
			}	
		}
		return highestPrice;
	}

	/**
	 * Find the average product price of all products.
	 * 
	 * @param products
	 * @return
	 */
	public Double avg(List<Product> products) {
		double sum = 0;
		for(Product i : products) {
			sum = sum + i.getPrice();
		}
		return (sum/products.size());
	}

	/**
	 * Find the median product price of all products.
	 * 
	 * @param products
	 * @return
	 */
	public Double median(List<Product> products) {
		
		double[] sortedArr = new double[products.size()];
        int index = 0;
        for(Product i : products) {
            sortedArr[index] = i.getPrice();
            index++;
        }
        int size = products.size();
        for(int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - i - 1; j++) {
                if(sortedArr[j] > sortedArr[j+1]) {
                    double temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j+1];
                    sortedArr[j+1] = temp;
                }
            }
        }
		
        int middleVal = sortedArr.length/2;
		double medianPrice = 0.0;
		if(sortedArr.length % 2 == 1) {		
			medianPrice = sortedArr[middleVal];
		}
		else if(sortedArr.length % 2 == 0) {
			double avgMedian = ((sortedArr[middleVal] + sortedArr[middleVal - 1])/2);
			medianPrice = avgMedian;
		}
				
		return medianPrice;
	}

	/**
	 * !! BONUS CHALLENGE REQUIREMENT !!
	 * 
	 * Find the total value of all products in each warehouse (total assets).
	 * 
	 * Let's look at some example data:
	 * 
	 * Warehouse A 
	 * Product 	| Price | Quantity 
	 * Rice 	| $3.40 | 8 
	 * Beans 	| $1.50 | 3
	 * ------------------------------------ 
	 * Warehouse B 
	 * Product 	| Price 	| Quantity
	 * TV 		| $50.25 	| 4 
	 * Speaker 	| $15.10 	| 6 
	 * -----------------------------------
	 * Result: 
	 * Warehouse A : $31.70 
	 * Warehouse B : $291.60
	 * 
	 * 
	 * @param products
	 * @return
	 */
	public Map<Warehouse, Double> totalAssetsPerWarehouse(List<Product> products) {
		return null;
	}

}
