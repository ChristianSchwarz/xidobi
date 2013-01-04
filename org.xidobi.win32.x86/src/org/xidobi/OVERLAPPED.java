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

/**
 *
 * @author Christian Schwarz
 * @author Tobias Bre�ler
 */
public class OVERLAPPED {

	// ULONG_PTR 
	long Internal;
	// ULONG_PTR 
	long InternalHigh;
	
	// __GNUC_EXTENSION union {
	// __GNUC_EXTENSION struct {
	// DWORD 
	int Offset;
	// DWORD 
	int OffsetHigh;
	// };
	// PVOID 
	int Pointer;
	// };
	
	// HANDLE 
	int hEvent;

}