# **Thread Local**

Thread Local class provides thread local variables. Thread Local class maintains values per thread
basis. each thread local object maintains seperate value like Userid , Transanction id etc.. For
each thread that accesses object. Thread can access its local value, can manipulate its value and
even can it can remove its value

Every part of code which is executed by thread we can access its local variable

Consider Servelet which invokes some business methods. We have requirement to generate a unique
transanction id for each and every request and we have pass this transanction id to business methods
for this requirement we can use thread local to maintain seperate transanction id for every request
i.e every thread

**NOTE**

Thread Local 1.2 version and enhanced in 1.5 version.Thread Local can be associated with thread
scope. Total code which is executed by thread has access to corresponding thread thread can access
its own local variables and cannot access other thread local variables.

once thread entered into dead states all its local variables by default eligible for the garbage
collection

**Constructor**

`ThreadLocal tl = new ThreadLocal();`

Methods

`Object get();` --> return value of thread local variable associated with current thread.

`Object initialValue():` --> returns initial value of thread local variable associated with current
thread.

The default implmentaion of above method returns null. to cusomized our own initialize value we have
overrride this method.

`void set(Object value);`

`void remove();` to remove value of thread local variable associated with current thead. newly added
in 1.5 .

**ThreadLocal Vs Inheritance**

Parent Threads thread local varialbe by default will not available to the child threads.if we want
to make parent threads thread local variable value available to child threads then we should go for
the InheritableThreadLocal class

By default child trhead value exaclty same as parent thread value but we can provide customized
value by overrriding childValue method

Constructor

`InheritableThreadLocal l = new InheritableThreadLocal();`

method -> `childValue()`

