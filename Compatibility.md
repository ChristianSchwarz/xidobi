## Operating systems ##

We have tested xidobi on the following operating systems:

| **Operating system** | **Compatible**                                   | **Known issues**                 |
|:---------------------|:-------------------------------------------------|:---------------------------------|
| Windows 8          | <font color='gray'>not tested yet</font>       | <font color='gray'>none</font> |
| Windows 7          | <font color='green'>yes</font>**, fully tested**| <font color='gray'>none</font> |
| Windows XP         | <font color='green'>yes</font>**, fully tested**| <font color='gray'>none</font> |

## Virtual serial ports ##

We have tested xidobi with the following virtual devices and software ports.

| **Type**           | **Manufacturer-Device** |                                     | **Compatible**                              | **Operating systems** | **Known issues**                 |
|:-------------------|:------------------------|:------------------------------------|:--------------------------------------------|:----------------------|:---------------------------------|
| Serial over LAN  |  [VSCOM - NetCOM Mini](http://vscom.de/658.htm) | <img src='http://www.vscom.de/images/658_small_list.jpg' height='40' />             | <font color='green'>yes</font>| Windows 7, XP | <font color='gray'>none</font> |
| Serial over LAN  | [Lantronix - XPort](http://www.lantronix.com/support/downloads/?p=XPORT) | <img src='http://www.lantronix.com/images/IMG_xport.jpg' height='40' /> | <font color='green'>yes</font>| Windows 7, XP |<font color='gray'>none</font> |
| USB to Serial <br /><font color='gray'>Chipset: PROLIFIC PL-2303HX<font /> <table><thead><th> <a href='http://www.digitus.info/en/products/archiv/digitus-usb-to-serial-adaptor-usb-11/'>DIGITUS DA-70145</a> </th><th> <img src='http://www.digitus.info/typo3temp/pics/7319a5ee3c.jpg' height='40' /> </th><th>  <font color='orange'>limited</font><b><i><sup>1</sup></i></b></th><th> Windows 7, XP  </th><th> Sometimes blue screen under <b>Windows</b>, which is caused by a bug in the Prolific driver (please see <a href='https://code.google.com/p/xidobi/issues/detail?id=13'>issue 13</a>). </th></thead><tbody>
<tr><td> USB to Serial <br /><font color='gray'>Chipset: FTDI FT232RL<font />  </td><td> <a href='http://www.digitus.info/en/products/accessories/adapter-and-converter/usb-to-serial-adaptor-usb-20-da-70157/'>DIGITUS DA-70157</a> </td><td> <img src='http://www.digitus.info/typo3temp/pics/d64ef5bc80.jpg' height='40' /> </td><td>  <font color='orange'>limited</font><b><i><sup>1</sup></i></b></td><td> Windows 7, XP </td><td> Sometimes hangs, when the connection is closed under <b>Windows</b>, which is a bug in the FTDI driver (please see <a href='https://code.google.com/p/xidobi/issues/detail?id=14'>issue 14</a>). Unplugging the USB device usually helps. </td></tr>
<tr><td> Serial Port Emulator  </td><td> <a href='http://sourceforge.net/projects/com0com/'>com0com</a> </td><td>  </td><td> <font color='gray'>not tested yet</font>  </td><td> Windows            </td><td> <font color='gray'>none</font>   </td></tr>
<tr><td> Serial over LAN </td><td> <a href='http://sourceforge.net/projects/com0com/files/com2tcp/'>com2tcp</a> </td><td>  </td><td> <font color='gray'>not tested yet</font>  </td><td> Windows            </td><td> <font color='gray'>none</font>   </td></tr></tbody></table>

<i><sup>1</sup> Problems are related to the glitches of the drivers or various malfunctions of the devices.</i>

<br />

<hr />

<h3>We need your help!</h3>

Of course we are not able to test all devices that are available on the market. Please feel free to give us a note about devices, you use with xidobi. In order to verify their compatibility, please have a look at our <a href='Testplan.md'>testing plan</a>.