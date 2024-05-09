@default:
  just --list

install:
  ./gradlew installDist

run:
  ./app/build/install/cruncher/bin/cruncher
