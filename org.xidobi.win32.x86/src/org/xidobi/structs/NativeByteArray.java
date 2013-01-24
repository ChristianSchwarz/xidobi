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
package org.xidobi.structs;

import static org.xidobi.internal.Preconditions.checkArgument;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import org.xidobi.WinApi;

/**
 * Java representation of a byte array in C.
 * 
 * @author Tobias Bre�ler
 */
public class NativeByteArray extends Pointer {

	/** the size of the native byte array */
	private final int length;

	/**
	 * Creates a new byte array instance on the heap. The instance must be disposed, when it isn't
	 * used anymore.
	 * 
	 * @param win
	 *            the native Win32-API, must not be <code>null</code>
	 * @param length
	 *            the size of the native byte array, must be greater than 0
	 */
	public NativeByteArray(	@Nonnull WinApi win,
							@Nonnegative int length) {
		super(win, length);
		this.length = length;
	}

	/**
	 * Returns the size of the native byte array.
	 * 
	 * @return size of byte array
	 */
	public int length() {
		checkIfDisposed();
		return length;
	}

	public byte[] getByteArray() {
		return getByteArray(length);
	}

	public byte[] getByteArray(int size) {
		checkArgument(size > 0, "size", "Expected a value greater than 0");
		checkArgument(size <= length, "size", "Expected a value lesser than or equal to length");
		checkIfDisposed();
		return getWinApi().getByteArray(this, size);
	}

}
