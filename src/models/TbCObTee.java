/*******************************************************************************
* Copyright (c) 2008, 2018, Washington University in St. Louis.
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*
* 1. Redistributions of source code must retain the above copyright notice,
*    this list of conditions and the following disclaimer.
*
* 2. Redistributions in binary form must reproduce the above copyright notice,
*    this list of conditions and the following disclaimer in the documentation
*    and/or other materials provided with the distribution.
*
* 3. Products derived from the software may not be called "Looking Glass", nor
*    may "Looking Glass" appear in their name, without prior written permission
*    of Washington University in St. Louis.
*
* 4. All advertising materials mentioning features or use of this software must
*    display the following acknowledgement: "This product includes software
*    developed by Washington University in St. Louis"
*
* 5. The gallery of art assets and animations provided with this software is
*    contributed by Electronic Arts Inc. and may be used for personal,
*    non-commercial, and academic use only. Redistributions of any program
*    source code that utilizes The Sims 2 Assets must also retain the copyright
*    notice, list of conditions and the disclaimer contained in
*    The Alice 3.0 Art Gallery License.
*
* DISCLAIMER:
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.  ANY AND ALL
* EXPRESS, STATUTORY OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
* IMPLIED WARRANTIES OF MERCHANTABILITY,  FITNESS FOR A PARTICULAR PURPOSE,
* TITLE, AND NON-INFRINGEMENT ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHORS,
* COPYRIGHT OWNERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
* INCIDENTAL, SPECIAL, EXEMPLARY, PUNITIVE OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING FROM OR OTHERWISE RELATING TO
* THE USE OF OR OTHER DEALINGS WITH THE SOFTWARE, EVEN IF ADVISED OF THE
* POSSIBILITY OF SUCH DAMAGE.
*******************************************************************************/
package models;

import main.PathwayPuzzle;
import main.PathwayUser;
import java.util.Collections;
import java.util.Arrays;

/**
* @author Wint Hnin
*/
public class TbCObTee{
	PathwayPuzzle puzzle;
 	PathwayUser user;

	public float getProb( PathwayPuzzle puzzle, PathwayUser user ) {
		this.puzzle = puzzle;
		this.user = user;

		int class_prediction = 0;
		class_prediction += TR0();
		class_prediction += TR1();
		class_prediction += TR2();
		class_prediction += TR3();
		class_prediction += TR4();
		class_prediction += TR5();
		class_prediction += TR6();
		class_prediction += TR7();
		class_prediction += TR8();
		class_prediction += TR9();

		return (float) (class_prediction/10.0);
	}

	private int findMaxIndex( int[] array ) { 
		int max = array[ 0 ];
		int maxIndex = 0;
		for( int i = 1; i < array.length; i++ ) {
			if( array[ i ] > max ) {
				max = array[ i ];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private int TR0() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		values = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 6 };
		return findMaxIndex(values);
	}

}