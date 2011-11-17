# Mustachequerade

Just a small throw-away project I used to track the performance of my implementation of Mustache, [Stencil](http://github.com/davidsantiago/stencil).

You probably want a preview of the output. Here's three successive warmed up runs.

    user=> (run-main-bench)
    Stencil main.mustache, 10000x: 
    "Elapsed time: 377.229 msecs"
    Clostache main.mustache, 10000x: 
    "Elapsed time: 4587.026 msecs"
    nil
    user=> (run-main-bench)
    Stencil main.mustache, 10000x: 
    "Elapsed time: 335.105 msecs"
    Clostache main.mustache, 10000x: 
    "Elapsed time: 4295.729 msecs"
    nil
    user=> (run-main-bench)
    Stencil main.mustache, 10000x: 
    "Elapsed time: 346.525 msecs"
    Clostache main.mustache, 10000x: 
    "Elapsed time: 4349.989 msecs"
    nil

To run this, I pulled Clostache from Clojars. Mustache.clj was unable to run, as I have updated to Clojure 1.3 and it has not yet done so.
