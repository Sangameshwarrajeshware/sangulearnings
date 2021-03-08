# **Callable And Future**

In case of Runnable job thread wont return anything after completing job

if thread required to return some result after execution then we should go callable

Callble interface contains only one method **call**

`public Object call() throws Exception`

if we submit callable object to executor then after completing the job
thread returns an object of the type **Future**
Future object can be used to retrive the result of callable job