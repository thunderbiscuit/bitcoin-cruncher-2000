# Readme
This is a simple template to kickstart new Kotlin-based cli projects.

It uses Clikt 4.2.1 and Kotlin 1.9.20, and produces a JVM-based cli.

Build for testing and run using
```shell
./gradlew installDist
./build/install/templatecliapp/bin/templatecliapp
```

Build and install to custom location using
```shell
./gradlew distTar
cd build/distributions
tar --extract --verbose --file templatecliapp-0.1.0-SNAPSHOT.tar -C ~/targetdirectory/
```

From there you can run the application using 
```shell
~/targetdirectory/templatecliapp-0.1.0-SNAPSHOT/bin/templatecliapp
```
