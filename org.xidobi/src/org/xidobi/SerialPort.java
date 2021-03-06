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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.WillCloseWhenClosed;

/**
 * Interface for serial port handles.
 * 
 * @author Christian Schwarz
 * @author Tobias Bre�ler
 */
public interface SerialPort {

	/**
	 * Opens a serial port with the given control settings and returns the connected serial port.
	 * <p>
	 * <b>IMPORTANT:</b> The returned {@link SerialConnection} must be closed, when it is not used
	 * anymore! Otherwise the port stays open!
	 * 
	 * @param settings
	 *            the control settings for the port, must not be <code>null</code>
	 * @return a connected serial port, never <code>null</code>
	 * @throws IOException
	 *             if the port cannot be opened
	 */
	@WillCloseWhenClosed
	SerialConnection open(@Nonnull SerialPortSettings settings) throws IOException;

	/**
	 * Returns the name of this port, for example "COM1".
	 * 
	 * @return the port name, not <code>null</code>
	 */
	@Nonnull
	String getPortName();

	/**
	 * Returns the additional description for the serial port.
	 * 
	 * @return the description for the serial port, can be <code>null</code> if no description is
	 *         available
	 */
	@Nullable
	String getDescription();

}
