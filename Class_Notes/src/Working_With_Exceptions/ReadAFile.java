
package Working_With_Exceptions;
import java.io.*;

public class ReadAFile {
	public static void main( String[] args ) {

		String fileName = "input.txt"; // Name of file to read
		try {
			// Use a FileReader object to open the file
			FileReader reader = new FileReader(fileName);

			// Boolean variable to read till the end of the file
			boolean doneReadingFile = false;

			// Loop till the file is done reading
			// (i.e., till the end of the file is reached)
			while (!doneReadingFile) {

				// Need to enter code here that uses FileReader.read()
				// to read the next byte and print it as a 
				// character to screen. Look at the Javadoc for the
				// read() method: it returns either the next character
				// cast as an integer or -1 if the end-of-file is reached.

				int nextCharacterAsAnInteger = reader.read();
				doneReadingFile = nextCharacterAsAnInteger == -1;

				if (!doneReadingFile){
					char nextCharacter = (char)nextCharacterAsAnInteger;
					System.out.println(nextCharacter);
				}
			}
			reader.close();
			System.out.println(); // print empty newline
		} catch (FileNotFoundException fnfe){
			System.err.println("Could not open the file");
		} catch (IOException ioe){
			System.err.println("Issue with reading or writing the file");
		}
	}
}


