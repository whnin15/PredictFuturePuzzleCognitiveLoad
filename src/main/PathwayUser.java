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
 * @author Wint Hnin
 */
public class PathwayUser {
	
	public String username;
	public String puzzle;
	public double allTbObTee;
	public double lastThreeTbObTee;
	public double allCbTe;
	public double lastThreeCbTe;
	public double allC;
	public double lastThreeC;
	public double allT;
	public double lastThreeT;
	public double allCbCe;
	public double lastThreeCbCe;
	public double allTbCe;
	public double lastThreeTbCe;
	public double allTbCOe;
	public double lastThreeTbCOe;
	public double allTbObCee;
	public double lastThreeTbObCee;
	public double allCbTbCee;
	public double lastThreeCbTbCee;
	public double allTbCObTee;
	public double lastThreeTbCObTee;
	public double allTbOe;
	public double lastThreeTbOe;
	public int structureQuits;
	public int structureConsectiveQuits;
	public double all_cogLoad;
	public double str_cogLoadAvg;
	public double str_numAttemptsAvg;
	public double str_changeInScoreAvg;
	public double str_numAttemptsConstructErrorsAvg;
	public double str_changeInConstructScoreAvg;
	public double str_postRefPlayScoreAvg;
	public double str_numAttemptsOfdoTogetherRearrangementsAvg;
	public double str_numAttemptsOfoneOrZeroInDoTAvg;
	public double str_numAttemptsWithoutOrderingBoxAvg;
	public double str_constructReverseUsageAvg;
	public double str_countsOfPlayConsecutivelyAvg;
	public double str_countsOfPlayPuzConsecutivelyAvg;
	public double str_countsOfPlayRefConsecutivelyAvg;
	public double str_countsOfPlayRatioAvg;
	public int str_noRefPlayedBoolean;
	public double str_numRepeatedErrorWithInsertionsAvg;
	public double str_numCorrectedFirstWrongIndexAvg;
	public double str_numReducedFirstWrongIndexAvg;
	public double str_numRepeatedFirstWrongStmtAvg;
	public double str_numMoveSameStmtConsecutivelyAvg;
	public double str_numPlaySameSetAvg;
	public double str_numCorrectButNotPlayedAvg;
	public double str_numResetAvg;
	public double str_numStepsAvg;
	public double str_numStepsDecCorrectInOrderingBoxAvg;
	public double str_numStepsSeparatedNestsAvg;
	public double str_numStmtsInLockAvg;
	public double str_numConstructsInLockAvg;
	public double str_numStmtsAfterLockAvg;
	public double str_numConstructsAfterLockAvg;
	public double str_nestingDepthAvg;
	public double str_unfamMethodsAvg;
	public double str_structContentAvg;
	public double str_uniqueStmtsAvg;
	public double str_CCntAvg;
	public double str_CbCeCntAvg;
	public double str_CbTbCeeCntAvg;
	public double str_CbTeCntAvg;
	public double str_TCntAvg;
	public double str_TbCeCntAvg;
	public double str_TbCObTeeCntAvg;
	public double str_TbCOeCntAvg;
	public double str_TbObCeeCntAvg;
	public double str_TbObTeeCntAvg;
	public double str_TbOeCntAvg;
	public double notStr_cogLoadAvg;
	public double notStr_numAttemptsAvg;
	public double notStr_changeInScoreAvg;
	public double notStr_numAttemptsConstructErrorsAvg;
	public double notStr_changeInConstructScoreAvg;
	public double notStr_postRefPlayScoreAvg;
	public double notStr_numAttemptsOfdoTogetherRearrangementsAvg;
	public double notStr_numAttemptsOfoneOrZeroInDoTAvg;
	public double notStr_numAttemptsWithoutOrderingBoxAvg;
	public double notStr_constructReverseUsageAvg;
	public double notStr_countsOfPlayConsecutivelyAvg;
	public double notStr_countsOfPlayPuzConsecutivelyAvg;
	public double notStr_countsOfPlayRefConsecutivelyAvg;
	public double notStr_countsOfPlayRatioAvg;
	public int notStr_noRefPlayedBoolean;
	public double notStr_numRepeatedErrorWithInsertionsAvg;
	public double notStr_numCorrectedFirstWrongIndexAvg;
	public double notStr_numReducedFirstWrongIndexAvg;
	public double notStr_numRepeatedFirstWrongStmtAvg;
	public double notStr_numMoveSameStmtConsecutivelyAvg;
	public double notStr_numPlaySameSetAvg;
	public double notStr_numCorrectButNotPlayedAvg;
	public double notStr_numResetAvg;
	public double notStr_numStepsAvg;
	public double notStr_numStepsDecCorrectInOrderingBoxAvg;
	public double notStr_numStepsSeparatedNestsAvg;
	public double notStr_numStmtsInLockAvg;
	public double notStr_numConstructsInLockAvg;
	public double notStr_numStmtsAfterLockAvg;
	public double notStr_numConstructsAfterLockAvg;
	public double notStr_nestingDepthAvg;
	public double notStr_unfamMethodsAvg;
	public double notStr_structContentAvg;
	public double notStr_uniqueStmtsAvg;
	public double notStr_CCntAvg;
	public double notStr_CbCeCntAvg;
	public double notStr_CbTbCeeCntAvg;
	public double notStr_CbTeCntAvg;
	public double notStr_TCntAvg;
	public double notStr_TbCeCntAvg;
	public double notStr_TbCObTeeCntAvg;
	public double notStr_TbCOeCntAvg;
	public double notStr_TbObCeeCntAvg;
	public double notStr_TbObTeeCntAvg;
	public double notStr_TbOeCntAvg;
	public double lastThree_cogLoadAvg;
	public double lastThree_numAttemptsAvg;
	public double lastThree_changeInScoreAvg;
	public double lastThree_numAttemptsConstructErrorsAvg;
	public double lastThree_changeInConstructScoreAvg;
	public double lastThree_postRefPlayScoreAvg;
	public double lastThree_numAttemptsOfdoTogetherRearrangementsAvg;
	public double lastThree_numAttemptsOfoneOrZeroInDoTAvg;
	public double lastThree_numAttemptsWithoutOrderingBoxAvg;
	public double lastThree_constructReverseUsageAvg;
	public double lastThree_countsOfPlayConsecutivelyAvg;
	public double lastThree_countsOfPlayPuzConsecutivelyAvg;
	public double lastThree_countsOfPlayRefConsecutivelyAvg;
	public double lastThree_countsOfPlayRatioAvg;
	public int lastThree_noRefPlayedBoolean;
	public double lastThree_numRepeatedErrorWithInsertionsAvg;
	public double lastThree_numCorrectedFirstWrongIndexAvg;
	public double lastThree_numReducedFirstWrongIndexAvg;
	public double lastThree_numRepeatedFirstWrongStmtAvg;
	public double lastThree_numMoveSameStmtConsecutivelyAvg;
	public double lastThree_numPlaySameSetAvg;
	public double lastThree_numCorrectButNotPlayedAvg;
	public double lastThree_numResetAvg;
	public double lastThree_numStepsAvg;
	public double lastThree_numStepsDecCorrectInOrderingBoxAvg;
	public double lastThree_numStepsSeparatedNestsAvg;
	public double lastThree_numStmtsInLockAvg;
	public double lastThree_numConstructsInLockAvg;
	public double lastThree_numStmtsAfterLockAvg;
	public double lastThree_numConstructsAfterLockAvg;
	public double lastThree_nestingDepthAvg;
	public double lastThree_unfamMethodsAvg;
	public double lastThree_structContentAvg;
	public double lastThree_uniqueStmtsAvg;
	public double lastThree_CCntAvg;
	public double lastThree_CbCeCntAvg;
	public double lastThree_CbTbCeeCntAvg;
	public double lastThree_CbTeCntAvg;
	public double lastThree_TCntAvg;
	public double lastThree_TbCeCntAvg;
	public double lastThree_TbCObTeeCntAvg;
	public double lastThree_TbCOeCntAvg;
	public double lastThree_TbObCeeCntAvg;
	public double lastThree_TbObTeeCntAvg;
	public double lastThree_TbOeCntAvg;
	public double last_cogLoadAvg;
	public double last_numAttemptsAvg;
	public double last_changeInScoreAvg;
	public double last_numAttemptsConstructErrorsAvg;
	public double last_changeInConstructScoreAvg;
	public double last_postRefPlayScoreAvg;
	public double last_numAttemptsOfdoTogetherRearrangementsAvg;
	public double last_numAttemptsOfoneOrZeroInDoTAvg;
	public double last_numAttemptsWithoutOrderingBoxAvg;
	public double last_constructReverseUsageAvg;
	public double last_countsOfPlayConsecutivelyAvg;
	public double last_countsOfPlayPuzConsecutivelyAvg;
	public double last_countsOfPlayRefConsecutivelyAvg;
	public double last_countsOfPlayRatioAvg;
	public int last_noRefPlayedBoolean;
	public double last_numRepeatedErrorWithInsertionsAvg;
	public double last_numCorrectedFirstWrongIndexAvg;
	public double last_numReducedFirstWrongIndexAvg;
	public double last_numRepeatedFirstWrongStmtAvg;
	public double last_numMoveSameStmtConsecutivelyAvg;
	public double last_numPlaySameSetAvg;
	public double last_numCorrectButNotPlayedAvg;
	public double last_numResetAvg;
	public double last_numStepsAvg;
	public double last_numStepsDecCorrectInOrderingBoxAvg;
	public double last_numStepsSeparatedNestsAvg;
	public double last_numStmtsInLockAvg;
	public double last_numConstructsInLockAvg;
	public double last_numStmtsAfterLockAvg;
	public double last_numConstructsAfterLockAvg;
	public double last_nestingDepthAvg;
	public double last_unfamMethodsAvg;
	public double last_structContentAvg;
	public double last_uniqueStmtsAvg;
	public double last_CCntAvg;
	public double last_CbCeCntAvg;
	public double last_CbTbCeeCntAvg;
	public double last_CbTeCntAvg;
	public double last_TCntAvg;
	public double last_TbCeCntAvg;
	public double last_TbCObTeeCntAvg;
	public double last_TbCOeCntAvg;
	public double last_TbObCeeCntAvg;
	public double last_TbObTeeCntAvg;
	public double last_TbOeCntAvg;

