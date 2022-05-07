package foundation;

import java.util.UUID;

public class Helpers {
	public static String generateString() {
		String uuid = UUID.randomUUID().toString();
		String removedSpecialChars = uuid.replace("-", "");
		
		return removedSpecialChars;
	}
	
	public static String generateEmailAddress() {	
		return generateString() + "@n.com";
	}
}
