# Mustachequerade

Just a small throw-away project I used to track the performance of my implementation of Mustache, [Stencil](http://github.com/davidsantiago/stencil).

You probably want a preview of the output. Here's three successive warmed up runs.

    user> (run-main-bench)
    Stencil main.mustache, 10000x: 
    "Elapsed time: 505.366 msecs"
    Clostache main.mustache, 10000x: 
    "Elapsed time: 8294.005 msecs"
    Mustache.clj main.mustache, 10000x:
    "Elapsed time: 1396.226 msecs"
    nil
    user> (run-main-bench)
    Stencil main.mustache, 10000x: 
    "Elapsed time: 735.05 msecs"
    Clostache main.mustache, 10000x: 
    "Elapsed time: 8180.648 msecs"
    Mustache.clj main.mustache, 10000x:
    "Elapsed time: 1324.391 msecs"
    nil
    user> (run-main-bench)
    Stencil main.mustache, 10000x: 
    "Elapsed time: 458.74 msecs"
    Clostache main.mustache, 10000x: 
    "Elapsed time: 8451.024 msecs"
    Mustache.clj main.mustache, 10000x:
    "Elapsed time: 1580.605 msecs"
    nil    

To run this, I pulled Clostache from Clojars and manually installed Mustache.clj.
