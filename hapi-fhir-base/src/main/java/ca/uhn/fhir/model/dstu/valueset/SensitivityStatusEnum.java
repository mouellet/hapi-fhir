
package ca.uhn.fhir.model.dstu.valueset;

/*
 * #%L
 * HAPI FHIR - Core Library
 * %%
 * Copyright (C) 2014 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum SensitivityStatusEnum {

	/**
	 * Code Value: <b>suspected</b>
	 *
	 * A suspected sensitivity to a substance.
	 */
	SUSPECTED("suspected", "http://hl7.org/fhir/sensitivitystatus"),
	
	/**
	 * Code Value: <b>confirmed</b>
	 *
	 * The sensitivity has been confirmed and is active.
	 */
	CONFIRMED("confirmed", "http://hl7.org/fhir/sensitivitystatus"),
	
	/**
	 * Code Value: <b>refuted</b>
	 *
	 * The sensitivity has been shown to never have existed.
	 */
	REFUTED("refuted", "http://hl7.org/fhir/sensitivitystatus"),
	
	/**
	 * Code Value: <b>resolved</b>
	 *
	 * The sensitivity used to exist but no longer does.
	 */
	RESOLVED("resolved", "http://hl7.org/fhir/sensitivitystatus"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/sensitivitystatus
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/sensitivitystatus";

	/**
	 * Name for this Value Set:
	 * SensitivityStatus
	 */
	public static final String VALUESET_NAME = "SensitivityStatus";

	private static Map<String, SensitivityStatusEnum> CODE_TO_ENUM = new HashMap<String, SensitivityStatusEnum>();
	private static Map<String, Map<String, SensitivityStatusEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, SensitivityStatusEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (SensitivityStatusEnum next : SensitivityStatusEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, SensitivityStatusEnum>());
			}
			SYSTEM_TO_CODE_TO_ENUM.get(next.getSystem()).put(next.getCode(), next);			
		}
	}
	
	/**
	 * Returns the code associated with this enumerated value
	 */
	public String getCode() {
		return myCode;
	}
	
	/**
	 * Returns the code system associated with this enumerated value
	 */
	public String getSystem() {
		return mySystem;
	}
	
	/**
	 * Returns the enumerated value associated with this code
	 */
	public SensitivityStatusEnum forCode(String theCode) {
		SensitivityStatusEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<SensitivityStatusEnum> VALUESET_BINDER = new IValueSetEnumBinder<SensitivityStatusEnum>() {
		@Override
		public String toCodeString(SensitivityStatusEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(SensitivityStatusEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public SensitivityStatusEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public SensitivityStatusEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, SensitivityStatusEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	SensitivityStatusEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
