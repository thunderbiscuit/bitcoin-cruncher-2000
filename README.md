# Readme

The Bitcoin Cruncher 2000 is a simple command line application that combines 4 libraries written to better understand the structures that together make bitcoin work.

The goal of the application is to put into production 4 hobby libraries that parse and validate the following:
- bitcoin transactions
- bitcoin blocks
- bitcoin scripts
- bitcoin partially signed bitcoin transactions (PSBT)

Those libraries are not released on Maven Central, and so to build this application you will need to build them yourself and publish them to your local Maven repository.

## Usage

Build and run using

```shell
just install
cd ./app/build/install/cruncher/bin/
./cruncher --help
```
