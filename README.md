# Array task, part I

An entity that wraps an `int` array, services (min/max, sum, average, two sorting
algorithms) and a file-based pipeline: reader -> validator -> parser -> factory.

## Requirements

* JDK 17 or newer
* Maven 3.9 or newer

## Commands

    mvn test                 # run unit tests
    mvn compile exec:java    # run the application

The application reads `data/arrays.txt` and writes logs to the console
and to `logs/application.log`.
