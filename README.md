# AFKKey
How not to afk

# why
it's there on the about section of the app

# how
imma give you out a tutorial on how to compile .java to .jar executable with cli. assuming you're already in the folder that contains your Main.java file, you're good.

1. open up your command line and type

`
  java --version
`

to make sure you have java on your system lol

and also compile your java file to make .class files

`
  javac Main.java
`

2. create a manifest.txt file

`
  Main-Class: Main
`

3. create a jar file within the folder

`
  java jar cvmf manifest.txt Main.jar *.class
`

4. run your jar file with cli

`
  java -cp Main.jar Main.java
`

you're good to go
