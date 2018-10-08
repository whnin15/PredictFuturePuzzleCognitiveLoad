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
public class CbCe{
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
		if ( user.structureQuits <= 0.5) {
			if ( user.notStr_unfamMethodsAvg <= 1.5) {
				if ( user.notStr_numReducedFirstWrongIndexAvg <= 2.1667) {
					if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 18.3333) {
						if ( puzzle.getUniqueStatementsCount() <= 4.5) {
							values = new int[] { 2,  5,  9,  13,  5,  2,  6,  0,  0,  1 };
						} else {
							values = new int[] { 0,  7,  13,  3,  1,  5,  2,  5,  0,  9 };
						}
					} else {
						values = new int[] { 2,  12,  1,  10,  1,  4,  0,  2,  0,  0 };
					}
				} else {
					values = new int[] { 1,  1,  6,  4,  5,  5,  4,  0,  0,  18 };
				}
			} else {
				if ( user.notStr_numConstructsAfterLockAvg <= 2.1667) {
					values = new int[] { 10,  21,  5,  0,  1,  2,  5,  2,  0,  5 };
				} else {
					if ( user.str_numConstructsInLockAvg <= 0.3333) {
						values = new int[] { 0,  15,  12,  3,  2,  0,  0,  0,  0,  0 };
					} else {
						values = new int[] { 1,  5,  14,  3,  3,  4,  0,  1,  0,  3 };
					}
				}
			}
		} else {
			if ( user.str_changeInScoreAvg <= 0.4021) {
				if ( user.notStr_numCorrectedFirstWrongIndexAvg <= 0.8333) {
					if ( user.lastThreeT <= 0.5) {
						values = new int[] { 5,  2,  0,  6,  2,  4,  1,  1,  0,  33 };
					} else {
						values = new int[] { 0,  0,  11,  4,  2,  5,  1,  7,  1,  7 };
					}
				} else {
					values = new int[] { 1,  0,  1,  3,  2,  3,  0,  0,  2,  28 };
				}
			} else {
				values = new int[] { 1,  3,  2,  5,  5,  3,  10,  3,  1,  9 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.1667) {
			if ( user.str_numCorrectButNotPlayedAvg <= 0.5833) {
				if ( user.lastThree_nestingDepthAvg <= 1.8333) {
					values = new int[] { 1,  2,  11,  5,  0,  3,  6,  0,  0,  3 };
				} else {
					if ( user.notStr_numPlaySameSetAvg <= 0.1667) {
						values = new int[] { 2,  24,  5,  0,  1,  2,  0,  1,  0,  1 };
					} else {
						values = new int[] { 3,  22,  11,  19,  3,  6,  1,  0,  0,  4 };
					}
				}
			} else {
				if ( user.str_changeInScoreAvg <= 0.3899) {
					values = new int[] { 5,  0,  0,  5,  0,  2,  4,  7,  1,  8 };
				} else {
					values = new int[] { 1,  7,  13,  1,  9,  7,  1,  1,  0,  1 };
				}
			}
		} else {
			if ( user.lastThree_postRefPlayScoreAvg <= 0.1042) {
				values = new int[] { 1,  3,  11,  18,  12,  2,  2,  0,  3,  7 };
			} else {
				if ( user.str_changeInScoreAvg <= 0.2274) {
					values = new int[] { 0,  1,  2,  3,  0,  5,  2,  2,  0,  40 };
				} else {
					if ( user.notStr_changeInScoreAvg <= 0.392) {
						values = new int[] { 0,  12,  7,  5,  1,  0,  3,  1,  0,  3 };
					} else {
						if ( user.lastThree_numPlaySameSetAvg <= 0.5) {
							values = new int[] { 5,  1,  6,  9,  3,  11,  0,  2,  0,  5 };
						} else {
							values = new int[] { 2,  3,  3,  0,  15,  3,  3,  8,  0,  21 };
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		if ( user.last_cogLoadAvg <= -1.5) {
			if ( user.notStr_numCorrectedFirstWrongIndexAvg <= 0.8333) {
				if ( user.lastThree_unfamMethodsAvg <= 1.1667) {
					values = new int[] { 1,  3,  9,  7,  1,  0,  1,  0,  0,  12 };
				} else {
					if ( user.str_numReducedFirstWrongIndexAvg <= 1.1667) {
						values = new int[] { 5,  25,  19,  3,  0,  0,  0,  0,  0,  0 };
					} else {
						if ( user.last_numAttemptsAvg <= 3.5) {
							values = new int[] { 2,  7,  12,  2,  0,  2,  1,  3,  0,  10 };
						} else {
							values = new int[] { 0,  12,  8,  4,  6,  7,  0,  0,  0,  2 };
						}
					}
				}
			} else {
				values = new int[] { 9,  4,  4,  1,  0,  2,  2,  0,  0,  15 };
			}
		} else {
			if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 6.1667) {
				if ( user.notStr_cogLoadAvg <= -0.5) {
					if ( user.notStr_postRefPlayScoreAvg <= 0.178) {
						values = new int[] { 1,  2,  4,  11,  6,  10,  4,  7,  2,  8 };
					} else {
						if ( user.lastThree_cogLoadAvg <= 2.8333) {
							if ( user.str_uniqueStmtsAvg <= 0.1667) {
								values = new int[] { 1,  7,  1,  2,  5,  3,  0,  0,  0,  8 };
							} else {
								values = new int[] { 0,  2,  8,  0,  0,  2,  0,  0,  0,  28 };
							}
						} else {
							values = new int[] { 1,  1,  1,  2,  5,  4,  0,  5,  1,  9 };
						}
					}
				} else {
					if ( user.notStr_postRefPlayScoreAvg <= 0.3472) {
						values = new int[] { 0,  1,  4,  0,  11,  4,  3,  3,  1,  2 };
					} else {
						values = new int[] { 0,  0,  0,  4,  6,  7,  4,  0,  4,  7 };
					}
				}
			} else {
				values = new int[] { 0,  1,  8,  21,  1,  3,  3,  0,  0,  5 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		if ( user.str_numAttemptsConstructErrorsAvg <= 0.5) {
			if ( user.notStr_numReducedFirstWrongIndexAvg <= 2.5) {
				if ( user.str_numReducedFirstWrongIndexAvg <= 0.3333) {
					if ( user.last_postRefPlayScoreAvg <= 0.4097) {
						if ( user.lastThree_numReducedFirstWrongIndexAvg <= 1.5) {
							values = new int[] { 1,  6,  9,  6,  2,  0,  5,  0,  0,  1 };
						} else {
							values = new int[] { 0,  5,  5,  9,  4,  9,  0,  0,  0,  1 };
						}
					} else {
						values = new int[] { 0,  14,  12,  5,  2,  4,  2,  0,  0,  1 };
					}
				} else {
					if ( user.lastThree_postRefPlayScoreAvg <= 0.1139) {
						values = new int[] { 1,  10,  4,  5,  4,  8,  0,  0,  0,  2 };
					} else {
						values = new int[] { 3,  5,  5,  4,  4,  12,  4,  4,  0,  18 };
					}
				}
			} else {
				values = new int[] { 12,  1,  6,  6,  5,  6,  4,  0,  2,  13 };
			}
		} else {
			if ( puzzle.getTbObTeeCnt() <= 0.5) {
				if ( user.str_cogLoadAvg <= 3.5833) {
					values = new int[] { 1,  8,  10,  11,  3,  1,  4,  3,  1,  2 };
				} else {
					if ( user.lastThree_numConstructsInLockAvg <= 1.5) {
						values = new int[] { 1,  1,  5,  4,  11,  7,  4,  5,  1,  14 };
					} else {
						if ( user.str_numAttemptsAvg <= 8.6667) {
							values = new int[] { 2,  6,  1,  5,  1,  2,  0,  0,  0,  21 };
						} else {
							values = new int[] { 2,  2,  3,  1,  2,  0,  1,  0,  0,  20 };
						}
					}
				}
			} else {
				values = new int[] { 0,  0,  3,  2,  0,  4,  0,  3,  2,  24 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		if ( user.str_numReducedFirstWrongIndexAvg <= 0.3333) {
			if ( user.lastThree_numConstructsAfterLockAvg <= 2.5) {
				values = new int[] { 8,  21,  9,  4,  4,  4,  3,  1,  0,  1 };
			} else {
				values = new int[] { 1,  10,  13,  19,  3,  2,  4,  0,  0,  1 };
			}
		} else {
			if ( user.lastThree_cogLoadAvg <= -0.5) {
				if ( user.str_changeInScoreAvg <= 0.4362) {
					values = new int[] { 12,  2,  11,  7,  5,  4,  0,  6,  0,  15 };
				} else {
					if ( user.str_numMoveSameStmtConsecutivelyAvg <= 1.5833) {
						values = new int[] { 4,  4,  20,  0,  2,  5,  2,  0,  0,  0 };
					} else {
						values = new int[] { 0,  8,  4,  9,  3,  6,  5,  0,  0,  3 };
					}
				}
			} else {
				if ( user.last_CbTbCeeCntAvg <= 0.5) {
					if ( user.lastThree_TCntAvg <= 0.1667) {
						if ( user.notStr_noRefPlayedBoolean <= 0.3952) {
							values = new int[] { 0,  3,  7,  6,  11,  4,  4,  3,  1,  3 };
						} else {
							values = new int[] { 0,  5,  2,  3,  8,  18,  4,  1,  2,  20 };
						}
					} else {
						if ( user.str_postRefPlayScoreAvg <= 0.2654) {
							values = new int[] { 1,  0,  4,  4,  3,  1,  4,  4,  1,  22 };
						} else {
							values = new int[] { 0,  6,  4,  4,  1,  8,  2,  1,  0,  7 };
						}
					}
				} else {
					values = new int[] { 0,  1,  1,  2,  1,  1,  1,  1,  0,  20 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		if ( user.notStr_structContentAvg <= 4.5) {
			if ( user.str_cogLoadAvg <= 3.5833) {
				if ( user.str_nestingDepthAvg <= 1.1667) {
					if ( user.notStr_CbCeCntAvg <= 0.1667) {
						values = new int[] { 0,  12,  17,  17,  3,  4,  0,  0,  0,  1 };
					} else {
						values = new int[] { 4,  15,  10,  4,  3,  6,  0,  0,  0,  2 };
					}
				} else {
					if ( user.str_cogLoadAvg <= 2.5833) {
						values = new int[] { 0,  11,  6,  2,  3,  16,  6,  2,  2,  1 };
					} else {
						values = new int[] { 4,  3,  10,  5,  9,  2,  1,  1,  1,  0 };
					}
				}
			} else {
				if ( user.str_numAttemptsConstructErrorsAvg <= 0.1667) {
					values = new int[] { 6,  9,  18,  7,  3,  4,  1,  0,  0,  5 };
				} else {
					if ( user.notStr_structContentAvg <= 3.1667) {
						if ( user.notStr_numRepeatedErrorWithInsertionsAvg <= 0.5) {
							values = new int[] { 1,  0,  1,  4,  2,  0,  1,  1,  0,  25 };
						} else {
							values = new int[] { 0,  2,  7,  0,  1,  12,  1,  3,  0,  12 };
						}
					} else {
						values = new int[] { 0,  7,  4,  3,  6,  7,  7,  3,  3,  8 };
					}
				}
			}
		} else {
			if ( user.notStr_TbObCeeCntAvg <= 0.1667) {
				values = new int[] { 0,  3,  7,  3,  0,  2,  0,  2,  1,  17 };
			} else {
				values = new int[] { 1,  8,  7,  12,  3,  1,  9,  5,  0,  17 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		if ( user.str_cogLoadAvg <= 3.8333) {
			if ( user.str_numAttemptsAvg <= 2.5) {
				if ( user.notStr_TbObTeeCntAvg <= 0.1667) {
					values = new int[] { 2,  17,  5,  7,  2,  8,  5,  0,  0,  1 };
				} else {
					values = new int[] { 5,  7,  7,  14,  0,  0,  3,  0,  0,  2 };
				}
			} else {
				if ( user.notStr_cogLoadAvg <= -1.5) {
					values = new int[] { 6,  12,  27,  4,  5,  3,  1,  1,  0,  1 };
				} else {
					if ( user.lastThree_structContentAvg <= 3.5) {
						values = new int[] { 0,  4,  5,  3,  3,  11,  2,  4,  0,  3 };
					} else {
						values = new int[] { 3,  2,  5,  1,  1,  2,  4,  0,  4,  9 };
					}
				}
			}
		} else {
			if ( user.lastThree_numAttemptsConstructErrorsAvg <= 1.1667) {
				if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 0.5833) {
					values = new int[] { 0,  3,  21,  5,  1,  1,  7,  0,  0,  3 };
				} else {
					values = new int[] { 3,  4,  9,  5,  0,  4,  0,  3,  2,  16 };
				}
			} else {
				if ( user.notStr_nestingDepthAvg <= 1.8333) {
					if ( user.structureConsectiveQuits <= 0.5) {
						values = new int[] { 0,  6,  4,  3,  3,  2,  0,  6,  0,  7 };
					} else {
						values = new int[] { 0,  3,  4,  0,  1,  7,  0,  4,  1,  37 };
					}
				} else {
					if ( user.lastThree_CbTbCeeCntAvg <= 0.1667) {
						values = new int[] { 8,  4,  1,  4,  8,  0,  0,  0,  0,  12 };
					} else {
						values = new int[] { 2,  1,  2,  6,  4,  7,  2,  0,  0,  8 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		if ( user.str_numAttemptsAvg <= 0.5) {
			if ( user.last_postRefPlayScoreAvg <= 0.1625) {
				values = new int[] { 5,  8,  10,  10,  4,  5,  6,  1,  0,  2 };
			} else {
				values = new int[] { 3,  22,  20,  5,  3,  4,  2,  0,  0,  0 };
			}
		} else {
			if ( user.str_postRefPlayScoreAvg <= 0.2246) {
				if ( user.all_cogLoad <= -0.7937) {
					values = new int[] { 2,  1,  1,  3,  2,  1,  0,  0,  0,  20 };
				} else {
					if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 1.5) {
						if ( user.last_numAttemptsAvg <= 2.5) {
							values = new int[] { 2,  1,  18,  4,  5,  3,  0,  1,  0,  2 };
						} else {
							values = new int[] { 2,  1,  6,  5,  11,  5,  3,  2,  1,  2 };
						}
					} else {
						if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 23.6667) {
							values = new int[] { 0,  0,  0,  3,  7,  2,  0,  1,  0,  18 };
						} else {
							values = new int[] { 2,  6,  5,  7,  2,  4,  0,  5,  0,  13 };
						}
					}
				}
			} else {
				if ( user.last_cogLoadAvg <= -1.5) {
					values = new int[] { 5,  22,  12,  4,  1,  8,  0,  2,  0,  8 };
				} else {
					if ( user.notStr_numRepeatedErrorWithInsertionsAvg <= 0.5) {
						values = new int[] { 0,  3,  3,  9,  2,  12,  0,  4,  0,  13 };
					} else {
						values = new int[] { 0,  4,  7,  0,  4,  16,  9,  5,  2,  11 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		if ( user.str_cogLoadAvg <= 3.8333) {
			if ( user.lastThree_numAttemptsWithoutOrderingBoxAvg <= 0.5) {
				if ( user.lastThreeCbCe <= 4.8333) {
					if ( user.notStr_cogLoadAvg <= -2.1667) {
						values = new int[] { 4,  21,  7,  0,  2,  1,  5,  0,  0,  3 };
					} else {
						if ( user.lastThreeCbCe <= 0.5) {
							values = new int[] { 2,  3,  19,  5,  3,  1,  5,  2,  0,  0 };
						} else {
							values = new int[] { 1,  6,  18,  2,  10,  18,  4,  3,  1,  2 };
						}
					}
				} else {
					values = new int[] { 1,  8,  1,  16,  0,  2,  0,  4,  0,  5 };
				}
			} else {
				values = new int[] { 2,  2,  3,  7,  3,  7,  8,  3,  0,  13 };
			}
		} else {
			if ( user.structureConsectiveQuits <= 0.5) {
				if ( user.str_numRepeatedErrorWithInsertionsAvg <= 0.5) {
					if ( user.last_postRefPlayScoreAvg <= 0.2614) {
						values = new int[] { 0,  4,  9,  1,  2,  0,  1,  6,  0,  15 };
					} else {
						values = new int[] { 4,  0,  2,  1,  2,  4,  0,  2,  0,  16 };
					}
				} else {
					values = new int[] { 0,  13,  18,  8,  4,  4,  2,  5,  0,  6 };
				}
			} else {
				if ( user.last_noRefPlayedBoolean <= 0.3431) {
					values = new int[] { 3,  0,  1,  2,  0,  5,  0,  1,  0,  25 };
				} else {
					values = new int[] { 0,  2,  10,  4,  1,  4,  4,  3,  3,  25 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		if ( user.lastThreeCbCe <= 2.5) {
			if ( user.notStr_cogLoadAvg <= -2.5) {
				values = new int[] { 7,  23,  10,  3,  0,  5,  1,  0,  0,  2 };
			} else {
				if ( user.notStr_changeInScoreAvg <= 0.608) {
					if ( user.lastThree_numAttemptsAvg <= 4.8333) {
						values = new int[] { 3,  8,  30,  2,  8,  3,  0,  2,  0,  1 };
					} else {
						values = new int[] { 0,  6,  10,  5,  8,  8,  3,  1,  1,  8 };
					}
				} else {
					values = new int[] { 9,  6,  2,  12,  0,  3,  2,  1,  0,  15 };
				}
			}
		} else {
			if ( user.lastThree_numPlaySameSetAvg <= 1.1667) {
				if ( user.str_numConstructsInLockAvg <= 1.1667) {
					if ( user.notStr_numAttemptsAvg <= 3.1667) {
						values = new int[] { 0,  2,  14,  10,  0,  5,  8,  5,  0,  2 };
					} else {
						values = new int[] { 1,  6,  1,  13,  2,  8,  6,  2,  0,  12 };
					}
				} else {
					if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 19.5) {
						values = new int[] { 0,  5,  6,  9,  6,  12,  3,  2,  3,  17 };
					} else {
						values = new int[] { 0,  2,  2,  8,  4,  1,  0,  0,  2,  22 };
					}
				}
			} else {
				values = new int[] { 0,  1,  5,  2,  2,  1,  0,  12,  0,  23 };
			}
		}
		return findMaxIndex(values);
	}

}