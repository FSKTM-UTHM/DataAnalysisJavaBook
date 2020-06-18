package textAnalaysis;

import java.io.FileInputStream;

/*
 * Author : Aamir Khan
 * Faculty of Computer Science and Information Technology
 * University Tun Hussein Onn Malaysia
 */

import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class PosTaggerClass {

	public static void main(String[] args) {

		try {

			String rawText = "Hi everyone? We are experimenting the part of speech tagging. In this program we will extract different POS tags";

			// Load the Tokenizer pre-train model
			InputStream textStream = new FileInputStream("lib/NlpModels/en-token.bin");
			TokenizerModel tokenizerModel = new TokenizerModel(textStream);

			// Instantiate TokenizerME class
			TokenizerME tokenizerME = new TokenizerME(tokenizerModel);

			// Tokenize the raw text
			String POStokens[] = tokenizerME.tokenize(rawText);

			// Load the POS model for part of speeches extraction
			InputStream inputStreamPOS = new FileInputStream("lib/NlpModels/en-pos-maxent.bin");
			POSModel POSmodel = new POSModel(inputStreamPOS);

			// Instantiate the POS tagger class
			POSTaggerME  POStagFinder = new POSTaggerME (POSmodel);

			// Search POS tags in the tokenized text
			String POStags[] = POStagFinder.tag(POStokens);

			// Print all of the words with corresponding POS tags in sentences
			for(int i=0;i<POStokens.length;i++) {
				System.out.println(POStokens[i]+" = "+POStags[i]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
