# MetOffice MountainArea forecasts Datapoint webservice Java client and objects.

*Or maybe a catchy name like "MaFcDpWsO-Java"*

## Java Objects

From a MetOffice DataPoint JSON output, the java objects were automatically generated.

Jackson is used heavily to shape the mapping between Java and WebService JSON.  
The object-graph is awkward, to say the least.

## Client

There's a simple client for fetching the feed

    Forecast foecast = new MichaelFish().saysFor("snowdonia", "datapoint API key");

## In the wild

It's a simple implementation, but used in production here: http://snowdon.live


   







