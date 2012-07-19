# Mustachequerade

Just a small throw-away project I used to track the performance of my implementation of Mustache, [Stencil](http://github.com/davidsantiago/stencil). It uses Hugo Duncan's [criterium](https://github.com/hugoduncan/criterium) to do the benchmarking, taking into account JVM warmup and other statistical difficulties.

You probably want a preview of the output. 

```
Benchmarking profiles:  [:current]
======================
Goal:  Benchmark the template called main.
-----
Case:  :shenmustache
Evaluation count             : 7627500
             Execution time mean : 7.896471 us  95.0% CI: (7.896271 us, 7.896730 us)
    Execution time std-deviation : 11.396719 us  95.0% CI: (11.325538 us, 11.502207 us)
         Execution time lower ci : 7.853160 us  95.0% CI: (7.853088 us, 7.853160 us)
         Execution time upper ci : 7.948350 us  95.0% CI: (7.948350 us, 7.948677 us)

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Case:  :clostache
Evaluation count             : 122880
             Execution time mean : 485.100814 us  95.0% CI: (485.073527 us, 485.140259 us)
    Execution time std-deviation : 143.733112 us  95.0% CI: (143.086291 us, 144.504621 us)
         Execution time lower ci : 480.130859 us  95.0% CI: (480.130859 us, 480.130859 us)
         Execution time upper ci : 490.562012 us  95.0% CI: (490.562012 us, 490.563745 us)

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Case:  :stencil
Evaluation count             : 5357400
             Execution time mean : 11.229046 us  95.0% CI: (11.228219 us, 11.230155 us)
    Execution time std-deviation : 36.344916 us  95.0% CI: (35.948762 us, 37.098196 us)
         Execution time lower ci : 11.149927 us  95.0% CI: (11.149927 us, 11.149927 us)
         Execution time upper ci : 11.348348 us  95.0% CI: (11.348348 us, 11.348348 us)

Found 4 outliers in 60 samples (6.6667 %)
	low-severe	 1 (1.6667 %)
	low-mild	 3 (5.0000 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Goal:  Benchmark the template called demo.
-----
Case:  :stencil
Evaluation count             : 3618960
             Execution time mean : 16.633689 us  95.0% CI: (16.633214 us, 16.634384 us)
    Execution time std-deviation : 19.354978 us  95.0% CI: (19.074369 us, 19.563673 us)
         Execution time lower ci : 16.544532 us  95.0% CI: (16.544532 us, 16.544532 us)
         Execution time upper ci : 16.764789 us  95.0% CI: (16.764789 us, 16.766254 us)

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 3 (5.0000 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Case:  :clostache
Evaluation count             : 50640
             Execution time mean : 1.186993 ms  95.0% CI: (1.186955 ms, 1.187057 ms)
    Execution time std-deviation : 222.387488 us  95.0% CI: (219.069990 us, 225.025102 us)
         Execution time lower ci : 1.178212 ms  95.0% CI: (1.178206 ms, 1.178212 ms)
         Execution time upper ci : 1.195103 ms  95.0% CI: (1.195030 ms, 1.195103 ms)

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Case:  :shenmustache
Evaluation count             : 7463340
             Execution time mean : 8.086077 us  95.0% CI: (8.085841 us, 8.086260 us)
    Execution time std-deviation : 11.774947 us  95.0% CI: (11.635327 us, 11.860546 us)
         Execution time lower ci : 8.041925 us  95.0% CI: (8.041925 us, 8.041925 us)
         Execution time upper ci : 8.139738 us  95.0% CI: (8.139738 us, 8.139738 us)

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

```

To run this, I pulled Clostache from Clojars. Mustache.clj was unable to run, as I have updated to Clojure 1.3 and it has not yet done so.
