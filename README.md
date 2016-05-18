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


