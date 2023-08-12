String Class Methods:
Creating Strings:
String str = "Hello";
String str = new String("Hello");

String Length:
int length = str.length();

Concatenation:
String newStr = str1 + str2;
String newStr = str1.concat(str2);

Substring:
String subStr = str.substring(startIndex);
String subStr = str.substring(startIndex, endIndex);

Character Extraction:
char ch = str.charAt(index);

String Comparison:
boolean isEqual = str1.equals(str2);
boolean isEqualIgnoreCase = str1.equalsIgnoreCase(str2);

Searching:
int index = str.indexOf(substring);
int lastIndex = str.lastIndexOf(substring);

Replacing:
String newStr = str.replace(oldStr, newStr);

Converting Case:
String upperCaseStr = str.toUpperCase();
String lowerCaseStr = str.toLowerCase();

Trimming Whitespace:
String trimmedStr = str.trim();


StringBuilder and StringBuffer Classes:
Creating StringBuilder:
StringBuilder sb = new StringBuilder();
StringBuilder sb = new StringBuilder("Hello");

Appending:
sb.append(str);

Inserting:
sb.insert(index, str);

Deleting:
sb.delete(startIndex, endIndex);

Replacing:
sb.replace(startIndex, endIndex, str);

Converting to String:
String finalStr = sb.toString();

String Formatting:
Using printf:
System.out.printf("Formatted: %s, %d", str, num);

String Format Method:
String formattedStr = String.format("Formatted: %s, %d", str, num);

Regular Expressions (java.util.regex package):
Pattern Matching:
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(inputStr);
boolean isMatch = matcher.matches();

Finding Matches:
boolean found = matcher.find();
String matchedStr = matcher.group();

Checking Character Types:
boolean isLetter = Character.isLetter(ch);
boolean isDigit = Character.isDigit(ch);
boolean isWhitespace = Character.isWhitespace(ch);
boolean isUpperCase = Character.isUpperCase(ch);
boolean isLowerCase = Character.isLowerCase(ch);

Converting Case:
char upperCaseCh = Character.toUpperCase(ch);
char lowerCaseCh = Character.toLowerCase(ch);

Checking Equality:
boolean isEqual = Character.compare(ch1, ch2) == 0;

char[] charArray = str.toCharArray();


Tokenizing Strings:
java
Copy code
StringTokenizer tokenizer = new StringTokenizer(inputStr, delimiters);
while (tokenizer.hasMoreTokens()) {
    String token = tokenizer.nextToken();
}
StringJoiner Class (java.util package):
Joining Strings:
java
Copy code
StringJoiner joiner = new StringJoiner(delimiter);
joiner.add(str1);
joiner.add(str2);
String joinedStr = joiner.toString();
Unicode and Code Points:
Getting Code Point:

int codePoint = str.codePointAt(index);
Getting Unicode Count:

int unicodeCount = str.length();
int unicodeCount = str.codePointCount(startIndex, endIndex);
Converting Code Point to String:

String strFromCodePoint = new String(new int[]{codePoint}, 0, 1);
