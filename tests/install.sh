#!/bin/sh

mkdir -p lib
cd ../
mvn package -q
cp ./target/webapi.activequerybuilder-*.jar ./tests/lib/
cp ./target/lib/* ./tests/lib/
