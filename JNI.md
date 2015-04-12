## Generating C headers ##

To generate the header files from your Java class, you must run the following command in your shell:

```
 javah -jni org.xidobi.OS
```

## Enable verbose mode in JVM ##

Just add the following value to your VM arguments.

```
 -verbose:jni
```