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
public class C{
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
		if ( user.str_numReducedFirstWrongIndexAvg <= 2.1667) {
			if ( user.lastThreeT <= -2.8333) {
				if ( user.notStr_numReducedFirstWrongIndexAvg <= 1.5) {
					values = new int[] { 9,  25,  4,  1,  0,  0,  0,  0,  2,  0 };
				} else {
					values = new int[] { 23,  9,  2,  3,  2,  0,  0,  0,  0,  0 };
				}
			} else {
				if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 18.8333) {
					if ( user.lastThree_numConstructsInLockAvg <= 1.5) {
						if ( user.lastThree_structContentAvg <= 2.1667) {
							values = new int[] { 7,  8,  8,  5,  0,  2,  0,  0,  0,  3 };
						} else {
							if ( user.str_numConstructsInLockAvg <= 0.1667) {
								values = new int[] { 0,  28,  10,  0,  0,  2,  0,  0,  0,  0 };
							} else {
								values = new int[] { 7,  13,  15,  3,  3,  1,  0,  0,  0,  0 };
							}
						}
					} else {
						if ( user.allT <= -1.5) {
							values = new int[] { 10,  9,  13,  1,  0,  1,  0,  0,  0,  0 };
						} else {
							if ( user.notStr_numAttemptsAvg <= 2.8333) {
								values = new int[] { 5,  13,  10,  5,  4,  12,  0,  0,  0,  3 };
							} else {
								values = new int[] { 4,  11,  4,  7,  11,  1,  1,  0,  0,  0 };
							}
						}
					}
				} else {
					if ( user.notStr_numStepsSeparatedNestsAvg <= 0.1667) {
						values = new int[] { 19,  1,  5,  8,  0,  2,  0,  0,  0,  0 };
					} else {
						values = new int[] { 12,  18,  17,  4,  1,  4,  0,  0,  0,  1 };
					}
				}
			}
		} else {
			if ( user.str_nestingDepthAvg <= 1.1667) {
				values = new int[] { 1,  17,  2,  12,  0,  0,  0,  0,  0,  0 };
			} else {
				if ( user.notStr_numCorrectedFirstWrongIndexAvg <= 0.8333) {
					if ( user.notStr_changeInConstructScoreAvg <= -0.1667) {
						values = new int[] { 8,  2,  12,  2,  9,  0,  0,  0,  0,  1 };
					} else {
						if ( puzzle.getNumStmtsInLock() <= 1.5) {
							values = new int[] { 6,  20,  13,  4,  1,  11,  0,  0,  0,  6 };
						} else {
							if ( user.str_numConstructsInLockAvg <= 1.5) {
								values = new int[] { 5,  6,  7,  13,  3,  5,  2,  0,  0,  6 };
							} else {
								values = new int[] { 2,  1,  21,  5,  3,  2,  2,  0,  0,  0 };
							}
						}
					}
				} else {
					values = new int[] { 6,  0,  10,  14,  0,  0,  0,  0,  1,  6 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		if ( user.lastThreeT <= -3.5) {
			values = new int[] { 29,  12,  3,  0,  0,  2,  0,  0,  0,  0 };
		} else {
			if ( user.lastThree_numPlaySameSetAvg <= 1.1667) {
				if ( user.notStr_noRefPlayedBoolean <= 0.9236) {
					if ( puzzle.getNumStmtsInLock() <= 1.5) {
						if ( user.str_numAttemptsConstructErrorsAvg <= 0.1667) {
							if ( puzzle.getStructContent() <= 0.5) {
								if ( user.str_numAttemptsAvg <= 6.5) {
									values = new int[] { 11,  16,  17,  2,  0,  1,  0,  0,  0,  0 };
								} else {
									values = new int[] { 14,  13,  1,  3,  0,  3,  0,  0,  0,  0 };
								}
							} else {
								if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 17.3333) {
									values = new int[] { 5,  11,  2,  4,  1,  2,  2,  0,  0,  3 };
								} else {
									values = new int[] { 6,  8,  14,  1,  1,  7,  0,  0,  0,  3 };
								}
							}
						} else {
							values = new int[] { 9,  3,  6,  2,  5,  0,  0,  0,  0,  11 };
						}
					} else {
						if ( user.notStr_CCntAvg <= 6.1667) {
							if ( user.str_numConstructsAfterLockAvg <= 5.5833) {
								if ( user.notStr_numRepeatedErrorWithInsertionsAvg <= 1.5) {
									if ( user.last_postRefPlayScoreAvg <= 0.2614) {
										values = new int[] { 3,  5,  17,  4,  2,  3,  3,  0,  0,  2 };
									} else {
										values = new int[] { 0,  6,  25,  2,  1,  1,  0,  1,  1,  0 };
									}
								} else {
									values = new int[] { 4,  14,  17,  3,  0,  5,  0,  0,  2,  1 };
								}
							} else {
								values = new int[] { 5,  10,  12,  15,  3,  4,  3,  0,  0,  0 };
							}
						} else {
							if ( user.notStr_structContentAvg <= 3.5) {
								values = new int[] { 2,  27,  8,  5,  4,  2,  0,  0,  0,  2 };
							} else {
								values = new int[] { 9,  7,  7,  0,  2,  1,  3,  0,  0,  1 };
							}
						}
					}
				} else {
					if ( user.last_numConstructsInLockAvg <= 1.5) {
						values = new int[] { 17,  14,  12,  7,  2,  0,  0,  0,  0,  6 };
					} else {
						if ( user.all_cogLoad <= -0.4578) {
							values = new int[] { 11,  7,  3,  1,  0,  3,  0,  0,  0,  1 };
						} else {
							values = new int[] { 1,  11,  0,  22,  3,  1,  0,  0,  0,  0 };
						}
					}
				}
			} else {
				values = new int[] { 22,  6,  7,  1,  2,  1,  0,  0,  0,  11 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		if ( user.notStr_cogLoadAvg <= -3.1667) {
			if ( user.notStr_numCorrectedFirstWrongIndexAvg <= 0.5) {
				if ( user.last_numRepeatedErrorWithInsertionsAvg <= 0.5) {
					values = new int[] { 12,  9,  3,  3,  2,  7,  2,  0,  0,  4 };
				} else {
					values = new int[] { 10,  18,  4,  0,  0,  1,  0,  0,  1,  0 };
				}
			} else {
				values = new int[] { 26,  3,  1,  0,  0,  0,  0,  0,  0,  4 };
			}
		} else {
			if ( user.notStr_TbCeCntAvg <= 0.1667) {
				if ( user.notStr_changeInScoreAvg <= 0.5769) {
					if ( user.allC <= -1.5) {
						if ( user.str_numCorrectButNotPlayedAvg <= 0.1667) {
							values = new int[] { 15,  17,  25,  4,  0,  3,  0,  0,  0,  0 };
						} else {
							if ( user.lastThree_numConstructsAfterLockAvg <= 2.5) {
								values = new int[] { 7,  21,  4,  3,  2,  2,  1,  0,  0,  2 };
							} else {
								values = new int[] { 1,  9,  4,  10,  3,  1,  1,  0,  0,  0 };
							}
						}
					} else {
						if ( user.last_changeInScoreAvg <= 0.3798) {
							if ( user.all_cogLoad <= -0.3713) {
								values = new int[] { 6,  3,  8,  2,  4,  2,  0,  0,  0,  3 };
							} else {
								values = new int[] { 4,  3,  5,  13,  3,  16,  3,  0,  0,  3 };
							}
						} else {
							values = new int[] { 3,  7,  17,  12,  11,  0,  0,  0,  0,  3 };
						}
					}
				} else {
					if ( user.last_numAttemptsAvg <= 6.5) {
						values = new int[] { 6,  2,  14,  9,  2,  4,  1,  0,  0,  1 };
					} else {
						values = new int[] { 5,  0,  21,  2,  0,  1,  0,  0,  0,  5 };
					}
				}
			} else {
				if ( user.str_uniqueStmtsAvg <= 0.8333) {
					if ( user.str_numMoveSameStmtConsecutivelyAvg <= 2.1667) {
						if ( user.lastThree_CbCeCntAvg <= 0.5) {
							values = new int[] { 15,  33,  3,  8,  2,  0,  0,  0,  0,  1 };
						} else {
							values = new int[] { 8,  30,  21,  6,  0,  2,  0,  1,  0,  0 };
						}
					} else {
						values = new int[] { 17,  8,  6,  9,  3,  1,  0,  0,  0,  1 };
					}
				} else {
					values = new int[] { 3,  9,  3,  9,  2,  4,  0,  0,  0,  5 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		if ( puzzle.getTbCOeCnt() <= 0.5) {
			if ( user.last_numPlaySameSetAvg <= 0.5) {
				if ( user.lastThree_uniqueStmtsAvg <= 0.1667) {
					if ( user.str_noRefPlayedBoolean <= 0.075) {
						if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 13.3333) {
							values = new int[] { 11,  3,  14,  0,  0,  3,  0,  0,  0,  0 };
						} else {
							values = new int[] { 16,  8,  2,  3,  1,  1,  0,  0,  0,  1 };
						}
					} else {
						values = new int[] { 11,  12,  19,  3,  6,  4,  0,  0,  0,  2 };
					}
				} else {
					if ( puzzle.getCCnt() <= 1.5) {
						if ( user.all_cogLoad <= -0.3487) {
							if ( user.last_cogLoadAvg <= -2.5) {
								if ( user.notStr_changeInScoreAvg <= 0.3581) {
									values = new int[] { 5,  23,  5,  2,  1,  3,  0,  0,  0,  5 };
								} else {
									values = new int[] { 20,  13,  4,  0,  1,  1,  0,  0,  0,  0 };
								}
							} else {
								if ( user.str_postRefPlayScoreAvg <= 0.1293) {
									values = new int[] { 2,  30,  16,  7,  2,  3,  0,  0,  0,  0 };
								} else {
									values = new int[] { 1,  9,  11,  8,  0,  3,  5,  0,  2,  1 };
								}
							}
						} else {
							if ( user.notStr_postRefPlayScoreAvg <= 0.3403) {
								values = new int[] { 1,  2,  20,  5,  4,  2,  0,  0,  0,  5 };
							} else {
								values = new int[] { 1,  7,  2,  13,  4,  8,  0,  0,  0,  6 };
							}
						}
					} else {
						if ( user.str_numReducedFirstWrongIndexAvg <= 0.3333) {
							values = new int[] { 10,  15,  7,  3,  0,  2,  0,  0,  0,  0 };
						} else {
							values = new int[] { 22,  10,  1,  6,  1,  1,  0,  0,  0,  0 };
						}
					}
				}
			} else {
				if ( user.last_changeInScoreAvg <= 0.4273) {
					values = new int[] { 24,  8,  21,  3,  4,  2,  0,  0,  0,  0 };
				} else {
					if ( user.notStr_numReducedFirstWrongIndexAvg <= 2.1667) {
						values = new int[] { 5,  5,  17,  3,  1,  0,  0,  0,  0,  0 };
					} else {
						values = new int[] { 5,  6,  11,  13,  0,  0,  0,  0,  0,  2 };
					}
				}
			}
		} else {
			if ( user.str_postRefPlayScoreAvg <= 0.0417) {
				values = new int[] { 1,  11,  9,  2,  0,  9,  1,  0,  1,  1 };
			} else {
				values = new int[] { 0,  1,  5,  2,  10,  7,  0,  0,  0,  8 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		if ( user.lastThreeT <= -0.1667) {
			if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 52.0) {
				if ( user.last_numReducedFirstWrongIndexAvg <= 1.5) {
					if ( user.lastThree_CbCeCntAvg <= 0.5) {
						values = new int[] { 5,  30,  9,  0,  2,  1,  0,  0,  0,  6 };
					} else {
						if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 16.8333) {
							if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 12.1667) {
								values = new int[] { 6,  10,  5,  1,  0,  5,  2,  0,  0,  1 };
							} else {
								values = new int[] { 6,  6,  15,  2,  0,  1,  0,  1,  0,  3 };
							}
						} else {
							values = new int[] { 21,  6,  2,  1,  4,  0,  0,  0,  0,  3 };
						}
					}
				} else {
					if ( user.allC <= -1.5) {
						values = new int[] { 29,  6,  3,  5,  0,  0,  0,  0,  0,  0 };
					} else {
						values = new int[] { 18,  3,  9,  4,  1,  1,  0,  0,  0,  1 };
					}
				}
			} else {
				values = new int[] { 9,  8,  4,  10,  2,  0,  1,  0,  0,  12 };
			}
		} else {
			if ( user.last_cogLoadAvg <= -2.5) {
				if ( user.lastThree_CCntAvg <= 5.1667) {
					values = new int[] { 9,  30,  7,  4,  1,  5,  0,  0,  0,  1 };
				} else {
					if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 17.5) {
						values = new int[] { 7,  7,  18,  2,  0,  1,  0,  0,  0,  0 };
					} else {
						values = new int[] { 9,  7,  5,  4,  0,  0,  1,  0,  0,  0 };
					}
				}
			} else {
				if ( user.lastThreeC <= 4.3333) {
					if ( user.str_cogLoadAvg <= 3.8333) {
						if ( user.lastThree_numStepsSeparatedNestsAvg <= 0.1667) {
							values = new int[] { 7,  14,  15,  24,  5,  2,  0,  0,  0,  0 };
						} else {
							values = new int[] { 3,  6,  27,  10,  11,  10,  0,  0,  2,  0 };
						}
					} else {
						if ( user.notStr_numAttemptsAvg <= 4.8333) {
							values = new int[] { 3,  0,  31,  4,  1,  3,  1,  0,  0,  2 };
						} else {
							values = new int[] { 2,  2,  12,  1,  1,  0,  0,  0,  0,  12 };
						}
					}
				} else {
					values = new int[] { 5,  26,  8,  6,  1,  1,  0,  0,  0,  3 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		if ( user.notStr_numCorrectedFirstWrongIndexAvg <= 0.1667) {
			if ( user.notStr_numRepeatedErrorWithInsertionsAvg <= 0.5) {
				values = new int[] { 8,  6,  13,  6,  11,  5,  0,  0,  0,  8 };
			} else {
				if ( user.str_nestingDepthAvg <= 1.1667) {
					if ( user.last_uniqueStmtsAvg <= 0.5) {
						if ( puzzle.getNumStmtsAfterLock() <= 4.5) {
							values = new int[] { 2,  29,  9,  4,  2,  3,  0,  0,  0,  0 };
						} else {
							values = new int[] { 7,  5,  15,  3,  0,  1,  0,  0,  2,  0 };
						}
					} else {
						values = new int[] { 0,  25,  7,  3,  0,  0,  0,  0,  0,  0 };
					}
				} else {
					if ( user.str_cogLoadAvg <= 4.5) {
						if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 36.25) {
							values = new int[] { 5,  7,  10,  9,  7,  4,  4,  0,  0,  2 };
						} else {
							values = new int[] { 5,  7,  16,  2,  0,  1,  0,  0,  0,  0 };
						}
					} else {
						values = new int[] { 8,  18,  6,  8,  1,  0,  0,  0,  0,  6 };
					}
				}
			}
		} else {
			if ( puzzle.getStructContent() <= 0.5) {
				if ( puzzle.getNumStmtsInLock() <= 1.5) {
					if ( user.str_nestingDepthAvg <= 0.5) {
						values = new int[] { 30,  5,  8,  0,  0,  0,  0,  0,  0,  0 };
					} else {
						if ( user.notStr_CbTbCeeCntAvg <= 0.1667) {
							values = new int[] { 13,  16,  5,  7,  0,  1,  0,  0,  0,  0 };
						} else {
							values = new int[] { 14,  3,  6,  6,  2,  0,  0,  0,  0,  2 };
						}
					}
				} else {
					if ( user.lastThree_changeInScoreAvg <= 0.388) {
						values = new int[] { 14,  9,  8,  3,  1,  9,  0,  0,  0,  2 };
					} else {
						if ( user.last_postRefPlayScoreAvg <= 0.3542) {
							values = new int[] { 15,  2,  17,  10,  0,  0,  0,  0,  0,  5 };
						} else {
							values = new int[] { 2,  12,  11,  5,  2,  0,  0,  0,  1,  5 };
						}
					}
				}
			} else {
				if ( user.last_CbCeCntAvg <= 0.5) {
					if ( user.notStr_numStepsSeparatedNestsAvg <= 0.1667) {
						values = new int[] { 5,  6,  13,  1,  7,  4,  0,  0,  0,  0 };
					} else {
						values = new int[] { 9,  6,  4,  6,  4,  0,  2,  0,  0,  1 };
					}
				} else {
					values = new int[] { 1,  3,  10,  1,  4,  6,  0,  1,  0,  14 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 40.1667) {
			if ( user.lastThree_cogLoadAvg <= -3.1667) {
				if ( user.lastThree_cogLoadAvg <= -3.5) {
					values = new int[] { 21,  11,  2,  0,  0,  5,  0,  0,  0,  0 };
				} else {
					values = new int[] { 16,  12,  8,  1,  3,  0,  0,  0,  2,  6 };
				}
			} else {
				if ( user.notStr_cogLoadAvg <= -1.8333) {
					if ( user.lastThree_cogLoadAvg <= 0.1667) {
						if ( user.str_postRefPlayScoreAvg <= 0.2321) {
							if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 0.4167) {
								if ( user.lastThree_nestingDepthAvg <= 1.5) {
									values = new int[] { 10,  14,  14,  1,  0,  3,  0,  0,  0,  0 };
								} else {
									values = new int[] { 12,  21,  5,  4,  2,  0,  0,  0,  0,  1 };
								}
							} else {
								values = new int[] { 9,  35,  3,  5,  0,  0,  0,  0,  0,  2 };
							}
						} else {
							values = new int[] { 8,  11,  10,  8,  1,  7,  3,  0,  0,  1 };
						}
					} else {
						values = new int[] { 5,  8,  10,  1,  2,  2,  0,  0,  0,  10 };
					}
				} else {
					if ( user.last_uniqueStmtsAvg <= 0.5) {
						if ( puzzle.getCCnt() <= 0.5) {
							if ( user.lastThree_countsOfPlayPuzConsecutivelyAvg <= 1.1667) {
								values = new int[] { 1,  2,  12,  4,  2,  9,  0,  0,  0,  0 };
							} else {
								values = new int[] { 4,  10,  6,  1,  9,  6,  0,  0,  0,  1 };
							}
						} else {
							if ( user.lastThree_postRefPlayScoreAvg <= 0.3779) {
								values = new int[] { 1,  11,  7,  11,  0,  1,  0,  0,  0,  2 };
							} else {
								values = new int[] { 7,  19,  6,  4,  1,  1,  0,  0,  0,  0 };
							}
						}
					} else {
						values = new int[] { 3,  11,  9,  22,  3,  2,  1,  0,  0,  0 };
					}
				}
			}
		} else {
			if ( user.last_noRefPlayedBoolean <= 0.3923) {
				if ( user.all_cogLoad <= -0.2754) {
					values = new int[] { 30,  7,  6,  4,  6,  0,  0,  0,  0,  4 };
				} else {
					values = new int[] { 4,  3,  10,  4,  0,  1,  1,  0,  0,  1 };
				}
			} else {
				if ( user.notStr_CCntAvg <= 5.6667) {
					values = new int[] { 1,  5,  3,  22,  6,  1,  0,  0,  1,  1 };
				} else {
					values = new int[] { 5,  4,  9,  6,  2,  3,  0,  0,  0,  5 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		if ( user.lastThree_cogLoadAvg <= -1.8333) {
			if ( user.notStr_numAttemptsAvg <= 1.8333) {
				if ( user.str_numConstructsAfterLockAvg <= 3.3333) {
					values = new int[] { 6,  11,  6,  0,  1,  1,  0,  0,  0,  0 };
				} else {
					values = new int[] { 0,  13,  11,  11,  2,  0,  0,  0,  0,  1 };
				}
			} else {
				if ( user.notStr_noRefPlayedBoolean <= 0.5903) {
					if ( user.lastThree_cogLoadAvg <= -3.1667) {
						values = new int[] { 21,  16,  3,  1,  0,  0,  0,  0,  0,  1 };
					} else {
						if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
							values = new int[] { 15,  25,  5,  7,  1,  0,  0,  0,  0,  1 };
						} else {
							values = new int[] { 7,  10,  20,  2,  4,  0,  0,  0,  0,  2 };
						}
					}
				} else {
					if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 19.1667) {
						values = new int[] { 18,  10,  11,  2,  0,  5,  0,  0,  0,  2 };
					} else {
						values = new int[] { 28,  1,  1,  1,  0,  1,  0,  0,  0,  4 };
					}
				}
			}
		} else {
			if ( user.str_numMoveSameStmtConsecutivelyAvg <= 2.5833) {
				if ( user.lastThree_TbObCeeCntAvg <= 0.1667) {
					if ( user.lastThreeC <= 2.8333) {
						if ( user.last_noRefPlayedBoolean <= 0.7571) {
							if ( user.str_numMoveSameStmtConsecutivelyAvg <= 1.1667) {
								if ( user.last_cogLoadAvg <= -2.5) {
									values = new int[] { 6,  16,  14,  5,  1,  2,  0,  0,  0,  0 };
								} else {
									values = new int[] { 1,  6,  14,  7,  7,  8,  0,  0,  0,  1 };
								}
							} else {
								values = new int[] { 1,  20,  10,  1,  3,  0,  0,  0,  0,  3 };
							}
						} else {
							values = new int[] { 5,  0,  12,  7,  0,  2,  0,  1,  0,  9 };
						}
					} else {
						values = new int[] { 7,  28,  6,  1,  2,  4,  0,  0,  0,  0 };
					}
				} else {
					values = new int[] { 1,  2,  12,  17,  2,  4,  0,  0,  0,  2 };
				}
			} else {
				if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 14.5) {
					values = new int[] { 6,  7,  6,  14,  1,  0,  1,  0,  0,  0 };
				} else {
					if ( user.notStr_changeInScoreAvg <= 0.4021) {
						values = new int[] { 14,  1,  5,  3,  3,  6,  0,  0,  0,  0 };
					} else {
						values = new int[] { 8,  10,  7,  4,  12,  2,  0,  0,  2,  9 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		if ( user.lastThree_numCorrectedFirstWrongIndexAvg <= 0.1667) {
			if ( user.notStr_cogLoadAvg <= -2.1667) {
				if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 17.5) {
					if ( user.str_postRefPlayScoreAvg <= 0.1303) {
						if ( user.lastThree_structContentAvg <= 2.8333) {
							values = new int[] { 5,  50,  3,  5,  2,  2,  0,  0,  0,  1 };
						} else {
							values = new int[] { 6,  13,  11,  0,  1,  0,  0,  0,  0,  0 };
						}
					} else {
						values = new int[] { 6,  14,  8,  8,  0,  3,  1,  0,  0,  6 };
					}
				} else {
					values = new int[] { 14,  8,  18,  1,  0,  0,  1,  0,  0,  3 };
				}
			} else {
				if ( user.str_numConstructsInLockAvg <= 0.1667) {
					values = new int[] { 2,  9,  13,  10,  2,  8,  0,  0,  0,  0 };
				} else {
					values = new int[] { 4,  12,  14,  7,  13,  1,  2,  0,  0,  6 };
				}
			}
		} else {
			if ( user.str_structContentAvg <= 3.1667) {
				if ( user.notStr_structContentAvg <= 3.5) {
					if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 13.0) {
						values = new int[] { 13,  12,  4,  3,  4,  4,  0,  0,  0,  0 };
					} else {
						if ( user.lastThree_numAttemptsAvg <= 3.8333) {
							values = new int[] { 5,  6,  23,  0,  0,  2,  1,  0,  0,  0 };
						} else {
							if ( user.allC <= -0.5) {
								values = new int[] { 12,  19,  19,  3,  0,  0,  0,  0,  0,  0 };
							} else {
								values = new int[] { 5,  12,  4,  11,  0,  0,  0,  0,  0,  0 };
							}
						}
					}
				} else {
					if ( user.lastThreeT <= -0.3333) {
						values = new int[] { 26,  11,  3,  1,  1,  1,  0,  0,  0,  0 };
					} else {
						values = new int[] { 8,  8,  13,  1,  0,  3,  1,  0,  0,  1 };
					}
				}
			} else {
				if ( user.lastThree_unfamMethodsAvg <= 1.1667) {
					if ( user.notStr_cogLoadAvg <= -1.8333) {
						values = new int[] { 12,  11,  1,  2,  1,  3,  0,  0,  0,  5 };
					} else {
						values = new int[] { 6,  7,  21,  11,  3,  8,  0,  0,  0,  2 };
					}
				} else {
					values = new int[] { 7,  4,  2,  5,  2,  0,  0,  0,  2,  11 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		if ( user.str_numConstructsAfterLockAvg <= 1.8333) {
			if ( user.notStr_CbTbCeeCntAvg <= 0.5) {
				if ( user.lastThreeC <= -2.1667) {
					values = new int[] { 21,  15,  14,  0,  0,  2,  0,  0,  0,  0 };
				} else {
					if ( user.lastThree_numAttemptsWithoutOrderingBoxAvg <= 0.1667) {
						if ( user.lastThree_nestingDepthAvg <= 1.8333) {
							values = new int[] { 6,  5,  11,  4,  8,  3,  0,  0,  0,  0 };
						} else {
							values = new int[] { 6,  9,  12,  4,  1,  0,  0,  0,  0,  0 };
						}
					} else {
						values = new int[] { 10,  20,  11,  0,  0,  0,  0,  3,  0,  0 };
					}
				}
			} else {
				values = new int[] { 6,  21,  2,  1,  1,  2,  1,  0,  0,  0 };
			}
		} else {
			if ( user.str_numCorrectedFirstWrongIndexAvg <= 1.1667) {
				if ( user.str_numPlaySameSetAvg <= 2.1667) {
					if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 25.5) {
						if ( puzzle.getNumStmtsAfterLock() <= 3.5) {
							if ( user.notStr_postRefPlayScoreAvg <= 0.2847) {
								values = new int[] { 0,  16,  11,  0,  0,  5,  0,  0,  0,  0 };
							} else {
								values = new int[] { 6,  21,  1,  0,  0,  1,  0,  0,  0,  1 };
							}
						} else {
							if ( user.str_cogLoadAvg <= 3.5833) {
								if ( user.all_cogLoad <= -0.5273) {
									values = new int[] { 4,  4,  5,  5,  5,  1,  2,  0,  0,  2 };
								} else {
									values = new int[] { 0,  15,  7,  21,  4,  3,  2,  0,  0,  1 };
								}
							} else {
								if ( user.lastThree_numConstructsAfterLockAvg <= 3.1667) {
									values = new int[] { 4,  17,  12,  6,  0,  1,  0,  0,  1,  0 };
								} else {
									values = new int[] { 19,  5,  9,  10,  1,  0,  0,  0,  0,  19 };
								}
							}
						}
					} else {
						if ( user.all_cogLoad <= -0.4264) {
							values = new int[] { 2,  3,  21,  0,  0,  0,  0,  0,  0,  4 };
						} else {
							values = new int[] { 6,  1,  4,  6,  3,  5,  0,  0,  0,  7 };
						}
					}
				} else {
					values = new int[] { 12,  1,  5,  11,  2,  0,  0,  0,  0,  1 };
				}
			} else {
				if ( user.notStr_cogLoadAvg <= -2.8333) {
					values = new int[] { 19,  7,  1,  1,  0,  3,  0,  0,  0,  1 };
				} else {
					if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
						values = new int[] { 6,  3,  5,  16,  1,  4,  0,  0,  0,  3 };
					} else {
						values = new int[] { 11,  4,  13,  2,  7,  6,  1,  0,  2,  3 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

}