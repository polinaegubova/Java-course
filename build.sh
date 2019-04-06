cd C:\Users\polin\IdeaProjects\KIK-Java

jar cf ./out/library/libSum.jar ./src/ru/polinaegubova/summator/Summator.java

mkdir C:\Users\polin\IdeaProjects\KIK-Java\out\app

javac -sourcepath .  -d out/app ./src/ru/polinaegubova/summator/*.java

java -cp ./out/app ru.polinaegubova.summator.Main 1 2
