
public class Implementation {
public static void main(String[] args) {
	String testText = "AABBCCDDEEFFJJIIIIIIIIII";
	String testPattern = "CCDDEE";
	String testPattern2 = "FFJJ";
	search(testText, testPattern);
	search(testText, testPattern2);
	
	
}
public static void search(String text, String pattern) {
	int t = text.length();
	int p = pattern.length();
	
	int i = 0;
	int j = 0;
	
	int[] LPS = createLPS(pattern);
	while (i < t) {
		if (pattern.charAt(j) == text.charAt(i)) {
			i++;
			j++;
		} if (j == p) {
			System.out.println("Plagarism has been found from index: " + (i - j) + " to " + ((i - j)+p));
			j = LPS[j-1];
		} if (i < t && pattern.charAt(j) != text.charAt(i)) {
			if (j != 0)
				j = LPS[j-1];
			else
				i++;
		}
	}
	
	
}

public static int[] createLPS(String pattern) {
	int pLength = pattern.length();
	int length = 0;
	int i = 1;
	int LPS[] = new int[pLength];
	LPS[0] = 0;
	
	while (i < pLength) {
		if (pattern.charAt(i) == pattern.charAt(length)) {
			length++;
			LPS[i] = length;
			i++;
		} else {
			if (length != 0) {
				length = LPS[length -1];
			}
			else {
				LPS[i] = length;
				i++;
			}
		}
	}
	
	return LPS;
}

}
