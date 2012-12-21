foafknows-enhancer
==================

This is a (so far not implemented) sample enhancer for Fusepool Stanbol platform.

The goal is to annotate a text with identifiers of foaf:Persons someone knows. You can find some sample SPARQL queries in the sparql subdirectory.

To run the sample queries you can use Dave Beckets excellent [librdf](http://librdf.org) toolchain. If you install binaries (available for all Unix-like systems, unfortunately a bit a PITA on Windows so far) you can run it like this:

    roqet -r csv foaf_name.rq

TODO
====

* fetch a given foaf profile (find examples in foaf_knows.rq)
* if you are lazy get the name from foaf:name in the foaf:knows of this profile (if available)
* but better go and fetch each of the foaf:knows and get foaf:givenname and foaf:family_name of them
* get a plain text from Stanbol
* find the found names in the text
* return the annotation to Stanbol (as identifiers), use the Ontology described at [Stanbol](https://stanbol.apache.org/docs/trunk/components/enhancer/enhancementstructure.html#fisetextannotation) for it
* check out the Stanbol [enhancer page](https://stanbol.apache.org/docs/trunk/components/enhancer/) for an introduction to the enhancers
* check out the [geonames](https://stanbol.apache.org/docs/trunk/components/enhancer/engines/geonamesengine.html) enhancer as a base for the plugin


Compile and install the bundle into the Fusepool Platform
=========================================================

Go to the root folder of the foafknows-enhancer project and run the following command
>mvn install -Dmaven.test.skip=true

If the compilation is successful you should find two jar files (bundles) within the target/ subfolder named after the artifactId and version of the project stated in the Maven pom.xml file.
We need only the bundle with the compiled files that should be demo.enhancer.engine.foafknows-01-SNAPSHOT.jar if you didn't change your pom.xml file.
To install the bundle into your Fusepool Platform instance, after you have started it, go to the console (http://localhost:8080/system/console/) select "bundles" then click on "Install/Update".
Select the bundle in your target folder from the pop-up window and then click on "Install or Update" button. You can search for your bundle from the "Bundles" page of the console and applying a filter such as "foaf".
You can start the bundle by clicking the start icon in the action menu. 
