#!/bin/bash
#----Window----
#javac -encoding UTF-8 -d app/bin/main/ app/src/main/java/com/bitcamp/board/App.java
#--------------
javac -d app/bin/main/ app/src/main/java/com/bitcamp/board/App.java
echo "compile"
java -cp app/bin/main/ com.bitcamp.board.App
