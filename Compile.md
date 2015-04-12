## Project dependencies ##

Xidobi has no dependencies at all, it runs out of the box. If you want to run the tests or compile xidobi, simply [clone the dependency repository](https://code.google.com/p/xidobi/source/checkout?repo=dependencies), it contains the required OSGi-Bundles:

  * javax.annotation <font color='gray'>1.3.7</font>
  * org.hamcrest.core <font color='gray'>1.2.0</font>
  * org.hamcrest.integration <font color='gray'>1.2.0</font>
  * org.hamcrest.library <font color='gray'>1.2.0</font>
  * org.junit <font color='gray'>4.8.2</font>
  * org.mockito <font color='gray'>1.9.0</font>
  * org.objenesis <font color='gray'>1.2.0</font>

Just activate the target definition file in the project 'org.xidobi.master' and use it as target platform in your Eclipse IDE.

### Build xidobi ###
Building xidobi is easy as it should if you have installed eclipse with the m2e plugin. Just checkout the [default repository](https://code.google.com/p/xidobi/source/checkout) and run the launch configuration 'Xidobi Master' from the org.xidobi.master project.

If you haven't installed eclipse with the m2e plugin. You have to install Maven and checkout the [default repository](https://code.google.com/p/xidobi/source/checkout). Locate your shell at the org.xidobi.master folder and run  `mvn clean install`.

After the Maven build in both ways run sucessfull you can find the artifacts at the target folders.

### Build Dependencies ###
If you want to add or delete some external libraries just checkout the repository '[dependencies](https://code.google.com/p/xidobi/source/checkout?repo=dependencies)'.

To append some external libraries add them to the lib-folder at the 'xidobi.dependencies.osgi'-project and set _dependencies-repo.target_ as your default target platform.

Now run
"`mvn clean install -p p2dir`"
at the 'xidobi.dependencies.osgi' -project or just run the _Create Dependencie P2-Directory_ - Launchconfiguration.

If everything run well, you can add the libraries to the 'xidobi.dependencies.feature' and run
"`mvn clean install -p repo`" at the 'xidobi.dependencies.osgi'
or run the _Create Dependencie Repository.launch_-Launchconfiguration.

At the end do a commit + push and after some minutes the new libraries are available at the targetsite.

Deleting a libarie is easy just as add them. You have to delete them from the 'xidobi.dependencies.feature' and run
"`mvn clean install -p repo`" at the 'xidobi.dependencies.osgi'
or the _Create Dependencie Repository.launch_-Launchconfiguration. Do a commit + push and you are done.
## Native libraries ##

### Compile native libraries for Windows (32bit) ###

You can use the following commands to compile the shared libraries with MinGW for Windows (32bit):

```
gcc -D_JNI_IMPLEMENTATION_ -O3 -Wall -c -fmessage-length=0 -o OS_structs.o "..\\OS_structs.c" 
gcc -D_JNI_IMPLEMENTATION_ -O3 -Wall -c -fmessage-length=0 -o OS.o "..\\OS.c" 
gcc -Wl,--kill-at -shared -o org.xidobi.native.x86.win32.dll OS_structs.o OS.o 
```