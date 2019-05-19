# Signing log files

This repository contains source code of the solution for signing log files using hash trees.

## Getting started

Follow these instructions to build and run the application.

### Prerequisites

Requires only Java JDK version 8.

To check, run:

```
$ java -version
openjdk version "1.8.0_181"
```

### Building and running

You can install dependencies with the included Maven Wrapper:

```
$ ./mvnw clean install
```

It is also possible to build executable Java Archive, to build run Maven `clean package` task:

```
$ ./mvnw clean package
```

this results in `signing-log-files.jar` file in the `target` directory.

To run the built archive:

```
$ java -jar ./target/signing-log-files.jar
```

### Example of use

```
List<String> entries = Files.readAllLines(Paths.get("src/main/resources/small_log.txt"));

HashTree hashTree = HashTreeBuilder.build(entries);
List<Node> hashChain = HashChainBuilder.build(hashTree, "[INFO] No tests to run.");
```
