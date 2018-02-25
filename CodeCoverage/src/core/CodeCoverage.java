package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Niklas Reje
 * 
 * Simple Code Coverage Checking Tool™ that redirects the output stream to a custom one that extracts relevant code coverage outputs.
 * 
 * Write System.out.println("#CC# {line ID}"); where {line ID} is an identifier for some line that you want to check the coverage for.
 * The {line ID} could contain whatever you want so long as it works for you.
 * 
 * Because the lines are kept in a set there are no guarantees that they will come in the order they where put there.
 *
 */

public class CodeCoverage extends PrintStream {
	private final Set<String> coveredLines = new HashSet<String>();
	private final PrintStream originalOutputStream = System.out;
	private final String outputFile;
	
	/**
	 * Changes the output stream to this object.
	 */
	public CodeCoverage(String outputFile){
		super(System.out);
		System.setOut(this);
		this.outputFile = outputFile;
	}
	
	/**
	 * Extract output streams that contain "#CC#" in the beginning of the string, otherwise pass it on to the normal println function.
	 */
	@Override
	public void println(String x) {
		if(x.startsWith("#CC#")) {
			String line = x.substring(5);
			coveredLines.add(line);
		}
		else super.println(x);
	}
	
	/**
	 * Get the set with all the covered lines.
	 */
	public Set<String> getResult() {
		resetOutputStream();
		return coveredLines;
	}
	
	/**
	 * Changes back to the original output stream. This should be called at the end every test method unless getResult() is called otherwise the original output stream is lost.
	 */
	public void resetOutputStream() {
		System.setOut(originalOutputStream);
	}
	
	/**
	 * Can be used to write the result to a file and will also keep the previous executions as well.
	 * @param methodName Just an identification and a way to tell when a new round of results began.
	 * @throws IOException
	 */
	public void writeToFile(String methodName){
		try(FileWriter fw = new FileWriter(outputFile, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			out.println(methodName+":");
			for(String s : getResult()) {
				out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Couldn't open output file");
		}
	}
}
