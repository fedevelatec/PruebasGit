package com.fedevela.thread;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class PowerFunction implements Function {// a sample of formula
	@Override
	public Double calculate(double arg) {
		return Math.pow(arg, 2);
	}
}

class X2Finction implements Function {// another sample of formula
	@Override
	public Double calculate(double arg) {
		return Math.abs(arg) * 2;
	}
}

public class GraphPointerThread {
	static int resCount = 0;// indicates the number of finished job(thread)
	// number of values need to process, here we are talking about sequential
	// numbers, but could be in any order
	static final int totalValue = 360;
	static DataOutputStream out;// for saving the response to file, stream
	static Double[] res;// array to keep result

	/**
	 * by Arash M. Dehghani arashmd.blogspot.com
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		GraphPointerThread.out = new DataOutputStream(new FileOutputStream(
				"C:/Users/fvelazquez/git/Pruebas1/PruebasGit/src/main/java/com/fedevela/threaddataRes.txt"));
		// create a function of a formula, power, 2x, etc...
		Function f = new PowerFunction();
		// init the result array
		res = new Double[GraphPointerThread.totalValue];
		// for each element in array
		// we sued the -180 -> 179 numbers, this not a rule, could be in any
		// order
		for (int i = 0, val = -(res.length / 2); i < res.length; i++, val++) {
			// run thread for each
			new Thread(new FunctionInvoker(val, f, i)).start();
		}
	}

	public synchronized static void addResultSet() {
		GraphPointerThread.resCount++;
		// if all of the results have calculated
		if (GraphPointerThread.resCount == GraphPointerThread.totalValue) {
			// persist the data
			GraphPointerThread.persistData();
		}
	}

	// this method gets called when all of results get calculated
	private static void persistData() {
		try {
			// here it writes doubles as string, could be double or in any
			// format
			for (Double d : res) {
				out.writeChars("[" + d.toString() + "]  ");
			}
			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("DONE!");
	}

	public static void setData(int i, Double val) {
		res[i] = val;// set the calculated value into the desire index
	}
}

// this guys runs the functions as thread
class FunctionInvoker implements Runnable {
	Function f;// reference of function(formula)
	double arg;
	int i;

	public FunctionInvoker(double arg, Function f, int i) {
		this.arg = arg;
		this.f = f;
		this.i = i;
	}

	@Override
	public void run() {
		// get the result from the function and pass it to get persist in array
		GraphPointerThread.setData(i, f.calculate(arg));
		// tell system that a result has been done.
		GraphPointerThread.addResultSet();
	}

}
