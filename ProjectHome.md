**xidobi** is a platform independant library for serial communication in Java 1.5+. It's released under the Apache 2.0 License, so it can be used and modified in open source and commercial projects.

## Goals ##

  * **clean** - no [featurits](http://en.wikipedia.org/wiki/Feature_creep), no surprises, pure and simple API
  * **proper resource management** - don't worry when a virtual port got uninstalled during an operation
  * **stability** in long running scenarios and multi threaded environments
  * **reliability** - no missing javadoc's, easy samples and tutorials to build xidobi yourself
  * **simple thread model** - don't worry about dead locks, race conditions and other synchonisation pitfalls
  * and of course **fully tested**

We want to provide _xidobi_ as a production ready solution for all aspects of serial communication.

## Motivation ##

Some may wonder why we created just an other serial communication library. There are other open source/free solutions like [RxTx](http://rxtx.qbang.org/wiki/index.php/Main_Page), [jSSC](https://code.google.com/p/java-simple-serial-connector/) or [jperipheral](https://code.google.com/p/jperipheral/) available. During several projects we tried them all, in the end non of them worked properly for us. Especially when we have to deal with virtual ports, we run into serious trouble like dead locks or resource leaks or vm-crashes. So we were looking into the sources to fix some bugs we encountered. To our surprise quite a lot stuff is done on the native part, outside the safe JVM world. We came to the conclusion that this is the root-cause of our troubles we had. So we decided to kick off xidobi and implement the native part with one-to-one mappings, inspired by [Eclipse-SWT](http://www.eclipse.org/articles/Article-SWT-Design-1/SWT-Design-1.html).

## Status ##

We have finished and testet our Windows (32bit) implementation on WinXP, Win2000 and Win7. Currently we are working on a RFC2217 / Serial over IP implementation, which is currently testet and working with VSCOM devices, as next we want to test xidobi against Lantronix devices (we currently waiting for a firmware update).

Our project is registered on <a href='https://www.ohloh.net/p/xidobi'>Ohloh</a>:

&lt;wiki:gadget url="http://www.ohloh.net/p/623310/widgets/project\_factoids\_stats.xml" height="250" width="400"  border="0"/&gt;


---


## How to communicate with us? ##

  * you can discuss about [xidobi at google-groups](http://groups.google.com/group/xidobi)
  * or [file a bug](https://code.google.com/p/xidobi/issues/list)

## We need you! ##

  * If you are a C coder you are warmly welcome to review our native implementation! Browse our source [here](https://code.google.com/p/xidobi/source/browse/#git%2Forg.xidobi.native.win32.x86).
  * We are no native english speakers, please give us a note about any typos you found!


---

<table border='0'>
<tr>
<td></td><td><wiki:gadget url="http://www.ohloh.net/p/623310/widgets/project_users_logo.xml" height="80" width="300" border="0"/></td>
</tr>
</table>