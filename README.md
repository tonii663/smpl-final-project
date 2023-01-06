# smpl-final-project

## Usage Windows (I don't use Linux but it's supposed to be easier than windows) 
- Run Jflex 
``` console
jflex Lexer.jflex
```

- Run Cup 
``` console
java -Xmx128m -jar <cup jar file> -parser SmplParser Parser.cup
```

- Run
``` console
java -classpath <path to cup> Main <filename>
```

### Example (Windows)
``` console
jflex Lexer.jflex
java  -Xmx128m -jar w:\_Libraries\cup\java-cup-11b.jar -parser SmplParser Parser.cup
javac -classpath ".;w:\_Libraries\cup\java-cup-11b.jar" *.java
java  -classpath ".;w:\_Libraries\cup\java-cup-11b.jar" Main tests\input*.txt
```