	public PathwayUser(String row) {
		String[] values = row.split(",");
		username = values[1];
		puzzle = values[2];
		allTbObTee = Double.parseDouble(values[3].trim()); 
		lastThreeTbObTee = Double.parseDouble(values[4].trim());
		allCbTe = Double.parseDouble(values[5].trim());
		lastThreeCbTe = Double.parseDouble(values[6].trim());
		allC = Double.parseDouble(values[7].trim());
		lastThreeC = Double.parseDouble(values[8].trim());
		allT = Double.parseDouble(values[9].trim());
		lastThreeT = Double.parseDouble(values[10].trim());
		allCbCe = Double.parseDouble(values[11].trim());
		lastThreeCbCe = Double.parseDouble(values[12].trim());
		allTbCe = Double.parseDouble(values[13].trim());
		lastThreeTbCe = Double.parseDouble(values[14].trim());
		allTbCOe = Double.parseDouble(values[15].trim());
		lastThreeTbCOe = Double.parseDouble(values[16].trim());
		allTbObCee = Double.parseDouble(values[17].trim());
		lastThreeTbObCee = Double.parseDouble(values[18].trim());
		allCbTbCee = Double.parseDouble(values[19].trim());
		lastThreeCbTbCee = Double.parseDouble(values[20].trim());
		allTbCObTee = Double.parseDouble(values[21].trim());
		lastThreeTbCObTee = Double.parseDouble(values[22].trim());
		allTbOe = Double.parseDouble(values[23].trim());
		lastThreeTbOe = Double.parseDouble(values[24].trim());
		structureQuits = Integer.parseInt(values[26].trim());
		structureConsectiveQuits = Integer.parseInt(values[27].trim());
		all_cogLoad = Double.parseDouble(values[47].trim());
		str_cogLoadAvg = Double.parseDouble(values[48].trim());
		str_numAttemptsAvg = Double.parseDouble(values[49].trim());
		str_changeInScoreAvg = Double.parseDouble(values[50].trim());
		str_numAttemptsConstructErrorsAvg = Double.parseDouble(values[51].trim());
		str_changeInConstructScoreAvg = Double.parseDouble(values[52].trim());
		str_postRefPlayScoreAvg = Double.parseDouble(values[53].trim());
		str_numAttemptsOfdoTogetherRearrangementsAvg = Double.parseDouble(values[54].trim());
		str_numAttemptsOfoneOrZeroInDoTAvg = Double.parseDouble(values[55].trim());
		str_numAttemptsWithoutOrderingBoxAvg = Double.parseDouble(values[56].trim());
		str_constructReverseUsageAvg = Double.parseDouble(values[57].trim());
		str_countsOfPlayConsecutivelyAvg = Double.parseDouble(values[58].trim());
		str_countsOfPlayPuzConsecutivelyAvg = Double.parseDouble(values[59].trim());
		str_countsOfPlayRefConsecutivelyAvg = Double.parseDouble(values[60].trim());
		str_countsOfPlayRatioAvg = Double.parseDouble(values[61].trim());
		str_noRefPlayedBoolean = Integer.parseInt(values[62].trim());
		str_numRepeatedErrorWithInsertionsAvg = Double.parseDouble(values[63].trim());
		str_numCorrectedFirstWrongIndexAvg = Double.parseDouble(values[64].trim());
		str_numReducedFirstWrongIndexAvg = Double.parseDouble(values[65].trim());
		str_numRepeatedFirstWrongStmtAvg = Double.parseDouble(values[66].trim());
		str_numMoveSameStmtConsecutivelyAvg = Double.parseDouble(values[67].trim());
		str_numPlaySameSetAvg = Double.parseDouble(values[68].trim());
		str_numCorrectButNotPlayedAvg = Double.parseDouble(values[69].trim());
		str_numResetAvg = Double.parseDouble(values[70].trim());
		str_numStepsAvg = Double.parseDouble(values[71].trim());
		str_numStepsDecCorrectInOrderingBoxAvg = Double.parseDouble(values[72].trim());
		str_numStepsSeparatedNestsAvg = Double.parseDouble(values[73].trim());
		str_numStmtsInLockAvg = Double.parseDouble(values[74].trim());
		str_numConstructsInLockAvg = Double.parseDouble(values[75].trim());
		str_numStmtsAfterLockAvg = Double.parseDouble(values[76].trim());
		str_numConstructsAfterLockAvg = Double.parseDouble(values[77].trim());
		str_nestingDepthAvg = Double.parseDouble(values[78].trim());
		str_unfamMethodsAvg = Double.parseDouble(values[79].trim());
		str_structContentAvg = Double.parseDouble(values[80].trim());
		str_uniqueStmtsAvg = Double.parseDouble(values[81].trim());
		str_CCntAvg = Double.parseDouble(values[82].trim());
		str_CbCeCntAvg = Double.parseDouble(values[83].trim());
		str_CbTbCeeCntAvg = Double.parseDouble(values[84].trim());
		str_CbTeCntAvg = Double.parseDouble(values[85].trim());
		str_TCntAvg = Double.parseDouble(values[86].trim());
		str_TbCeCntAvg = Double.parseDouble(values[87].trim());
		str_TbCObTeeCntAvg = Double.parseDouble(values[88].trim());
		str_TbCOeCntAvg = Double.parseDouble(values[89].trim());
		str_TbObCeeCntAvg = Double.parseDouble(values[90].trim());
		str_TbObTeeCntAvg = Double.parseDouble(values[91].trim());
		str_TbOeCntAvg = Double.parseDouble(values[92].trim());
		notStr_cogLoadAvg = Double.parseDouble(values[93].trim());
		notStr_numAttemptsAvg = Double.parseDouble(values[94].trim());
		notStr_changeInScoreAvg = Double.parseDouble(values[95].trim());
		notStr_numAttemptsConstructErrorsAvg = Double.parseDouble(values[96].trim());
		notStr_changeInConstructScoreAvg = Double.parseDouble(values[97].trim());
		notStr_postRefPlayScoreAvg = Double.parseDouble(values[98].trim());
		notStr_numAttemptsOfdoTogetherRearrangementsAvg = Double.parseDouble(values[99].trim());
		notStr_numAttemptsOfoneOrZeroInDoTAvg = Double.parseDouble(values[100].trim());
		notStr_numAttemptsWithoutOrderingBoxAvg = Double.parseDouble(values[101].trim());
		notStr_constructReverseUsageAvg = Double.parseDouble(values[102].trim());
		notStr_countsOfPlayConsecutivelyAvg = Double.parseDouble(values[103].trim());
		notStr_countsOfPlayPuzConsecutivelyAvg = Double.parseDouble(values[104].trim());
		notStr_countsOfPlayRefConsecutivelyAvg = Double.parseDouble(values[105].trim());
		notStr_countsOfPlayRatioAvg = Double.parseDouble(values[106].trim());
		notStr_noRefPlayedBoolean = Integer.parseInt(values[107].trim());
		notStr_numRepeatedErrorWithInsertionsAvg = Double.parseDouble(values[108].trim());
		notStr_numCorrectedFirstWrongIndexAvg = Double.parseDouble(values[109].trim());
		notStr_numReducedFirstWrongIndexAvg = Double.parseDouble(values[110].trim());
		notStr_numRepeatedFirstWrongStmtAvg = Double.parseDouble(values[111].trim());
		notStr_numMoveSameStmtConsecutivelyAvg = Double.parseDouble(values[112].trim());
		notStr_numPlaySameSetAvg = Double.parseDouble(values[113].trim());
		notStr_numCorrectButNotPlayedAvg = Double.parseDouble(values[114].trim());
		notStr_numResetAvg = Double.parseDouble(values[115].trim());
		notStr_numStepsAvg = Double.parseDouble(values[116].trim());
		notStr_numStepsDecCorrectInOrderingBoxAvg = Double.parseDouble(values[117].trim());
		notStr_numStepsSeparatedNestsAvg = Double.parseDouble(values[118].trim());
		notStr_numStmtsInLockAvg = Double.parseDouble(values[119].trim());
		notStr_numConstructsInLockAvg = Double.parseDouble(values[120].trim());
		notStr_numStmtsAfterLockAvg = Double.parseDouble(values[121].trim());
		notStr_numConstructsAfterLockAvg = Double.parseDouble(values[122].trim());
		notStr_nestingDepthAvg = Double.parseDouble(values[123].trim());
		notStr_unfamMethodsAvg = Double.parseDouble(values[124].trim());
		notStr_structContentAvg = Double.parseDouble(values[125].trim());
		notStr_uniqueStmtsAvg = Double.parseDouble(values[126].trim());
		notStr_CCntAvg = Double.parseDouble(values[127].trim());
		notStr_CbCeCntAvg = Double.parseDouble(values[128].trim());
		notStr_CbTbCeeCntAvg = Double.parseDouble(values[129].trim());
		notStr_CbTeCntAvg = Double.parseDouble(values[130].trim());
		notStr_TCntAvg = Double.parseDouble(values[131].trim());
		notStr_TbCeCntAvg = Double.parseDouble(values[132].trim());
		notStr_TbCObTeeCntAvg = Double.parseDouble(values[133].trim());
		notStr_TbCOeCntAvg = Double.parseDouble(values[134].trim());
		notStr_TbObCeeCntAvg = Double.parseDouble(values[135].trim());
		notStr_TbObTeeCntAvg = Double.parseDouble(values[136].trim());
		notStr_TbOeCntAvg = Double.parseDouble(values[137].trim());
		lastThree_cogLoadAvg = Double.parseDouble(values[138].trim());
		lastThree_numAttemptsAvg = Double.parseDouble(values[139].trim());
		lastThree_changeInScoreAvg = Double.parseDouble(values[140].trim());
		lastThree_numAttemptsConstructErrorsAvg = Double.parseDouble(values[141].trim());
		lastThree_changeInConstructScoreAvg = Double.parseDouble(values[142].trim());
		lastThree_postRefPlayScoreAvg = Double.parseDouble(values[143].trim());
		lastThree_numAttemptsOfdoTogetherRearrangementsAvg = Double.parseDouble(values[144].trim());
		lastThree_numAttemptsOfoneOrZeroInDoTAvg = Double.parseDouble(values[145].trim());
		lastThree_numAttemptsWithoutOrderingBoxAvg = Double.parseDouble(values[146].trim());
		lastThree_constructReverseUsageAvg = Double.parseDouble(values[147].trim());
		lastThree_countsOfPlayConsecutivelyAvg = Double.parseDouble(values[148].trim());
		lastThree_countsOfPlayPuzConsecutivelyAvg = Double.parseDouble(values[149].trim());
		lastThree_countsOfPlayRefConsecutivelyAvg = Double.parseDouble(values[150].trim());
		lastThree_countsOfPlayRatioAvg = Double.parseDouble(values[151].trim());
		lastThree_noRefPlayedBoolean = Integer.parseInt(values[152].trim());
		lastThree_numRepeatedErrorWithInsertionsAvg = Double.parseDouble(values[153].trim());
		lastThree_numCorrectedFirstWrongIndexAvg = Double.parseDouble(values[154].trim());
		lastThree_numReducedFirstWrongIndexAvg = Double.parseDouble(values[155].trim());
		lastThree_numRepeatedFirstWrongStmtAvg = Double.parseDouble(values[156].trim());
		lastThree_numMoveSameStmtConsecutivelyAvg = Double.parseDouble(values[157].trim());
		lastThree_numPlaySameSetAvg = Double.parseDouble(values[158].trim());
		lastThree_numCorrectButNotPlayedAvg = Double.parseDouble(values[159].trim());
		lastThree_numResetAvg = Double.parseDouble(values[160].trim());
		lastThree_numStepsAvg = Double.parseDouble(values[161].trim());
		lastThree_numStepsDecCorrectInOrderingBoxAvg = Double.parseDouble(values[162].trim());
		lastThree_numStepsSeparatedNestsAvg = Double.parseDouble(values[163].trim());
		lastThree_numStmtsInLockAvg = Double.parseDouble(values[164].trim());
		lastThree_numConstructsInLockAvg = Double.parseDouble(values[165].trim());
		lastThree_numStmtsAfterLockAvg = Double.parseDouble(values[166].trim());
		lastThree_numConstructsAfterLockAvg = Double.parseDouble(values[167].trim());
		lastThree_nestingDepthAvg = Double.parseDouble(values[168].trim());
		lastThree_unfamMethodsAvg = Double.parseDouble(values[169].trim());
		lastThree_structContentAvg = Double.parseDouble(values[170].trim());
		lastThree_uniqueStmtsAvg = Double.parseDouble(values[171].trim());
		lastThree_CCntAvg = Double.parseDouble(values[172].trim());
		lastThree_CbCeCntAvg = Double.parseDouble(values[173].trim());
		lastThree_CbTbCeeCntAvg = Double.parseDouble(values[174].trim());
		lastThree_CbTeCntAvg = Double.parseDouble(values[175].trim());
		lastThree_TCntAvg = Double.parseDouble(values[176].trim());
		lastThree_TbCeCntAvg = Double.parseDouble(values[177].trim());
		lastThree_TbCObTeeCntAvg = Double.parseDouble(values[178].trim());
		lastThree_TbCOeCntAvg = Double.parseDouble(values[179].trim());
		lastThree_TbObCeeCntAvg = Double.parseDouble(values[180].trim());
		lastThree_TbObTeeCntAvg = Double.parseDouble(values[181].trim());
		lastThree_TbOeCntAvg = Double.parseDouble(values[182].trim());
		last_cogLoadAvg = Double.parseDouble(values[183].trim());
		last_numAttemptsAvg = Double.parseDouble(values[184].trim());
		last_changeInScoreAvg = Double.parseDouble(values[185].trim());
		last_numAttemptsConstructErrorsAvg = Double.parseDouble(values[186].trim());
		last_changeInConstructScoreAvg = Double.parseDouble(values[187].trim());
		last_postRefPlayScoreAvg = Double.parseDouble(values[188].trim());
		last_numAttemptsOfdoTogetherRearrangementsAvg = Double.parseDouble(values[189].trim());
		last_numAttemptsOfoneOrZeroInDoTAvg = Double.parseDouble(values[190].trim());
		last_numAttemptsWithoutOrderingBoxAvg = Double.parseDouble(values[191].trim());
		last_constructReverseUsageAvg = Double.parseDouble(values[192].trim());
		last_countsOfPlayConsecutivelyAvg = Double.parseDouble(values[193].trim());
		last_countsOfPlayPuzConsecutivelyAvg = Double.parseDouble(values[194].trim());
		last_countsOfPlayRefConsecutivelyAvg = Double.parseDouble(values[195].trim());
		last_countsOfPlayRatioAvg = Double.parseDouble(values[196].trim());
		last_noRefPlayedBoolean = Integer.parseInt(values[197].trim());
		last_numRepeatedErrorWithInsertionsAvg = Double.parseDouble(values[198].trim());
		last_numCorrectedFirstWrongIndexAvg = Double.parseDouble(values[199].trim());
		last_numReducedFirstWrongIndexAvg = Double.parseDouble(values[200].trim());
		last_numRepeatedFirstWrongStmtAvg = Double.parseDouble(values[201].trim());
		last_numMoveSameStmtConsecutivelyAvg = Double.parseDouble(values[202].trim());
		last_numPlaySameSetAvg = Double.parseDouble(values[203].trim());
		last_numCorrectButNotPlayedAvg = Double.parseDouble(values[204].trim());
		last_numResetAvg = Double.parseDouble(values[205].trim());
		last_numStepsAvg = Double.parseDouble(values[206].trim());
		last_numStepsDecCorrectInOrderingBoxAvg = Double.parseDouble(values[207].trim());
		last_numStepsSeparatedNestsAvg = Double.parseDouble(values[208].trim());
		last_numStmtsInLockAvg = Double.parseDouble(values[209].trim());
		last_numConstructsInLockAvg = Double.parseDouble(values[210].trim());
		last_numStmtsAfterLockAvg = Double.parseDouble(values[211].trim());
		last_numConstructsAfterLockAvg = Double.parseDouble(values[212].trim());
		last_nestingDepthAvg = Double.parseDouble(values[213].trim());
		last_unfamMethodsAvg = Double.parseDouble(values[214].trim());
		last_structContentAvg = Double.parseDouble(values[215].trim());
		last_uniqueStmtsAvg = Double.parseDouble(values[216].trim());
		last_CCntAvg = Double.parseDouble(values[217].trim());
		last_CbCeCntAvg = Double.parseDouble(values[218].trim());
		last_CbTbCeeCntAvg = Double.parseDouble(values[219].trim());
		last_CbTeCntAvg = Double.parseDouble(values[220].trim());
		last_TCntAvg = Double.parseDouble(values[221].trim());
		last_TbCeCntAvg = Double.parseDouble(values[222].trim());
		last_TbCObTeeCntAvg = Double.parseDouble(values[223].trim());
		last_TbCOeCntAvg = Double.parseDouble(values[224].trim());
		last_TbObCeeCntAvg = Double.parseDouble(values[225].trim());
		last_TbObTeeCntAvg = Double.parseDouble(values[226].trim());
		last_TbOeCntAvg = Double.parseDouble(values[227].trim());
	}
}
