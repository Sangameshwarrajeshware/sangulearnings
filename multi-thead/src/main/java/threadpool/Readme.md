# **Thread Pool or Executor Service**

Creating new Thread for every job creates **performance and memory problems** to overcome this we should go for the Thread Pool

Thread pool is pool of already created threads and ready to do our job 

Java 1.5 introduced thread pool framework to implements 

Thread pool frame work also called executor Framework

`

ExecutorServie service = Executors.newFixedThreadPool(5);

service.submit(job) ; // submit jobs

servie.shutdown(); // to shutdown the service
`
_while desinging web servers and applications servers we can use Thread Pool concept_

