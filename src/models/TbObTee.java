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
public class TbObTee{
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
		if ( user.lastThree_unfamMethodsAvg <= 2.5) {
			if ( user.lastThree_CCntAvg <= 5.1667) {
				values = new int[] { 7,  4,  3,  2,  2,  1,  0,  6,  2,  5 };
			} else {
				if ( user.str_cogLoadAvg <= 4.6667) {
					values = new int[] { 2,  5,  3,  2,  5,  4,  0,  5,  0,  15 };
				} else {
					values = new int[] { 1,  6,  2,  2,  3,  2,  0,  0,  0,  31 };
				}
			}
		} else {
			if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 27.5) {
				if ( user.notStr_structContentAvg <= 1.1667) {
					values = new int[] { 8,  4,  6,  6,  5,  0,  0,  0,  0,  1 };
				} else {
					values = new int[] { 3,  20,  4,  2,  3,  5,  0,  0,  0,  0 };
				}
			} else {
				if ( user.str_cogLoadAvg <= 3.8333) {
					values = new int[] { 0,  0,  3,  4,  7,  5,  2,  6,  1,  8 };
				} else {
					if ( user.allT <= -0.5) {
						values = new int[] { 6,  15,  19,  0,  2,  0,  0,  0,  0,  6 };
					} else {
						values = new int[] { 2,  5,  8,  8,  0,  6,  3,  1,  0,  21 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		if ( user.lastThreeT <= 0.8333) {
			if ( user.str_numRepeatedFirstWrongStmtAvg <= 0.1667) {
				if ( user.notStr_changeInScoreAvg <= 0.4121) {
					values = new int[] { 3,  16,  12,  4,  19,  1,  0,  0,  0,  0 };
				} else {
					values = new int[] { 3,  7,  11,  3,  1,  5,  1,  0,  0,  3 };
				}
			} else {
				if ( user.notStr_changeInScoreAvg <= 0.3604) {
					values = new int[] { 2,  11,  11,  2,  6,  3,  4,  4,  0,  7 };
				} else {
					if ( user.notStr_numStepsSeparatedNestsAvg <= 1.1667) {
						if ( user.lastThree_countsOfPlayPuzConsecutivelyAvg <= 1.8333) {
							values = new int[] { 4,  1,  4,  1,  4,  3,  0,  0,  2,  17 };
						} else {
							values = new int[] { 7,  2,  8,  0,  2,  0,  1,  1,  0,  3 };
						}
					} else {
						values = new int[] { 1,  6,  1,  0,  3,  0,  0,  1,  0,  21 };
					}
				}
			}
		} else {
			if ( user.last_postRefPlayScoreAvg <= 0.2176) {
				values = new int[] { 1,  4,  3,  8,  3,  5,  0,  2,  2,  26 };
			} else {
				values = new int[] { 0,  1,  3,  4,  3,  13,  4,  0,  0,  11 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		if ( user.lastThree_cogLoadAvg <= 0.5) {
			if ( user.notStr_noRefPlayedBoolean <= 0.5352) {
				if ( user.notStr_structContentAvg <= 0.8333) {
					values = new int[] { 2,  9,  13,  7,  3,  4,  0,  0,  0,  6 };
				} else {
					if ( user.str_cogLoadAvg <= 4.1667) {
						values = new int[] { 1,  34,  7,  0,  3,  0,  0,  0,  0,  6 };
					} else {
						values = new int[] { 2,  12,  9,  0,  4,  4,  2,  0,  0,  11 };
					}
				}
			} else {
				if ( user.allTbObTee <= -0.5) {
					values = new int[] { 9,  3,  14,  2,  0,  0,  0,  0,  1,  0 };
				} else {
					values = new int[] { 10,  8,  3,  5,  6,  0,  0,  2,  0,  4 };
				}
			}
		} else {
			if ( user.last_TbCeCntAvg <= 0.5) {
				values = new int[] { 2,  6,  3,  9,  9,  7,  3,  3,  0,  10 };
			} else {
				if ( user.last_numMoveSameStmtConsecutivelyAvg <= 2.5) {
					values = new int[] { 1,  1,  8,  4,  9,  2,  0,  0,  0,  7 };
				} else {
					values = new int[] { 1,  0,  4,  2,  1,  3,  1,  0,  0,  23 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		if ( user.allTbCe <= -0.5) {
			if ( user.str_numReducedFirstWrongIndexAvg <= 1.1667) {
				values = new int[] { 6,  20,  9,  7,  1,  1,  1,  2,  0,  1 };
			} else {
				if ( user.notStr_constructReverseUsageAvg <= 0.5) {
					values = new int[] { 4,  7,  12,  0,  2,  2,  0,  0,  0,  6 };
				} else {
					values = new int[] { 13,  6,  4,  0,  0,  0,  0,  0,  0,  11 };
				}
			}
		} else {
			if ( user.last_numCorrectedFirstWrongIndexAvg <= 1.5) {
				if ( user.allTbObTee <= 2.5) {
					if ( user.lastThree_structContentAvg <= 0.8333) {
						values = new int[] { 6,  2,  5,  9,  0,  7,  0,  6,  0,  8 };
					} else {
						values = new int[] { 3,  10,  16,  4,  13,  3,  7,  0,  2,  3 };
					}
				} else {
					if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 33.8333) {
						values = new int[] { 3,  2,  1,  2,  5,  1,  0,  2,  0,  10 };
					} else {
						values = new int[] { 2,  3,  1,  9,  0,  0,  1,  0,  0,  16 };
					}
				}
			} else {
				values = new int[] { 0,  2,  3,  1,  9,  4,  1,  2,  0,  26 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		if ( user.allT <= -0.5) {
			if ( user.last_numConstructsAfterLockAvg <= 5.5) {
				values = new int[] { 4,  11,  20,  2,  5,  1,  3,  0,  2,  3 };
			} else {
				if ( user.lastThree_noRefPlayedBoolean <= 0.3694) {
					values = new int[] { 4,  24,  1,  0,  8,  4,  0,  0,  0,  10 };
				} else {
					values = new int[] { 15,  10,  9,  0,  1,  0,  0,  0,  0,  16 };
				}
			}
		} else {
			if ( user.allCbCe <= 0.5) {
				if ( user.last_numConstructsAfterLockAvg <= 7.5) {
					if ( user.str_postRefPlayScoreAvg <= 0.152) {
						values = new int[] { 0,  2,  0,  10,  4,  1,  1,  1,  0,  12 };
					} else {
						values = new int[] { 1,  5,  0,  0,  6,  11,  3,  0,  3,  8 };
					}
				} else {
					values = new int[] { 3,  1,  4,  1,  13,  3,  0,  7,  0,  4 };
				}
			} else {
				if ( user.allTbObTee <= 1.5) {
					values = new int[] { 0,  0,  5,  9,  1,  9,  0,  0,  0,  15 };
				} else {
					values = new int[] { 0,  0,  1,  0,  4,  2,  0,  0,  0,  22 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		if ( user.str_uniqueStmtsAvg <= 0.8333) {
			if ( user.lastThree_unfamMethodsAvg <= 2.5) {
				if ( user.lastThree_numAttemptsAvg <= 4.5) {
					values = new int[] { 5,  8,  1,  0,  3,  1,  0,  6,  0,  4 };
				} else {
					values = new int[] { 0,  4,  3,  0,  1,  3,  2,  5,  0,  24 };
				}
			} else {
				if ( user.lastThreeTbObTee <= -1.1667) {
					values = new int[] { 1,  19,  23,  2,  6,  3,  0,  0,  0,  0 };
				} else {
					values = new int[] { 3,  28,  5,  9,  5,  2,  0,  3,  1,  5 };
				}
			}
		} else {
			if ( user.last_changeInScoreAvg <= 0.6548) {
				if ( user.str_numAttemptsOfoneOrZeroInDoTAvg <= 1.1667) {
					values = new int[] { 10,  2,  8,  19,  6,  4,  1,  0,  5,  6 };
				} else {
					values = new int[] { 4,  5,  5,  3,  3,  3,  0,  2,  0,  17 };
				}
			} else {
				values = new int[] { 0,  6,  7,  3,  0,  2,  2,  0,  0,  17 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 24.8333) {
			if ( user.lastThree_countsOfPlayPuzConsecutivelyAvg <= 0.5) {
				values = new int[] { 3,  10,  27,  3,  4,  1,  0,  0,  0,  2 };
			} else {
				values = new int[] { 8,  17,  8,  7,  6,  2,  2,  3,  0,  5 };
			}
		} else {
			if ( user.allTbObTee <= 1.5) {
				if ( user.last_changeInConstructScoreAvg <= -0.5) {
					values = new int[] { 5,  14,  5,  10,  0,  4,  4,  1,  4,  8 };
				} else {
					if ( user.last_structContentAvg <= 1.5) {
						values = new int[] { 1,  0,  12,  0,  2,  12,  0,  0,  0,  7 };
					} else {
						values = new int[] { 6,  3,  5,  2,  7,  1,  0,  0,  0,  4 };
					}
				}
			} else {
				if ( user.last_constructReverseUsageAvg <= 0.5) {
					values = new int[] { 6,  0,  3,  5,  11,  1,  0,  1,  0,  24 };
				} else {
					values = new int[] { 0,  3,  3,  5,  1,  1,  3,  0,  0,  33 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		if ( user.str_numAttemptsAvg <= 4.8333) {
			if ( user.all_cogLoad <= -1.3134) {
				values = new int[] { 3,  26,  10,  1,  4,  0,  2,  1,  0,  1 };
			} else {
				values = new int[] { 1,  5,  23,  5,  6,  0,  0,  0,  0,  9 };
			}
		} else {
			if ( user.str_numConstructsAfterLockAvg <= 6.4167) {
				if ( user.lastThreeTbObTee <= 2.8333) {
					if ( user.notStr_cogLoadAvg <= -1.8333) {
						values = new int[] { 12,  5,  10,  2,  2,  0,  0,  1,  0,  5 };
					} else {
						values = new int[] { 2,  5,  3,  14,  7,  9,  2,  1,  0,  17 };
					}
				} else {
					values = new int[] { 1,  2,  8,  8,  8,  4,  2,  4,  0,  34 };
				}
			} else {
				values = new int[] { 6,  19,  12,  1,  3,  9,  1,  0,  0,  9 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		if ( user.last_numCorrectedFirstWrongIndexAvg <= 1.5) {
			if ( user.lastThreeTbOe <= -2.5) {
				values = new int[] { 19,  18,  5,  0,  6,  0,  2,  0,  2,  1 };
			} else {
				if ( user.lastThree_numAttemptsAvg <= 2.5) {
					values = new int[] { 3,  4,  26,  2,  4,  2,  0,  1,  0,  6 };
				} else {
					if ( user.lastThree_CCntAvg <= 4.1667) {
						values = new int[] { 0,  2,  9,  11,  0,  5,  2,  0,  0,  4 };
					} else {
						if ( user.notStr_numConstructsAfterLockAvg <= 5.8333) {
							values = new int[] { 1,  10,  10,  9,  1,  1,  1,  0,  1,  3 };
						} else {
							if ( puzzle.getNumStmtsAfterLock() <= 5.5) {
								values = new int[] { 6,  1,  3,  1,  1,  1,  1,  0,  1,  14 };
							} else {
								values = new int[] { 6,  3,  6,  5,  13,  4,  0,  1,  0,  6 };
							}
						}
					}
				}
			}
		} else {
			if ( user.last_noRefPlayedBoolean <= 0.2614) {
				values = new int[] { 0,  2,  1,  0,  2,  5,  1,  2,  0,  25 };
			} else {
				values = new int[] { 3,  7,  2,  3,  5,  8,  0,  1,  0,  14 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		if ( user.lastThreeCbCe <= 0.8333) {
			if ( user.str_numAttemptsOfoneOrZeroInDoTAvg <= 0.5833) {
				if ( user.lastThreeTbOe <= -2.6667) {
					values = new int[] { 12,  17,  2,  1,  0,  0,  0,  0,  0,  5 };
				} else {
					if ( user.lastThree_numAttemptsAvg <= 3.8333) {
						values = new int[] { 0,  4,  27,  8,  2,  0,  2,  0,  0,  2 };
					} else {
						values = new int[] { 5,  16,  9,  10,  4,  1,  0,  2,  0,  7 };
					}
				}
			} else {
				if ( user.all_cogLoad <= -0.9613) {
					values = new int[] { 16,  11,  7,  0,  3,  0,  0,  0,  0,  14 };
				} else {
					if ( user.last_noRefPlayedBoolean <= 0.1144) {
						values = new int[] { 1,  7,  1,  0,  10,  0,  1,  8,  0,  6 };
					} else {
						if ( user.str_noRefPlayedBoolean <= 0.2945) {
							values = new int[] { 2,  0,  2,  6,  2,  3,  3,  1,  0,  13 };
						} else {
							values = new int[] { 2,  0,  3,  3,  11,  1,  5,  2,  0,  5 };
						}
					}
				}
			}
		} else {
			values = new int[] { 0,  0,  8,  4,  1,  3,  0,  0,  0,  24 };
		}
		return findMaxIndex(values);
	}

}