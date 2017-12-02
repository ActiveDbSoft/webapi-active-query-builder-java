if not exist lib mkdir lib
cd ../
mvn package -q
copy .\target\webapi.activequerybuilder-*.jar .\tests\lib\
copy .\target\lib\* .\tests\lib\
