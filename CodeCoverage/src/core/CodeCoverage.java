package core;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Niklas Reje
 * 
 * Simple Code Coverage Checking Tool™ that redirects the error stream to a custom one that extracts relevant error outputs.
 * 
 * Write System.err.println("#CC# {line ID}"); where {line ID} is an identifier for some line that you want to check the coverage for.
 * The {line ID} could contain whatever you want so long as it works for you.
 * 
 * Because the lines are kept in a set there are no guarantees that they will come in the order they where put there.
 *
 */

public class CodeCoverage extends PrintStream {
	private final Set<String> coveredLines = new HashSet<String>();
	private final PrintStream originalErrorStream = System.err;
	
	/**
	 * Changes the error output stream to this object.
	 */
	public CodeCoverage(){
		super(System.err);
		System.setErr(this);
	}
	
	/**
	 * Extract error streams that contain "#CC#" in the beginning of the string, otherwise sends it to the normal println function.
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
		resetErrorStream();
		return coveredLines;
	}
	
	/**
	 * Changes back to the original error output stream. This needs to be called at the end every test method unless getResult() is called.
	 */
	public void resetErrorStream() {
		System.setErr(originalErrorStream);
	}
}
