/*
 * Copyright 2013 Gemtec GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xidobi;

import java.io.IOException;

/**
 * Interface for serial port handles.
 * 
 * @author Christian Schwarz
 * @author Tobias Bre�ler
 */
public interface SerialPortHandle {

	/**
	 * Opens a serial port with the given control settings and returns the connected serial port.
	 * 
	 * @param portName
	 *            the name of the port to be open, must not be <code>null</code>
	 * @param settings
	 *            the control settings for the port, must not be <code>null</code>
	 * @return a connected serial port, never <code>null</code>
	 * @throws IOException
	 *             if the port cannot be opened
	 */
	SerialPort open(String portName, SerialPortSettings settings) throws IOException;
}
