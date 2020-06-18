package textAnalaysis;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

import opennlp.tools.tokenize.SimpleTokenizer;

public class SimpleTokenizerClass {

	public static void main(String[] args) {

		String rawText = "Hi everyone? Welcome to the Java Book Programs from FSKTM UTHM";

		// Instantiate SimpleTokenizer class
		SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;

		// Tokenize the raw text
		String tokens[] = simpleTokenizer.tokenize(rawText);

		// Print all the tokens
		for (String token : tokens) {
			System.out.println(token);
		}
	}
}
