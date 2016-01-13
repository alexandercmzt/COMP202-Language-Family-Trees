import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;


public class LanguageLearner
{

	public static void main(String[] args) throws IOException
	{
  		
		writeVocabulary(countWords("docs/train/eng/", 20), "eng_vocab.txt");
		writeVocabulary(countWords("docs/train/fre/", 20), "fre_vocab.txt");
	}

	public static HashMap<String, Integer> countWords(String directory, int nFiles) throws IOException
	{
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		ArrayList<String> allWords = new ArrayList<String>();
  		allWords = getWords(directory, nFiles);	 //getWords gets an arraylist of all the words in the files

  		for (int i=0; i<allWords.size(); i++) 
  		{
  			if (!wordCount.containsKey(allWords.get(i))) //adds words that are new
  			{
  				wordCount.put(allWords.get(i),1);
  			}
  			else if (wordCount.containsKey(allWords.get(i)))
  			{
  				wordCount.put(allWords.get(i), wordCount.get(allWords.get(i))+1); //adds one to that word's count if it is already in the hashmap
  			}
  		}
  		return wordCount;
  	}

  	public static void writeVocabulary(HashMap<String, Integer> vocab, String fileName) throws IOException
  	{
  		List<String> keys = new ArrayList<String>(vocab.keySet());
  		Collections.sort(keys);

  		FileWriter fw = new FileWriter(fileName);
  		BufferedWriter bw = new BufferedWriter(fw);

  		for(int i =0; i<keys.size(); i++)
  		{
  			bw.write(keys.get(i) + " " + vocab.get(keys.get(i)));
  			bw.newLine();
  		}
  		bw.close();	

  	}

  	public static ArrayList<String> getWords(String directory, int nFiles) throws IOException
  	{
  		ArrayList<String> allWords = new ArrayList<String>();

  		for (int i=1; i<=nFiles; i++) 
  		{
  			List<String> lines = Files.readAllLines(Paths.get((directory+i+".txt").toString()), //gets the words in the txt file into a list
  				Charset.defaultCharset());
  			for (String line : lines) 
  			{
  				String [] wordList = line.split(" |\\-"); //so that hyphenated words are split up into two words as well as normal words being split up

  				for (int j=0; j<wordList.length; j++) 
  				{
  					wordList[j] = wordList[j].replaceAll("[^a-zA-Z]",""); //removing punctuation, also arraylists are easier to work with
  					if (!wordList[j].equals("")) //i also could have made all words lowercase here but the assignment example didn't have it so i didnt
  					{
  						allWords.add(wordList[j]);
  					}
  				}
  			}
  		}
  		return allWords;
  	}

  }