public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{
  word = noCapitals(word);
  word = noWeirdCharacters(word);
  for(int i = 0; i < word.length()/2; i++) {
    if(word.charAt(i) != word.charAt(word.length() - 1 - i))
      return false;
  }
  return true;
}

public String noCapitals(String sWord){
  return sWord.toLowerCase();
}

public String noWeirdCharacters(String sWord) {
  String temp = new String();
  for(int i = 0; i < sWord.length(); i++) {
    if(Character.isLetter(sWord.charAt(i))) {
      temp += sWord.charAt(i);
    }
  }
  return temp;
}