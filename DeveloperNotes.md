## What others do ... and what we do! ##

Some may wonder why we created just an other serial communication library. There are other open source/free solutions like [RxTx](http://rxtx.qbang.org/wiki/index.php/Main_Page), [jSSC](https://code.google.com/p/java-simple-serial-connector/) or [jperipheral](https://code.google.com/p/jperipheral/) available. During several projects we tried them all, in the end non of them worked properly for us. Especially when we have to deal with virtual ports, we run into serious trouble like dead locks or resource leaks or vm-crashes. So we were looking into the sources to fix some bugs we encountered. To our surprise quite a lot stuff is done on the native part, outside the safe JVM world. We came to the conclusion that this is the root-cause of our troubles we had. So we decided to kick off xidobi and implement the native part with one-to-one mappings, inspired by [Eclipse-SWT](http://www.eclipse.org/articles/Article-SWT-Design-1/SWT-Design-1.html).

![http://xidobi.googlecode.com/files/xidobi-architecture.png](http://xidobi.googlecode.com/files/xidobi-architecture.png)

<br />


---


## Implementation details ##

### Some issues with Windows ###

If you close the serial port under Windows, you have to do some extra work, to avoid starvations, deadlocks or memory access errors that can occur in some cheap serial port drivers.

With the following steps we can bypass these ugly driver bugs:

  * `CancelIo` - cancels all outstanding I/O operations
  * `PurgeComm` - discards all characters from the out- and input buffer
  * `SetCommMask` - releases the `WaitCommEvent` function. This is necessary, because the asynchronous `WaitCommEvent` doesn't return immediatly on `WAIT_FAILED` during read operations. It can cause a memory access violation error, because the resources are disposed too early or it causes starvation.

After the port is closed via `CloseHandle`, we also have to wait for the termination of the serial connection. This is neccessary, because when the close operation returns, the pending I/O operations in the background are not canceled immediatly. We must wait until all I/O operations are finished. Only then we can dispose all allocated resources in the next step. The only way to find out that all pending I/O operations are finished and the port is really closed, is to re-open the port. If it is successfull, all pending operations should be terminated.

In order to await the termination of all pending I/O operations, we just try to open the serial port again and again, until the port is not busy anymore and the port can be successfully opened.