package textAnalaysis;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class NameFinderClass {

	public static void main(String[] args) {

		try {

			String rawText = "Hi everyone? We are experimenting the persons name extraction. In this program we will extract James, Ali, sadiq and Amin";

			// Load the Tokenizer pre-train model
			InputStream textStream = new FileInputStream("lib/NlpModels/en-token.bin");
			TokenizerModel tokenizerModel = new TokenizerModel(textStream);

			// Instantiate TokenizerME class
			TokenizerME tokenizerME = new TokenizerME(tokenizerModel);

			// Tokenize the raw text
			String tokens[] = tokenizerME.tokenize(rawText);

			// Load the NER model for Person's name extraction
			InputStream inputStream = new FileInputStream("lib/NlpModels/en-ner-person.bin");
			TokenNameFinderModel model = new TokenNameFinderModel(inputStream);

			// Instantiate the Person's name finder class
			NameFinderME nameFinder = new NameFinderME(model);

			// Search Person's names in the tokenized text
			Span names[] = nameFinder.find(tokens);

			// Print all of the persons names in sentences
			for (Span name : names)
				System.out.println(tokens[name.getStart()]);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
