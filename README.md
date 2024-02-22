В проекте используются:
Java 17
Gradle 8.5

Для обработки командной строки используется библиотека args4j. https://github.com/kohsuke/args4j
implementation group: 'args4j',    name: 'args4j',         version: '2.33'
implementation group: 'args4j',    name: 'args4j-site',    version: '2.33'


Запуск командой:
java -jar shiftTest-1.0-SNAPSHOT.jar -s -a -p sample- in1.txt in2.txt
