# **Callable And Future**

In case of Runnable, job of the thread wont return anything after completing job

if thread required to return some result after execution then we should go for callable

Callable interface contains only one method **call**

`public Object call() throws Exception`

if we submit callable object to executor then after completing the job
thread returns an object of the type **Future**
Future object can be used to retrive the result of callable job


**Runnable**

_if thread not required to return anything after completing the job then
we should go for the Runnable

contains only one method -> run()

return type is -> void

with in run method any chance of raising checked exception complusory we should handle by try catch becuase we cannot use throws keyword for run method

Runnable -> java.lang
introduced in 1.0 version_


**Callable**

_if thread is required to return something after completing the job then we should go the callable

contains only one mehotnd -> call()

return type is -> Object

with in call method any chance of raising checked exception we are not required handle by try catch becuase call method already thrwos exception


Callable -> java.util.concurrent

introduced in 1.5 version_