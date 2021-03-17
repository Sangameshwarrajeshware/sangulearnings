

    for (int i=100;i<108;i++){
      int id=i;
      new Thread(()-> {
        String birthDate = new UserServiceWithTenTheads().birthDate(id);
        System.out.println(birthDate);
      }).start();
    }

In above Example if we try with 1000 threads. it consumes lot of memory so we should go with ThreadPool concept

the above code will generate for 1000 task it will create 1000 SimpleDateFormat Object



    for (int i = 100; i < 1200; i++) {
      int id = i;
      threadPool.submit(
          () -> {
            String date = new UserServiceUsingThreadPool().birthDate(id);
            System.out.println(date);
          });
    }

Submitting the 1000 task to threadpool of having 10 threads


`private static final SimpleDateFormat simpleDateFormat 
= new SimpleDateFormat("yyyy-MM-dd");`

Making SimpleDateFormat Global instead of creating new 1000 objects

But All threads will have access to same global object and leads to 
not thread safe which will have DataIntegrity issue

One solution can making use of Lock.

if we put into Synchronized block then it will be thread safe
but this leads to slow down of the application

The other Good solution will making ThreadLocal. 
The Variable Specific to the one thread is called ThreadLocal.
Each Thead will have their local copy of it.

if we have 10 threads then 10 simpledatefromat object will have. 
if we assign 1000 task also the variable remains same.

ThreadLocal : Per thread local instances for memory efficiency and thread safety.



    

