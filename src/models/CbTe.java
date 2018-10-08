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
public class CbTe{
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
		if ( user.allCbTe <= -3.5) {
			values = new int[] { 25,  5,  2,  1,  0,  0,  0,  0,  0,  3 };
		} else {
			if ( user.last_numConstructsAfterLockAvg <= 4.5) {
				if ( user.notStr_numReducedFirstWrongIndexAvg <= 1.8333) {
					if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 0.5) {
						values = new int[] { 3,  21,  6,  0,  2,  0,  3,  0,  0,  1 };
					} else {
						if ( user.lastThree_changeInScoreAvg <= 0.3131) {
							values = new int[] { 4,  15,  17,  13,  1,  1,  0,  0,  0,  0 };
						} else {
							values = new int[] { 4,  7,  23,  0,  0,  0,  5,  0,  0,  0 };
						}
					}
				} else {
					values = new int[] { 7,  6,  9,  9,  11,  1,  0,  0,  0,  3 };
				}
			} else {
				if ( user.str_numConstructsInLockAvg <= 0.1667) {
					values = new int[] { 2,  9,  14,  5,  1,  1,  0,  0,  0,  6 };
				} else {
					if ( puzzle.getUniqueStatementsCount() <= 7.5) {
						if ( puzzle.getNumStmtsAfterLock() <= 5.5) {
							values = new int[] { 14,  4,  12,  4,  4,  1,  0,  0,  3,  6 };
						} else {
							if ( user.all_cogLoad <= -0.8091) {
								values = new int[] { 8,  8,  3,  10,  0,  2,  4,  0,  0,  2 };
							} else {
								values = new int[] { 1,  0,  3,  11,  9,  3,  2,  3,  0,  13 };
							}
						}
					} else {
						if ( user.lastThree_CCntAvg <= 6.5) {
							values = new int[] { 0,  2,  9,  7,  16,  8,  4,  2,  0,  4 };
						} else {
							values = new int[] { 3,  2,  1,  2,  6,  13,  6,  2,  1,  21 };
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		if ( user.str_CCntAvg <= 4.4167) {
			if ( user.last_numCorrectedFirstWrongIndexAvg <= 0.5) {
				values = new int[] { 6,  35,  10,  12,  2,  0,  0,  0,  0,  6 };
			} else {
				values = new int[] { 19,  6,  2,  4,  1,  2,  0,  1,  0,  0 };
			}
		} else {
			if ( puzzle.getTCnt() <= 0.5) {
				if ( user.last_numAttemptsConstructErrorsAvg <= 5.5) {
					if ( user.str_unfamMethodsAvg <= 1.1667) {
						values = new int[] { 1,  21,  9,  5,  4,  3,  0,  0,  0,  2 };
					} else {
						if ( user.lastThree_numRepeatedFirstWrongStmtAvg <= 0.8333) {
							if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 1.5) {
								if ( user.last_TbCObTeeCntAvg <= 0.5) {
									if ( user.lastThreeCbCe <= -0.6667) {
										values = new int[] { 10,  3,  7,  1,  6,  0,  2,  0,  0,  1 };
									} else {
										values = new int[] { 10,  0,  10,  3,  10,  0,  4,  0,  0,  3 };
									}
								} else {
									values = new int[] { 8,  4,  3,  11,  4,  0,  5,  1,  2,  3 };
								}
							} else {
								values = new int[] { 6,  6,  21,  5,  1,  8,  2,  2,  0,  6 };
							}
						} else {
							values = new int[] { 0,  15,  8,  5,  6,  4,  1,  0,  0,  1 };
						}
					}
				} else {
					values = new int[] { 12,  5,  3,  6,  14,  4,  0,  3,  0,  2 };
				}
			} else {
				if ( user.str_noRefPlayedBoolean <= 0.3988) {
					values = new int[] { 5,  2,  9,  1,  10,  6,  3,  0,  0,  4 };
				} else {
					values = new int[] { 0,  0,  1,  6,  2,  9,  6,  2,  2,  9 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		if ( user.lastThree_cogLoadAvg <= -2.5) {
			if ( puzzle.getStructContent() <= 0.5) {
				values = new int[] { 16,  6,  4,  6,  1,  0,  0,  0,  0,  2 };
			} else {
				if ( user.notStr_structContentAvg <= 2.8333) {
					values = new int[] { 8,  16,  6,  3,  0,  0,  0,  0,  0,  0 };
				} else {
					values = new int[] { 5,  23,  4,  0,  1,  0,  3,  0,  0,  2 };
				}
			}
		} else {
			if ( puzzle.getUnfamiliarMethodsCount() <= 3.5) {
				if ( user.lastThree_CbTbCeeCntAvg <= 0.1667) {
					if ( user.str_numConstructsInLockAvg <= 1.1667) {
						values = new int[] { 6,  3,  7,  21,  5,  5,  4,  0,  4,  2 };
					} else {
						values = new int[] { 2,  5,  9,  1,  8,  3,  2,  0,  0,  3 };
					}
				} else {
					if ( user.notStr_cogLoadAvg <= -1.1667) {
						if ( user.last_numConstructsAfterLockAvg <= 3.5) {
							values = new int[] { 10,  15,  8,  0,  2,  0,  0,  0,  0,  0 };
						} else {
							values = new int[] { 4,  10,  15,  2,  2,  0,  0,  0,  0,  0 };
						}
					} else {
						if ( user.str_numAttemptsConstructErrorsAvg <= 4.3333) {
							values = new int[] { 9,  2,  8,  3,  6,  0,  0,  0,  0,  5 };
						} else {
							values = new int[] { 1,  2,  9,  7,  5,  0,  1,  0,  3,  2 };
						}
					}
				}
			} else {
				if ( user.all_cogLoad <= -0.4179) {
					if ( user.lastThree_numAttemptsConstructErrorsAvg <= 2.8333) {
						values = new int[] { 0,  3,  18,  6,  10,  0,  1,  0,  0,  10 };
					} else {
						values = new int[] { 1,  6,  9,  6,  2,  13,  2,  3,  0,  5 };
					}
				} else {
					if ( user.notStr_CbTbCeeCntAvg <= 0.1667) {
						values = new int[] { 3,  0,  0,  7,  6,  8,  0,  0,  0,  4 };
					} else {
						values = new int[] { 0,  1,  0,  12,  1,  6,  6,  0,  0,  9 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		if ( user.lastThreeT <= -2.5) {
			if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 36.0) {
				values = new int[] { 14,  14,  6,  8,  1,  0,  0,  0,  0,  1 };
			} else {
				values = new int[] { 24,  6,  4,  1,  0,  0,  0,  0,  0,  4 };
			}
		} else {
			if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.8333) {
				if ( puzzle.getTCnt() <= 0.5) {
					if ( user.str_noRefPlayedBoolean <= 0.2504) {
						if ( user.notStr_CbTbCeeCntAvg <= 0.1667) {
							values = new int[] { 6,  8,  14,  3,  4,  7,  1,  0,  0,  6 };
						} else {
							values = new int[] { 7,  27,  22,  2,  2,  0,  0,  0,  0,  0 };
						}
					} else {
						if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 17.5) {
							values = new int[] { 3,  1,  13,  23,  1,  1,  4,  0,  0,  3 };
						} else {
							values = new int[] { 13,  3,  17,  5,  2,  1,  3,  2,  0,  3 };
						}
					}
				} else {
					values = new int[] { 4,  2,  7,  3,  5,  15,  5,  1,  0,  2 };
				}
			} else {
				if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 22.5) {
					if ( user.notStr_changeInScoreAvg <= 0.5812) {
						values = new int[] { 13,  12,  6,  4,  5,  1,  0,  1,  0,  2 };
					} else {
						values = new int[] { 0,  4,  4,  3,  1,  9,  1,  1,  0,  6 };
					}
				} else {
					if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 5.8333) {
						values = new int[] { 4,  6,  7,  7,  11,  3,  1,  0,  1,  4 };
					} else {
						values = new int[] { 1,  0,  0,  3,  19,  2,  2,  0,  4,  3 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		if ( user.lastThreeT <= -2.8333) {
			values = new int[] { 28,  9,  5,  10,  1,  0,  0,  0,  0,  2 };
		} else {
			if ( user.lastThree_numConstructsAfterLockAvg <= 5.5) {
				if ( user.str_noRefPlayedBoolean <= 0.1737) {
					if ( user.lastThree_postRefPlayScoreAvg <= 0.2513) {
						values = new int[] { 3,  16,  17,  7,  1,  3,  0,  0,  0,  1 };
					} else {
						values = new int[] { 4,  27,  11,  2,  0,  0,  0,  1,  0,  0 };
					}
				} else {
					if ( user.str_structContentAvg <= 4.8333) {
						if ( user.str_changeInConstructScoreAvg <= -0.5833) {
							values = new int[] { 10,  6,  2,  2,  2,  1,  2,  2,  0,  1 };
						} else {
							if ( user.str_numMoveSameStmtConsecutivelyAvg <= 3.5) {
								if ( user.lastThreeCbTe <= 1.8333) {
									values = new int[] { 5,  2,  6,  12,  0,  6,  1,  0,  1,  14 };
								} else {
									values = new int[] { 5,  3,  15,  1,  4,  0,  0,  3,  0,  6 };
								}
							} else {
								if ( user.lastThree_changeInScoreAvg <= 0.5516) {
									values = new int[] { 3,  7,  9,  8,  2,  0,  5,  3,  0,  0 };
								} else {
									values = new int[] { 0,  0,  12,  1,  23,  2,  1,  0,  2,  5 };
								}
							}
						}
					} else {
						values = new int[] { 1,  13,  1,  4,  6,  7,  4,  0,  0,  0 };
					}
				}
			} else {
				if ( user.last_cogLoadAvg <= -0.5) {
					values = new int[] { 14,  5,  6,  7,  5,  2,  0,  3,  0,  8 };
				} else {
					values = new int[] { 4,  2,  3,  7,  5,  17,  3,  3,  3,  9 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		if ( user.notStr_TCntAvg <= 0.1667) {
			if ( user.str_cogLoadAvg <= 2.1667) {
				values = new int[] { 9,  28,  6,  3,  0,  0,  0,  1,  0,  0 };
			} else {
				if ( user.notStr_postRefPlayScoreAvg <= 0.4156) {
					if ( user.notStr_structContentAvg <= 2.5) {
						values = new int[] { 2,  4,  7,  2,  9,  7,  4,  0,  2,  3 };
					} else {
						if ( user.lastThreeCbTe <= 2.8333) {
							values = new int[] { 2,  6,  12,  0,  2,  0,  0,  2,  1,  5 };
						} else {
							values = new int[] { 4,  4,  16,  5,  2,  0,  0,  0,  0,  1 };
						}
					}
				} else {
					values = new int[] { 2,  18,  3,  6,  8,  1,  1,  0,  0,  0 };
				}
			}
		} else {
			if ( puzzle.getNumStmtsInLock() <= 1.5) {
				if ( user.notStr_unfamMethodsAvg <= 1.8333) {
					values = new int[] { 9,  2,  1,  8,  6,  2,  5,  0,  0,  6 };
				} else {
					if ( user.str_noRefPlayedBoolean <= 0.4808) {
						if ( user.last_countsOfPlayPuzConsecutivelyAvg <= 0.5) {
							values = new int[] { 3,  10,  32,  4,  6,  1,  0,  0,  0,  2 };
						} else {
							if ( user.last_noRefPlayedBoolean <= 0.3485) {
								values = new int[] { 4,  6,  5,  1,  0,  1,  0,  6,  0,  4 };
							} else {
								values = new int[] { 10,  7,  10,  5,  1,  1,  0,  0,  0,  0 };
							}
						}
					} else {
						values = new int[] { 10,  3,  4,  8,  1,  0,  0,  0,  0,  1 };
					}
				}
			} else {
				if ( user.lastThree_changeInScoreAvg <= 0.6322) {
					if ( user.allCbCe <= -0.5) {
						values = new int[] { 10,  1,  5,  5,  1,  2,  0,  2,  0,  1 };
					} else {
						values = new int[] { 3,  0,  5,  5,  5,  11,  9,  1,  0,  6 };
					}
				} else {
					values = new int[] { 2,  1,  5,  1,  15,  5,  3,  1,  2,  5 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 29.5) {
			if ( user.notStr_postRefPlayScoreAvg <= 0.494) {
				if ( user.lastThree_cogLoadAvg <= -2.5) {
					values = new int[] { 12,  22,  13,  6,  1,  0,  0,  0,  0,  3 };
				} else {
					if ( user.str_structContentAvg <= 2.1667) {
						values = new int[] { 8,  11,  12,  6,  0,  0,  0,  0,  0,  0 };
					} else {
						if ( user.lastThree_cogLoadAvg <= 0.5) {
							values = new int[] { 1,  5,  26,  7,  0,  0,  0,  2,  0,  2 };
						} else {
							values = new int[] { 3,  3,  10,  5,  0,  5,  0,  0,  0,  5 };
						}
					}
				}
			} else {
				values = new int[] { 13,  11,  3,  14,  6,  2,  1,  1,  0,  1 };
			}
		} else {
			if ( puzzle.getNumStmtsAfterLock() <= 7.5) {
				if ( user.lastThree_numConstructsInLockAvg <= 0.8333) {
					values = new int[] { 2,  10,  7,  3,  2,  11,  0,  5,  0,  1 };
				} else {
					if ( user.lastThree_cogLoadAvg <= -0.8333) {
						values = new int[] { 18,  14,  13,  5,  6,  0,  0,  0,  0,  5 };
					} else {
						if ( user.str_countsOfPlayConsecutivelyAvg <= 0.1722) {
							if ( user.str_numConstructsAfterLockAvg <= 4.4167) {
								values = new int[] { 5,  2,  8,  9,  11,  0,  0,  0,  0,  4 };
							} else {
								values = new int[] { 3,  0,  2,  4,  23,  3,  1,  0,  5,  0 };
							}
						} else {
							values = new int[] { 4,  2,  4,  14,  4,  6,  2,  3,  0,  2 };
						}
					}
				}
			} else {
				values = new int[] { 3,  0,  6,  4,  4,  7,  6,  0,  1,  11 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		if ( user.lastThree_cogLoadAvg <= -1.1667) {
			if ( user.last_postRefPlayScoreAvg <= 0.6125) {
				if ( user.str_numConstructsAfterLockAvg <= 0.5) {
					values = new int[] { 20,  21,  6,  1,  0,  5,  0,  0,  0,  1 };
				} else {
					if ( user.str_postRefPlayScoreAvg <= 0.0227) {
						values = new int[] { 0,  11,  28,  1,  1,  0,  0,  0,  0,  1 };
					} else {
						if ( user.lastThree_cogLoadAvg <= -2.5) {
							values = new int[] { 17,  7,  2,  2,  4,  1,  0,  0,  0,  0 };
						} else {
							values = new int[] { 1,  10,  11,  3,  1,  5,  0,  0,  0,  17 };
						}
					}
				}
			} else {
				values = new int[] { 2,  13,  4,  15,  0,  0,  0,  0,  0,  1 };
			}
		} else {
			if ( puzzle.getNumConstructsAfterLock() <= 3.5) {
				if ( puzzle.getTbCeCnt() <= 0.5) {
					if ( user.str_noRefPlayedBoolean <= 0.4814) {
						if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 28.5) {
							values = new int[] { 2,  7,  16,  1,  15,  0,  1,  2,  2,  2 };
						} else {
							values = new int[] { 6,  1,  7,  8,  3,  2,  1,  1,  0,  8 };
						}
					} else {
						values = new int[] { 5,  4,  3,  28,  12,  2,  3,  1,  0,  2 };
					}
				} else {
					values = new int[] { 2,  3,  12,  2,  5,  2,  0,  0,  0,  0 };
				}
			} else {
				if ( user.lastThree_numStepsSeparatedNestsAvg <= 1.1667) {
					if ( user.last_numCorrectedFirstWrongIndexAvg <= 0.5) {
						values = new int[] { 5,  3,  3,  3,  3,  0,  6,  1,  0,  10 };
					} else {
						values = new int[] { 1,  1,  2,  1,  11,  12,  3,  3,  1,  6 };
					}
				} else {
					values = new int[] { 2,  2,  5,  7,  0,  5,  4,  0,  2,  0 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		if ( user.str_unfamMethodsAvg <= 1.1667) {
			if ( user.notStr_numAttemptsAvg <= 3.1667) {
				values = new int[] { 3,  41,  11,  6,  1,  4,  0,  0,  0,  0 };
			} else {
				values = new int[] { 19,  13,  11,  5,  6,  3,  0,  0,  0,  1 };
			}
		} else {
			if ( user.str_postRefPlayScoreAvg <= 0.1581) {
				if ( user.lastThreeCbCe <= -1.8333) {
					if ( user.lastThree_numAttemptsAvg <= 4.1667) {
						values = new int[] { 0,  0,  18,  6,  0,  0,  0,  0,  0,  4 };
					} else {
						values = new int[] { 1,  5,  14,  5,  1,  2,  0,  2,  0,  1 };
					}
				} else {
					if ( user.lastThree_numConstructsAfterLockAvg <= 2.8333) {
						values = new int[] { 3,  0,  16,  0,  3,  0,  1,  0,  0,  4 };
					} else {
						if ( user.notStr_TCntAvg <= 0.5) {
							values = new int[] { 4,  9,  10,  8,  9,  4,  2,  0,  1,  11 };
						} else {
							values = new int[] { 3,  0,  5,  7,  8,  13,  0,  0,  0,  3 };
						}
					}
				}
			} else {
				if ( user.notStr_structContentAvg <= 2.5) {
					values = new int[] { 10,  6,  0,  20,  16,  5,  5,  4,  1,  0 };
				} else {
					if ( user.last_numConstructsInLockAvg <= 1.5) {
						if ( user.str_uniqueStmtsAvg <= 0.1667) {
							values = new int[] { 7,  10,  8,  0,  3,  2,  0,  3,  0,  3 };
						} else {
							values = new int[] { 13,  3,  3,  6,  1,  0,  4,  3,  0,  2 };
						}
					} else {
						values = new int[] { 0,  4,  6,  3,  5,  1,  4,  2,  2,  13 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		if ( user.allCbCe <= -1.5) {
			if ( user.str_uniqueStmtsAvg <= 0.1667) {
				if ( user.last_TbCObTeeCntAvg <= 0.5) {
					values = new int[] { 1,  24,  1,  3,  2,  0,  0,  0,  0,  3 };
				} else {
					values = new int[] { 5,  14,  4,  3,  0,  1,  0,  0,  0,  5 };
				}
			} else {
				values = new int[] { 9,  9,  14,  3,  3,  0,  0,  3,  0,  3 };
			}
		} else {
			if ( user.lastThreeCbCe <= -1.8333) {
				values = new int[] { 0,  1,  25,  8,  1,  0,  2,  2,  0,  4 };
			} else {
				if ( user.lastThreeTbCe <= 3.8333) {
					if ( user.lastThreeCbCe <= 0.8333) {
						if ( puzzle.getCbTeCnt() <= 0.5) {
							if ( user.last_noRefPlayedBoolean <= 0.4808) {
								values = new int[] { 8,  3,  12,  2,  4,  3,  5,  1,  0,  3 };
							} else {
								values = new int[] { 7,  1,  3,  1,  17,  5,  2,  0,  0,  2 };
							}
						} else {
							values = new int[] { 4,  3,  5,  3,  4,  19,  2,  1,  8,  5 };
						}
					} else {
						values = new int[] { 0,  1,  0,  5,  3,  6,  9,  2,  1,  6 };
					}
				} else {
					if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 4.5) {
						if ( user.notStr_postRefPlayScoreAvg <= 0.2411) {
							values = new int[] { 6,  12,  18,  8,  0,  1,  0,  0,  0,  1 };
						} else {
							if ( user.lastThree_changeInScoreAvg <= 0.4163) {
								values = new int[] { 20,  9,  3,  4,  0,  0,  0,  0,  0,  0 };
							} else {
								values = new int[] { 8,  5,  8,  1,  0,  0,  1,  1,  0,  5 };
							}
						}
					} else {
						values = new int[] { 8,  7,  10,  11,  14,  3,  0,  0,  2,  0 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

}