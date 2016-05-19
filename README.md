# apiquery

To create the jar file and run the tests, use maven
```
mvn clean install
```

This will create a 'fat' jar with all dependencies inside the target folder, including the file:
```
apiquery-1.0-SNAPSHOT.jar
```

This project is a simple console application that loads data from public APIs.
Is configured through system properties like: 
```
java -jar -Dapi=apiname -Dmovie="movie name" apiquery-1.0-SNAPSHOT.jar
```

It does not uses command line arguments, that would be 
```
java -jar apiquery-1.0-SNAPSHOT.jar api=apiname movie="movie name"
```

It just connects to a dummy server (Please see the dummy server here: https://github.com/joaomiguelpereira/dummyhttpapi

It responds always with the same data, when the inputs are validates.


How to run:
```
java -jar -Dapi=apiname -Dmovie="movie name" apiquery-1.0-SNAPSHOT.jar
```

Outout:
```
Indiana Jones and the Last Crusade     Steven Spielberg     1989
Indiana Jones and the Temple of Doom     Steven Spielberg     1984
Indiana Jones and the Kingdom of the Crystal Skull     Steven Spielberg     2008
Indiana Jones 5     Steven Spielberg     2015
```

