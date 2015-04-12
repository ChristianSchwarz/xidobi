## Test cases ##

The following cases are tested:

  * find available serial ports
  * connect to serial port
  * disconnect from serial port
  * write data to serial port
  * disconnect port during write operation
  * read data from serial port
  * disconnect port during read operation
  * permanent open, read, write and close

For **virtual serial port devices** (like USB to serial converters) the following cases are tested:

  * disconnect hardware during read operation
  * disconnect hardware during write operation

All test cases should be executed repeatedly and for at least a week. Only then we can make sure that the given serial port device and operating system is compatible with xidobi.

Please feel free to contribute your test results to our [compatibility list](Compatibility.md).