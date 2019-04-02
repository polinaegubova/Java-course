# Делаем директорию, в которой находится этот скрипт, текущей
cd "$( cd "$(dirname "$0")" ; pwd -P )"

# Создаем директории для .class файлов
mkdir -p out/app
mkdir -p out/library

# Собираем библиотеку
javac -sourcepath src -d out/library src/ru/polinaegubova/summator/Summator.java

# Упаковываем библиотеку в jar
jar -cf out/library/libSum.jar -C out/library ru/polinaegubova/summator/Summator.class

# Собираем основное приложение
javac -sourcepath src  -d out/app src/ru/polinaegubova/summator/Main.java

# Запускаем приложение, указывая путь к скомпилированному главному приложению out/app
# и к скомпилированной библиотеке, которая была упакована в jar
java -cp out/app:out/library/libSum.jar ru.polinaegubova.summator.Main 1 2
