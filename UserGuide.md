## Get the serial port ##

Before you can start writing and reading data, you must get the desired serial port. There are two ways to get a serial port:

**1. Find all available ports on the system:**

```
SerialPortProvider finder = SerialPortProvider.getSerialPortFinder();
Set<SerialPort> availablePorts = finder.getAll();
```

You will get a `Set` with all available serial ports that are installed on the system. It also includes ports that are currently busy.

**2. Get a well-known port on the system:**

```
SerialPortProvider finder = SerialPortProvider.getSerialPortFinder();
SerialPort port = finder.get("COM1");
```

You will get the desired port or `null`, if such a serial port is not installed on the system.

## Open a serial connection ##

To open a connection to the serial port, just call:

```
SerialConnection connection = port.open(settings);
```

In order to comunicate with a serial port you have to setup baud rate, data bits, stop bits and so on. With xidobi it is very easy to setup your serial connection. You just have to configure the parameters that you need:

```
SerialPortSettings settings = SerialPortSettings
                                .from9600bauds8N1()
                                .create();
```

This code will result in a serial port setting with the following values:

  * baud rate = 9600 (_default_)
  * data bits = 8 (_default_)
  * stop bits = 1 (_default_)
  * parity = none (_default_)
  * flow control = none (_default_)
  * RTS = true (_default_)
  * DTR = true (_default_)

If you want to setup more parameters, then just add them:

```
SerialPortSettings settings = SerialPortSettings
                                .from9600bauds8N1()
                                .bauds(1200)
                                .set(DATABITS_6)
                                .set(PARITY_SPACE)
                                .create();
```

This will result in a serial port setting with the following values:

  * baud rate = 1200 (_as configured_)
  * data bits = 6 (_as configured_)
  * stop bits = 1 (_default_)
  * parity = space (_as configured_)
  * flow control = none (_default_)
  * RTS = true (_default_)
  * DTR = true (_default_)

## Write data to serial port ##

After you have successfully established a connection, you are able to write data to that serial port:

```
byte[] data = ... ; // the data that should be written to the serial port
connection.write(data);
```

The method will return, after all data was written to the port. If an I/O error occurs, an `IOException` will be thrown.

## Read data from serial port ##

In order to read data from the serial port, you can call:

```
byte[] readData = connection.read();
```

This method blocks until at least one byte can be returned or an I/O error occurs.

## Close the serial connection ##

To close the serial connection, just call:

```
connection.close();
```

<br />


---


