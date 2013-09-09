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
package org.xidobi.rfc2217.internal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * Tests the class {@link ReaderImpl}.
 * 
 * @author Peter-Ren� Jeschke
 */
public class TestReaderImpl {

	@Rule
	public ExpectedException exception = none();

	private ReaderImpl reader;

	@Mock
	private InputStream input;

	@Before
	public void setup() {
		initMocks(this);
		reader = new ReaderImpl(input);
	}

	/**
	 * Expects to throw an {@link IllegalArgumentException} if the argument for the constructor is
	 * null.
	 **/
	@SuppressWarnings("unused")
	@Test
	public void new_withNull() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Argument >inputStream< must not be null!");
		new ReaderImpl(null);
	}

	/**
	 * When the input is smaller than the buffer(4096), an array with the length of the input must
	 * be returned.
	 */
	@Test
	public void read_smallerThanBuffer() throws IOException {
		when(input.read(any(byte[].class))).thenAnswer(readIntoBuffer(5));
		byte[] expectedResult = { 0, 1, 2, 3, 4 };
		assertThat(reader.read(), is(expectedResult));
	}

	/**
	 * When the input is smaller than the buffer(4096), an array with the length of the input must
	 * be returned.
	 */
	@Test
	public void read_EOS() throws IOException {
		exception.expect(IOException.class);
		exception.expectMessage("End of stream was detected while reading from TCP.");

		when(input.read(any(byte[].class))).thenAnswer(readIntoBuffer(-1));
		reader.read();
	}

	/**
	 * When the inputstream throws an {@link InterruptedIOException} while reading, the reader
	 * should forward it to the caller.
	 */
	@Test
	public void read_streamThrowsInterruptedIOException() throws IOException {
		exception.expect(InterruptedIOException.class);
		exception.expectMessage("Fatal thread interruption during read");

		when(input.read(any(byte[].class))).thenThrow(new InterruptedIOException("Fatal thread interruption during read."));

		reader.read();
	}

	/**
	 * Creates a new Answer for Mokito that reads incrementing bytes into the first argument of the
	 * method (expecting a byte-array).
	 */
	private Answer<Integer> readIntoBuffer(final int length) {
		return new Answer<Integer>() {

			public Integer answer(InvocationOnMock invocation) throws Throwable {
				byte[] buffer = (byte[]) invocation.getArguments()[0];
				for (byte i = 0; i < length; i++) {
					buffer[i] = i;
				}
				return length;
			}
		};
	}
}
