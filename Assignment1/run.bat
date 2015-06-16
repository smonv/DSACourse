cls
echo off
mkdir bin
javac -d bin -cp . src/slmt/Main.java src/controllers/*.java src/entity/*.java src/list/*.java
java -cp bin slmt.Main
pause
del /S /Q bin\*
rmdir bin\slmt
rmdir bin\controllers
rmdir bin\entity
rmdir bin\list