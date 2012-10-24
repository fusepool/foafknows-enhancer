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
