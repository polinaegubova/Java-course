cd C:\Users\polin\IdeaProjects\KIK-Java

mkdir bin

javac -sourcepath src -d bin ./src/ru/polinaegubova/summator/*.java

java -cp ./bin ru.polinaegubova.summator.Main 1 2
