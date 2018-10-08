/*******************************************************************************
 * Copyright (c) 2008, 2016, Washington University in St. Louis.
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
package main;

import java.util.ArrayList;

/**
 * @author Evan Balzuweit
 */
public class PathwayPuzzle {

	 private String name;
	 private int difficulty;
	 private int lines;
	 private int numConst;
	 private int stmtsInLock;
	 private int stmtsAfterLock;
	 private int constructsInLock;
	 private int constructsAfterLock;

	 private int nestingDepth;
	 private int unfamMethods;
	 private int structContent;
	 private int uniqueStmts;
	 private String structure;
	 private String pathwayName;

	 private int CCnt;
	 private int CbCeCnt;
	 private int CbTbCeeCnt;
	 private int CbTeCnt;
	 private int TCnt;
	 private int TbCeCnt;
	 private int TbCObTeeCnt;
	 private int TbCOeCnt;
	 private int TbObCeeCnt;
	 private int TbObTeeCnt;
	 private int TbOeCnt;

	public PathwayPuzzle(String line) {
		String[] values = line.split(",");
		
		name = values[2];
		difficulty = Integer.parseInt(values[4]);
		lines = Integer.parseInt(values[6]);
		numConst = Integer.parseInt(values[11] );
		stmtsInLock = Integer.parseInt(values[12]);
		stmtsAfterLock = Integer.parseInt(values[13]);
		constructsInLock = Integer.parseInt(values[14]);
		constructsAfterLock = Integer.parseInt(values[15]);
		
		
		 nestingDepth = Integer.parseInt(values[10]);
		 unfamMethods = Integer.parseInt(values[7]);
		 structContent = Integer.parseInt(values[8]);;
		 uniqueStmts = Integer.parseInt(values[9]);;
		 structure = values[3];
		 pathwayName = values[1];
		 
		 CCnt = Integer.parseInt(values[26]);
		 CbCeCnt = Integer.parseInt(values[27]);
		 CbTeCnt = Integer.parseInt(values[28]);
		 TCnt = Integer.parseInt(values[29]);
		 TbCeCnt = Integer.parseInt(values[30]);
		 TbCObTeeCnt = Integer.parseInt(values[31]);
		 TbCOeCnt = Integer.parseInt(values[32]);
		 TbObCeeCnt = Integer.parseInt(values[33]);
		 TbObTeeCnt = Integer.parseInt(values[34]);
		 TbOeCnt = Integer.parseInt(values[35]);
		 CbTbCeeCnt = Integer.parseInt(values[36]);
	}

	public String getName() {
		return name;
	}

	public String getDifficulty() {
		switch( difficulty ) {
		case 1:
			return "Easy";
		case 2:
			return "Easy-Medium";
		case 3:
			return "Medium";
		case 4:
			return "Medium-Hard";
		case 5:
			return "Hard";
		case 6:
			return "CHALLENGE";
		default:
			return "";
		}
	}

	public int getDifficultyAsInt() {
		return difficulty;
	}

	public int getLines() {
		return lines;
	}

	public int getConstruct() {
		return numConst;
	}

	public int getNumStmtsInLock() {
		return stmtsInLock;
	}

	public int getNumStmtsAfterLock() {
		return stmtsAfterLock;
	}

	public int getNumConstructsInLock() {
		return constructsInLock;
	}

	public int getNumConstructsAfterLock() {
		return constructsAfterLock;
	}

	public int getNestingDepth() {
		return nestingDepth;
	}

	public int getUniqueStatementsCount() {
		return uniqueStmts;
	}

	public int getUnfamiliarMethodsCount() {
		return unfamMethods;
	}

	public int getStructContent() {
		return structContent;
	}

	public String getStructure() {
		return structure;
	}
	
	public String getPathwayName() {
		return pathwayName;
	}

	public int getCCnt() {
		return CCnt;
	}

	public int getCbCeCnt() {
		return CbCeCnt;
	}

	public int getCbTbCeeCnt() {
		return CbTbCeeCnt;
	}

	public int getCbTeCnt() {
		return CbTeCnt;
	}

	public int getTCnt() {
		return TCnt;
	}

	public int getTbCeCnt() {
		return TbCeCnt;
	}

	public int getTbCObTeeCnt() {
		return TbCObTeeCnt;
	}

	public int getTbCOeCnt() {
		return TbCOeCnt;
	}

	public int getTbObCeeCnt() {
		return TbObCeeCnt;
	}

	public int getTbObTeeCnt() {
		return TbObTeeCnt;
	}

	public int getTbOeCnt() {
		return TbOeCnt;
	}

	@Override
	public String toString() {
		return name + " : " + difficulty;
	}
}
