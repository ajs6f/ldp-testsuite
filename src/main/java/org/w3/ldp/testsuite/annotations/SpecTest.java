package org.w3.ldp.testsuite.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SpecTest {

	/**
	 * Describes the status of the Test Case
	 */
	public static enum STATUS {

		/**
		 * WG_PENDING (default) - no official recommendation from the WG
		 * supporting the specification being tested by this test suite.
		 */
		WG_PENDING,

		/** WG_APPROVED - working group has approved this test case */
		WG_APPROVED,

		/** WG_DEPRECATED - no longer recommended by WG */
		WG_DEPRECATED,

		/**
		 * WG_EXTENSION - valuable test case but not part of the WG approved set
		 */
		WG_EXTENSION,

		/**
		 * WG_CLARIFICATION - requires further clarification from the working group
		 */
		WG_CLARIFICATION
	}

	;

	/**
	 * The URI of the spec
	 */
	public String specRefUri() default "No Specification URI";

	/**
	 * The status of the test case, pending or approved
	 */
	public STATUS approval() default STATUS.WG_PENDING;

	/**
	 * For reporting purposes, the way the Test Case has been implemented
	 */
	public static enum METHOD {
		/** NOT_IMPLEMENTED (default) - possible to implement, just not done */
		NOT_IMPLEMENTED,

		/** AUTOMATED - implementation complete */
		AUTOMATED,

		/** MANUAL - server test but not automated */
		MANUAL, 
		
		/** CLIENT_ONLY - test is only client-side, this test suite doesn't test it. */
		CLIENT_ONLY
	};

	/**
	 * Whether the test case itself has been implemented or not
	 */
	public METHOD testMethod() default METHOD.NOT_IMPLEMENTED;

	/**
	 * Whether further comment that can be useful
	 */
	public String comment() default "";
	
	/**
	 * Steps needed to be taken to validate the test.  For manual/client tests
	 * it specify the actions (step) what should be done to verify the result.  
	 * For automation tests, it summarized what the automated test does.
	 * @return
	 */
	public String[] steps() default {};

}
