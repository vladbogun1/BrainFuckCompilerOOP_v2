@echo off
cd java/
set arg1=%1
javac ua\nure\bogun\brainfuck\*.java
javac ua\nure\bogun\brainfuck\commands\*.java
javac ua\nure\bogun\brainfuck\factory\*.java
java -cp . ua.nure.bogun.brainfuck.MainClass %arg1%
del ua\nure\bogun\brainfuck\*.class
del ua\nure\bogun\brainfuck\commands\*.class
del ua\nure\bogun\brainfuck\factory\*.class
cd ../
