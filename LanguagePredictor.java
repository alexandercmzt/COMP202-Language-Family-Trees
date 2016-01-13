import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LanguagePredictor{


  public static void main(String[] args) throws IOException
  {
    classifyDocuments(readVocabulary("eng_vocab.txt"), readVocabulary("fre_vocab.txt"), "docs/test/", 20);
  }
  

  public static HashMap<String,Integer> readVocabulary(String fileName) throws IOException
  {

    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    HashMap<String, Integer> wordsHash = new HashMap<String, Integer>();

    while(true)
    {
      try
      {
        String arr[] = br.readLine().split(" ");
        wordsHash.put(arr[0], Integer.valueOf(arr[1])); 
      }

      catch(NullPointerException e) //so it stops at the end
      {
        break;
      }
    }
    return wordsHash;
  }
  

  public static void classifyDocuments(HashMap<String,Integer> engVocab, HashMap<String,Integer> freVocab, 
   String directory, int nFiles) throws IOException
  {
    for (int i=1; i<=nFiles; i++) 
    {
      ArrayList<String> testWords = new ArrayList<String>();
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
            testWords.add(wordList[j]);
          }
        }
      }
      int englishWords = 0;
      int frenchWords = 0;

      for (int j = 0; j<testWords.size(); j++) //keeps a tally of words that are found in either dictionary
      {
        if (engVocab.containsKey(testWords.get(j)))
        {
          englishWords +=1;
        }
        if (freVocab.containsKey(testWords.get(j)))
        {
          frenchWords +=1;
        }
      }
      System.out.println(i + ".txt has " + englishWords + " words matching English and " + frenchWords + " words matching French.");
      if (englishWords>frenchWords)
      {
        System.out.println(i + ".txt is hence in English");
      }
      else
      {
        System.out.println(i + ".txt is hence in French");
      }
      testWords.clear();   //clears the arraylist so that words arent left in the next comparison
    }
  }

  /*****************************************************************************
   Put the output of classifyDocuments here, and a sentence to describe whether
   your program worked.
   
   The program worked as all the comparisons turned out with the correct result. 

1.txt has 30 words matching English and 12 words matching French.
1.txt is hence in English
2.txt has 82 words matching English and 41 words matching French.
2.txt is hence in English
3.txt has 151 words matching English and 65 words matching French.
3.txt is hence in English
4.txt has 401 words matching English and 149 words matching French.
4.txt is hence in English
5.txt has 97 words matching English and 51 words matching French.
5.txt is hence in English
6.txt has 234 words matching English and 104 words matching French.
6.txt is hence in English
7.txt has 65 words matching English and 30 words matching French.
7.txt is hence in English
8.txt has 213 words matching English and 90 words matching French.
8.txt is hence in English
9.txt has 81 words matching English and 37 words matching French.
9.txt is hence in English
10.txt has 610 words matching English and 273 words matching French.
10.txt is hence in English
11.txt has 76 words matching English and 438 words matching French.
11.txt is hence in French
12.txt has 24 words matching English and 176 words matching French.
12.txt is hence in French
13.txt has 23 words matching English and 63 words matching French.
13.txt is hence in French
14.txt has 54 words matching English and 263 words matching French.
14.txt is hence in French
15.txt has 33 words matching English and 156 words matching French.
15.txt is hence in French
16.txt has 21 words matching English and 127 words matching French.
16.txt is hence in French
17.txt has 43 words matching English and 263 words matching French.
17.txt is hence in French
18.txt has 96 words matching English and 481 words matching French.
18.txt is hence in French
19.txt has 29 words matching English and 173 words matching French.
19.txt is hence in French
20.txt has 45 words matching English and 220 words matching French.
20.txt is hence in French
   
   
   
   
   
   
   
   
   

   *****************************************************************************/
 }