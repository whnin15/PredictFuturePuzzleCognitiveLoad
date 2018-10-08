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
public class T{
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
		if ( user.lastThreeCbTe <= 1.8333) {
			if ( user.str_unfamMethodsAvg <= 1.1667) {
				if ( user.notStr_noRefPlayedBoolean <= 0.4433) {
					if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 24.1667) {
						values = new int[] { 5,  9,  11,  2,  0,  2,  1,  0,  0,  2 };
					} else {
						values = new int[] { 0,  7,  20,  0,  4,  3,  2,  0,  0,  4 };
					}
				} else {
					values = new int[] { 8,  19,  5,  8,  4,  1,  3,  0,  0,  4 };
				}
			} else {
				if ( user.lastThreeC <= -2.8333) {
					if ( user.notStr_numCorrectedFirstWrongIndexAvg <= 0.1667) {
						values = new int[] { 7,  5,  7,  14,  1,  4,  0,  0,  0,  6 };
					} else {
						if ( user.last_changeInScoreAvg <= 0.5609) {
							values = new int[] { 5,  5,  5,  2,  1,  3,  1,  0,  0,  7 };
						} else {
							values = new int[] { 10,  12,  9,  1,  2,  1,  0,  0,  0,  3 };
						}
					}
				} else {
					if ( user.str_changeInScoreAvg <= 0.2532) {
						if ( user.notStr_noRefPlayedBoolean <= 0.1863) {
							values = new int[] { 0,  2,  7,  3,  9,  2,  2,  0,  0,  3 };
						} else {
							if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 2.5) {
								if ( user.lastThreeCbTe <= -0.8333) {
									values = new int[] { 0,  2,  7,  1,  2,  1,  1,  1,  0,  34 };
								} else {
									values = new int[] { 0,  4,  6,  4,  8,  0,  1,  2,  0,  17 };
								}
							} else {
								values = new int[] { 7,  1,  1,  2,  5,  5,  0,  0,  0,  12 };
							}
						}
					} else {
						if ( user.str_changeInConstructScoreAvg <= -0.8333) {
							values = new int[] { 6,  5,  11,  1,  3,  4,  2,  3,  0,  14 };
						} else {
							if ( user.lastThreeT <= -0.1667) {
								values = new int[] { 7,  4,  6,  22,  0,  4,  0,  7,  0,  12 };
							} else {
								if ( user.lastThreeTbCe <= 1.1667) {
									values = new int[] { 0,  1,  1,  7,  3,  9,  10,  2,  0,  4 };
								} else {
									values = new int[] { 0,  0,  3,  9,  21,  1,  0,  1,  0,  3 };
								}
							}
						}
					}
				}
			}
		} else {
			if ( user.notStr_TbCObTeeCntAvg <= 0.1667) {
				if ( user.lastThree_cogLoadAvg <= -2.1667) {
					if ( user.notStr_numConstructsAfterLockAvg <= 2.5) {
						if ( user.last_changeInScoreAvg <= 0.1455) {
							values = new int[] { 27,  16,  7,  7,  0,  4,  0,  0,  0,  1 };
						} else {
							values = new int[] { 8,  4,  16,  5,  3,  1,  0,  1,  0,  1 };
						}
					} else {
						if ( user.notStr_uniqueStmtsAvg <= 0.8333) {
							if ( user.all_cogLoad <= -0.6422) {
								values = new int[] { 5,  31,  2,  8,  2,  0,  0,  0,  0,  2 };
							} else {
								if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 4.1667) {
									if ( user.lastThree_numPlaySameSetAvg <= 0.1667) {
										if ( user.notStr_noRefPlayedBoolean <= 0.3611) {
											values = new int[] { 7,  20,  1,  4,  1,  1,  0,  0,  0,  0 };
										} else {
											values = new int[] { 12,  12,  7,  0,  6,  3,  0,  0,  0,  0 };
										}
									} else {
										values = new int[] { 0,  16,  13,  3,  2,  0,  1,  0,  0,  0 };
									}
								} else {
									values = new int[] { 7,  12,  8,  4,  0,  0,  0,  0,  0,  6 };
								}
							}
						} else {
							values = new int[] { 8,  10,  18,  7,  3,  4,  0,  3,  0,  0 };
						}
					}
				} else {
					if ( user.last_numConstructsAfterLockAvg <= 4.5) {
						if ( user.notStr_numAttemptsAvg <= 4.5) {
							if ( user.str_numCorrectButNotPlayedAvg <= 0.25) {
								if ( puzzle.getUnfamiliarMethodsCount() <= 2.5) {
									values = new int[] { 6,  5,  7,  6,  8,  0,  0,  0,  0,  0 };
								} else {
									values = new int[] { 0,  2,  3,  4,  7,  8,  3,  0,  0,  1 };
								}
							} else {
								values = new int[] { 6,  19,  7,  14,  5,  1,  6,  0,  1,  1 };
							}
						} else {
							if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 30.25) {
								values = new int[] { 6,  2,  11,  3,  16,  2,  1,  0,  0,  0 };
							} else {
								values = new int[] { 11,  0,  8,  2,  4,  1,  0,  0,  0,  5 };
							}
						}
					} else {
						if ( user.notStr_CCntAvg <= 4.8333) {
							values = new int[] { 11,  5,  1,  6,  2,  3,  2,  2,  0,  1 };
						} else {
							if ( user.lastThree_cogLoadAvg <= -1.5) {
								values = new int[] { 3,  14,  25,  2,  2,  12,  0,  0,  0,  3 };
							} else {
								if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
									values = new int[] { 2,  8,  13,  10,  6,  4,  1,  0,  0,  1 };
								} else {
									if ( user.notStr_cogLoadAvg <= -1.1667) {
										values = new int[] { 2,  7,  6,  10,  8,  14,  2,  0,  0,  1 };
									} else {
										if ( user.notStr_numReducedFirstWrongIndexAvg <= 1.8333) {
											values = new int[] { 0,  0,  0,  6,  6,  27,  6,  6,  1,  3 };
										} else {
											values = new int[] { 0,  0,  2,  11,  1,  9,  12,  1,  0,  8 };
										}
									}
								}
							}
						}
					}
				}
			} else {
				if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
					if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 0.8333) {
						if ( user.lastThree_numAttemptsAvg <= 1.8333) {
							values = new int[] { 12,  14,  13,  1,  3,  2,  0,  0,  0,  0 };
						} else {
							values = new int[] { 8,  31,  3,  7,  3,  3,  1,  0,  0,  0 };
						}
					} else {
						if ( user.last_numConstructsAfterLockAvg <= 4.5) {
							values = new int[] { 35,  12,  6,  2,  5,  1,  0,  0,  0,  0 };
						} else {
							values = new int[] { 19,  25,  4,  2,  3,  0,  0,  0,  0,  1 };
						}
					}
				} else {
					if ( user.allT <= -1.5) {
						values = new int[] { 6,  16,  17,  1,  2,  5,  0,  0,  0,  5 };
					} else {
						values = new int[] { 0,  2,  5,  13,  11,  7,  4,  0,  2,  0 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		if ( user.lastThreeT <= -2.5) {
			if ( user.lastThree_noRefPlayedBoolean <= 0.0303) {
				values = new int[] { 24,  6,  6,  6,  2,  0,  0,  2,  0,  0 };
			} else {
				if ( user.last_unfamMethodsAvg <= 1.5) {
					if ( user.last_numConstructsAfterLockAvg <= 5.5) {
						if ( user.allT <= -2.5) {
							if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
								values = new int[] { 31,  9,  8,  3,  0,  0,  0,  0,  0,  0 };
							} else {
								values = new int[] { 14,  15,  9,  3,  2,  0,  0,  0,  0,  2 };
							}
						} else {
							if ( user.last_noRefPlayedBoolean <= 0.45) {
								values = new int[] { 7,  10,  20,  5,  0,  1,  0,  1,  0,  0 };
							} else {
								values = new int[] { 7,  23,  11,  5,  3,  1,  0,  0,  0,  0 };
							}
						}
					} else {
						if ( user.lastThree_numCorrectedFirstWrongIndexAvg <= 0.1667) {
							values = new int[] { 8,  14,  3,  0,  4,  0,  2,  0,  0,  2 };
						} else {
							values = new int[] { 2,  29,  1,  1,  0,  0,  2,  0,  0,  3 };
						}
					}
				} else {
					if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 20.0) {
						values = new int[] { 14,  13,  5,  2,  1,  0,  0,  0,  0,  9 };
					} else {
						values = new int[] { 23,  3,  6,  1,  0,  4,  0,  0,  0,  2 };
					}
				}
			}
		} else {
			if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
				if ( user.lastThree_unfamMethodsAvg <= 0.8333) {
					if ( user.str_cogLoadAvg <= 1.0) {
						if ( user.lastThree_numPlaySameSetAvg <= 0.1667) {
							if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 9.5) {
								values = new int[] { 29,  8,  1,  1,  2,  1,  0,  0,  0,  0 };
							} else {
								values = new int[] { 10,  17,  2,  4,  0,  1,  0,  0,  0,  0 };
							}
						} else {
							values = new int[] { 24,  29,  8,  4,  7,  0,  0,  0,  0,  0 };
						}
					} else {
						values = new int[] { 8,  16,  5,  8,  1,  1,  0,  0,  0,  0 };
					}
				} else {
					if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
						if ( user.notStr_cogLoadAvg <= -2.1667) {
							values = new int[] { 8,  23,  0,  5,  3,  0,  0,  0,  0,  0 };
						} else {
							if ( user.notStr_postRefPlayScoreAvg <= 0.2492) {
								values = new int[] { 0,  8,  6,  12,  6,  2,  1,  0,  0,  0 };
							} else {
								values = new int[] { 18,  3,  5,  7,  3,  1,  0,  0,  0,  0 };
							}
						}
					} else {
						if ( puzzle.getNumStmtsAfterLock() <= 11.5) {
							if ( user.notStr_TbCeCntAvg <= 0.5) {
								if ( user.lastThree_cogLoadAvg <= -1.1667) {
									values = new int[] { 2,  5,  13,  0,  0,  3,  0,  0,  0,  6 };
								} else {
									if ( user.str_numAttemptsConstructErrorsAvg <= 3.8333) {
										values = new int[] { 1,  3,  3,  9,  16,  11,  2,  2,  0,  3 };
									} else {
										values = new int[] { 4,  0,  5,  5,  0,  5,  2,  0,  0,  7 };
									}
								}
							} else {
								if ( user.str_cogLoadAvg <= 1.0) {
									values = new int[] { 4,  9,  7,  11,  0,  0,  0,  0,  0,  0 };
								} else {
									values = new int[] { 8,  0,  16,  7,  2,  4,  0,  0,  0,  5 };
								}
							}
						} else {
							values = new int[] { 10,  17,  6,  1,  1,  4,  0,  0,  0,  0 };
						}
					}
				}
			} else {
				if ( user.str_unfamMethodsAvg <= 1.4167) {
					if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.5833) {
						if ( user.allC <= -1.5) {
							values = new int[] { 2,  17,  9,  11,  3,  0,  0,  0,  0,  0 };
						} else {
							if ( puzzle.getUnfamiliarMethodsCount() <= 2.5) {
								if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 0.4167) {
									values = new int[] { 0,  13,  27,  10,  0,  4,  2,  0,  0,  2 };
								} else {
									if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 19.5833) {
										values = new int[] { 4,  4,  3,  16,  4,  4,  0,  0,  0,  0 };
									} else {
										values = new int[] { 7,  4,  8,  3,  6,  6,  3,  0,  0,  5 };
									}
								}
							} else {
								if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 26.3333) {
									if ( user.str_numConstructsAfterLockAvg <= 5.75) {
										if ( user.lastThree_cogLoadAvg <= -1.8333) {
											values = new int[] { 5,  15,  8,  6,  4,  2,  4,  1,  0,  0 };
										} else {
											if ( user.lastThree_countsOfPlayPuzConsecutivelyAvg <= 1.1667) {
												values = new int[] { 0,  4,  3,  2,  6,  14,  5,  0,  0,  2 };
											} else {
												values = new int[] { 0,  2,  6,  6,  5,  5,  6,  0,  0,  4 };
											}
										}
									} else {
										values = new int[] { 0,  5,  1,  4,  11,  13,  3,  3,  1,  1 };
									}
								} else {
									values = new int[] { 2,  1,  11,  3,  0,  8,  7,  0,  0,  2 };
								}
							}
						}
					} else {
						if ( user.str_changeInScoreAvg <= 0.3342) {
							values = new int[] { 1,  0,  2,  25,  2,  5,  1,  0,  2,  1 };
						} else {
							if ( user.str_numAttemptsOfoneOrZeroInDoTAvg <= 0.5) {
								values = new int[] { 0,  9,  5,  1,  12,  7,  0,  0,  0,  6 };
							} else {
								values = new int[] { 2,  1,  5,  13,  3,  2,  2,  0,  0,  5 };
							}
						}
					}
				} else {
					if ( user.notStr_constructReverseUsageAvg <= 0.1667) {
						if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 23.5) {
							values = new int[] { 6,  6,  19,  1,  4,  2,  1,  0,  0,  9 };
						} else {
							if ( user.lastThreeCbTe <= 1.6667) {
								if ( user.lastThree_numAttemptsAvg <= 4.5) {
									values = new int[] { 0,  7,  10,  3,  2,  2,  3,  2,  0,  13 };
								} else {
									if ( user.str_structContentAvg <= 3.1667) {
										values = new int[] { 2,  4,  2,  12,  0,  4,  4,  1,  0,  5 };
									} else {
										values = new int[] { 0,  4,  9,  17,  12,  0,  0,  1,  0,  2 };
									}
								}
							} else {
								values = new int[] { 2,  4,  7,  1,  13,  1,  3,  0,  0,  0 };
							}
						}
					} else {
						if ( puzzle.getStructContent() <= 0.5) {
							if ( user.str_numAttemptsOfoneOrZeroInDoTAvg <= 0.4167) {
								values = new int[] { 0,  1,  12,  0,  4,  3,  0,  0,  0,  11 };
							} else {
								values = new int[] { 0,  0,  2,  2,  2,  3,  9,  3,  0,  23 };
							}
						} else {
							values = new int[] { 3,  13,  3,  8,  6,  4,  1,  5,  0,  10 };
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		if ( user.lastThree_cogLoadAvg <= -1.8333) {
			if ( puzzle.getTCnt() <= 2.5) {
				if ( user.lastThree_nestingDepthAvg <= 1.8333) {
					if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
						if ( user.last_TbCeCntAvg <= 0.5) {
							if ( user.lastThree_uniqueStmtsAvg <= 0.5) {
								values = new int[] { 10,  6,  8,  3,  4,  1,  1,  0,  0,  1 };
							} else {
								values = new int[] { 24,  9,  5,  2,  0,  2,  0,  0,  0,  0 };
							}
						} else {
							if ( user.allT <= -2.5) {
								values = new int[] { 19,  16,  2,  2,  0,  0,  0,  0,  0,  0 };
							} else {
								values = new int[] { 7,  33,  5,  4,  2,  0,  0,  0,  0,  0 };
							}
						}
					} else {
						if ( user.last_TbCeCntAvg <= 0.5) {
							if ( user.str_numConstructsInLockAvg <= 0.1667) {
								if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 10.8333) {
									values = new int[] { 3,  2,  18,  6,  0,  2,  0,  1,  0,  1 };
								} else {
									if ( user.lastThree_numRepeatedErrorWithInsertionsAvg <= 1.5) {
										values = new int[] { 9,  7,  17,  0,  4,  2,  0,  0,  0,  1 };
									} else {
										values = new int[] { 5,  10,  7,  3,  1,  2,  3,  0,  0,  0 };
									}
								}
							} else {
								if ( puzzle.getStructContent() <= 0.5) {
									values = new int[] { 5,  3,  4,  3,  6,  5,  1,  4,  0,  5 };
								} else {
									values = new int[] { 13,  8,  10,  2,  1,  6,  0,  1,  0,  5 };
								}
							}
						} else {
							if ( user.lastThree_numCorrectedFirstWrongIndexAvg <= 0.1667) {
								if ( user.lastThree_numStepsSeparatedNestsAvg <= 0.1667) {
									if ( user.lastThree_numConstructsInLockAvg <= 1.5833) {
										values = new int[] { 3,  4,  6,  8,  0,  4,  0,  0,  0,  6 };
									} else {
										values = new int[] { 5,  9,  4,  11,  1,  5,  1,  2,  0,  0 };
									}
								} else {
									values = new int[] { 4,  10,  6,  4,  2,  6,  0,  0,  0,  1 };
								}
							} else {
								if ( user.lastThree_structContentAvg <= 1.5) {
									values = new int[] { 1,  9,  11,  8,  4,  0,  0,  0,  0,  0 };
								} else {
									values = new int[] { 3,  13,  12,  4,  0,  2,  0,  0,  0,  1 };
								}
							}
						}
					}
				} else {
					if ( user.last_changeInScoreAvg <= 0.3239) {
						values = new int[] { 10,  43,  6,  4,  3,  4,  4,  0,  0,  10 };
					} else {
						if ( user.last_cogLoadAvg <= -2.5) {
							values = new int[] { 10,  22,  5,  2,  0,  4,  1,  0,  0,  2 };
						} else {
							values = new int[] { 7,  6,  11,  2,  14,  2,  0,  0,  0,  7 };
						}
					}
				}
			} else {
				if ( user.lastThree_numPlaySameSetAvg <= 0.1667) {
					values = new int[] { 19,  21,  5,  0,  2,  4,  0,  0,  0,  0 };
				} else {
					values = new int[] { 20,  12,  1,  0,  0,  0,  0,  0,  0,  0 };
				}
			}
		} else {
			if ( user.str_numAttemptsConstructErrorsAvg <= 0.8333) {
				if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 10.3333) {
					if ( user.lastThree_TbOeCntAvg <= 0.1667) {
						if ( user.lastThree_changeInScoreAvg <= 0.3046) {
							if ( user.last_cogLoadAvg <= -0.5) {
								values = new int[] { 4,  3,  22,  5,  5,  4,  2,  2,  0,  0 };
							} else {
								values = new int[] { 3,  3,  9,  0,  7,  12,  3,  0,  0,  0 };
							}
						} else {
							if ( puzzle.getUniqueStatementsCount() <= 7.5) {
								if ( user.notStr_numMoveSameStmtConsecutivelyAvg <= 0.8333) {
									values = new int[] { 1,  7,  9,  2,  11,  4,  0,  0,  0,  2 };
								} else {
									values = new int[] { 5,  11,  9,  7,  3,  1,  1,  0,  0,  3 };
								}
							} else {
								values = new int[] { 0,  0,  6,  8,  6,  9,  9,  0,  0,  1 };
							}
						}
					} else {
						if ( user.notStr_nestingDepthAvg <= 1.1667) {
							values = new int[] { 2,  13,  9,  4,  1,  1,  0,  0,  0,  1 };
						} else {
							values = new int[] { 1,  9,  7,  11,  8,  3,  0,  1,  0,  0 };
						}
					}
				} else {
					if ( user.notStr_TbCObTeeCntAvg <= 0.4167) {
						if ( user.str_CCntAvg <= 7.1667) {
							if ( user.last_changeInScoreAvg <= 0.1436) {
								values = new int[] { 14,  4,  8,  7,  5,  2,  8,  2,  0,  3 };
							} else {
								if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 22.0) {
									values = new int[] { 3,  16,  2,  7,  3,  9,  8,  1,  4,  5 };
								} else {
									if ( user.str_nestingDepthAvg <= 1.5) {
										values = new int[] { 7,  2,  4,  10,  5,  1,  0,  3,  0,  6 };
									} else {
										values = new int[] { 1,  3,  4,  10,  11,  6,  0,  0,  0,  0 };
									}
								}
							}
						} else {
							values = new int[] { 2,  24,  5,  8,  2,  5,  8,  0,  2,  0 };
						}
					} else {
						values = new int[] { 2,  17,  2,  4,  1,  2,  0,  0,  0,  10 };
					}
				}
			} else {
				if ( user.notStr_numStepsSeparatedNestsAvg <= 1.8333) {
					if ( user.str_numCorrectButNotPlayedAvg <= 0.8333) {
						if ( user.lastThreeCbCe <= -0.8333) {
							values = new int[] { 0,  4,  1,  3,  8,  2,  1,  0,  0,  20 };
						} else {
							values = new int[] { 1,  8,  4,  8,  3,  8,  3,  0,  0,  10 };
						}
					} else {
						if ( user.notStr_numConstructsInLockAvg <= 0.8333) {
							if ( user.last_noRefPlayedBoolean <= 0.4167) {
								values = new int[] { 1,  2,  6,  4,  10,  6,  3,  6,  0,  2 };
							} else {
								values = new int[] { 1,  0,  11,  0,  5,  2,  0,  1,  0,  14 };
							}
						} else {
							if ( user.str_numAttemptsOfdoTogetherRearrangementsAvg <= 0.1667) {
								if ( user.str_numAttemptsAvg <= 9.0) {
									if ( user.all_cogLoad <= -0.3673) {
										values = new int[] { 5,  0,  10,  3,  4,  4,  3,  0,  0,  1 };
									} else {
										values = new int[] { 3,  1,  4,  6,  1,  5,  0,  0,  0,  12 };
									}
								} else {
									values = new int[] { 0,  0,  11,  14,  0,  6,  1,  3,  0,  2 };
								}
							} else {
								if ( user.last_numConstructsInLockAvg <= 1.5) {
									values = new int[] { 1,  1,  3,  19,  10,  3,  1,  0,  0,  4 };
								} else {
									values = new int[] { 1,  4,  6,  10,  9,  0,  1,  0,  0,  8 };
								}
							}
						}
					}
				} else {
					values = new int[] { 3,  19,  2,  5,  5,  2,  1,  0,  0,  7 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		if ( user.lastThreeT <= -3.1667) {
			if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 16.1667) {
				if ( user.all_cogLoad <= -0.4885) {
					values = new int[] { 32,  5,  2,  4,  0,  0,  0,  0,  0,  0 };
				} else {
					if ( user.last_TbCeCntAvg <= 0.5) {
						values = new int[] { 30,  6,  13,  2,  3,  5,  0,  0,  0,  1 };
					} else {
						values = new int[] { 10,  12,  4,  7,  1,  0,  0,  0,  0,  0 };
					}
				}
			} else {
				values = new int[] { 15,  9,  15,  0,  0,  8,  0,  1,  0,  4 };
			}
		} else {
			if ( user.lastThreeTbCe <= 4.1667) {
				if ( user.all_cogLoad <= -1.1276) {
					if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 39.5) {
						if ( user.str_cogLoadAvg <= 4.8333) {
							values = new int[] { 4,  28,  1,  12,  1,  1,  1,  0,  0,  7 };
						} else {
							if ( user.str_numReducedFirstWrongIndexAvg <= 1.8333) {
								values = new int[] { 6,  3,  12,  1,  2,  0,  0,  0,  0,  2 };
							} else {
								values = new int[] { 0,  15,  2,  4,  1,  3,  0,  0,  0,  12 };
							}
						}
					} else {
						values = new int[] { 12,  8,  2,  0,  3,  1,  0,  0,  0,  9 };
					}
				} else {
					if ( user.notStr_countsOfPlayConsecutivelyAvg <= 0.3259) {
						if ( puzzle.getTbObTeeCnt() <= 0.5) {
							if ( user.lastThree_numCorrectButNotPlayedAvg <= 1.1667) {
								if ( user.lastThree_changeInScoreAvg <= 0.2656) {
									values = new int[] { 1,  2,  22,  5,  5,  5,  9,  1,  0,  13 };
								} else {
									if ( user.str_postRefPlayScoreAvg <= 0.1171) {
										if ( user.str_numAttemptsOfoneOrZeroInDoTAvg <= 0.5) {
											values = new int[] { 1,  9,  6,  2,  1,  1,  3,  3,  0,  5 };
										} else {
											values = new int[] { 0,  2,  3,  21,  4,  4,  0,  0,  0,  3 };
										}
									} else {
										if ( user.notStr_numAttemptsOfoneOrZeroInDoTAvg <= 0.1667) {
											values = new int[] { 2,  1,  5,  6,  10,  6,  4,  1,  0,  12 };
										} else {
											values = new int[] { 1,  13,  2,  2,  7,  12,  0,  0,  0,  4 };
										}
									}
								}
							} else {
								values = new int[] { 0,  3,  5,  5,  17,  11,  0,  1,  0,  3 };
							}
						} else {
							values = new int[] { 0,  0,  0,  2,  4,  5,  12,  6,  0,  15 };
						}
					} else {
						if ( user.lastThree_noRefPlayedBoolean <= 0.3746) {
							values = new int[] { 0,  0,  2,  3,  4,  3,  2,  0,  0,  13 };
						} else {
							values = new int[] { 4,  1,  3,  5,  1,  0,  1,  1,  0,  16 };
						}
					}
				}
			} else {
				if ( puzzle.getTCnt() <= 2.5) {
					if ( user.allT <= -1.5) {
						if ( user.all_cogLoad <= -0.5403) {
							if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 1.1667) {
								if ( user.lastThree_unfamMethodsAvg <= 1.1667) {
									values = new int[] { 5,  8,  17,  11,  3,  4,  2,  0,  0,  2 };
								} else {
									values = new int[] { 4,  19,  9,  4,  0,  0,  0,  0,  0,  0 };
								}
							} else {
								values = new int[] { 6,  3,  35,  10,  6,  0,  3,  0,  0,  0 };
							}
						} else {
							if ( user.notStr_numReducedFirstWrongIndexAvg <= 1.8333) {
								if ( user.notStr_cogLoadAvg <= -1.8333) {
									if ( user.last_TbOeCntAvg <= 0.5) {
										if ( user.lastThree_numConstructsInLockAvg <= 1.8333) {
											if ( user.last_CCntAvg <= 5.5) {
												values = new int[] { 10,  22,  0,  0,  0,  2,  0,  0,  0,  0 };
											} else {
												values = new int[] { 1,  37,  14,  9,  5,  5,  0,  0,  0,  0 };
											}
										} else {
											values = new int[] { 1,  8,  10,  5,  0,  3,  0,  0,  0,  2 };
										}
									} else {
										values = new int[] { 17,  20,  8,  9,  1,  2,  2,  0,  0,  0 };
									}
								} else {
									values = new int[] { 4,  13,  0,  11,  5,  2,  3,  0,  0,  1 };
								}
							} else {
								values = new int[] { 22,  11,  6,  6,  1,  5,  0,  0,  0,  1 };
							}
						}
					} else {
						if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 10.8333) {
							values = new int[] { 2,  0,  9,  21,  1,  2,  3,  1,  0,  1 };
						} else {
							if ( user.allCbCe <= 0.5) {
								values = new int[] { 2,  6,  15,  2,  5,  1,  0,  0,  0,  0 };
							} else {
								if ( user.all_cogLoad <= 0.0556) {
									if ( user.lastThree_postRefPlayScoreAvg <= 0.2656) {
										if ( user.notStr_changeInScoreAvg <= 0.5285) {
											if ( user.lastThree_numRepeatedErrorWithInsertionsAvg <= 1.5) {
												values = new int[] { 4,  23,  4,  7,  5,  3,  4,  0,  0,  1 };
											} else {
												values = new int[] { 8,  8,  4,  5,  11,  6,  2,  0,  0,  0 };
											}
										} else {
											values = new int[] { 4,  7,  15,  12,  8,  3,  4,  0,  0,  8 };
										}
									} else {
										if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
											values = new int[] { 6,  9,  8,  4,  4,  4,  1,  0,  0,  1 };
										} else {
											if ( user.notStr_numAttemptsWithoutOrderingBoxAvg <= 0.1667) {
												values = new int[] { 4,  0,  3,  23,  16,  12,  6,  6,  3,  9 };
											} else {
												values = new int[] { 4,  6,  2,  6,  5,  16,  2,  1,  0,  1 };
											}
										}
									}
								} else {
									values = new int[] { 6,  0,  9,  20,  3,  4,  0,  2,  1,  3 };
								}
							}
						}
					}
				} else {
					if ( puzzle.getUnfamiliarMethodsCount() <= 0.5) {
						if ( user.last_changeInScoreAvg <= 0.0714) {
							values = new int[] { 8,  6,  10,  1,  1,  0,  0,  0,  0,  0 };
						} else {
							values = new int[] { 27,  18,  2,  1,  2,  0,  0,  0,  0,  0 };
						}
					} else {
						values = new int[] { 13,  27,  7,  4,  5,  2,  0,  0,  0,  0 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		if ( user.lastThreeT <= -2.1667) {
			if ( user.lastThree_numConstructsAfterLockAvg <= 3.1667) {
				if ( user.last_postRefPlayScoreAvg <= 0.1339) {
					if ( user.lastThree_postRefPlayScoreAvg <= 0.0246) {
						values = new int[] { 16,  10,  5,  6,  2,  1,  0,  2,  0,  1 };
					} else {
						if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 0.8333) {
							values = new int[] { 17,  13,  21,  3,  2,  0,  0,  2,  0,  0 };
						} else {
							values = new int[] { 5,  5,  21,  0,  0,  1,  0,  0,  0,  1 };
						}
					}
				} else {
					if ( puzzle.getUniqueStatementsCount() <= 6.5) {
						values = new int[] { 6,  28,  16,  11,  3,  2,  0,  0,  0,  0 };
					} else {
						values = new int[] { 11,  10,  4,  11,  5,  3,  0,  1,  0,  3 };
					}
				}
			} else {
				if ( user.str_TbCeCntAvg <= 0.8333) {
					if ( user.notStr_cogLoadAvg <= -3.1667) {
						values = new int[] { 27,  14,  2,  3,  0,  1,  3,  0,  0,  4 };
					} else {
						if ( user.lastThreeCbTe <= 3.6667) {
							values = new int[] { 8,  13,  2,  1,  3,  1,  3,  0,  0,  3 };
						} else {
							if ( puzzle.getUniqueStatementsCount() <= 6.5) {
								values = new int[] { 4,  30,  12,  1,  0,  2,  0,  0,  0,  0 };
							} else {
								values = new int[] { 1,  7,  3,  7,  6,  5,  0,  0,  0,  0 };
							}
						}
					}
				} else {
					values = new int[] { 5,  11,  2,  5,  3,  1,  4,  0,  0,  8 };
				}
			}
		} else {
			if ( user.str_numMoveSameStmtConsecutivelyAvg <= 1.8333) {
				if ( user.lastThree_numAttemptsAvg <= 3.1667) {
					if ( user.notStr_nestingDepthAvg <= 1.1667) {
						if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
							values = new int[] { 9,  38,  13,  1,  6,  1,  0,  0,  0,  0 };
						} else {
							values = new int[] { 0,  16,  9,  15,  0,  4,  1,  0,  0,  2 };
						}
					} else {
						if ( user.lastThreeC <= -1.5) {
							values = new int[] { 1,  19,  17,  4,  0,  3,  7,  0,  0,  2 };
						} else {
							if ( user.lastThreeT <= -1.5) {
								values = new int[] { 5,  13,  13,  7,  4,  0,  3,  0,  0,  4 };
							} else {
								if ( user.notStr_numConstructsAfterLockAvg <= 3.1667) {
									values = new int[] { 2,  14,  9,  13,  9,  4,  3,  0,  0,  1 };
								} else {
									if ( user.last_countsOfPlayPuzConsecutivelyAvg <= 0.5) {
										values = new int[] { 2,  3,  1,  4,  2,  26,  2,  0,  0,  1 };
									} else {
										values = new int[] { 1,  6,  5,  4,  5,  8,  3,  3,  0,  0 };
									}
								}
							}
						}
					}
				} else {
					if ( user.notStr_nestingDepthAvg <= 0.4167) {
						if ( user.last_numReducedFirstWrongIndexAvg <= 1.5) {
							values = new int[] { 16,  4,  5,  2,  2,  0,  0,  0,  0,  3 };
						} else {
							values = new int[] { 11,  16,  0,  2,  2,  5,  0,  0,  0,  10 };
						}
					} else {
						if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
							if ( user.notStr_numMoveSameStmtConsecutivelyAvg <= 1.1667) {
								values = new int[] { 12,  10,  12,  3,  8,  0,  0,  0,  0,  1 };
							} else {
								values = new int[] { 7,  19,  2,  11,  2,  4,  1,  0,  0,  1 };
							}
						} else {
							if ( user.lastThree_TbCeCntAvg <= 0.1667) {
								values = new int[] { 7,  14,  17,  5,  7,  5,  0,  0,  0,  0 };
							} else {
								if ( user.str_numRepeatedErrorWithInsertionsAvg <= 0.5) {
									if ( user.last_numMoveSameStmtConsecutivelyAvg <= 0.5) {
										values = new int[] { 1,  0,  2,  8,  7,  8,  11,  0,  0,  7 };
									} else {
										values = new int[] { 1,  4,  10,  4,  11,  21,  2,  0,  1,  2 };
									}
								} else {
									values = new int[] { 0,  4,  14,  6,  1,  1,  2,  1,  0,  5 };
								}
							}
						}
					}
				}
			} else {
				if ( user.allCbCe <= 2.5) {
					if ( user.lastThreeC <= -1.5) {
						if ( user.notStr_structContentAvg <= 2.8333) {
							if ( user.str_numStepsSeparatedNestsAvg <= 2.4167) {
								if ( user.lastThree_numStepsSeparatedNestsAvg <= 0.5) {
									values = new int[] { 0,  15,  6,  8,  6,  0,  1,  2,  0,  3 };
								} else {
									values = new int[] { 4,  4,  4,  12,  7,  3,  1,  0,  0,  11 };
								}
							} else {
								values = new int[] { 0,  20,  4,  3,  1,  2,  0,  0,  0,  4 };
							}
						} else {
							if ( user.lastThree_TbCeCntAvg <= 0.1667) {
								if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 47.5) {
									values = new int[] { 0,  2,  5,  10,  0,  8,  2,  0,  0,  8 };
								} else {
									values = new int[] { 1,  3,  5,  1,  1,  9,  0,  7,  0,  2 };
								}
							} else {
								values = new int[] { 3,  2,  8,  8,  0,  2,  2,  0,  0,  19 };
							}
						}
					} else {
						if ( user.lastThreeTbOe <= 4.3333) {
							values = new int[] { 1,  0,  4,  12,  6,  8,  1,  4,  0,  12 };
						} else {
							if ( user.notStr_numPlaySameSetAvg <= 0.1667) {
								values = new int[] { 1,  3,  5,  8,  8,  2,  1,  3,  0,  10 };
							} else {
								values = new int[] { 2,  5,  6,  1,  35,  0,  1,  1,  0,  10 };
							}
						}
					}
				} else {
					if ( user.str_TbOeCntAvg <= 0.1667) {
						if ( user.lastThree_nestingDepthAvg <= 1.5) {
							values = new int[] { 12,  12,  3,  21,  5,  4,  1,  0,  0,  9 };
						} else {
							if ( user.str_structContentAvg <= 2.8333) {
								values = new int[] { 0,  2,  6,  11,  6,  4,  0,  0,  0,  0 };
							} else {
								values = new int[] { 2,  1,  2,  15,  0,  13,  0,  0,  0,  0 };
							}
						}
					} else {
						values = new int[] { 5,  13,  2,  6,  4,  3,  7,  0,  2,  4 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		if ( user.lastThree_TbCeCntAvg <= 0.4167) {
			if ( user.str_cogLoadAvg <= 4.8333) {
				if ( user.str_nestingDepthAvg <= 1.1667) {
					if ( user.notStr_uniqueStmtsAvg <= 0.1667) {
						values = new int[] { 20,  9,  7,  3,  0,  9,  0,  1,  0,  1 };
					} else {
						if ( puzzle.getNumConstructsAfterLock() <= 2.5) {
							values = new int[] { 22,  13,  11,  8,  5,  0,  2,  0,  0,  1 };
						} else {
							if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 14.5) {
								values = new int[] { 7,  5,  5,  2,  4,  6,  0,  0,  0,  3 };
							} else {
								values = new int[] { 0,  4,  21,  2,  5,  4,  5,  0,  0,  1 };
							}
						}
					}
				} else {
					if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 40.3333) {
						if ( user.lastThree_structContentAvg <= 2.8333) {
							values = new int[] { 0,  16,  7,  18,  4,  1,  3,  4,  0,  10 };
						} else {
							if ( user.lastThree_numAttemptsConstructErrorsAvg <= 0.8333) {
								values = new int[] { 0,  7,  4,  1,  7,  3,  10,  0,  0,  4 };
							} else {
								values = new int[] { 0,  0,  3,  6,  16,  5,  1,  0,  0,  4 };
							}
						}
					} else {
						if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 1.5) {
							values = new int[] { 17,  5,  3,  1,  5,  2,  4,  1,  0,  3 };
						} else {
							if ( user.lastThreeC <= -1.5) {
								values = new int[] { 2,  5,  7,  10,  10,  4,  5,  1,  0,  2 };
							} else {
								values = new int[] { 11,  2,  6,  3,  4,  0,  1,  1,  0,  5 };
							}
						}
					}
				}
			} else {
				if ( user.allCbCe <= 0.5) {
					if ( user.allTbOe <= 1.5) {
						if ( user.str_numMoveSameStmtConsecutivelyAvg <= 1.8333) {
							values = new int[] { 4,  5,  11,  2,  3,  2,  1,  0,  0,  7 };
						} else {
							values = new int[] { 3,  5,  4,  2,  0,  0,  0,  1,  0,  21 };
						}
					} else {
						if ( user.notStr_changeInScoreAvg <= 0.3525) {
							values = new int[] { 1,  4,  17,  1,  3,  3,  0,  0,  0,  4 };
						} else {
							values = new int[] { 1,  8,  7,  3,  7,  5,  0,  0,  0,  4 };
						}
					}
				} else {
					if ( user.str_postRefPlayScoreAvg <= 0.2113) {
						if ( user.str_TbCObTeeCntAvg <= 0.1667) {
							values = new int[] { 3,  1,  2,  2,  4,  2,  0,  0,  0,  17 };
						} else {
							values = new int[] { 3,  0,  0,  2,  1,  11,  1,  0,  2,  16 };
						}
					} else {
						values = new int[] { 8,  3,  9,  9,  4,  1,  0,  1,  0,  11 };
					}
				}
			}
		} else {
			if ( user.lastThree_cogLoadAvg <= -1.8333) {
				if ( puzzle.getTCnt() <= 2.5) {
					if ( user.notStr_cogLoadAvg <= -3.5833) {
						if ( user.notStr_cogLoadAvg <= -3.8333) {
							values = new int[] { 13,  16,  6,  2,  0,  5,  0,  0,  0,  2 };
						} else {
							values = new int[] { 16,  10,  6,  0,  2,  0,  0,  0,  0,  0 };
						}
					} else {
						if ( user.last_CCntAvg <= 4.5) {
							values = new int[] { 13,  9,  22,  6,  1,  3,  0,  3,  0,  1 };
						} else {
							if ( user.str_CCntAvg <= 5.8333) {
								if ( user.notStr_numMoveSameStmtConsecutivelyAvg <= 1.1667) {
									if ( user.last_numConstructsAfterLockAvg <= 4.5) {
										if ( user.last_CCntAvg <= 5.5) {
											values = new int[] { 10,  17,  2,  2,  4,  0,  1,  0,  0,  0 };
										} else {
											values = new int[] { 6,  8,  18,  5,  7,  2,  0,  1,  0,  1 };
										}
									} else {
										if ( user.notStr_changeInScoreAvg <= 0.4592) {
											values = new int[] { 8,  36,  7,  6,  2,  7,  0,  0,  0,  0 };
										} else {
											values = new int[] { 7,  6,  12,  2,  4,  0,  0,  0,  0,  0 };
										}
									}
								} else {
									values = new int[] { 2,  23,  2,  1,  2,  0,  1,  1,  0,  2 };
								}
							} else {
								if ( user.lastThree_postRefPlayScoreAvg <= 0.4123) {
									values = new int[] { 3,  6,  11,  9,  7,  4,  0,  2,  0,  3 };
								} else {
									values = new int[] { 3,  11,  6,  6,  1,  0,  2,  0,  0,  2 };
								}
							}
						}
					}
				} else {
					if ( user.notStr_noRefPlayedBoolean <= 0.375) {
						values = new int[] { 9,  23,  7,  0,  0,  0,  0,  0,  0,  0 };
					} else {
						values = new int[] { 13,  17,  0,  0,  1,  2,  0,  0,  0,  0 };
					}
				}
			} else {
				if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
					if ( user.last_numMoveSameStmtConsecutivelyAvg <= 1.5) {
						if ( user.str_unfamMethodsAvg <= 0.8333) {
							if ( user.lastThree_changeInScoreAvg <= 0.3171) {
								values = new int[] { 12,  8,  10,  4,  5,  0,  0,  0,  0,  0 };
							} else {
								if ( user.notStr_numMoveSameStmtConsecutivelyAvg <= 0.8333) {
									values = new int[] { 4,  17,  1,  2,  5,  0,  0,  0,  0,  0 };
								} else {
									values = new int[] { 11,  15,  4,  3,  0,  0,  0,  0,  0,  1 };
								}
							}
						} else {
							if ( user.notStr_changeInScoreAvg <= 0.442) {
								values = new int[] { 4,  14,  9,  6,  2,  2,  1,  0,  0,  0 };
							} else {
								values = new int[] { 2,  19,  3,  2,  1,  3,  0,  0,  0,  1 };
							}
						}
					} else {
						values = new int[] { 10,  7,  10,  9,  2,  9,  2,  0,  0,  6 };
					}
				} else {
					if ( user.last_postRefPlayScoreAvg <= 0.0278) {
						if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 1.8333) {
							if ( user.notStr_numConstructsInLockAvg <= 1.5) {
								values = new int[] { 4,  1,  6,  1,  7,  9,  4,  0,  0,  2 };
							} else {
								values = new int[] { 1,  4,  5,  13,  17,  2,  1,  2,  0,  0 };
							}
						} else {
							values = new int[] { 0,  0,  1,  13,  5,  2,  1,  0,  0,  14 };
						}
					} else {
						if ( user.last_cogLoadAvg <= -1.5) {
							values = new int[] { 1,  9,  10,  8,  4,  9,  7,  1,  0,  2 };
						} else {
							if ( user.notStr_numReducedFirstWrongIndexAvg <= 1.1667) {
								values = new int[] { 0,  0,  5,  6,  6,  20,  2,  2,  0,  0 };
							} else {
								if ( user.last_uniqueStmtsAvg <= 0.5) {
									values = new int[] { 2,  3,  2,  9,  8,  8,  1,  0,  1,  4 };
								} else {
									values = new int[] { 0,  2,  1,  21,  1,  13,  5,  3,  0,  7 };
								}
							}
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		if ( user.str_numConstructsInLockAvg <= 0.1667) {
			if ( user.lastThree_cogLoadAvg <= -3.5833) {
				if ( user.all_cogLoad <= -0.5847) {
					values = new int[] { 26,  4,  1,  0,  0,  0,  0,  0,  0,  2 };
				} else {
					values = new int[] { 27,  25,  9,  0,  1,  1,  0,  0,  0,  0 };
				}
			} else {
				if ( user.notStr_cogLoadAvg <= -1.1667) {
					if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 0.5) {
						if ( puzzle.getNumStmtsAfterLock() <= 6.5) {
							if ( user.lastThree_structContentAvg <= 1.8333) {
								if ( user.notStr_unfamMethodsAvg <= 0.8333) {
									if ( puzzle.getNumStmtsAfterLock() <= 4.5) {
										values = new int[] { 4,  14,  2,  7,  1,  10,  0,  0,  0,  2 };
									} else {
										values = new int[] { 6,  29,  4,  0,  2,  1,  0,  0,  0,  0 };
									}
								} else {
									if ( user.last_numMoveSameStmtConsecutivelyAvg <= 0.5) {
										values = new int[] { 9,  12,  5,  8,  0,  6,  2,  0,  0,  0 };
									} else {
										if ( puzzle.getTCnt() <= 0.5) {
											values = new int[] { 5,  14,  3,  5,  0,  1,  0,  0,  0,  1 };
										} else {
											values = new int[] { 4,  5,  14,  6,  4,  5,  0,  3,  0,  0 };
										}
									}
								}
							} else {
								if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 24.1667) {
									if ( user.lastThree_numRepeatedErrorWithInsertionsAvg <= 0.5) {
										values = new int[] { 20,  10,  4,  1,  3,  1,  0,  0,  0,  0 };
									} else {
										if ( user.last_numAttemptsAvg <= 1.5) {
											values = new int[] { 12,  24,  12,  1,  0,  0,  0,  0,  0,  0 };
										} else {
											values = new int[] { 10,  21,  6,  1,  2,  0,  0,  0,  0,  1 };
										}
									}
								} else {
									values = new int[] { 5,  9,  11,  4,  0,  0,  0,  0,  0,  6 };
								}
							}
						} else {
							if ( user.notStr_structContentAvg <= 1.8333) {
								values = new int[] { 3,  9,  6,  16,  1,  6,  0,  0,  0,  0 };
							} else {
								if ( user.all_cogLoad <= -0.6462) {
									values = new int[] { 3,  31,  6,  8,  10,  0,  0,  0,  0,  3 };
								} else {
									values = new int[] { 1,  8,  4,  1,  5,  7,  4,  0,  0,  0 };
								}
							}
						}
					} else {
						if ( user.lastThree_numAttemptsAvg <= 3.5) {
							values = new int[] { 2,  13,  12,  6,  1,  2,  0,  0,  0,  0 };
						} else {
							values = new int[] { 0,  1,  16,  1,  1,  0,  0,  0,  0,  12 };
						}
					}
				} else {
					if ( user.allT <= 0.5) {
						if ( user.lastThree_numAttemptsWithoutOrderingBoxAvg <= 0.1667) {
							if ( user.lastThree_numConstructsInLockAvg <= 1.5) {
								values = new int[] { 0,  3,  1,  7,  5,  19,  4,  1,  2,  2 };
							} else {
								values = new int[] { 2,  1,  9,  9,  11,  7,  2,  0,  0,  2 };
							}
						} else {
							values = new int[] { 1,  7,  1,  15,  4,  2,  2,  0,  0,  2 };
						}
					} else {
						values = new int[] { 15,  5,  5,  1,  2,  3,  2,  0,  0,  4 };
					}
				}
			}
		} else {
			if ( user.allT <= -0.5) {
				if ( user.notStr_numStepsSeparatedNestsAvg <= 1.8333) {
					if ( user.lastThreeC <= 1.5) {
						if ( user.lastThree_CbTbCeeCntAvg <= 0.1667) {
							if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 12.5) {
								values = new int[] { 3,  20,  6,  7,  4,  0,  1,  1,  0,  25 };
							} else {
								if ( user.lastThree_structContentAvg <= 3.1667) {
									values = new int[] { 12,  11,  2,  1,  2,  14,  1,  0,  0,  14 };
								} else {
									values = new int[] { 6,  2,  12,  5,  0,  1,  1,  0,  0,  4 };
								}
							}
						} else {
							if ( user.lastThree_postRefPlayScoreAvg <= 0.3356) {
								values = new int[] { 6,  2,  27,  3,  5,  3,  3,  0,  0,  1 };
							} else {
								values = new int[] { 9,  7,  5,  1,  3,  1,  0,  1,  0,  3 };
							}
						}
					} else {
						if ( user.notStr_numConstructsInLockAvg <= 1.1667) {
							values = new int[] { 4,  1,  12,  20,  2,  0,  1,  0,  0,  0 };
						} else {
							if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 5.4167) {
								if ( user.str_numReducedFirstWrongIndexAvg <= 2.6667) {
									values = new int[] { 16,  7,  7,  9,  1,  11,  7,  0,  0,  2 };
								} else {
									values = new int[] { 5,  14,  17,  4,  5,  6,  3,  0,  0,  1 };
								}
							} else {
								values = new int[] { 6,  10,  1,  22,  5,  2,  0,  0,  0,  6 };
							}
						}
					}
				} else {
					values = new int[] { 8,  26,  7,  2,  0,  2,  0,  0,  0,  0 };
				}
			} else {
				if ( user.lastThree_countsOfPlayConsecutivelyAvg <= 0.2714) {
					if ( user.lastThreeCbTe <= 2.5) {
						if ( user.allTbOe <= 3.0) {
							values = new int[] { 1,  4,  2,  15,  2,  9,  3,  2,  0,  15 };
						} else {
							if ( user.str_numStepsSeparatedNestsAvg <= 1.1667) {
								values = new int[] { 1,  2,  4,  3,  22,  4,  1,  2,  0,  5 };
							} else {
								values = new int[] { 0,  5,  1,  7,  3,  10,  3,  1,  0,  5 };
							}
						}
					} else {
						if ( user.str_postRefPlayScoreAvg <= 0.3363) {
							if ( user.str_numAttemptsAvg <= 7.75) {
								if ( user.notStr_CCntAvg <= 5.8333) {
									values = new int[] { 7,  16,  4,  3,  0,  6,  4,  0,  0,  0 };
								} else {
									values = new int[] { 2,  9,  3,  7,  3,  13,  4,  2,  2,  4 };
								}
							} else {
								if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 17.3333) {
									values = new int[] { 7,  4,  0,  11,  1,  7,  1,  4,  0,  0 };
								} else {
									values = new int[] { 7,  0,  10,  7,  2,  6,  0,  0,  0,  0 };
								}
							}
						} else {
							values = new int[] { 1,  15,  6,  2,  1,  2,  2,  1,  0,  4 };
						}
					}
				} else {
					if ( user.notStr_structContentAvg <= 2.5) {
						values = new int[] { 0,  1,  3,  14,  2,  5,  3,  1,  0,  14 };
					} else {
						values = new int[] { 0,  6,  2,  2,  4,  1,  0,  1,  0,  36 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		if ( user.last_cogLoadAvg <= -2.5) {
			if ( user.allC <= -1.5) {
				if ( user.str_numConstructsAfterLockAvg <= 2.6667) {
					values = new int[] { 7,  33,  6,  0,  3,  2,  0,  0,  0,  2 };
				} else {
					if ( user.str_TbCeCntAvg <= 0.4167) {
						values = new int[] { 19,  15,  9,  3,  0,  1,  0,  0,  0,  10 };
					} else {
						values = new int[] { 6,  25,  1,  1,  4,  2,  0,  0,  0,  6 };
					}
				}
			} else {
				if ( user.notStr_cogLoadAvg <= -3.1667) {
					if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
						values = new int[] { 42,  12,  7,  4,  1,  0,  0,  0,  0,  0 };
					} else {
						if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 12.5) {
							values = new int[] { 9,  9,  17,  6,  1,  7,  0,  0,  0,  5 };
						} else {
							values = new int[] { 19,  11,  1,  2,  2,  5,  3,  0,  0,  3 };
						}
					}
				} else {
					if ( user.str_unfamMethodsAvg <= 1.1667) {
						if ( user.lastThree_numConstructsAfterLockAvg <= 3.1667) {
							if ( user.notStr_numAttemptsAvg <= 2.8333) {
								if ( puzzle.getNumStmtsInLock() <= 1.5) {
									values = new int[] { 1,  31,  15,  6,  2,  0,  0,  1,  0,  0 };
								} else {
									values = new int[] { 21,  25,  4,  3,  0,  1,  0,  0,  0,  0 };
								}
							} else {
								if ( user.lastThree_uniqueStmtsAvg <= 0.1667) {
									values = new int[] { 12,  13,  7,  3,  0,  2,  0,  0,  0,  0 };
								} else {
									values = new int[] { 23,  9,  10,  2,  2,  1,  2,  0,  0,  1 };
								}
							}
						} else {
							if ( user.notStr_numConstructsAfterLockAvg <= 4.4167) {
								if ( user.notStr_numAttemptsAvg <= 3.3333) {
									values = new int[] { 4,  20,  23,  8,  1,  3,  0,  0,  0,  0 };
								} else {
									values = new int[] { 10,  6,  8,  3,  0,  4,  0,  0,  0,  2 };
								}
							} else {
								values = new int[] { 4,  18,  4,  2,  0,  3,  3,  0,  0,  1 };
							}
						}
					} else {
						values = new int[] { 3,  6,  8,  8,  2,  2,  0,  2,  0,  2 };
					}
				}
			}
		} else {
			if ( user.lastThreeCbCe <= 2.8333) {
				if ( puzzle.getTbObTeeCnt() <= 0.5) {
					if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 67.5) {
						if ( user.str_numConstructsAfterLockAvg <= 1.8333) {
							values = new int[] { 3,  8,  15,  16,  2,  2,  2,  0,  0,  4 };
						} else {
							if ( user.lastThree_numAttemptsAvg <= 4.5) {
								if ( user.last_CCntAvg <= 5.5) {
									if ( user.notStr_numStepsSeparatedNestsAvg <= 0.1667) {
										values = new int[] { 0,  3,  8,  3,  0,  4,  6,  0,  0,  4 };
									} else {
										values = new int[] { 2,  1,  5,  6,  5,  2,  0,  0,  0,  4 };
									}
								} else {
									values = new int[] { 0,  4,  7,  3,  4,  2,  4,  2,  0,  24 };
								}
							} else {
								if ( user.notStr_TCntAvg <= 0.1667) {
									if ( user.notStr_nestingDepthAvg <= 1.8333) {
										values = new int[] { 4,  18,  1,  6,  6,  9,  4,  0,  0,  3 };
									} else {
										values = new int[] { 3,  4,  17,  15,  7,  5,  6,  2,  0,  1 };
									}
								} else {
									if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 2.8333) {
										values = new int[] { 2,  1,  0,  8,  23,  4,  0,  0,  0,  4 };
									} else {
										values = new int[] { 4,  2,  5,  4,  5,  4,  0,  0,  0,  9 };
									}
								}
							}
						}
					} else {
						values = new int[] { 0,  3,  19,  5,  0,  8,  0,  4,  0,  11 };
					}
				} else {
					if ( user.notStr_numAttemptsAvg <= 3.5) {
						values = new int[] { 0,  0,  1,  0,  3,  0,  5,  4,  0,  16 };
					} else {
						values = new int[] { 0,  0,  0,  3,  2,  2,  1,  0,  0,  25 };
					}
				}
			} else {
				if ( user.notStr_nestingDepthAvg <= 1.1667) {
					if ( user.str_CCntAvg <= 5.75) {
						if ( user.notStr_TbCeCntAvg <= 0.5833) {
							values = new int[] { 13,  14,  3,  2,  1,  4,  0,  0,  0,  0 };
						} else {
							if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 0.8333) {
								values = new int[] { 6,  38,  4,  2,  3,  1,  0,  0,  0,  2 };
							} else {
								values = new int[] { 0,  19,  8,  8,  4,  4,  0,  0,  0,  0 };
							}
						}
					} else {
						values = new int[] { 3,  6,  3,  8,  7,  3,  0,  2,  1,  3 };
					}
				} else {
					if ( user.notStr_postRefPlayScoreAvg <= 0.6534) {
						if ( user.str_postRefPlayScoreAvg <= 0.3019) {
							if ( user.notStr_changeInScoreAvg <= 0.4188) {
								if ( user.notStr_uniqueStmtsAvg <= 0.1667) {
									values = new int[] { 4,  4,  9,  13,  2,  7,  3,  0,  0,  0 };
								} else {
									if ( user.str_numAttemptsAvg <= 0.5) {
										if ( user.notStr_structContentAvg <= 1.8333) {
											values = new int[] { 5,  7,  6,  16,  10,  8,  2,  0,  0,  0 };
										} else {
											values = new int[] { 8,  10,  4,  1,  13,  11,  3,  0,  0,  0 };
										}
									} else {
										values = new int[] { 15,  7,  3,  2,  5,  11,  2,  2,  2,  0 };
									}
								}
							} else {
								if ( user.notStr_numAttemptsOfoneOrZeroInDoTAvg <= 0.1667) {
									if ( user.notStr_numConstructsAfterLockAvg <= 4.1667) {
										values = new int[] { 5,  21,  12,  3,  0,  5,  1,  0,  0,  1 };
									} else {
										values = new int[] { 0,  6,  12,  11,  0,  1,  0,  0,  0,  6 };
									}
								} else {
									values = new int[] { 3,  1,  11,  8,  8,  9,  2,  1,  0,  1 };
								}
							}
						} else {
							values = new int[] { 0,  2,  4,  21,  8,  8,  7,  0,  0,  4 };
						}
					} else {
						values = new int[] { 3,  2,  0,  22,  6,  1,  0,  0,  0,  1 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		if ( user.str_unfamMethodsAvg <= 0.8333) {
			if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
				if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.4167) {
					if ( user.notStr_cogLoadAvg <= -3.1667) {
						if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 10.0) {
							values = new int[] { 22,  4,  1,  2,  3,  0,  0,  0,  0,  0 };
						} else {
							values = new int[] { 21,  12,  1,  2,  0,  1,  0,  0,  0,  0 };
						}
					} else {
						if ( user.notStr_numRepeatedFirstWrongStmtAvg <= 0.1667) {
							if ( user.notStr_numAttemptsAvg <= 1.5833) {
								values = new int[] { 1,  13,  14,  9,  2,  9,  1,  0,  0,  0 };
							} else {
								if ( user.notStr_structContentAvg <= 2.5) {
									if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 13.5) {
										values = new int[] { 14,  7,  9,  7,  0,  6,  0,  0,  0,  5 };
									} else {
										values = new int[] { 8,  23,  5,  7,  3,  3,  0,  0,  0,  0 };
									}
								} else {
									values = new int[] { 9,  31,  4,  1,  0,  0,  0,  0,  0,  2 };
								}
							}
						} else {
							if ( user.lastThree_TbCeCntAvg <= 1.1667) {
								values = new int[] { 17,  8,  2,  0,  2,  0,  1,  0,  0,  0 };
							} else {
								values = new int[] { 11,  16,  5,  5,  3,  1,  0,  0,  0,  0 };
							}
						}
					}
				} else {
					values = new int[] { 8,  7,  9,  10,  5,  2,  2,  0,  0,  3 };
				}
			} else {
				if ( user.last_numStepsSeparatedNestsAvg <= 0.5) {
					if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 7.5) {
						values = new int[] { 16,  13,  2,  2,  0,  3,  0,  4,  0,  0 };
					} else {
						if ( puzzle.getTbObTeeCnt() <= 0.5) {
							if ( user.allC <= -1.5) {
								values = new int[] { 11,  22,  4,  4,  3,  0,  0,  0,  0,  1 };
							} else {
								if ( user.notStr_numConstructsAfterLockAvg <= 2.5) {
									if ( user.last_changeInScoreAvg <= 0.2111) {
										values = new int[] { 14,  5,  4,  5,  1,  4,  2,  0,  0,  0 };
									} else {
										values = new int[] { 3,  0,  11,  8,  5,  3,  0,  2,  0,  1 };
									}
								} else {
									if ( user.notStr_cogLoadAvg <= -1.5) {
										if ( user.notStr_numRepeatedErrorWithInsertionsAvg <= 0.5) {
											values = new int[] { 13,  17,  21,  2,  5,  10,  1,  0,  0,  2 };
										} else {
											if ( user.notStr_nestingDepthAvg <= 1.5) {
												values = new int[] { 4,  12,  14,  8,  3,  0,  0,  1,  0,  1 };
											} else {
												values = new int[] { 3,  28,  10,  4,  2,  6,  1,  0,  0,  1 };
											}
										}
									} else {
										values = new int[] { 0,  2,  2,  13,  9,  15,  9,  1,  1,  2 };
									}
								}
							}
						} else {
							values = new int[] { 11,  25,  1,  5,  3,  0,  2,  0,  0,  0 };
						}
					}
				} else {
					if ( user.lastThree_cogLoadAvg <= -1.8333) {
						values = new int[] { 2,  20,  13,  4,  5,  1,  6,  0,  0,  0 };
					} else {
						values = new int[] { 2,  4,  10,  6,  17,  11,  12,  0,  0,  10 };
					}
				}
			}
		} else {
			if ( user.lastThreeCbCe <= -2.5) {
				if ( user.str_numMoveSameStmtConsecutivelyAvg <= 2.6667) {
					values = new int[] { 8,  9,  1,  1,  2,  12,  2,  4,  0,  5 };
				} else {
					values = new int[] { 3,  26,  5,  4,  4,  0,  2,  0,  0,  7 };
				}
			} else {
				if ( user.lastThree_countsOfPlayConsecutivelyAvg <= 0.9042) {
					if ( user.notStr_cogLoadAvg <= -2.5) {
						if ( user.str_postRefPlayScoreAvg <= 0.2684) {
							if ( user.notStr_unfamMethodsAvg <= 1.8333) {
								values = new int[] { 5,  7,  13,  2,  6,  6,  2,  0,  0,  0 };
							} else {
								values = new int[] { 8,  10,  6,  5,  0,  5,  2,  2,  0,  17 };
							}
						} else {
							values = new int[] { 20,  17,  6,  4,  2,  0,  1,  1,  0,  3 };
						}
					} else {
						if ( user.str_numStepsSeparatedNestsAvg <= 0.1667) {
							if ( user.allTbOe <= 3.5) {
								values = new int[] { 2,  4,  6,  2,  2,  2,  0,  0,  0,  14 };
							} else {
								if ( user.lastThreeCbCe <= -1.1667) {
									values = new int[] { 1,  10,  10,  1,  8,  0,  0,  0,  0,  0 };
								} else {
									if ( user.lastThree_numAttemptsOfoneOrZeroInDoTAvg <= 0.1667) {
										values = new int[] { 2,  5,  24,  7,  8,  3,  3,  2,  0,  4 };
									} else {
										values = new int[] { 0,  2,  7,  6,  11,  7,  2,  0,  0,  1 };
									}
								}
							}
						} else {
							if ( user.str_changeInConstructScoreAvg <= 0.5) {
								if ( user.str_cogLoadAvg <= 2.8333) {
									values = new int[] { 4,  12,  15,  0,  4,  3,  8,  7,  0,  4 };
								} else {
									if ( user.str_numConstructsInLockAvg <= 0.8333) {
										if ( user.notStr_numPlaySameSetAvg <= 0.1667) {
											values = new int[] { 0,  3,  3,  4,  5,  16,  0,  0,  0,  5 };
										} else {
											values = new int[] { 0,  3,  0,  4,  10,  3,  5,  0,  2,  8 };
										}
									} else {
										if ( user.str_numMoveSameStmtConsecutivelyAvg <= 2.5833) {
											if ( user.notStr_numAttemptsAvg <= 2.5) {
												values = new int[] { 1,  3,  0,  3,  5,  1,  9,  2,  1,  6 };
											} else {
												values = new int[] { 2,  5,  6,  3,  4,  7,  3,  0,  0,  7 };
											}
										} else {
											if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 4.5) {
												values = new int[] { 3,  5,  10,  20,  5,  6,  0,  0,  0,  7 };
											} else {
												values = new int[] { 0,  2,  0,  25,  7,  2,  0,  0,  0,  4 };
											}
										}
									}
								}
							} else {
								values = new int[] { 0,  0,  13,  4,  2,  4,  0,  1,  0,  14 };
							}
						}
					}
				} else {
					values = new int[] { 1,  4,  6,  8,  3,  4,  0,  1,  0,  32 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		if ( user.allCbCe <= 4.0) {
			if ( user.str_numStepsSeparatedNestsAvg <= 0.1667) {
				if ( user.lastThreeC <= -1.5) {
					if ( user.lastThreeTbOe <= -2.1667) {
						values = new int[] { 10,  12,  5,  1,  4,  1,  1,  0,  0,  2 };
					} else {
						if ( user.str_nestingDepthAvg <= 0.25) {
							if ( user.last_noRefPlayedBoolean <= 0.4143) {
								values = new int[] { 8,  10,  5,  5,  0,  1,  0,  0,  0,  1 };
							} else {
								values = new int[] { 7,  12,  9,  1,  1,  0,  0,  0,  0,  0 };
							}
						} else {
							if ( user.str_numCorrectButNotPlayedAvg <= 0.5833) {
								values = new int[] { 0,  6,  21,  1,  0,  0,  0,  0,  0,  6 };
							} else {
								values = new int[] { 1,  29,  16,  3,  5,  2,  1,  0,  0,  7 };
							}
						}
					}
				} else {
					values = new int[] { 8,  8,  6,  14,  4,  5,  2,  2,  0,  14 };
				}
			} else {
				if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 34.8333) {
					if ( user.lastThreeC <= -1.5) {
						if ( user.allT <= -0.5) {
							if ( user.notStr_numStmtsAfterLockAvg <= 0.5) {
								if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 42.5) {
									values = new int[] { 5,  7,  9,  1,  1,  2,  5,  0,  0,  15 };
								} else {
									values = new int[] { 3,  7,  4,  8,  0,  0,  1,  0,  0,  3 };
								}
							} else {
								values = new int[] { 3,  4,  1,  1,  3,  2,  0,  3,  0,  25 };
							}
						} else {
							values = new int[] { 5,  4,  2,  12,  3,  12,  7,  4,  0,  5 };
						}
					} else {
						if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 20.5) {
							values = new int[] { 0,  1,  2,  13,  7,  8,  3,  0,  0,  15 };
						} else {
							values = new int[] { 0,  1,  0,  3,  13,  1,  0,  1,  0,  23 };
						}
					}
				} else {
					if ( user.last_countsOfPlayPuzConsecutivelyAvg <= 1.5) {
						if ( user.allTbOe <= 0.5) {
							values = new int[] { 3,  11,  2,  4,  1,  6,  1,  1,  0,  2 };
						} else {
							values = new int[] { 3,  3,  17,  4,  8,  2,  2,  0,  0,  2 };
						}
					} else {
						if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 2.5) {
							values = new int[] { 2,  0,  7,  17,  1,  5,  1,  0,  0,  17 };
						} else {
							values = new int[] { 3,  8,  9,  4,  1,  4,  0,  0,  0,  5 };
						}
					}
				}
			}
		} else {
			if ( puzzle.getTCnt() <= 2.5) {
				if ( user.notStr_unfamMethodsAvg <= 0.8333) {
					if ( user.last_cogLoadAvg <= -3.5) {
						values = new int[] { 18,  9,  3,  3,  0,  0,  1,  5,  0,  0 };
					} else {
						if ( user.lastThree_TCntAvg <= 0.1667) {
							values = new int[] { 8,  33,  6,  0,  0,  3,  0,  0,  2,  5 };
						} else {
							if ( user.notStr_nestingDepthAvg <= 0.4167) {
								values = new int[] { 5,  6,  6,  10,  2,  1,  0,  0,  0,  0 };
							} else {
								values = new int[] { 2,  16,  3,  1,  4,  1,  0,  0,  0,  2 };
							}
						}
					}
				} else {
					if ( user.all_cogLoad <= -0.2198) {
						if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
							if ( user.lastThree_CCntAvg <= 4.8333) {
								values = new int[] { 21,  11,  3,  2,  0,  0,  0,  0,  0,  1 };
							} else {
								if ( user.notStr_structContentAvg <= 1.8333) {
									values = new int[] { 9,  33,  8,  7,  5,  5,  0,  0,  0,  0 };
								} else {
									values = new int[] { 15,  8,  7,  4,  4,  0,  0,  0,  0,  0 };
								}
							}
						} else {
							if ( user.all_cogLoad <= -0.4857) {
								if ( user.lastThree_changeInScoreAvg <= 0.45) {
									if ( user.notStr_CCntAvg <= 6.1667) {
										values = new int[] { 19,  4,  7,  6,  1,  0,  2,  0,  0,  0 };
									} else {
										values = new int[] { 4,  6,  11,  9,  6,  1,  0,  0,  0,  1 };
									}
								} else {
									values = new int[] { 2,  7,  19,  6,  6,  4,  2,  0,  0,  13 };
								}
							} else {
								if ( user.notStr_numMoveSameStmtConsecutivelyAvg <= 0.8333) {
									if ( user.notStr_numStepsSeparatedNestsAvg <= 0.5) {
										if ( user.last_postRefPlayScoreAvg <= 0.0801) {
											values = new int[] { 2,  13,  5,  4,  4,  2,  2,  0,  0,  1 };
										} else {
											values = new int[] { 0,  13,  12,  2,  9,  11,  1,  0,  0,  0 };
										}
									} else {
										values = new int[] { 3,  10,  18,  3,  7,  4,  5,  0,  0,  5 };
									}
								} else {
									if ( puzzle.getTCnt() <= 1.5) {
										values = new int[] { 4,  8,  4,  7,  0,  15,  0,  1,  0,  0 };
									} else {
										values = new int[] { 7,  11,  12,  8,  1,  3,  0,  1,  0,  0 };
									}
								}
							}
						}
					} else {
						if ( user.lastThree_CCntAvg <= 4.8333) {
							values = new int[] { 5,  26,  3,  4,  8,  5,  4,  2,  0,  1 };
						} else {
							if ( user.notStr_numAttemptsOfdoTogetherRearrangementsAvg <= 0.1667) {
								if ( user.lastThree_noRefPlayedBoolean <= 1.0556) {
									if ( user.lastThree_numCorrectedFirstWrongIndexAvg <= 0.1667) {
										if ( user.lastThree_changeInScoreAvg <= 0.2348) {
											values = new int[] { 0,  3,  2,  1,  3,  16,  0,  2,  0,  1 };
										} else {
											values = new int[] { 9,  3,  3,  4,  5,  2,  3,  5,  1,  3 };
										}
									} else {
										values = new int[] { 3,  9,  11,  1,  2,  5,  1,  0,  0,  4 };
									}
								} else {
									values = new int[] { 5,  1,  3,  22,  6,  6,  1,  0,  0,  0 };
								}
							} else {
								values = new int[] { 9,  4,  4,  28,  4,  4,  1,  1,  0,  6 };
							}
						}
					}
				}
			} else {
				if ( user.last_changeInScoreAvg <= 0.0714) {
					if ( user.notStr_cogLoadAvg <= -2.5) {
						values = new int[] { 16,  6,  2,  0,  0,  2,  0,  0,  0,  0 };
					} else {
						values = new int[] { 11,  13,  8,  3,  1,  0,  0,  0,  0,  0 };
					}
				} else {
					if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 15.8333) {
						values = new int[] { 3,  23,  0,  0,  2,  1,  0,  0,  0,  0 };
					} else {
						values = new int[] { 6,  21,  1,  3,  2,  3,  0,  0,  0,  0 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

}