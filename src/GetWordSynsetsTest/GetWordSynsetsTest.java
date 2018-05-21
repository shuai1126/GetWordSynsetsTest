package GetWordSynsetsTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

public class GetWordSynsetsTest {
    private static String WORDNET_PATH = "D:\\Program Files (x86)\\WordNet\\2.1\\dict";

    public static void main(String[] args) throws IOException{
        File wnDir=new File(WORDNET_PATH);
        URL url=new URL("file", null, WORDNET_PATH);
        IDictionary dict=new Dictionary(url);
        dict.open();//打开词典
        getSynonyms(dict); //testing

    }

    public static void getSynonyms(IDictionary dict){

        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        IIndexWord idxWord =dict.getIndexWord(str, POS.VERB);
        IWordID wordID = idxWord.getWordIDs().get(0) ; // 1st meaning
        IWord word = dict.getWord(wordID);
        ISynset synset = word.getSynset (); //ISynset是一个词的同义词集的接口

        // iterate over words associated with the synset
        for(IWord w : synset.getWords())
            System.out.println(w.getLemma());//打印同义词集中的每个同义词
    }
}
