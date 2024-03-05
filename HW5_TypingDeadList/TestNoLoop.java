import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNoLoop {  
	@Test
	void testNoLoopRemove() throws FileNotFoundException {  //4 marks
		//You must provide the correct path for your file
		File f = new File("C:\\Users\\picha\\eclipse-workspace\\HW5\\src\\TypingDeadList.java");
		Scanner s = new Scanner(f);

		boolean foundLoop = false;
		String line = "";
		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("void remove()")) {
				break;
			}
		}

		while (s.hasNextLine()) {
			if (line.contains("for") || line.contains("while")) {
				foundLoop = true;
				break;
			}
			line = s.nextLine();
		}
		s.close();
		assertFalse(foundLoop);

	}

}
