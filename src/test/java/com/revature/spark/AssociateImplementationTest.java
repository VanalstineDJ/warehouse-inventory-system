package com.revature.spark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.revature.spark.beans.Product;
import com.revature.spark.beans.Warehouse;
import com.revature.spark.todo.AssociateImplementation;

@RunWith(Parameterized.class)
public class AssociateImplementationTest {

	static AssociateImplementation testObj = new AssociateImplementation();
	static double precision = 0.01; // the "delta" used to measure the precision of the tests
	
	public AssociateImplementationTest(List<Product> products, double sum, double min, double max, double avg, double median, Map<Warehouse,Double> totals) {
		this.productList = products;
		this.sum = sum;
		this.min = min;
		this.max = max;
		this.avg = avg;
		this.median = median;
		this.warehouseTotals = totals;
	}

	List<Product> productList;

	double sum;
	double min;
	double max;
	double avg;
	double median;
	Map<Warehouse, Double> warehouseTotals;

	@SuppressWarnings("serial")
	@Parameters
	public static List<Object[]> generateTestData() {
		Warehouse wha = new Warehouse(1, "Warehouse A", "123 Revature Ln");
		Warehouse whb = new Warehouse(2, "Warehouse B", "456 Revature Ln");
		Warehouse whc = new Warehouse(3, "Warehouse C", "789 Revature Ln");
		List<Object[]> list = new ArrayList<>();
		// first test case
		list.add(new Object[] {
				Arrays.asList(new Object[] { new Product(1, "A", 1.25, 10, wha), new Product(2, "B", 5.50, 3, whb),
						new Product(3, "C", 10.00, 0, wha), new Product(4, "D", 0.15, 20, wha),
						new Product(5, "E", 3.25, 1, whc), new Product(6, "F", 99.99, 5, wha),
						new Product(7, "G", 25.13, 8, whb), new Product(8, "H", 49.78, 2, whc),
						new Product(9, "I", 12.21, 9, wha), new Product(10, "J", 5.00, 11, whb) }),
				1000.69, // sum
				0.15, // min
				99.99, // max
				21.23, // avg
				7.75, // median
				// creating a subclass on the fly to directly instantiate a map
				new HashMap<Warehouse, Double>() {
					{
						put(wha, 625.34);
						put(whb, 272.54);
						put(whc, 102.81);
					}
				} });
		// second test case
		list.add(new Object[] {
				Arrays.asList(new Object[] { new Product(1, "A", 1.01, 100, wha), new Product(2, "B", 7.29, 40, wha),
						new Product(3, "C", 11.00, 10, whb), new Product(4, "D", 62.15, 2, whc),
						new Product(5, "E", 9.75, 3, wha), new Product(6, "F", 13.33, 3, whb),
						new Product(7, "G", 27.54, 3, whb), new Product(8, "H", 41.88, 5, whb),
						new Product(9, "I", 9.21, 6, wha) }),
				1043.42, // sum
				1.01, // min
				62.15, // max
				20.35, // avg
				11.00, // median
				new HashMap<Warehouse, Double>() {
					{
						put(wha, 477.11);
						put(whb, 442.01);
						put(whc, 124.30);
					}
				} });
		// third test case
		list.add(new Object[] {
				Arrays.asList(new Object[] {
						new Product(1, "A", 0.01, 1000, wha),
						new Product(2, "B", 1.99, 3, wha),
						new Product(3, "C", 0.99, 0, wha),
						new Product(4, "D", 9.99, 20, whb),
						new Product(5, "E", 10, 1, whb),
						new Product(6, "F", 15, 5, whc),
						new Product(7, "G", 20, 8, whc),
						new Product(8, "H", 50, 2, whc)
				}),
				560.77, // sum
				0.01, // min
				50.00, // max
				13.50, // avg
				10.00,  // median
				new HashMap<Warehouse,Double>() {{
					put(wha, 15.97);
					put(whb, 209.8);
					put(whc, 335.00);
				}}
		});
		// last test case - testing that they handled the case of a single product
		list.add(new Object[] {
				Arrays.asList(new Object[] {
						new Product(1, "A", 2.55, 5, wha)
				}),
				12.75, // sum
				2.55, // min
				2.55, // max
				2.55, // avg
				2.55,  // median
				new HashMap<Warehouse,Double>() {{
					put(wha, 12.75);
				}}
		});
		return list;
	}

	@Test
	public void sumTest() {
		double testSum = testObj.sum(productList);
		assertEquals(sum, testSum, precision);
	}

	@Test
	public void minTest() {
		double testMin = testObj.min(productList);
		assertEquals(min, testMin, precision);
	}

	@Test
	public void maxTest() {
		double testMax = testObj.max(productList);
		assertEquals(max, testMax, precision);
	}

	@Test
	public void avgTest() {
		double testAvg = testObj.avg(productList);
		assertEquals(avg, testAvg, precision);
	}

	@Test
	public void medianTest() {
		double testMedian = testObj.median(productList);
		assertEquals(median, testMedian, precision);
	}

//	@Test
//	public void totalAssetsPerWarehouseTest() {
//		Map<Warehouse, Double> testTotal = testObj.totalAssetsPerWarehouse(productList);
//		try {
//			for (Warehouse entry : warehouseTotals.keySet()) {
//				// all the totals from each warehouse should match
//				assertEquals(warehouseTotals.get(entry), testTotal.get(entry), 0.01);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail("An exception was thrown during this test - therefore the test was failed");
//		}
//	}

}
